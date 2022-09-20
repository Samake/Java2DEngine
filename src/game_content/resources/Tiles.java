package game_content.resources;

import engine.sprites.SpriteAtlas;
import engine.tiles.TileBluePrint;

public class Tiles {
	
	public enum TILETYPE {
		VOID, GRASS, SAND, STONE, WATER, DIRT, STREET, EARTH, WOOD
	}
	
	public static final TileBluePrint[] tileTypes = new TileBluePrint[2048];
	
	private static int voidIndex = 0;
	
	private static int grassIndex = 100;
	private static float grassHestitation = 1.0f; //0.8f
	
	private static int sandIndex = 200;
	private static float sandHestitation = 1.0f; //0.6f
	
	private static int stoneIndex = 300;
	private static float stoneHestitation = 1.0f; //1.0f
	
	private static int waterIndex = 400;
	private static float waterHestitation = 1.0f; // 0.5f
	
	private static int dirtIndex = 500;
	private static float dirtHestitation = 1.0f; // 0.7f
	
	private static int streetIndex = 600;
	private static float streetHestitation = 1.0f; // 1.0f
	
	private static int earthIndex = 700;
	private static float earthHestitation = 1.0f; // 0.7f
	
	private static int woodIndex = 800;
	private static float woodHestitation = 1.0f; // 1.0f
	
	/** VOID **/
	public static final TileBluePrint VOID = new TileBluePrint(tileTypes, voidIndex, TILETYPE.VOID, "VOID", new SpriteAtlas(Sheets.TILES_SHEET, 0, 0, false, 0, 0, false), 0.1f, true);
	
