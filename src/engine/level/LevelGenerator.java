package engine.level;

import engine.core.Config;
import engine.debug.Log;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import engine.tiles.TileBluePrint;
import engine.utils.Misc;
import engine.utils.OpenSimplexNoise;
import game_content.resources.Tiles;
import game_content.resources.Tiles.TILETYPE;

public class LevelGenerator {
	
	private static boolean changeUp = false;
	private static boolean changeDown = false;
	private static boolean changeLeft = false;
	private static boolean changeRight = false;

	public static void generateEmptyLevel(int width, int height, String tileName, Level level) {
		
		Log.print("Generate new empty level " + width + "x" + height + "!");	
		
		Tile[][] tiles = new Tile[width][height];
		
		TileBluePrint tileBluePrint = addGrassVariations();
		
		if (tileName != null && !tileName.isEmpty()) {
			if (!tileName.contains("GRASS")) {
				tileBluePrint = Tiles.getBluePrintByName(tileName);
			}
		}
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int id = x + y * width;

				tiles[x][y] = new BasicTile(id, x, y, tileBluePrint, 1.0f);
			}
		}
		
		level.tiles = tiles;
	}

	public static void generateRandomLevel(int width, int height, Level level) {
		
		Log.print("Generate new random level " + width + "x" + height + "!");
		
		Tile[][] tiles = new Tile[width][height];
		
		long seed = generateRandomSeed();
		OpenSimplexNoise noise = new OpenSimplexNoise(seed);
		double featureSizeBase = Misc.randomInteger(12, 35) * 1.15;
		double featureSizeLayer1 = featureSizeBase / 2.25;
		double featureSizeLayer2 = featureSizeBase * 2.75;
		double featureSizeLayer3 = featureSizeBase * 3.185;
		
		float lowNoise = 1;
		float highNoise = 0;
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				double noiseBaseValue1 = (1 + noise.eval((double) (x / featureSizeBase), (double) (y / featureSizeBase), (double) (y / featureSizeBase), (double) (x / featureSizeBase)) / 2);
				double noiseBaseValue2 = noise.eval((double) (x / featureSizeLayer1), (double) (y / featureSizeLayer1), (double) (y / featureSizeLayer1), (double) (x / featureSizeLayer1));
				double noiseBaseValue3 = noise.eval((double) (x / featureSizeLayer2), (double) (y / featureSizeLayer2), (double) (y / featureSizeLayer2), (double) (x / featureSizeLayer2));
				double noiseBaseValue4 = noise.eval((double) (x / featureSizeLayer3), (double) (y / featureSizeLayer3), (double) (y / featureSizeLayer3), (double) (x / featureSizeLayer3));
				double noiseBaseValue = (noiseBaseValue1 + noiseBaseValue2 + noiseBaseValue3 + noiseBaseValue4) / 4;
				float noiseValue = (float) (((noiseBaseValue + 1) * 127.5)) / 255;
				float heightValue = 1.0f;
						
				if (Config.HEIGHT_INFORMATIONS) {
					heightValue = Math.min((noiseValue - 0.35f) * 3.0f, 1.0f);
				}
				
				if (noiseValue > highNoise) {
					highNoise = noiseValue;
				}
				
				if (noiseValue < lowNoise) {
					lowNoise = noiseValue;
				}
				
				if (noiseValue <= 0.57) {
					noiseValue = 0.0f;
				}
				
				int id = x + y * width;
				
				if (noiseValue > 0) {
					// Grass layer
					tiles[x][y] = new BasicTile(id, x, y, addGrassVariations(), heightValue);
					
					// Sand layer
					if (noiseValue > 0.57 && noiseValue <= 0.59) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.SAND_CLEAN, heightValue);
					}
					
					// Dirt layer
					if (noiseValue > 0.59 && noiseValue <= 0.60) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.DIRT_CLEAN, heightValue);
					}
					
					// Dirt layer
					if (noiseValue > 0.73 && noiseValue < 0.75) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.DIRT_CLEAN, heightValue);
					}
					
					// Stone layer
					if (noiseValue >= 0.75) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.STONE_CLEAN, heightValue);
					}
				} else {
					// Water layer
					tiles[x][y] = new BasicTile(id, x, y, Tiles.WATER_CLEAN, heightValue);
				}
			}
		}

		System.err.println("Seed: " + seed + ", featureSize: " + featureSizeBase + ", lowNoise: " + lowNoise + ", highNoise" + highNoise);
		
		level.tiles = tiles;
	}
	
	public static void smoothWorld(Tile[][] tiles, int width, int height, Level level) {
		int iterations = 3;
		
		Log.print("Start Smoothing level tiles with " + iterations + " iterations...");
		
		for (int iteration = 0; iteration < iterations; iteration++) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					smoothBorders(level, x, y, tiles[x][y]);
				}
			}
		}
		
		Log.print("Level tiles smoothed!");
	}

	public static void smoothBorders(Level level, int x, int y, Tile currentTile) {
		changeUp = false;
		changeDown = false;
		changeLeft = false;
		changeRight = false;
		
		if (currentTile != null) {
			int xL = x - 1;
			int xR = x + 1;
			int yU = y - 1;
			int yD = y + 1;
			
			Tile upTile = null;
			Tile downTile = null;
			Tile leftTile = null;
			Tile rightTile = null;
			
			TILETYPE currentTileType = currentTile.bluePrint.type;
			String currentTileName = currentTile.bluePrint.name;
			
			TILETYPE upTileType = null;
			String upTileName = null;
			
			TILETYPE downTileType = null;
			String downTileName = null;
			
			TILETYPE leftTileType = null;
			String leftTileName = null;
			
			TILETYPE rightTileType = null;
			String rightTileName = null;
			
			if (xL >= 0 && xL < level.width) {
				leftTile = level.tiles[xL][y];

				if (leftTile != null) {
					leftTileName = leftTile.bluePrint.name;
					leftTileType = leftTile.bluePrint.type;
					
					if (!leftTileName.contains(currentTileName)) {
						leftTile.marked = true;
						changeLeft = true;
					}
				}
			}
			
			if (xR >= 0 && xR < level.width) {
				rightTile = level.tiles[xR][y];
				
				if (rightTile != null) {
					rightTileName = rightTile.bluePrint.name;
					rightTileType = rightTile.bluePrint.type;
					
					if (!rightTileName.contains(currentTileName)) {
						rightTile.marked = true;
						changeRight = true;
					}
				}
			}
			
			if (yU >= 0 && yU < level.height) {
				upTile = level.tiles[x][yU];
				
				if (upTile != null) {
					upTileName = upTile.bluePrint.name;
					upTileType = upTile.bluePrint.type;
					
					if (!upTileName.contains(currentTileName)) {
						upTile.marked = true;
						changeUp = true;
					}
				}
			}
			
			if (yD >= 0 && yD < level.height) {
				downTile = level.tiles[x][yD];
				
				if (downTile != null) {
					downTileName = downTile.bluePrint.name;
					downTileType = downTile.bluePrint.type;
					
					if (!downTileName.contains(currentTileName)) {
						downTile.marked = true;
						changeDown = true;
					}
				}
			}
			
			if (changeUp && changeLeft) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(upTileType.toString());
				fileName.append("_U_L");
				
				findTileAndReplace(level, xL, yU, fileName, currentTile, upTile, "_U_L");
			}
			
			if (changeUp && changeRight) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(upTileType.toString());
				fileName.append("_U_R");
				
				findTileAndReplace(level, xR, yU, fileName, currentTile, upTile, "_U_R");
			}
			
			if (changeDown && changeLeft) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(downTileType.toString());
				fileName.append("_B_L");
				
				findTileAndReplace(level, xL, yD, fileName, currentTile, downTile, "_B_L");
			}
			
			if (changeDown && changeRight) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(downTileType.toString());
				fileName.append("_B_R");
				
				findTileAndReplace(level, xR, yD, fileName, currentTile, downTile, "_B_R");
			}
			
			if (changeLeft) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(leftTileType.toString());
				fileName.append("_M_L");
				
				findTileAndReplace(level, xL, y, fileName, currentTile, leftTile, "_M_L");
			}
			
			if (changeRight) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(rightTileType.toString());
				fileName.append("_M_R");
				
				findTileAndReplace(level, xR, y, fileName, currentTile, rightTile, "_M_R");
			}
			
			if (changeUp) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(upTileType.toString());
				fileName.append("_U_M");
				
				findTileAndReplace(level, x, yU, fileName, currentTile, upTile, "_U_M");
			}
			
			if (changeDown) {
				StringBuilder fileName = new StringBuilder();
				fileName.append(currentTileType.toString());
				fileName.append("_");
				fileName.append(downTileType.toString());
				fileName.append("_B_M");
				
				findTileAndReplace(level, x, yD, fileName, currentTile, downTile, "_B_M");
			}
		}
	}

	private static void findTileAndReplace(Level level, int x, int y, StringBuilder fileName, Tile currentTile, Tile newtile, String alternativeTilePart) {
		TileBluePrint blueluePrint = Tiles.getBluePrintByName(fileName.toString());
		
		if (blueluePrint != null) {
			replaceTile(level, x, y, blueluePrint);
		} else {
			String alternativeTile = newtile.bluePrint.name.replace(currentTile.bluePrint.type.toString() + "_", "");
			String [] alternativeTileParts = alternativeTile.split("_");

			StringBuilder fileNameNew = new StringBuilder();
			fileNameNew.append(currentTile.bluePrint.type.toString());
			fileNameNew.append("_");
			fileNameNew.append(alternativeTileParts[0]);
			fileNameNew.append(alternativeTilePart);
		
			System.err.println(fileName.toString() + " failed. Alternative >> " + fileNameNew);
			
			blueluePrint = Tiles.getBluePrintByName(fileNameNew.toString());
			
			if (blueluePrint != null) {
				replaceTile(level, x, y, blueluePrint);
			}
		}
	}

	private static void replaceTile(Level level, int x, int y, TileBluePrint bluePrint) {
		int id = x + y * level.width;
		level.tiles[x][y] = new BasicTile(id, x, y, bluePrint, 1.0f);
		level.tiles[x][y].marked = true;
	}

	private static long generateRandomSeed() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			result = result + Misc.randomInteger(0, 9);
		}
		
		return Long.valueOf(result);
	}
	
	private static TileBluePrint addGrassVariations() {
		TileBluePrint result = Tiles.GRASS_CLEAN;
		
		int randomValue = Misc.randomInteger(0, 100);
		
		if (randomValue > 0 && randomValue <= 60) {
			result = Tiles.GRASS_CLEAN;
		} else if (randomValue > 0 && randomValue <= 60) {
			result = Tiles.GRASS_LUSH_01;
		} else if (randomValue > 60 && randomValue <= 70) {
			result = Tiles.GRASS_LUSH_02;
		} else if (randomValue > 70 && randomValue <= 80) {
			result = Tiles.GRASS_LUSH_03;
		} else if (randomValue > 80 && randomValue <= 85) {
			result = Tiles.GRASS_FLOWER_01;
		}
		
		return result;
	}

}
