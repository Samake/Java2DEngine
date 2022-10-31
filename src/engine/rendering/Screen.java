package engine.rendering;

import java.awt.Color;

import engine.collission.CollissionBox;
import engine.core.Config;
import engine.debug.Log;
import engine.sprites.SpriteAtlas;
import engine.sprites.SpriteSheet;

public class Screen {

	public static final byte BIT_MIRROR_X = 0x01;
	public static final byte BIT_MIRROR_Y = 0x02;

	public int[] pixelsScene;
	public int[] pixelsGUI;

	public int xOffset = 0;
	public int yOffset = 0;
	
	private int minX = 0;
	private int maxX = 0;
	private int minY = 0;
	private int maxY = 0;
	
	public Screen() {
		this.maxX = Config.WINDOW_WIDTH;
		this.maxY = Config.WINDOW_HEIGHT;
		
		reset();
		
		Log.print("Screen were created! Width: " + Config.WINDOW_WIDTH + ", Height: " + Config.WINDOW_HEIGHT + ", Scale: " + Config.WINDOW_SCALE + ", Native Resolution: " + (Config.WINDOW_WIDTH * Config.WINDOW_SCALE) + "x" + (Config.WINDOW_HEIGHT * Config.WINDOW_SCALE) + ", Pixels: " + pixelsScene.length);
	}
	
	public void reset() {
		pixelsScene = new int[Config.WINDOW_WIDTH * Config.WINDOW_HEIGHT];
		pixelsGUI = new int[Config.WINDOW_WIDTH * Config.WINDOW_HEIGHT];
	}
	
	public void renderShadow(SpriteAtlas atlas, float inX, float inY, int tileID, int mirrorDir, float scale, float alpha, float shadowStrength) {
		int xPos = (int) (inX - xOffset);
		int yPos = (int) (inY - yOffset);
		
		SpriteSheet sheet = atlas.sheet;
		
		if (sheet != null && isRendered(atlas.sheet, xPos, yPos)) {		
			boolean xMirror = (mirrorDir & BIT_MIRROR_X) > 0;
			boolean yMirror = (mirrorDir & BIT_MIRROR_Y) > 0;
			
			float scaleMap = scale - 1.0f;
			
			int xTile = tileID % sheet.slots;
			int yTile = tileID / sheet.slots;
			int tileOffset = (xTile << sheet.getShiftOperator()) + (yTile << sheet.getShiftOperator()) * sheet.width;
			
			for (int y = 0; y < sheet.tileSize; y++) {
				int ySheet = y;
				
				if (yMirror) ySheet = sheet.tileSize - 1 - y;
				
				float yPixel = y + yPos + (y * scaleMap) - (((int) scaleMap << sheet.getShiftOperator()) / 2);

				for (int x = 0; x < sheet.tileSize; x++) {
					int xSheet = x;
					
					if (xMirror) xSheet = sheet.tileSize - 1 - x;
					
					float xPixel = x + xPos + (x * scaleMap) - (((int)scaleMap << sheet.getShiftOperator()) / 2);
					
					int col = sheet.pixels[xSheet + ySheet * sheet.width + tileOffset];
		
					if (col < 255) {
						Color drawColor = new Color(col, true);
						
						if (drawColor.getAlpha() > 0) {
							for (int yScale = 0; yScale < scale; yScale++) {
								if (yPixel + yScale < 0 || yPixel + yScale >= Config.WINDOW_HEIGHT) continue;
								
								for (int xScale = 0; xScale < scale; xScale++) {
									if (xPixel + xScale < 0 || xPixel + xScale >= Config.WINDOW_WIDTH) continue;
									
									int currentColorInt = pixelsScene[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH];
									Color currentColor = new Color(currentColorInt);
									
									int shadowRed = (int) (currentColor.getRed() * (1.0f - shadowStrength));
									int shadowGreen= (int) (currentColor.getGreen() * (1.0f - shadowStrength));
									int shadowBlue = (int) (currentColor.getBlue() * (1.0f - shadowStrength));
									
									Color shadowColor = new Color(shadowRed, shadowGreen, shadowBlue);
				
									pixelsScene[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH] = shadowColor.getRGB();
								}
							}
						} else {
							continue;
						}
					}
				}
			}
		}
	}
	
