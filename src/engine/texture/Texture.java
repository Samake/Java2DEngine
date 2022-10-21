package engine.texture;

import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import engine.debug.Log;
import engine.sprites.SpriteSheet;

public class Texture {

	public int id;
	public BufferedImage image = null;
	public int[] pixels;

	public Texture(Texture[] list, int id, String path, float alpha) {
		if (list[id] != null) throw new RuntimeException("Duplicate texture id on " + id);
		
		this.id = id;
		
		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (image == null) {
			Log.print("Texture " + path + " could not be loaded!");
			
			return;
		}
		
		pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		
		if (alpha < 1.0f) {
			generateAlphaImage(alpha);
		}

		list[id] = this;
	}
	
	private void generateAlphaImage(float alphaNew) {
		int[] result = new int[pixels.length];
		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		if (newImage != null) {
			for (int i = 0; i < pixels.length; i++) {
				Color coronaColor = new Color(pixels[i], true);
				
				int red = coronaColor.getRed();
				int green = coronaColor.getGreen();
				int blue = coronaColor.getBlue();
				int alpha = (int) (coronaColor.getAlpha() * alphaNew);
				
				Color output = new Color(red, green, blue, alpha);
				
				result[i] = output.getRGB();
			}
			
			newImage.setRGB(0, 0, image.getWidth(), image.getHeight(), result, 0, image.getWidth());
			
			pixels = result;
			image = newImage;
		}
	}
}
