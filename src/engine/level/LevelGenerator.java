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
	
	public static Tile[][] tiles;
	
	private static boolean changeUp = false;
	private static boolean changeDown = false;
	private static boolean changeLeft = false;
	private static boolean changeRight = false;

	public static Tile[][] generateEmptyLevel(int width, int height, String tileName) {
		
		Log.print("Generate new empty level " + width + "x" + height + "!");	
		
		tiles = new Tile[width][height];
		
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
		
		return tiles;
	}

	public static Tile[][] generateRandomLevel(int width, int height) {
		
		Log.print("Generate new random level " + width + "x" + height + "!");
		
		tiles = new Tile[width][height];
		
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
					tiles[x][y] = new BasicTile(id, x, y, Tiles.GRASS_CLEAN, heightValue);
					
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
		
		return tiles;
	}
	
	public static void smoothWorld(Tile[][] tiles, int width, int height) {
		int iterations = 3;
		
		Log.print("Start Smoothing level tiles with " + iterations + " iterations...");
		
		for (int iteration = 0; iteration < iterations; iteration++) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
//					smoothBorders(tiles, x, y, width, height, TILETYPE.WATER);
//					smoothBorders(tiles, x, y, width, height, TILETYPE.SAND);
//					smoothBorders(tiles, x, y, width, height, TILETYPE.DIRT);
//					smoothBorders(tiles, x, y, width, height, TILETYPE.GRASS);
//					smoothBorders(tiles, x, y, width, height, TILETYPE.STONE);
					
					smoothBorders(tiles, x, y, width, height, TILETYPE.STONE);
					smoothBorders(tiles, x, y, width, height, TILETYPE.GRASS);
					smoothBorders(tiles, x, y, width, height, TILETYPE.DIRT);
					smoothBorders(tiles, x, y, width, height, TILETYPE.SAND);
					smoothBorders(tiles, x, y, width, height, TILETYPE.WATER);
				}
			}
		}
		
		Log.print("Level tiles smoothed!");
	}

	private static void smoothBorders(Tile[][] tiles, int x, int y, int width, int height, TILETYPE searchType) {
		Tile currentTile = tiles[x][y];
		changeUp = false;
		changeDown = false;
		changeLeft = false;
		changeRight = false;
		
		if (currentTile != null && !currentTile.smoothed) {
			int xL = x - 1;
			int xR = x + 1;
			int yU = y - 1;
			int yD = y + 1;
			
			Tile upTile = null;
			Tile downTile = null;
			Tile leftTile = null;
			Tile rightTile = null;
			
			TILETYPE currenTileType = currentTile.bluePrint.type;
			TILETYPE upTileType = null;
			TILETYPE downTileType = null;
			TILETYPE leftTileType = null;
			TILETYPE rightTileType = null;
			
			if (currenTileType.equals(searchType)) {
				if (xL >= 0 && xL < width) {
					leftTile = tiles[xL][y];
					
					if (leftTile != null) {
						leftTileType = leftTile.bluePrint.type;
						
						if (!leftTileType.equals(currenTileType)) {
							//leftTile.selected = true;
							changeLeft = true;
						}
					}
				}
				
				if (xR >= 0 && xR < width) {
					rightTile = tiles[xR][y];
					
					if (rightTile != null) {
						rightTileType = rightTile.bluePrint.type;
						
						if (!rightTileType.equals(currenTileType)) {
							//rightTile.selected = true;
							changeRight = true;
						}
					}
				}
				
				if (yU >= 0 && yU < height) {
					upTile = tiles[x][yU];
					
					if (upTile != null) {
						upTileType = upTile.bluePrint.type;
						
						if (!upTileType.equals(currenTileType)) {
							//upTile.selected = true;
							changeUp = true;
						}
					}
				}
				
				if (yD >= 0 && yD < height) {
					downTile = tiles[x][yD];
					
					if (downTile != null) {
						downTileType = downTile.bluePrint.type;
						
						if (!downTileType.equals(currenTileType)) {
							//downTile.selected = true;
							changeDown = true;
						}
					}
				}
				
				if (changeLeft && changeRight && changeUp && changeDown) {
					currentTile.smoothed = true;
				}
				
				if (changeLeft) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(leftTileType.toString());
					fileName.append("_M_L");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xL, y, width, newBluePrint, true);
					}
				}
				
				if (changeRight) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(rightTileType.toString());
					fileName.append("_M_R");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xR, y, width, newBluePrint, true);
					}
				}
				
				if (changeUp) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(upTileType.toString());
					fileName.append("_U_M");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, x, yU, width, newBluePrint, true);
					}
				}
				
				if (changeDown) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(downTileType.toString());
					fileName.append("_B_M");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, x, yD, width, newBluePrint, true);
					}
				}
				
				if (changeUp && changeLeft) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(upTileType.toString());
					fileName.append("_U_L");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xL, yU, width, newBluePrint, true);
					}
				}
				
				if (changeUp && changeRight) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(upTileType.toString());
					fileName.append("_U_R");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xR, yU, width, newBluePrint, true);
					}
				}
				
				if (changeDown && changeLeft) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(downTileType.toString());
					fileName.append("_B_L");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xL, yD, width, newBluePrint, true);
					}
				}
				
				if (changeDown && changeRight) {
					StringBuilder fileName = new StringBuilder();
					fileName.append(currenTileType.toString());
					fileName.append("_");
					fileName.append(downTileType.toString());
					fileName.append("_B_R");
					
					TileBluePrint newBluePrint = Tiles.getBluePrintByName(fileName.toString());
					
					if (newBluePrint != null) {
						replaceTile(tiles, xR, yD, width, newBluePrint, true);
					}
				}
			}
		}
	}

	private static void replaceTile(Tile[][] tiles, int x, int y, int width, TileBluePrint newTile, boolean smoothed) {
		if (newTile != null) {
			if (!tiles[x][y].smoothed) {
				int id = x + y * width;
				float brightness = tiles[x][y].brightness;
				tiles[x][y] = new BasicTile(id, x, y, newTile, brightness);
				tiles[x][y].smoothed = smoothed;
				//tiles[x][y].selected = true;
			}
		}
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