	public void render(SpriteAtlas atlas, float inX, float inY, int tileID, int mirrorDir, float scale, float alpha, float brightness, boolean isInWater) {
		int xPos = (int) (inX - xOffset);
		int yPos = (int) (inY - yOffset);
		
		SpriteSheet sheet = atlas.sheet;
		
		if (sheet != null && isRendered(atlas.sheet, xPos, yPos)) {		
			boolean xMirror = (mirrorDir & BIT_MIRROR_X) > 0;
			boolean yMirror = (mirrorDir & BIT_MIRROR_Y) > 0;
			
			float scaleMap = scale - 1.0f;
			
			int xTile = tileID % sheet.slots;
			int yTile = tileID / sheet.slots;
			int tileOffset = (xTile << sheet.getShiftOperator()) + (yTile << sheet.getShiftOperator()) * sheet.width;
			
			for (int y = 0; y < sheet.tileSize; y++) {
				int ySheet = y;
				
				if (yMirror) ySheet = sheet.tileSize - 1 - y;
				
				float yPixel = y + yPos + (y * scaleMap) - (((int) scaleMap << sheet.getShiftOperator()) / 2);

				for (int x = 0; x < sheet.tileSize; x++) {
					int xSheet = x;
					
					if (xMirror) xSheet = sheet.tileSize - 1 - x;
					
					float xPixel = x + xPos + (x * scaleMap) - (((int)scaleMap << sheet.getShiftOperator()) / 2);
					
					int col = sheet.pixels[xSheet + ySheet * sheet.width + tileOffset];
		
					if (col < 255) {
						Color drawColor;
						
						if (Config.HEIGHT_INFORMATIONS) {
							Color drawBaseColor = new Color(col, true);
							
							float redValue = (float) (drawBaseColor.getRed() * brightness);
							float greenValue = (float) (drawBaseColor.getGreen() * brightness);
							float blueValue = (float) (drawBaseColor.getBlue() * brightness);
							
							drawColor = new Color((int) redValue, (int) greenValue, (int) blueValue, drawBaseColor.getAlpha());
						} else {
							drawColor = new Color(col, true);
						}
						
						if (drawColor.getAlpha() > 0) {
							for (int yScale = 0; yScale < scale; yScale++) {
								if (yPixel + yScale < 0 || yPixel + yScale >= Config.WINDOW_HEIGHT) continue;
								
								for (int xScale = 0; xScale < scale; xScale++) {
									if (xPixel + xScale < 0 || xPixel + xScale >= Config.WINDOW_WIDTH) continue;

									int currentColor = pixelsScene[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH];
									
									pixelsScene[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH] = mergeIntColors(currentColor, drawColor, alpha, isInWater, sheet.tileSize, y);
								}
							}
						} else {
							continue;
						}
					}
				}
			}
		}
	}
	
	private int mergeIntColors(int currentColor, Color drawColor, float alpha, boolean isInWater, int size, int height) {
		if (isInWater) {
			alpha *= 0.99f;
		}

		if (alpha < 1.0f) {
			Color baseColor = new Color(currentColor, true);
			
			int red;
			int green;
			int blue;
			int alphaValue = baseColor.getAlpha();
			
			if (isInWater) {
				float waterFade = 1.0f - ((1.0f / size) * height * 2);
				alpha = waterFade * 0.5f;

				red = (int) (baseColor.getRed() * (1.0 - alpha)) + (int) (drawColor.getRed() * alpha);
				green = (int) (baseColor.getGreen() * (1.0 - alpha)) + (int) (drawColor.getGreen() * alpha);
				blue = (int) (baseColor.getBlue() * (1.0 - alpha)) + (int) (drawColor.getBlue() * alpha);
				
				red += baseColor.getRed();
				green += baseColor.getGreen();
				blue += baseColor.getBlue();
				
				red /= 2;
				green /= 2;
				blue /= 2;
			} else {
				red = (int) (baseColor.getRed() * (1.0 - alpha)) + (int) (drawColor.getRed() * alpha);
				green = (int) (baseColor.getGreen() * (1.0 - alpha)) + (int) (drawColor.getGreen() * alpha);
				blue = (int) (baseColor.getBlue() * (1.0 - alpha)) + (int) (drawColor.getBlue() * alpha);
			}

			if (red < 0) {red = 0;}
			if (red > 255) {red = 255;}
			if (green < 0) {green = 0;}
			if (green > 255) {green = 255;}
			if (blue < 0) {blue = 0;}
			if (blue > 255) {blue = 255;}
			
			Color mergedColor = new Color(red ,green, blue, alphaValue);
		
			return mergedColor.getRGB();
		}
		
		return drawColor.getRGB();
	}
	
