package engine.rendering;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.RescaleOp;
import java.awt.image.WritableRaster;

import engine.core.Config;
import engine.core.Engine;
import engine.debug.Debug;
import engine.debug.Log;
import engine.input.InputHandler;
import engine.scene.GameScene;
import engine.utils.Vector3f;

public class Renderer {

	public BufferedImage sceneImage = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	public BufferedImage guiImage = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	public BufferedImage sceneLightMap = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
	public BufferedImage greyScale = new BufferedImage(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB); 
	
	public Vector3f lightDirection;
	public Vector3f normal;

	public Renderer() {
		lightDirection = new Vector3f();
		normal = new Vector3f();
		
		Log.print("Renderer initialized.");
	}

	public void update(InputHandler input, int gameSpeed) {
		lightDirection.x = -1.0f;
		lightDirection.y = 1.0f;
		lightDirection.z = 0.5f;
		
		if (input.keyF1.isTyped()) {
			Config.ADVANCED_LIGHT = !Config.ADVANCED_LIGHT;
		}
		
		if (input.keyF2.isTyped()) {
			Config.SHADOWS = !Config.SHADOWS;
		}
		
		if (input.keyF3.isTyped()) {
			Debug.toggleEnabled();
		}
		
		if (input.keyF4.isTyped()) {
			Debug.toggleCollission();
		}
		
		if (input.keyF5.isTyped()) {
			Config.LIGHT_SHINE = !Config.LIGHT_SHINE;
		}
		
		if (input.keyF6.isTyped()) {
			Config.LIGHT_CORONA = !Config.LIGHT_CORONA;
		}
	}
	
	public void preRender(Graphics graphics, GameScene scene) {
		if (scene != null) {
			sceneImage.setRGB(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, scene.screen.pixelsScene, 0, Config.WINDOW_WIDTH);
			guiImage.setRGB(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, scene.screen.pixelsGUI, 0, Config.WINDOW_WIDTH);
			
			scene.screen.reset();
			
			scene.renderLights(sceneLightMap);
			scene.render();
			
			multiplyLightMap();
			
			scene.renderEffects(sceneImage);
			
			graphics.setColor(Color.black);
			graphics.fillRect(0, 0, Config.RESOLUTION_WIDTH, Config.RESOLUTION_HEIGHT);
		}
	}
	
