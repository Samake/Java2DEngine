package engine.level;

import engine.core.Config;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import engine.tiles.TileBluePrint;
import engine.utils.Misc;
import engine.utils.OpenSimplexNoise;
import game_content.resources.Tiles;

public class LevelGenerator {
	
	public static Tile[][] tiles;

	public static Tile[][] generateEmptyLevel(int width, int height, String tileName) {
		tiles = new Tile[width][height];
		
		TileBluePrint tileBluePrint = Tiles.GRASS_CLEAN;
		
		if (tileName != null && !tileName.isEmpty()) {
			tileBluePrint = Tiles.getBluePrintByName(tileName);
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
					tiles[x][y] = new BasicTile(id, x, y, Tiles.GRASS_CLEAN, heightValue);
					
					if (noiseValue > 0.57 && noiseValue <= 0.59) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.SAND_CLEAN, heightValue);
					}
					
					if (noiseValue > 0.59 && noiseValue <= 0.60) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.DIRT_CLEAN, heightValue);
					}
					
					if (noiseValue > 0.73 && noiseValue < 0.75) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.DIRT_CLEAN, heightValue);
					}
					
					if (noiseValue >= 0.75) {
						tiles[x][y] = new BasicTile(id, x, y, Tiles.STONE_CLEAN, heightValue);
					}
				} else {
					tiles[x][y] = new BasicTile(id, x, y, Tiles.WATER_CLEAN, heightValue);
				}
			}
		}
		
		System.err.println("Seed: " + seed + ", featureSize: " + featureSizeBase + ", lowNoise: " + lowNoise + ", highNoise" + highNoise);
		
		return tiles;
	}

	private static long generateRandomSeed() {
		String result = "";
		
		for (int i = 0; i < 10; i++) {
			result = result + Misc.randomInteger(0, 9);
		}
		
		return Long.valueOf(result);
	}

}