	public void renderFont(SpriteAtlas atlas, float inX, float inY, int tileID, int mirrorDir, float scale, Color fontColor) {
		int xPos = (int) (inX - xOffset);
		int yPos = (int) (inY - yOffset);
		
		SpriteSheet sheet = atlas.sheet;
		
		if (sheet != null && isRendered(atlas.sheet, xPos, yPos)) {		
			boolean xMirror = (mirrorDir & BIT_MIRROR_X) > 0;
			boolean yMirror = (mirrorDir & BIT_MIRROR_Y) > 0;
			
			float scaleMap = scale - 1.0f;
			
			int xTile = tileID % sheet.slots;
			int yTile = tileID / sheet.slots;
			int tileOffset = (xTile << sheet.getShiftOperator()) + (yTile << sheet.getShiftOperator()) * sheet.width;
			
			for (int y = 0; y < sheet.tileSize; y++) {
				int ySheet = y;
				
				if (yMirror) ySheet = sheet.tileSize - 1 - y;
				
				float yPixel = y + yPos + (y * scaleMap) - (((int) scaleMap << sheet.getShiftOperator()) / 2);

				for (int x = 0; x < sheet.tileSize; x++) {
					int xSheet = x;
					
					if (xMirror) xSheet = sheet.tileSize - 1 - x;
					
					float xPixel = x + xPos + (x * scaleMap) - (((int)scaleMap << sheet.getShiftOperator()) / 2);
					
					int col = sheet.pixels[xSheet + ySheet * sheet.width + tileOffset];
		
					if (col < 255) {
						
						Color drawColor = new Color(col, true);
						int r = drawColor.getRed() * fontColor.getRed();
						int g = drawColor.getGreen() * fontColor.getGreen();
						int b = drawColor.getBlue() * fontColor.getBlue();
						int a = drawColor.getAlpha();
						
						Color finalfontColor = new Color(r / 255, g / 255, b / 255, a);
						
						if (drawColor.getAlpha() > 0) {
							for (int yScale = 0; yScale < scale; yScale++) {
								if (yPixel + yScale < 0 || yPixel + yScale >= Config.WINDOW_HEIGHT) continue;
								
								for (int xScale = 0; xScale < scale; xScale++) {
									if (xPixel + xScale < 0 || xPixel + xScale >= Config.WINDOW_WIDTH) continue;
									
									pixelsGUI[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH] = finalfontColor.getRGB();
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void renderGUI(SpriteAtlas atlas, float inX, float inY, int tileID, int mirrorDir, float scale) {
		int xPos = (int) (inX);
		int yPos = (int) (inY);
		
		SpriteSheet sheet = atlas.sheet;
		
		if (sheet != null && isRendered(atlas.sheet, xPos, yPos)) {		
			boolean xMirror = (mirrorDir & BIT_MIRROR_X) > 0;
			boolean yMirror = (mirrorDir & BIT_MIRROR_Y) > 0;
			
			float scaleMap = scale - 1.0f;
			
			int xTile = tileID % sheet.slots;
			int yTile = tileID / sheet.slots;
			int tileOffset = (xTile << sheet.getShiftOperator()) + (yTile << sheet.getShiftOperator()) * sheet.width;
			
			for (int y = 0; y < sheet.tileSize; y++) {
				int ySheet = y;
				
				if (yMirror) ySheet = sheet.tileSize - 1 - y;
				
				float yPixel = y + yPos + (y * scaleMap) - (((int) scaleMap << sheet.getShiftOperator()) / 2);

				for (int x = 0; x < sheet.tileSize; x++) {
					int xSheet = x;
					
					if (xMirror) xSheet = sheet.tileSize - 1 - x;
					
					float xPixel = x + xPos + (x * scaleMap) - (((int)scaleMap << sheet.getShiftOperator()) / 2);
					
					int col = sheet.pixels[xSheet + ySheet * sheet.width + tileOffset];
		
					if (col < 255) {
						
						Color drawColor = new Color(col, true);
						
						if (drawColor.getAlpha() > 0) {
							for (int yScale = 0; yScale < scale; yScale++) {
								if (yPixel + yScale < 0 || yPixel + yScale >= Config.WINDOW_HEIGHT) continue;
								
								for (int xScale = 0; xScale < scale; xScale++) {
									if (xPixel + xScale < 0 || xPixel + xScale >= Config.WINDOW_WIDTH) continue;
									
									pixelsGUI[((int) xPixel + xScale) + ((int) yPixel + yScale) * Config.WINDOW_WIDTH] = col;
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void renderDebug(CollissionBox box, Color debugColor) {
		if (box != null) {
			int minX = (int) (box.position.x + box.minX - xOffset);
			int maxX = (int) (box.position.x + box.maxX - xOffset);
			int minY = (int) (box.position.y + box.minY - yOffset);
			int maxY = (int) (box.position.y + box.maxY - yOffset);
			
			for (int x = minX; x <= maxX; x++) {
				int upperValue = x + minY * Config.WINDOW_WIDTH;
				int downValue = x + maxY * Config.WINDOW_WIDTH;
				
				if (pixelsGUI.length > upperValue && upperValue > 0) {
					pixelsGUI[upperValue] = debugColor.getRGB();
				}
				
				if (pixelsGUI.length > downValue && downValue > 0) {
					pixelsGUI[downValue] = debugColor.getRGB();
				}
			}
			
			for (int y = minY; y <= maxY; y++) {
				int upperValue = minX + y * Config.WINDOW_WIDTH;
				int downValue = maxX + y * Config.WINDOW_WIDTH;
				
				if (pixelsGUI.length > upperValue && upperValue > 0) {
					pixelsGUI[upperValue] = debugColor.getRGB();
				}
				
				if (pixelsGUI.length > downValue && downValue > 0) {
					pixelsGUI[downValue] = debugColor.getRGB();
				}
			}
		}
	}

	public void renderSelectedTile(float inX, float inY, int inWidth, int inHeight, Color color) {
		int xPos = (int) (inX - xOffset);
		int yPos = (int) (inY - yOffset);
		
		// draw frame
		for (int x = xPos; x < xPos + inWidth; x++) {
			int upperValue = x + yPos * Config.WINDOW_WIDTH;
			int downValue = x + (yPos + inHeight - 1) * Config.WINDOW_WIDTH;
			
			if (pixelsGUI.length > upperValue && upperValue >= 0) {
				pixelsGUI[upperValue] = color.getRGB();
			}
			
			if (pixelsGUI.length > downValue && downValue >= 0) {
				pixelsGUI[downValue] = color.getRGB();
			}
		}
		
		for (int y = yPos; y < yPos + inHeight; y++) {
			int upperValue = xPos + y * Config.WINDOW_WIDTH;
			int downValue = (xPos + inWidth - 1) + y * Config.WINDOW_WIDTH;
			
			if (pixelsGUI.length > upperValue && upperValue >= 0) {
				pixelsGUI[upperValue] = color.getRGB();
			}
			
			if (pixelsGUI.length > downValue && downValue >= 0) {
				pixelsGUI[downValue] = color.getRGB();
			}
		}
	}
	
	public boolean isRendered(SpriteSheet sheet, int x, int y) {
		if (x + sheet.tileSize > minX && x - sheet.tileSize < maxX) {
			if (y + sheet.tileSize > minY && y - sheet.tileSize < maxY) {
				return true;
			}
		}
		
		return false;
	}
	
	public void setOffset(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
}
