package engine.sprites;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import engine.debug.Log;

public class SpriteSheet {

	public int id;
	public String path;
	public int width;
	public int height;
	public int slots;
	public int tileSize;
	
	public int[] pixels;
	
	public BufferedImage image = null;
	
	public SpriteSheet(SpriteSheet[] list, int id, String path, int slots, int offSet) {
		if (list[id] != null) throw new RuntimeException("Duplicate sheetType id on " + id);
		
		this.id = id;
		
		try {
			image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (image == null) {
			Log.print("Spritesheet " + path + " could not be loaded!");
			
			return;
		}
		
		this.path = path;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.slots = slots;
		this.tileSize = width / slots;
		
		pixels = image.getRGB(0, 0, width, height, null, 0, width);
		
		list[id] = this;
		
		if (offSet > 0) {
			generateOffsetImage(offSet);
		}
		
		//Log.print("Spritesheet " + path + " loaded! - Width: " + width + ", Height: " + height + ", Slots: " + slots + " , TileSize: " + tileSize + ", Pixels: " + pixels.length);
	}
	
	private void generateOffsetImage(int offSet) {
		int[] cutOff = new int[pixels.length];
		int[] result = new int[pixels.length];
		
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
		
		if (newImage != null) {
			
			for (int i = 0; i < result.length; i++) {
				cutOff[i] = 0;
				result[i] = 0;
			}
			
			int index = 0;

			for(int y = 0; y < image.getHeight(); y++){
		        for(int x = 0; x < image.getWidth(); x++){
		          int pixel = pixels[x + y * image.getWidth()];
		          
		          if (y > offSet) {
		        	  cutOff[index] = pixel;
		        	  index++;
		          }
		        }       
		    }
			
			for (int i = 0; i < cutOff.length; i++) {
				result[i] = cutOff[i];
			}
			
			newImage.setRGB(0, 0, image.getWidth(), image.getHeight(), result, 0, image.getWidth());
			
			pixels = result;
			image = newImage;
		}
		
	}

	public int getShiftOperator() {
		switch(tileSize){
        case 0:
            return 0;
        case 2:
            return 1;
        case 4:
            return 2;
        case 8:
	        return 3;
        case 16:
            return 4;
        case 32:
            return 5;
        case 64:
            return 6;
        case 128:
            return 7;
        case 256:
            return 8;
        default:
        	return 3;
        }
	}
}
