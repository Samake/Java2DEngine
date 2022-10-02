package engine.scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import engine.camera.Camera;
import engine.gui.GUI;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.lights.PointLight;

public class GameScene extends Scene {

	public Camera camera = new Camera();
	public Level level;
	public GUI gui;
	
	public static boolean isEditor = false;
	
	public GameScene() {
		super();
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (camera != null) {
			camera.update(input, gameSpeed);
		}
		
		if (level != null) {
			level.update(input, camera, gameSpeed);
		}
		
		if (gui != null) {
			gui.update(input, gameSpeed);
		}
	}
	
	@Override
	public void render() {
		super.render();
		
		if (level != null && screen != null) {

			level.renderTiles(screen);
			level.renderDecals(screen);
			level.renderEntities(screen);
			
			if (isEditor) {
				level.renderLights(screen);
			}
		}
	}
	
	@Override
	public void renderGUI(Graphics graphics) {
		if (gui != null) {
			gui.renderGameGUI(graphics, screen, this);
		}
	}
	
	public void renderLights(BufferedImage image) {
		if (level != null) {
			Graphics2D graphic = (Graphics2D) image.getGraphics();
			
			if (level.ambient != null) {
				Color ambientColor = level.ambient.ambientColor;
				
				if (ambientColor!= null) {
					graphic.setColor(ambientColor);
				}
				
				graphic.fillRect(0, 0, image.getWidth(), image.getHeight());
				
				for (PointLight light : level.renderListLights) {
					if (light.enabled) {
						light.updatePosition(screen);
						
						drawLight(graphic, light.screenX, light.screenY, light.color, light.radius, light.alphaModifier, ambientColor);
					}
				}
			} else {
				graphic.setColor(new Color(0, 0, 0, 255));
				graphic.fillRect(0, 0, image.getWidth(), image.getHeight());
			}
			
			graphic.dispose();
		}
	}
	
	private void drawLight(Graphics2D graphic, float x, float y, Color lightColor, float radius, float alphaModifier, Color ambientColor) {
        //graphic.setComposite(AlphaComposite.SrcOut);
        
        Point2D center = new Point2D.Float(x, y);
        float[] fractions = {0.0f, 1.0f};
        
        float r = lightColor.getRed();
        float g = lightColor.getGreen();
        float b = lightColor.getBlue();
        float a = lightColor.getAlpha() * alphaModifier;
        
        if (ambientColor != null) {
        	r = r + ambientColor.getRed();
        	
        	if (r < 0) {r = 0;}
        	if (r > 255) {r = 255;}
        	
        	g = g + ambientColor.getGreen();
        	
        	if (g < 0) {g = 0;}
        	if (g > 255) {g = 255;}
        	
        	b = b + ambientColor.getBlue();
        	
        	if (b < 0) {b = 0;}
        	if (b > 255) {b = 255;}
        }
        
        Color[] colors = {new Color(r / 255, g / 255, b / 255, a / 255), new Color(r / 255, g / 255, b / 255, 0)};
       
        RadialGradientPaint paint = new RadialGradientPaint(center, radius, fractions, colors, CycleMethod.REFLECT);
        
        graphic.setPaint(paint);
       
        graphic.fillOval((int) x - (int) radius, (int) y - (int) radius, (int) radius * 2, (int) radius * 2);
    }

	public void setLevel(Level level) {
		this.level = level;
		
		if (camera != null) {
			int shiftOperator = level.getTileAtlas().sheet.getShiftOperator();
			int cameraPositionX = level.width / 2 << shiftOperator;
			int cameraPositionY = level.height / 2 << shiftOperator;
			
			camera.position.set(cameraPositionX, cameraPositionY);
		}
	}
}
