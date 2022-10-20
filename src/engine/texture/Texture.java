package engine.texture;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import engine.debug.Log;
import engine.sprites.SpriteSheet;

public class Texture {

	public int id;
	public BufferedImage image = null;
	public int[] pixels;

	public Texture(Texture[] list, int id, String path) {
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

		list[id] = this;
	}
}