	public void render(Engine canvas, BufferStrategy bufferStrategy, Graphics graphics, GameScene scene) {
		if (scene != null) {

			
			graphics.drawImage(sceneImage, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
			graphics.drawImage(guiImage, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
			
			scene.renderGUI(graphics);
		}
	}

	public void renderShape(BufferStrategy bufferStrategy, Shape shape, Color color, int thickness) {
		Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		graphics.setColor(color);
		graphics.setStroke(new BasicStroke(thickness));
		graphics.draw(shape);
	}

	public void postRender(BufferStrategy bufferStrategy, Graphics graphics) {
		graphics.dispose();
		bufferStrategy.show();
	}

	
	private void multiplyLightMap() {
		int[] scenePixels = sceneImage.getRGB(0, 0, sceneImage.getWidth(), sceneImage.getHeight(), null, 0, sceneImage.getWidth());
		int[] lightMapPixels = sceneLightMap.getRGB(0, 0, sceneLightMap.getWidth(), sceneLightMap.getHeight(), null, 0, sceneLightMap.getWidth());
		int[] normalMapPixels = null;
		
		if (Config.ADVANCED_LIGHT) {
			normalMapPixels = getNormal(toGrayscale(scenePixels), 55, 100, Config.NORMAL_STRENGTH);
		}
		
		int[] pixelsFinal = new int[scenePixels.length];
		
		for (int i = 0; i < pixelsFinal.length; i++) {
			Color sceneColor = new Color(scenePixels[i], true);
			int sceneColorRed = sceneColor.getRed();
			int sceneColorGreen = sceneColor.getGreen();
			int sceneColorBlue = sceneColor.getBlue();
			int sceneColorAlpha = sceneColor.getAlpha();
			
			Color lightMapColor = new Color(lightMapPixels[i]);
			int lightMapColorRed = lightMapColor.getRed();
			int lightMapColorGreen = lightMapColor.getGreen();
			int lightMapColorBlue = lightMapColor.getBlue();
			
			
			int red = 0;
			int green = 0;
			int blue = 0;
			
			if (Config.ADVANCED_LIGHT) {
				Color normalMapColor = new Color(normalMapPixels[i]);
				float normalMapColorRed = 2.0f * normalMapColor.getRed() - 1.0f;
				float normalMapColorGreen = 2.0f * normalMapColor.getGreen() - 1.0f;
				float normalMapColorBlue = 2.0f * normalMapColor.getBlue() - 1.0f;
				
				normal.set(normalMapColorRed, normalMapColorGreen, normalMapColorBlue);
				
				double diffuse = Math.max(normal.dot(lightDirection), 0.0) / 255;
				
				red = (int) (diffuse * sceneColorRed * lightMapColorRed) / 255;
				green = (int) (diffuse * sceneColorGreen * lightMapColorGreen) / 255;
				blue = (int) (diffuse * sceneColorBlue * lightMapColorBlue) / 255;
			} else {
				red = (int) (sceneColorRed * lightMapColorRed) / 255;
				green = (int) (sceneColorGreen * lightMapColorGreen) / 255;
				blue = (int) (sceneColorBlue * lightMapColorBlue) / 255;
			}

			if (red < 0) red = 0;
			if (red > 255) red = 255;
			if (green < 0) green = 0;
			if (green > 255) green = 255;
			if (blue< 0) blue = 0;
			if (blue > 255) blue = 255;
			
			Color output = new Color(red, green, blue, sceneColorAlpha);
			
			pixelsFinal[i] = output.getRGB();
		}
		
		sceneImage.setRGB(0, 0, sceneImage.getWidth(), sceneImage.getHeight(), pixelsFinal, 0, sceneImage.getWidth());
	}
	
	public int[] getNormal (BufferedImage input, int contrast, int brightness, float power) {
		BufferedImageOp op = new RescaleOp(contrast / 100f, brightness / 100f, null);
        input = op.filter(input, null);
        BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_INT_RGB);
        WritableRaster outRaster = output.getRaster();

        for (int y = 0; y < output.getHeight(); y++) {
            for (int x = 0; x < output.getWidth(); x++) {
            	
            	int xPos = x;
            	int yPos = y;
            	
            	if (xPos + 1 > input.getWidth() - 1) {
            		xPos = input.getWidth() - 2;
            	}
            	
            	if (xPos - 1 < 0) {
            		xPos = 1;
            	}
            	
            	if (yPos + 1 > input.getHeight() - 1) {
            		yPos = input.getHeight() - 2;
            	}
            	
            	if (yPos - 1 < 0) {
            		yPos = 1;
            	}
            	
            	Vector3f xNormal = new Vector3f((float) 1, (float) 0, (float) (power * Math.sin(Math.atan((input.getRGB(xPos - 1, yPos) - input.getRGB(xPos + 1, yPos))))));
            	Vector3f yNormal = new Vector3f((float) 0, (float) 1, (float) (power * Math.sin(Math.atan((input.getRGB(xPos, yPos - 1) - input.getRGB(xPos, yPos + 1))))));

            	Vector3f normal = new Vector3f();
                normal.cross(xNormal, yNormal);
                normal.normalize();

                int[] rgb = {
                        (int) (((normal.x + 1f) / 2) * 255),
                        (int) (((normal.y + 1f) / 2) * 255),
                        (int) (((normal.z + 1f) / 2) * 255)
                };

                outRaster.setPixel(x, y, rgb);
            }
        }

        output.setData(outRaster);
        
        return output.getRGB(0, 0, output.getWidth(), output.getHeight(), null, 0, output.getWidth());
    }

	private BufferedImage toGrayscale(int[] source) {
		int[] result = new int[source.length];
		
		for (int i = 0; i < source.length; i++) {
			Color pixelColor = new Color(source[i], true);
			int pixelColorRed = pixelColor.getRed();
			int pixelColorGreen = pixelColor.getGreen();
			int pixelColorBlue = pixelColor.getBlue();
			int pixelColorAlpha = pixelColor.getAlpha();
			
			int red = (pixelColorRed + pixelColorGreen + pixelColorBlue) / 3;
			int green = (pixelColorRed + pixelColorGreen + pixelColorBlue) / 3;
			int blue = (pixelColorRed + pixelColorGreen + pixelColorBlue) / 3;
			
			Color output = new Color(red, green, blue, pixelColorAlpha);
			
			result[i] = output.getRGB();
		}
		
		greyScale.setRGB(0, 0, greyScale.getWidth(), greyScale.getHeight(), result, 0, greyScale.getWidth());
		
		return greyScale;
	}
}
