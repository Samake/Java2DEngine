package engine.level;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	
				if (tiles[x][y] == null) {
					tiles[x][y] = new BasicTile(id, x, y, tileBluePrint, 1.0f);
				}
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
		
		Log.print("Start smoothing level tiles...");
		
		// simplify borders
		Log.print("Simplify level tiles...");
		
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				simplifyBorders(tiles, x, y, width, height);
			}
		}
		
		Log.print("Level tiles simplified!");
		
		// smooth borders
		int iterations = 1;
		
		Log.print("Smoothing level tiles with " + iterations + " iterations...");
		
		for (int iteration = 0; iteration < iterations; iteration++) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					smoothBorders(tiles, x, y, width, height);
				}
			}
		}
		
		Log.print("Level tiles smoothed!");
	}
	
	private static void simplifyBorders(Tile[][] tiles, int x, int y, int width, int height) {
		Tile currentTile = tiles[x][y];
		
		if (currentTile != null) {
			int xLlength = width;
			int yLlength = height;
			int xPos = x;
			int xPosL = xPos - 1;
			int xPosR = xPos + 1;
			int yPos = y;
			int yPosU = yPos - 1;
			int yPosD = yPos + 1;

			boolean changeUp = false;
			boolean changeDown = false;
			boolean changeLeft = false;
			boolean changeRight = false;
			
			Tile upTile = null;
			Tile downTile = null;
			Tile leftTile = null;
			Tile rightTile = null;
			
			TILETYPE currenTileType = null;
			TILETYPE upTileType = null;
			TILETYPE downTileType = null;
			TILETYPE leftTileType = null;
			TILETYPE rightTileType = null;
			
			boolean startProcess = true;

			Map<TileBluePrint, Integer> replaceOptions = new HashMap<TileBluePrint, Integer>();
			
			if (startProcess) {
				currenTileType = currentTile.blueprint.type;

				if (xPosL > 0 && xPosL < xLlength) {
					leftTile = tiles[xPosL][yPos];
				}
				
				if (xPosR > 0 && xPosR < xLlength) {
					rightTile = tiles[xPosR][yPos];
				}
				
				if (yPosU > 0 && yPosU < yLlength) {
					upTile = tiles[xPos][yPosU];
				}
				
				if (yPosD > 0 && yPosD < yLlength) {
					downTile = tiles[xPos][yPosD];
				}
				
				if (upTile != null) {
					upTileType = upTile.blueprint.type;
					
					if (upTileType != null) {
						if (!upTileType.equals(currenTileType)) {
							changeUp = true;
				
							if (!replaceOptions.containsKey(upTile.blueprint)) {
								replaceOptions.put(upTile.blueprint, 1);
							} else {
								int counter = replaceOptions.get(upTile.blueprint) + 1;
								replaceOptions.replace(upTile.blueprint, counter);
							}
						}
					}
				}
				
				if (downTile != null) {
					downTileType = downTile.blueprint.type;
					
					if (downTileType != null) {
						if (!downTileType.equals(currenTileType)) {
							changeDown = true;
							
							if (!replaceOptions.containsKey(downTile.blueprint)) {
								replaceOptions.put(downTile.blueprint, 1);
							} else {
								int counter = replaceOptions.get(downTile.blueprint) + 1;
								replaceOptions.replace(downTile.blueprint, counter);
							}
						}
					}
				}
				
				if (leftTile != null) {
					leftTileType = leftTile.blueprint.type;
					
					if (leftTileType != null) {
						if (!leftTileType.equals(currenTileType)) {
							changeLeft = true;
							
							if (!replaceOptions.containsKey(leftTile.blueprint)) {
								replaceOptions.put(leftTile.blueprint, 1);
							} else {
								int counter = replaceOptions.get(leftTile.blueprint) + 1;
								replaceOptions.replace(leftTile.blueprint, counter);
							}
						}
					}
				}
				
				if (rightTile != null) {
					rightTileType = rightTile.blueprint.type;
					
					if (rightTileType != null) {
						if (!rightTileType.equals(currenTileType)) {
							changeRight = true;
							
							if (!replaceOptions.containsKey(rightTile.blueprint)) {
								replaceOptions.put(rightTile.blueprint, 1);
							} else {
								int counter = replaceOptions.get(rightTile.blueprint) + 1;
								replaceOptions.replace(rightTile.blueprint, counter);
							}
						}
					}
				}
				
				if (changeUp && changeDown && changeLeft && changeRight) {
					int count = 0;
					TileBluePrint bluePrint = null; 
					
					for (Entry<TileBluePrint, Integer> entry : replaceOptions.entrySet()) {
						if (entry != null) {
							if (entry.getValue() >= count) {
								count = entry.getValue();
								bluePrint = entry.getKey();
							}
						}
					}
					
					if (bluePrint != null) {
						replaceTile(tiles, xPos, yPos, width, bluePrint, false);
					}
				}
				
				replaceOptions = null;
			}
		}
	}
	
	private static void smoothBorders(Tile[][] tiles, int x, int y, int width, int height) {
		Tile currentTile = tiles[x][y];
		
		if (currentTile != null) {
			int xLlength = width;
			int yLlength = height;
			int xPos = x;
			int xPosL = xPos - 1;
			int xPosR = xPos + 1;
			int yPos = y;
			int yPosU = yPos - 1;
			int yPosD = yPos + 1;

			boolean changeUp = false;
			boolean changeDown = false;
			boolean changeLeft = false;
			boolean changeRight = false;
			
			Tile upTile = null;
			Tile downTile = null;
			Tile leftTile = null;
			Tile rightTile = null;
			
			TILETYPE currenTileType = null;
			TILETYPE upTileType = null;
			TILETYPE downTileType = null;
			TILETYPE leftTileType = null;
			TILETYPE rightTileType = null;
			
			boolean startProcess = true;
			
			//startProcess = !currentTile.blueprint.name.contains("CLEAN");

			if (startProcess) {
				currenTileType = currentTile.blueprint.type;

				if (xPosL > 0 && xPosL < xLlength) {
					leftTile = tiles[xPosL][yPos];
				}
				
				if (xPosR > 0 && xPosR < xLlength) {
					rightTile = tiles[xPosR][yPos];
				}
				
				if (yPosU > 0 && yPosU < yLlength) {
					upTile = tiles[xPos][yPosU];
				}
				
				if (yPosD > 0 && yPosD < yLlength) {
					downTile = tiles[xPos][yPosD];
				}
				
				if (upTile != null && !upTile.smoothed) {
					upTileType = upTile.blueprint.type;
					
					if (upTileType != null) {
						if (!upTileType.equals(currenTileType)) {
							changeUp = true;
						}
					}
				}
				
				if (downTile != null && !downTile.smoothed) {
					downTileType = downTile.blueprint.type;
					
					if (downTileType != null) {
						if (!downTileType.equals(currenTileType)) {
							changeDown = true;
						}
					}
				}
				
				if (leftTile != null && !leftTile.smoothed) {
					leftTileType = leftTile.blueprint.type;
					
					if (leftTileType != null) {
						if (!leftTileType.equals(currenTileType)) {
							changeLeft = true;
						}
					}
				}
				
				if (rightTile != null && !rightTile.smoothed) {
					rightTileType = rightTile.blueprint.type;
					
					if (rightTileType != null) {
						if (!rightTileType.equals(currenTileType)) {
							changeRight = true;
						}
					}
				}
				

				if (changeUp && !changeDown) {
					StringBuilder tileName = new StringBuilder();

					tileName = new StringBuilder();
					tileName.append(upTileType.toString());
					tileName.append("_");
					tileName.append(currenTileType.toString());
					tileName.append("_B_M");
					
					TileBluePrint newTile = Tiles.getBluePrintByName(tileName.toString());
					
					if (newTile != null) {
						replaceTile(tiles, xPos, yPosU, width, newTile, true);
					}
				}
				
				if (changeDown && !changeUp) {
					StringBuilder tileName = new StringBuilder();

					tileName = new StringBuilder();
					tileName.append(downTileType.toString());
					tileName.append("_");
					tileName.append(currenTileType.toString());
					tileName.append("_U_M");
					
					TileBluePrint newTile = Tiles.getBluePrintByName(tileName.toString());
					
					if (newTile != null) {
						replaceTile(tiles, xPos, yPosD, width, newTile, true);
					}
				}
//				
//				if (changeLeft && !changeUp && !changeDown && !changeRight) {
//					StringBuilder tileName = new StringBuilder();
//
//					tileName = new StringBuilder();
//					tileName.append(leftTileType.toString());
//					tileName.append("_");
//					tileName.append(currenTileType.toString());
//					tileName.append("_M_R");
//					
//					TileBluePrint newTile = Tiles.getBluePrintByName(tileName.toString());
//					
//					if (newTile != null) {
//						replaceTile(tiles, xPosL, yPos, width, newTile, true);
//					}
//				}
				
				//TileBluePrint newTile = Tiles.getBluePrintByName(tileName.toString());
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