	/** GRASS **/
	public static final TileBluePrint GRASS_CLEAN = new TileBluePrint(tileTypes, grassIndex + 0, TILETYPE.GRASS, "GRASS_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_LUSH_01 = new TileBluePrint(tileTypes, grassIndex + 1, TILETYPE.GRASS, "GRASS_LUSH_01",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_LUSH_02 = new TileBluePrint(tileTypes, grassIndex + 2, TILETYPE.GRASS, "GRASS_LUSH_02",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_LUSH_03 = new TileBluePrint(tileTypes, grassIndex + 3, TILETYPE.GRASS, "GRASS_LUSH_03",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_FLOWER_01 = new TileBluePrint(tileTypes, grassIndex + 4, TILETYPE.GRASS, "GRASS_FLOWER_01",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 1, false, 0, 0, false), grassHestitation, false);	
	public static final TileBluePrint GRASS_EARTH_U_L = new TileBluePrint(tileTypes, grassIndex + 5, TILETYPE.GRASS, "GRASS_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_U_M = new TileBluePrint(tileTypes, grassIndex + 6, TILETYPE.GRASS, "GRASS_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_U_R = new TileBluePrint(tileTypes, grassIndex + 7, TILETYPE.GRASS, "GRASS_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_M_L = new TileBluePrint(tileTypes, grassIndex + 8, TILETYPE.GRASS, "GRASS_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_M_R = new TileBluePrint(tileTypes, grassIndex + 9, TILETYPE.GRASS, "GRASS_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_B_L = new TileBluePrint(tileTypes, grassIndex + 10, TILETYPE.GRASS, "GRASS_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_B_M = new TileBluePrint(tileTypes, grassIndex + 11, TILETYPE.GRASS, "GRASS_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_EARTH_B_R = new TileBluePrint(tileTypes, grassIndex + 12, TILETYPE.GRASS, "GRASS_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 3, false, 0, 0, false), grassHestitation, false);	
	public static final TileBluePrint GRASS_STREET_U_L = new TileBluePrint(tileTypes, grassIndex + 13, TILETYPE.GRASS, "GRASS_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_U_M = new TileBluePrint(tileTypes, grassIndex + 14, TILETYPE.GRASS, "GRASS_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_U_R = new TileBluePrint(tileTypes, grassIndex + 15, TILETYPE.GRASS, "GRASS_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_M_L = new TileBluePrint(tileTypes, grassIndex + 16, TILETYPE.GRASS, "GRASS_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_M_R = new TileBluePrint(tileTypes, grassIndex + 17, TILETYPE.GRASS, "GRASS_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_B_L = new TileBluePrint(tileTypes, grassIndex + 18, TILETYPE.GRASS, "GRASS_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_B_M = new TileBluePrint(tileTypes, grassIndex + 19, TILETYPE.GRASS, "GRASS_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STREET_B_R = new TileBluePrint(tileTypes, grassIndex + 20, TILETYPE.GRASS, "GRASS_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_U_L = new TileBluePrint(tileTypes, grassIndex + 21, TILETYPE.GRASS, "GRASS_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_U_M = new TileBluePrint(tileTypes, grassIndex + 22, TILETYPE.GRASS, "GRASS_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_U_R = new TileBluePrint(tileTypes, grassIndex + 23, TILETYPE.GRASS, "GRASS_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_M_L = new TileBluePrint(tileTypes, grassIndex + 24, TILETYPE.GRASS, "GRASS_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_M_R = new TileBluePrint(tileTypes, grassIndex + 25, TILETYPE.GRASS, "GRASS_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_B_L = new TileBluePrint(tileTypes, grassIndex + 26, TILETYPE.GRASS, "GRASS_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_B_M = new TileBluePrint(tileTypes, grassIndex + 27, TILETYPE.GRASS, "GRASS_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_DIRT_B_R = new TileBluePrint(tileTypes, grassIndex + 28, TILETYPE.GRASS, "GRASS_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 3, false, 0, 0, false), grassHestitation, false);	
	public static final TileBluePrint GRASS_WATER_U_L = new TileBluePrint(tileTypes, grassIndex + 29, TILETYPE.GRASS, "GRASS_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_U_M = new TileBluePrint(tileTypes, grassIndex + 30, TILETYPE.GRASS, "GRASS_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_U_R = new TileBluePrint(tileTypes, grassIndex + 31, TILETYPE.GRASS, "GRASS_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_M_L = new TileBluePrint(tileTypes, grassIndex + 32, TILETYPE.GRASS, "GRASS_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_M_R = new TileBluePrint(tileTypes, grassIndex + 33, TILETYPE.GRASS, "GRASS_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_B_L = new TileBluePrint(tileTypes, grassIndex + 34, TILETYPE.GRASS, "GRASS_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_B_M = new TileBluePrint(tileTypes, grassIndex + 35, TILETYPE.GRASS, "GRASS_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_WATER_B_R = new TileBluePrint(tileTypes, grassIndex + 36, TILETYPE.GRASS, "GRASS_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_U_L = new TileBluePrint(tileTypes, grassIndex + 37, TILETYPE.GRASS, "GRASS_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_U_M = new TileBluePrint(tileTypes, grassIndex + 38, TILETYPE.GRASS, "GRASS_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_U_R = new TileBluePrint(tileTypes, grassIndex + 39, TILETYPE.GRASS, "GRASS_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_M_L = new TileBluePrint(tileTypes, grassIndex + 40, TILETYPE.GRASS, "GRASS_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_M_R = new TileBluePrint(tileTypes, grassIndex + 41, TILETYPE.GRASS, "GRASS_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_B_L = new TileBluePrint(tileTypes, grassIndex + 42, TILETYPE.GRASS, "GRASS_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_B_M = new TileBluePrint(tileTypes, grassIndex + 43, TILETYPE.GRASS, "GRASS_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_STONE_B_R = new TileBluePrint(tileTypes, grassIndex + 44, TILETYPE.GRASS, "GRASS_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_U_L = new TileBluePrint(tileTypes, grassIndex + 45, TILETYPE.GRASS, "GRASS_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_U_M = new TileBluePrint(tileTypes, grassIndex + 46, TILETYPE.GRASS, "GRASS_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_U_R = new TileBluePrint(tileTypes, grassIndex + 47, TILETYPE.GRASS, "GRASS_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_M_L = new TileBluePrint(tileTypes, grassIndex + 48, TILETYPE.GRASS, "GRASS_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_M_R = new TileBluePrint(tileTypes, grassIndex + 49, TILETYPE.GRASS, "GRASS_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_B_L = new TileBluePrint(tileTypes, grassIndex + 50, TILETYPE.GRASS, "GRASS_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_B_M = new TileBluePrint(tileTypes, grassIndex + 51, TILETYPE.GRASS, "GRASS_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileBluePrint GRASS_SAND_B_R = new TileBluePrint(tileTypes, grassIndex + 52, TILETYPE.GRASS, "GRASS_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 3, false, 0, 0, false), grassHestitation, false);
	
	/** SAND **/
	public static final TileBluePrint SAND_CLEAN = new TileBluePrint(tileTypes, sandIndex + 0, TILETYPE.SAND, "SAND_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_U_L = new TileBluePrint(tileTypes, sandIndex + 1, TILETYPE.SAND, "SAND_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_U_M = new TileBluePrint(tileTypes, sandIndex + 2, TILETYPE.SAND, "SAND_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_U_R = new TileBluePrint(tileTypes, sandIndex + 3, TILETYPE.SAND, "SAND_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_M_L = new TileBluePrint(tileTypes, sandIndex + 4, TILETYPE.SAND, "SAND_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_M_R = new TileBluePrint(tileTypes, sandIndex + 5, TILETYPE.SAND, "SAND_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_B_L = new TileBluePrint(tileTypes, sandIndex + 6, TILETYPE.SAND, "SAND_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_B_M = new TileBluePrint(tileTypes, sandIndex + 7, TILETYPE.SAND, "SAND_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_GRASS_B_R = new TileBluePrint(tileTypes, sandIndex + 8, TILETYPE.SAND, "SAND_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 6, false, 0, 0, false), sandHestitation, false);	
	public static final TileBluePrint SAND_STONE_U_L = new TileBluePrint(tileTypes, sandIndex + 9, TILETYPE.SAND, "SAND_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_U_M = new TileBluePrint(tileTypes, sandIndex + 10, TILETYPE.SAND, "SAND_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_U_R = new TileBluePrint(tileTypes, sandIndex + 11, TILETYPE.SAND, "SAND_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_M_L = new TileBluePrint(tileTypes, sandIndex + 12, TILETYPE.SAND, "SAND_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_M_R = new TileBluePrint(tileTypes, sandIndex + 13, TILETYPE.SAND, "SAND_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_B_L = new TileBluePrint(tileTypes, sandIndex + 14, TILETYPE.SAND, "SAND_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_B_M = new TileBluePrint(tileTypes, sandIndex + 15, TILETYPE.SAND, "SAND_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STONE_B_R = new TileBluePrint(tileTypes, sandIndex + 16, TILETYPE.SAND, "SAND_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_U_L = new TileBluePrint(tileTypes, sandIndex + 17, TILETYPE.SAND, "SAND_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_U_M = new TileBluePrint(tileTypes, sandIndex + 18, TILETYPE.SAND, "SAND_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_U_R = new TileBluePrint(tileTypes, sandIndex + 19, TILETYPE.SAND, "SAND_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_M_L = new TileBluePrint(tileTypes, sandIndex + 20, TILETYPE.SAND, "SAND_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_M_R = new TileBluePrint(tileTypes, sandIndex + 21, TILETYPE.SAND, "SAND_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_B_L = new TileBluePrint(tileTypes, sandIndex + 22, TILETYPE.SAND, "SAND_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_B_M = new TileBluePrint(tileTypes, sandIndex + 23, TILETYPE.SAND, "SAND_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_WATER_B_R = new TileBluePrint(tileTypes, sandIndex + 24, TILETYPE.SAND, "SAND_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_U_L = new TileBluePrint(tileTypes, sandIndex + 25, TILETYPE.SAND, "SAND_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_U_M = new TileBluePrint(tileTypes, sandIndex + 26, TILETYPE.SAND, "SAND_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_U_R = new TileBluePrint(tileTypes, sandIndex + 27, TILETYPE.SAND, "SAND_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_M_L = new TileBluePrint(tileTypes, sandIndex + 28, TILETYPE.SAND, "SAND_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_M_R = new TileBluePrint(tileTypes, sandIndex + 29, TILETYPE.SAND, "SAND_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_B_L = new TileBluePrint(tileTypes, sandIndex + 30, TILETYPE.SAND, "SAND_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_B_M = new TileBluePrint(tileTypes, sandIndex + 31, TILETYPE.SAND, "SAND_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_DIRT_B_R = new TileBluePrint(tileTypes, sandIndex + 32, TILETYPE.SAND, "SAND_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_U_L = new TileBluePrint(tileTypes, sandIndex + 33, TILETYPE.SAND, "SAND_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_U_M = new TileBluePrint(tileTypes, sandIndex + 34, TILETYPE.SAND, "SAND_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_U_R = new TileBluePrint(tileTypes, sandIndex + 35, TILETYPE.SAND, "SAND_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_M_L = new TileBluePrint(tileTypes, sandIndex + 36, TILETYPE.SAND, "SAND_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_M_R = new TileBluePrint(tileTypes, sandIndex + 37, TILETYPE.SAND, "SAND_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_B_L = new TileBluePrint(tileTypes, sandIndex + 38, TILETYPE.SAND, "SAND_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_B_M = new TileBluePrint(tileTypes, sandIndex + 39, TILETYPE.SAND, "SAND_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_STREET_B_R = new TileBluePrint(tileTypes, sandIndex + 40, TILETYPE.SAND, "SAND_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_U_L = new TileBluePrint(tileTypes, sandIndex + 41, TILETYPE.SAND, "SAND_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_U_M = new TileBluePrint(tileTypes, sandIndex + 42, TILETYPE.SAND, "SAND_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_U_R = new TileBluePrint(tileTypes, sandIndex + 43, TILETYPE.SAND, "SAND_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_M_L = new TileBluePrint(tileTypes, sandIndex + 44, TILETYPE.SAND, "SAND_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_M_R = new TileBluePrint(tileTypes, sandIndex + 45, TILETYPE.SAND, "SAND_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_B_L = new TileBluePrint(tileTypes, sandIndex + 46, TILETYPE.SAND, "SAND_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_B_M = new TileBluePrint(tileTypes, sandIndex + 47, TILETYPE.SAND, "SAND_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileBluePrint SAND_EARTH_B_R = new TileBluePrint(tileTypes, sandIndex + 48, TILETYPE.SAND, "SAND_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 6, false, 0, 0, false), sandHestitation, false);
	
	
	/** STONE **/
	public static final TileBluePrint STONE_CLEAN = new TileBluePrint(tileTypes, stoneIndex + 0, TILETYPE.STONE, "STONE_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_U_L = new TileBluePrint(tileTypes, stoneIndex + 1, TILETYPE.STONE, "STONE_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_U_M = new TileBluePrint(tileTypes, stoneIndex + 2, TILETYPE.STONE, "STONE_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_U_R = new TileBluePrint(tileTypes, stoneIndex + 3, TILETYPE.STONE, "STONE_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_M_L = new TileBluePrint(tileTypes, stoneIndex + 4, TILETYPE.STONE, "STONE_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_M_R = new TileBluePrint(tileTypes, stoneIndex + 5, TILETYPE.STONE, "STONE_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_B_L = new TileBluePrint(tileTypes, stoneIndex + 6, TILETYPE.STONE, "STONE_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_B_M = new TileBluePrint(tileTypes, stoneIndex + 7, TILETYPE.STONE, "STONE_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_SAND_B_R = new TileBluePrint(tileTypes, stoneIndex + 8, TILETYPE.STONE, "STONE_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_U_L = new TileBluePrint(tileTypes, stoneIndex + 9, TILETYPE.STONE, "STONE_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_U_M = new TileBluePrint(tileTypes, stoneIndex + 10, TILETYPE.STONE, "STONE_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_U_R = new TileBluePrint(tileTypes, stoneIndex + 11, TILETYPE.STONE, "STONE_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_M_L = new TileBluePrint(tileTypes, stoneIndex + 12, TILETYPE.STONE, "STONE_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_M_R = new TileBluePrint(tileTypes, stoneIndex + 13, TILETYPE.STONE, "STONE_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_B_L = new TileBluePrint(tileTypes, stoneIndex + 14, TILETYPE.STONE, "STONE_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_B_M = new TileBluePrint(tileTypes, stoneIndex + 15, TILETYPE.STONE, "STONE_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_GRASS_B_R = new TileBluePrint(tileTypes, stoneIndex + 16, TILETYPE.STONE, "STONE_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_U_L = new TileBluePrint(tileTypes, stoneIndex + 17, TILETYPE.STONE, "STONE_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_U_M = new TileBluePrint(tileTypes, stoneIndex + 18, TILETYPE.STONE, "STONE_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_U_R = new TileBluePrint(tileTypes, stoneIndex + 19, TILETYPE.STONE, "STONE_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_M_L = new TileBluePrint(tileTypes, stoneIndex + 20, TILETYPE.STONE, "STONE_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_M_R = new TileBluePrint(tileTypes, stoneIndex + 21, TILETYPE.STONE, "STONE_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_B_L = new TileBluePrint(tileTypes, stoneIndex + 22, TILETYPE.STONE, "STONE_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_B_M = new TileBluePrint(tileTypes, stoneIndex + 23, TILETYPE.STONE, "STONE_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_WATER_B_R = new TileBluePrint(tileTypes, stoneIndex + 24, TILETYPE.STONE, "STONE_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 9, false, 0, 0, false), stoneHestitation, false);	
	public static final TileBluePrint STONE_DIRT_U_L = new TileBluePrint(tileTypes, stoneIndex + 25, TILETYPE.STONE, "STONE_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_U_M = new TileBluePrint(tileTypes, stoneIndex + 26, TILETYPE.STONE, "STONE_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_U_R = new TileBluePrint(tileTypes, stoneIndex + 27, TILETYPE.STONE, "STONE_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_M_L = new TileBluePrint(tileTypes, stoneIndex + 28, TILETYPE.STONE, "STONE_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_M_R = new TileBluePrint(tileTypes, stoneIndex + 29, TILETYPE.STONE, "STONE_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_B_L = new TileBluePrint(tileTypes, stoneIndex + 30, TILETYPE.STONE, "STONE_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_B_M = new TileBluePrint(tileTypes, stoneIndex + 31, TILETYPE.STONE, "STONE_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_DIRT_B_R = new TileBluePrint(tileTypes, stoneIndex + 32, TILETYPE.STONE, "STONE_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_U_L = new TileBluePrint(tileTypes, stoneIndex + 33, TILETYPE.STONE, "STONE_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_U_M = new TileBluePrint(tileTypes, stoneIndex + 34, TILETYPE.STONE, "STONE_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_U_R = new TileBluePrint(tileTypes, stoneIndex + 35, TILETYPE.STONE, "STONE_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_M_L = new TileBluePrint(tileTypes, stoneIndex + 36, TILETYPE.STONE, "STONE_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_M_R = new TileBluePrint(tileTypes, stoneIndex + 37, TILETYPE.STONE, "STONE_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_B_L = new TileBluePrint(tileTypes, stoneIndex + 38, TILETYPE.STONE, "STONE_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_B_M = new TileBluePrint(tileTypes, stoneIndex + 39, TILETYPE.STONE, "STONE_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_STREET_B_R = new TileBluePrint(tileTypes, stoneIndex + 40, TILETYPE.STONE, "STONE_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_U_L = new TileBluePrint(tileTypes, stoneIndex + 41, TILETYPE.STONE, "STONE_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_U_M = new TileBluePrint(tileTypes, stoneIndex + 42, TILETYPE.STONE, "STONE_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_U_R = new TileBluePrint(tileTypes, stoneIndex + 43, TILETYPE.STONE, "STONE_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_M_L = new TileBluePrint(tileTypes, stoneIndex + 44, TILETYPE.STONE, "STONE_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_M_R = new TileBluePrint(tileTypes, stoneIndex + 45, TILETYPE.STONE, "STONE_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_B_L = new TileBluePrint(tileTypes, stoneIndex + 46, TILETYPE.STONE, "STONE_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_B_M = new TileBluePrint(tileTypes, stoneIndex + 47, TILETYPE.STONE, "STONE_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileBluePrint STONE_EARTH_B_R = new TileBluePrint(tileTypes, stoneIndex + 48, TILETYPE.STONE, "STONE_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 9, false, 0, 0, false), stoneHestitation, false);
	
	/** WATER **/
	public static final TileBluePrint WATER_CLEAN = new TileBluePrint(tileTypes, waterIndex + 0, TILETYPE.WATER, "WATER_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 10, true, 250, 3, true), waterHestitation, false);	
	public static final TileBluePrint WATER_SAND_U_L = new TileBluePrint(tileTypes, waterIndex + 1, TILETYPE.WATER, "WATER_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_U_M = new TileBluePrint(tileTypes, waterIndex + 2, TILETYPE.WATER, "WATER_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_U_R = new TileBluePrint(tileTypes, waterIndex + 3, TILETYPE.WATER, "WATER_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_M_L = new TileBluePrint(tileTypes, waterIndex + 4, TILETYPE.WATER, "WATER_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_M_R = new TileBluePrint(tileTypes, waterIndex + 5, TILETYPE.WATER, "WATER_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_B_L = new TileBluePrint(tileTypes, waterIndex + 6, TILETYPE.WATER, "WATER_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_B_M = new TileBluePrint(tileTypes, waterIndex + 7, TILETYPE.WATER, "WATER_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_SAND_B_R = new TileBluePrint(tileTypes, waterIndex + 8, TILETYPE.WATER, "WATER_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_U_L = new TileBluePrint(tileTypes, waterIndex + 9, TILETYPE.WATER, "WATER_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_U_M = new TileBluePrint(tileTypes, waterIndex + 10, TILETYPE.WATER, "WATER_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_U_R = new TileBluePrint(tileTypes, waterIndex + 11, TILETYPE.WATER, "WATER_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_M_L = new TileBluePrint(tileTypes, waterIndex + 12, TILETYPE.WATER, "WATER_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_M_R = new TileBluePrint(tileTypes, waterIndex + 13, TILETYPE.WATER, "WATER_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_B_L = new TileBluePrint(tileTypes, waterIndex + 14, TILETYPE.WATER, "WATER_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_B_M = new TileBluePrint(tileTypes, waterIndex + 15, TILETYPE.WATER, "WATER_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_GRASS_B_R = new TileBluePrint(tileTypes, waterIndex + 16, TILETYPE.WATER, "WATER_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_U_L = new TileBluePrint(tileTypes, waterIndex + 17, TILETYPE.WATER, "WATER_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_U_M = new TileBluePrint(tileTypes, waterIndex + 18, TILETYPE.WATER, "WATER_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_U_R = new TileBluePrint(tileTypes, waterIndex + 19, TILETYPE.WATER, "WATER_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_M_L = new TileBluePrint(tileTypes, waterIndex + 20, TILETYPE.WATER, "WATER_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_M_R = new TileBluePrint(tileTypes, waterIndex + 21, TILETYPE.WATER, "WATER_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_B_L = new TileBluePrint(tileTypes, waterIndex + 22, TILETYPE.WATER, "WATER_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_B_M = new TileBluePrint(tileTypes, waterIndex + 23, TILETYPE.WATER, "WATER_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STONE_B_R = new TileBluePrint(tileTypes, waterIndex + 24, TILETYPE.WATER, "WATER_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_U_L = new TileBluePrint(tileTypes, waterIndex + 25, TILETYPE.WATER, "WATER_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_U_M = new TileBluePrint(tileTypes, waterIndex + 26, TILETYPE.WATER, "WATER_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_U_R = new TileBluePrint(tileTypes, waterIndex + 27, TILETYPE.WATER, "WATER_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_M_L = new TileBluePrint(tileTypes, waterIndex + 28, TILETYPE.WATER, "WATER_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_M_R = new TileBluePrint(tileTypes, waterIndex + 29, TILETYPE.WATER, "WATER_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_B_L = new TileBluePrint(tileTypes, waterIndex + 30, TILETYPE.WATER, "WATER_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_B_M = new TileBluePrint(tileTypes, waterIndex + 31, TILETYPE.WATER, "WATER_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_DIRT_B_R = new TileBluePrint(tileTypes, waterIndex + 32, TILETYPE.WATER, "WATER_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_U_L = new TileBluePrint(tileTypes, waterIndex + 33, TILETYPE.WATER, "WATER_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_U_M = new TileBluePrint(tileTypes, waterIndex + 34, TILETYPE.WATER, "WATER_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_U_R = new TileBluePrint(tileTypes, waterIndex + 35, TILETYPE.WATER, "WATER_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_M_L = new TileBluePrint(tileTypes, waterIndex + 36, TILETYPE.WATER, "WATER_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_M_R = new TileBluePrint(tileTypes, waterIndex + 37, TILETYPE.WATER, "WATER_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_B_L = new TileBluePrint(tileTypes, waterIndex + 38, TILETYPE.WATER, "WATER_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_B_M = new TileBluePrint(tileTypes, waterIndex + 39, TILETYPE.WATER, "WATER_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_STREET_B_R = new TileBluePrint(tileTypes, waterIndex + 40, TILETYPE.WATER, "WATER_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_U_L = new TileBluePrint(tileTypes, waterIndex + 41, TILETYPE.WATER, "WATER_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_U_M = new TileBluePrint(tileTypes, waterIndex + 42, TILETYPE.WATER, "WATER_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_U_R = new TileBluePrint(tileTypes, waterIndex + 43, TILETYPE.WATER, "WATER_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 10, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_M_L = new TileBluePrint(tileTypes, waterIndex + 44, TILETYPE.WATER, "WATER_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_M_R = new TileBluePrint(tileTypes, waterIndex + 45, TILETYPE.WATER, "WATER_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 11, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_B_L = new TileBluePrint(tileTypes, waterIndex + 46, TILETYPE.WATER, "WATER_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_B_M = new TileBluePrint(tileTypes, waterIndex + 47, TILETYPE.WATER, "WATER_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 12, false, 0, 0, false), waterHestitation, false);
	public static final TileBluePrint WATER_EARTH_B_R = new TileBluePrint(tileTypes, waterIndex + 48, TILETYPE.WATER, "WATER_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 12, false, 0, 0, false), waterHestitation, false);
	
	/** DIRT **/
	public static final TileBluePrint DIRT_CLEAN = new TileBluePrint(tileTypes, dirtIndex + 0, TILETYPE.DIRT, "DIRT_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_U_L = new TileBluePrint(tileTypes, dirtIndex + 1, TILETYPE.DIRT, "DIRT_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_U_M = new TileBluePrint(tileTypes, dirtIndex + 2, TILETYPE.DIRT, "DIRT_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_U_R = new TileBluePrint(tileTypes, dirtIndex + 3, TILETYPE.DIRT, "DIRT_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_M_L = new TileBluePrint(tileTypes, dirtIndex + 4, TILETYPE.DIRT, "DIRT_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_M_R = new TileBluePrint(tileTypes, dirtIndex + 5, TILETYPE.DIRT, "DIRT_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_B_L = new TileBluePrint(tileTypes, dirtIndex + 6, TILETYPE.DIRT, "DIRT_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_B_M = new TileBluePrint(tileTypes, dirtIndex + 7, TILETYPE.DIRT, "DIRT_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_SAND_B_R = new TileBluePrint(tileTypes, dirtIndex + 8, TILETYPE.DIRT, "DIRT_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 15, false, 0, 0, false), dirtHestitation, false);
	public static final TileBluePrint DIRT_GRASS_U_L = new TileBluePrint(tileTypes, dirtIndex + 9, TILETYPE.DIRT, "DIRT_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_U_M = new TileBluePrint(tileTypes, dirtIndex + 10, TILETYPE.DIRT, "DIRT_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_U_R = new TileBluePrint(tileTypes, dirtIndex + 11, TILETYPE.DIRT, "DIRT_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_M_L = new TileBluePrint(tileTypes, dirtIndex + 12, TILETYPE.DIRT, "DIRT_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_M_R = new TileBluePrint(tileTypes, dirtIndex + 13, TILETYPE.DIRT, "DIRT_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_B_L = new TileBluePrint(tileTypes, dirtIndex + 14, TILETYPE.DIRT, "DIRT_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_B_M = new TileBluePrint(tileTypes, dirtIndex + 15, TILETYPE.DIRT, "DIRT_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_GRASS_B_R = new TileBluePrint(tileTypes, dirtIndex + 16, TILETYPE.DIRT, "DIRT_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_U_L = new TileBluePrint(tileTypes, dirtIndex + 17, TILETYPE.DIRT, "DIRT_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_U_M = new TileBluePrint(tileTypes, dirtIndex + 18, TILETYPE.DIRT, "DIRT_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_U_R = new TileBluePrint(tileTypes, dirtIndex + 19, TILETYPE.DIRT, "DIRT_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_M_L = new TileBluePrint(tileTypes, dirtIndex + 20, TILETYPE.DIRT, "DIRT_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_M_R = new TileBluePrint(tileTypes, dirtIndex + 21, TILETYPE.DIRT, "DIRT_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_B_L = new TileBluePrint(tileTypes, dirtIndex + 22, TILETYPE.DIRT, "DIRT_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_B_M = new TileBluePrint(tileTypes, dirtIndex + 23, TILETYPE.DIRT, "DIRT_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STONE_B_R = new TileBluePrint(tileTypes, dirtIndex + 24, TILETYPE.DIRT, "DIRT_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 15, false, 0, 0, false), dirtHestitation, false);			
	public static final TileBluePrint DIRT_WATER_U_L = new TileBluePrint(tileTypes, dirtIndex + 25, TILETYPE.DIRT, "DIRT_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_U_M = new TileBluePrint(tileTypes, dirtIndex + 26, TILETYPE.DIRT, "DIRT_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_U_R = new TileBluePrint(tileTypes, dirtIndex + 27, TILETYPE.DIRT, "DIRT_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_M_L = new TileBluePrint(tileTypes, dirtIndex + 28, TILETYPE.DIRT, "DIRT_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_M_R = new TileBluePrint(tileTypes, dirtIndex + 29, TILETYPE.DIRT, "DIRT_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_B_L = new TileBluePrint(tileTypes, dirtIndex + 30, TILETYPE.DIRT, "DIRT_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_B_M = new TileBluePrint(tileTypes, dirtIndex + 31, TILETYPE.DIRT, "DIRT_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_WATER_B_R = new TileBluePrint(tileTypes, dirtIndex + 32, TILETYPE.DIRT, "DIRT_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_U_L = new TileBluePrint(tileTypes, dirtIndex + 33, TILETYPE.DIRT, "DIRT_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_U_M = new TileBluePrint(tileTypes, dirtIndex + 34, TILETYPE.DIRT, "DIRT_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_U_R = new TileBluePrint(tileTypes, dirtIndex + 35, TILETYPE.DIRT, "DIRT_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_M_L = new TileBluePrint(tileTypes, dirtIndex + 36, TILETYPE.DIRT, "DIRT_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_M_R = new TileBluePrint(tileTypes, dirtIndex + 37, TILETYPE.DIRT, "DIRT_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_B_L = new TileBluePrint(tileTypes, dirtIndex + 38, TILETYPE.DIRT, "DIRT_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_B_M = new TileBluePrint(tileTypes, dirtIndex + 39, TILETYPE.DIRT, "DIRT_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_STREET_B_R = new TileBluePrint(tileTypes, dirtIndex + 40, TILETYPE.DIRT, "DIRT_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_U_L = new TileBluePrint(tileTypes, dirtIndex + 41, TILETYPE.DIRT, "DIRT_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_U_M = new TileBluePrint(tileTypes, dirtIndex + 42, TILETYPE.DIRT, "DIRT_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_U_R = new TileBluePrint(tileTypes, dirtIndex + 43, TILETYPE.DIRT, "DIRT_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 13, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_M_L = new TileBluePrint(tileTypes, dirtIndex + 44, TILETYPE.DIRT, "DIRT_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_M_R = new TileBluePrint(tileTypes, dirtIndex + 45, TILETYPE.DIRT, "DIRT_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 14, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_B_L = new TileBluePrint(tileTypes, dirtIndex + 46, TILETYPE.DIRT, "DIRT_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_B_M = new TileBluePrint(tileTypes, dirtIndex + 47, TILETYPE.DIRT, "DIRT_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 15, false, 0, 0, false), dirtHestitation, false);	
	public static final TileBluePrint DIRT_EARTH_B_R = new TileBluePrint(tileTypes, dirtIndex + 48, TILETYPE.DIRT, "DIRT_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 15, false, 0, 0, false), dirtHestitation, false);	
	
	/** STREET **/
	
	
	/** EARTH **/
	
	
	/** WOOD **/
	public static final TileBluePrint WOOD_CLEAN = new TileBluePrint(tileTypes, woodIndex + 0, TILETYPE.WOOD, "WOOD_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_L = new TileBluePrint(tileTypes, woodIndex + 1, TILETYPE.WOOD, "WOOD_L",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_R = new TileBluePrint(tileTypes, woodIndex + 2, TILETYPE.WOOD, "WOOD_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_U = new TileBluePrint(tileTypes, woodIndex + 3, TILETYPE.WOOD, "WOOD_U",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_B = new TileBluePrint(tileTypes, woodIndex + 4, TILETYPE.WOOD, "WOOD_B",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_ALL = new TileBluePrint(tileTypes, woodIndex + 5, TILETYPE.WOOD, "WOOD_ALL",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 0, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_B_L = new TileBluePrint(tileTypes, woodIndex + 6, TILETYPE.WOOD, "WOOD_CORNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_CORNER_B_R = new TileBluePrint(tileTypes, woodIndex + 7, TILETYPE.WOOD, "WOOD_CORNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_CORNER_U_L = new TileBluePrint(tileTypes, woodIndex + 8, TILETYPE.WOOD, "WOOD_CORNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_CORNER_R_R = new TileBluePrint(tileTypes, woodIndex + 9, TILETYPE.WOOD, "WOOD_CORNER_R_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_INNER_U_R = new TileBluePrint(tileTypes, woodIndex + 10, TILETYPE.WOOD, "WOOD_INNER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_INNER_U_L = new TileBluePrint(tileTypes, woodIndex + 11, TILETYPE.WOOD, "WOOD_INNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_INNER_B_L = new TileBluePrint(tileTypes, woodIndex + 12, TILETYPE.WOOD, "WOOD_INNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileBluePrint WOOD_INNER_B_R = new TileBluePrint(tileTypes, woodIndex + 13, TILETYPE.WOOD, "WOOD_INNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 0, false, 0, 0, false), woodHestitation, false);
	
	public static TileBluePrint getBluePrintByID(int id) {
		return tileTypes[id];
	}
	
	public static TileBluePrint getBluePrintByName(String name) {
		for (TileBluePrint tileBlueprint : tileTypes) {
			if (tileBlueprint != null) {
				if (tileBlueprint.name.equals(name)) {
					return tileBlueprint;
				}
			}
		}
		
		return null;
	}
}
