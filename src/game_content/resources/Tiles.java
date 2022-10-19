package game_content.resources;

import engine.sprites.SpriteAtlas;
import engine.tiles.TileConfig;

public class Tiles {
	
	public enum TILETYPE {
		VOID, GRASS, SAND, STONE, WATER, STREET, EARTH, WOOD
	}
	
	public static final TileConfig[] tileTypes = new TileConfig[2048];
	
	public static int voidIndex = 0;
	public static int waterIndex = 1;
	public static float waterHestitation = 0.5f; // 0.5f
	public static int grassIndex = 100;
	public static float grassHestitation = 0.8f; //0.8f
	public static int sandIndex = 200;
	public static float sandHestitation = 0.6f; //0.6f
	public static int stoneIndex = 300;
	public static float stoneHestitation = 1.0f; //1.0f
	public static int streetIndex = 400;
	public static float streetHestitation = 1.0f; // 1.0f
	public static int earthIndex = 500;
	public static float earthHestitation = 0.7f; // 0.7f
	public static int woodIndex = 600;
	public static float woodHestitation = 1.0f; // 1.0f
	
	/** VOID **/
	public static final TileConfig VOID = new TileConfig(tileTypes, voidIndex, TILETYPE.VOID, "VOID", new SpriteAtlas(Sheets.TILES_SHEET, 0, 0, false, 0, 0, false), 0.1f, true);
	
	/** WATER **/
	public static final TileConfig WATER_CLEAN = new TileConfig(tileTypes, waterIndex + 0, TILETYPE.WATER, "WATER_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 0, true, 300, 7, true), waterHestitation, false);	
	
	/** GRASS **/
	public static final TileConfig GRASS_CLEAN = new TileConfig(tileTypes, grassIndex + 0, TILETYPE.GRASS, "GRASS_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig GRASS_LUSH_01 = new TileConfig(tileTypes, grassIndex + 1, TILETYPE.GRASS, "GRASS_LUSH_01",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig GRASS_LUSH_02 = new TileConfig(tileTypes, grassIndex + 2, TILETYPE.GRASS, "GRASS_LUSH_02",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig GRASS_LUSH_03 = new TileConfig(tileTypes, grassIndex + 3, TILETYPE.GRASS, "GRASS_LUSH_03",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig GRASS_FLOWER_01 = new TileConfig(tileTypes, grassIndex + 4, TILETYPE.GRASS, "GRASS_FLOWER_01",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 2, false, 0, 0, false), grassHestitation, false);		
	public static final TileConfig F_GRASS_T_EARTH_U_L = new TileConfig(tileTypes, grassIndex + 5, TILETYPE.GRASS, "F_GRASS_T_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_U_M = new TileConfig(tileTypes, grassIndex + 6, TILETYPE.GRASS, "F_GRASS_T_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_U_R = new TileConfig(tileTypes, grassIndex + 7, TILETYPE.GRASS, "F_GRASS_T_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_M_L = new TileConfig(tileTypes, grassIndex + 8, TILETYPE.GRASS, "F_GRASS_T_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_M_R = new TileConfig(tileTypes, grassIndex + 9, TILETYPE.GRASS, "F_GRASS_T_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_B_L = new TileConfig(tileTypes, grassIndex + 10, TILETYPE.GRASS, "F_GRASS_T_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_B_M = new TileConfig(tileTypes, grassIndex + 11, TILETYPE.GRASS, "F_GRASS_T_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_EARTH_B_R = new TileConfig(tileTypes, grassIndex + 12, TILETYPE.GRASS, "F_GRASS_T_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_U_L = new TileConfig(tileTypes, grassIndex + 13, TILETYPE.GRASS, "T_GRASS_F_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_U_M = new TileConfig(tileTypes, grassIndex + 14, TILETYPE.GRASS, "T_GRASS_F_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_U_R = new TileConfig(tileTypes, grassIndex + 15, TILETYPE.GRASS, "T_GRASS_F_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_M_L = new TileConfig(tileTypes, grassIndex + 16, TILETYPE.GRASS, "T_GRASS_F_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_M_R = new TileConfig(tileTypes, grassIndex + 17, TILETYPE.GRASS, "T_GRASS_F_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_B_L = new TileConfig(tileTypes, grassIndex + 18, TILETYPE.GRASS, "T_GRASS_F_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_B_M = new TileConfig(tileTypes, grassIndex + 19, TILETYPE.GRASS, "T_GRASS_F_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_EARTH_B_R = new TileConfig(tileTypes, grassIndex + 20, TILETYPE.GRASS, "T_GRASS_F_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_U_L = new TileConfig(tileTypes, grassIndex + 21, TILETYPE.GRASS, "F_GRASS_T_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_U_M = new TileConfig(tileTypes, grassIndex + 22, TILETYPE.GRASS, "F_GRASS_T_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_U_R = new TileConfig(tileTypes, grassIndex + 23, TILETYPE.GRASS, "F_GRASS_T_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_M_L = new TileConfig(tileTypes, grassIndex + 24, TILETYPE.GRASS, "F_GRASS_T_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_M_R = new TileConfig(tileTypes, grassIndex + 25, TILETYPE.GRASS, "F_GRASS_T_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_B_L = new TileConfig(tileTypes, grassIndex + 26, TILETYPE.GRASS, "F_GRASS_T_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_B_M = new TileConfig(tileTypes, grassIndex + 27, TILETYPE.GRASS, "F_GRASS_T_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STREET_B_R = new TileConfig(tileTypes, grassIndex + 28, TILETYPE.GRASS, "F_GRASS_T_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_U_L = new TileConfig(tileTypes, grassIndex + 29, TILETYPE.GRASS, "T_GRASS_F_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_U_M = new TileConfig(tileTypes, grassIndex + 30, TILETYPE.GRASS, "T_GRASS_F_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_U_R = new TileConfig(tileTypes, grassIndex + 31, TILETYPE.GRASS, "T_GRASS_F_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_M_L = new TileConfig(tileTypes, grassIndex + 32, TILETYPE.GRASS, "T_GRASS_F_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_M_R = new TileConfig(tileTypes, grassIndex + 33, TILETYPE.GRASS, "T_GRASS_F_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_B_L = new TileConfig(tileTypes, grassIndex + 34, TILETYPE.GRASS, "T_GRASS_F_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_B_M = new TileConfig(tileTypes, grassIndex + 35, TILETYPE.GRASS, "T_GRASS_F_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STREET_B_R = new TileConfig(tileTypes, grassIndex + 36, TILETYPE.GRASS, "T_GRASS_F_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_U_L = new TileConfig(tileTypes, grassIndex + 37, TILETYPE.GRASS, "F_GRASS_T_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_U_M = new TileConfig(tileTypes, grassIndex + 38, TILETYPE.GRASS, "F_GRASS_T_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_U_R = new TileConfig(tileTypes, grassIndex + 39, TILETYPE.GRASS, "F_GRASS_T_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_M_L = new TileConfig(tileTypes, grassIndex + 40, TILETYPE.GRASS, "F_GRASS_T_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_M_R = new TileConfig(tileTypes, grassIndex + 41, TILETYPE.GRASS, "F_GRASS_T_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_B_L = new TileConfig(tileTypes, grassIndex + 42, TILETYPE.GRASS, "F_GRASS_T_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_B_M = new TileConfig(tileTypes, grassIndex + 43, TILETYPE.GRASS, "F_GRASS_T_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_WATER_B_R = new TileConfig(tileTypes, grassIndex + 44, TILETYPE.GRASS, "F_GRASS_T_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_U_L = new TileConfig(tileTypes, grassIndex + 45, TILETYPE.GRASS, "T_GRASS_F_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_U_M = new TileConfig(tileTypes, grassIndex + 46, TILETYPE.GRASS, "T_GRASS_F_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_U_R = new TileConfig(tileTypes, grassIndex + 47, TILETYPE.GRASS, "T_GRASS_F_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_M_L = new TileConfig(tileTypes, grassIndex + 48, TILETYPE.GRASS, "T_GRASS_F_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_M_R = new TileConfig(tileTypes, grassIndex + 49, TILETYPE.GRASS, "T_GRASS_F_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_B_L = new TileConfig(tileTypes, grassIndex + 50, TILETYPE.GRASS, "T_GRASS_F_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_B_M = new TileConfig(tileTypes, grassIndex + 51, TILETYPE.GRASS, "T_GRASS_F_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_WATER_B_R = new TileConfig(tileTypes, grassIndex + 52, TILETYPE.GRASS, "T_GRASS_F_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_U_L = new TileConfig(tileTypes, grassIndex + 53, TILETYPE.GRASS, "F_GRASS_T_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_U_M = new TileConfig(tileTypes, grassIndex + 54, TILETYPE.GRASS, "F_GRASS_T_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_U_R = new TileConfig(tileTypes, grassIndex + 55, TILETYPE.GRASS, "F_GRASS_T_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_M_L = new TileConfig(tileTypes, grassIndex + 56, TILETYPE.GRASS, "F_GRASS_T_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_M_R = new TileConfig(tileTypes, grassIndex + 57, TILETYPE.GRASS, "F_GRASS_T_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_B_L = new TileConfig(tileTypes, grassIndex + 58, TILETYPE.GRASS, "F_GRASS_T_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_B_M = new TileConfig(tileTypes, grassIndex + 59, TILETYPE.GRASS, "F_GRASS_T_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_STONE_B_R = new TileConfig(tileTypes, grassIndex + 60, TILETYPE.GRASS, "F_GRASS_T_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_U_L = new TileConfig(tileTypes, grassIndex + 61, TILETYPE.GRASS, "T_GRASS_F_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_U_M = new TileConfig(tileTypes, grassIndex + 62, TILETYPE.GRASS, "T_GRASS_F_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_U_R = new TileConfig(tileTypes, grassIndex + 63, TILETYPE.GRASS, "T_GRASS_F_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_M_L = new TileConfig(tileTypes, grassIndex + 64, TILETYPE.GRASS, "T_GRASS_F_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_M_R = new TileConfig(tileTypes, grassIndex + 65, TILETYPE.GRASS, "T_GRASS_F_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_B_L = new TileConfig(tileTypes, grassIndex + 66, TILETYPE.GRASS, "T_GRASS_F_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_B_M = new TileConfig(tileTypes, grassIndex + 67, TILETYPE.GRASS, "T_GRASS_F_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_STONE_B_R = new TileConfig(tileTypes, grassIndex + 68, TILETYPE.GRASS, "T_GRASS_F_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_U_L = new TileConfig(tileTypes, grassIndex + 69, TILETYPE.GRASS, "F_GRASS_T_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_U_M = new TileConfig(tileTypes, grassIndex + 70, TILETYPE.GRASS, "F_GRASS_T_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_U_R = new TileConfig(tileTypes, grassIndex + 71, TILETYPE.GRASS, "F_GRASS_T_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_M_L = new TileConfig(tileTypes, grassIndex + 72, TILETYPE.GRASS, "F_GRASS_T_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_M_R = new TileConfig(tileTypes, grassIndex + 73, TILETYPE.GRASS, "F_GRASS_T_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_B_L = new TileConfig(tileTypes, grassIndex + 74, TILETYPE.GRASS, "F_GRASS_T_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_B_M = new TileConfig(tileTypes, grassIndex + 75, TILETYPE.GRASS, "F_GRASS_T_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig F_GRASS_T_SAND_B_R = new TileConfig(tileTypes, grassIndex + 76, TILETYPE.GRASS, "F_GRASS_T_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_U_L = new TileConfig(tileTypes, grassIndex + 77, TILETYPE.GRASS, "T_GRASS_F_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_U_M = new TileConfig(tileTypes, grassIndex + 78, TILETYPE.GRASS, "T_GRASS_F_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_U_R = new TileConfig(tileTypes, grassIndex + 79, TILETYPE.GRASS, "T_GRASS_F_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 1, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_M_L = new TileConfig(tileTypes, grassIndex + 80, TILETYPE.GRASS, "T_GRASS_F_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_M_R = new TileConfig(tileTypes, grassIndex + 81, TILETYPE.GRASS, "T_GRASS_F_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 2, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_B_L = new TileConfig(tileTypes, grassIndex + 82, TILETYPE.GRASS, "T_GRASS_F_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_B_M = new TileConfig(tileTypes, grassIndex + 83, TILETYPE.GRASS, "T_GRASS_F_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 3, false, 0, 0, false), grassHestitation, false);
	public static final TileConfig T_GRASS_F_SAND_B_R = new TileConfig(tileTypes, grassIndex + 84, TILETYPE.GRASS, "T_GRASS_F_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 3, false, 0, 0, false), grassHestitation, false);

	/** SAND **/
	public static final TileConfig SAND_CLEAN = new TileConfig(tileTypes, sandIndex + 0, TILETYPE.SAND, "SAND_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_U_L = new TileConfig(tileTypes, sandIndex + 1, TILETYPE.SAND, "F_SAND_T_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_U_M = new TileConfig(tileTypes, sandIndex + 2, TILETYPE.SAND, "F_SAND_T_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_U_R = new TileConfig(tileTypes, sandIndex + 3, TILETYPE.SAND, "F_SAND_T_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_M_L = new TileConfig(tileTypes, sandIndex + 4, TILETYPE.SAND, "F_SAND_T_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_M_R = new TileConfig(tileTypes, sandIndex + 5, TILETYPE.SAND, "F_SAND_T_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_B_L = new TileConfig(tileTypes, sandIndex + 6, TILETYPE.SAND, "F_SAND_T_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_B_M = new TileConfig(tileTypes, sandIndex + 7, TILETYPE.SAND, "F_SAND_T_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_GRASS_B_R = new TileConfig(tileTypes, sandIndex + 8, TILETYPE.SAND, "F_SAND_T_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_U_L = new TileConfig(tileTypes, sandIndex + 9, TILETYPE.SAND, "T_SAND_F_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_U_M = new TileConfig(tileTypes, sandIndex + 10, TILETYPE.SAND, "T_SAND_F_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_U_R = new TileConfig(tileTypes, sandIndex + 11, TILETYPE.SAND, "T_SAND_F_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_M_L = new TileConfig(tileTypes, sandIndex + 12, TILETYPE.SAND, "T_SAND_F_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_M_R = new TileConfig(tileTypes, sandIndex + 13, TILETYPE.SAND, "T_SAND_F_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_B_L = new TileConfig(tileTypes, sandIndex + 14, TILETYPE.SAND, "T_SAND_F_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_B_M = new TileConfig(tileTypes, sandIndex + 15, TILETYPE.SAND, "T_SAND_F_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_GRASS_B_R = new TileConfig(tileTypes, sandIndex + 16, TILETYPE.SAND, "T_SAND_F_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_U_L = new TileConfig(tileTypes, sandIndex + 17, TILETYPE.SAND, "F_SAND_T_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_U_M = new TileConfig(tileTypes, sandIndex + 18, TILETYPE.SAND, "F_SAND_T_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_U_R = new TileConfig(tileTypes, sandIndex + 19, TILETYPE.SAND, "F_SAND_T_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_M_L = new TileConfig(tileTypes, sandIndex + 20, TILETYPE.SAND, "F_SAND_T_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_M_R = new TileConfig(tileTypes, sandIndex + 21, TILETYPE.SAND, "F_SAND_T_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_B_L = new TileConfig(tileTypes, sandIndex + 22, TILETYPE.SAND, "F_SAND_T_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_B_M = new TileConfig(tileTypes, sandIndex + 23, TILETYPE.SAND, "F_SAND_T_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_EARTH_B_R = new TileConfig(tileTypes, sandIndex + 24, TILETYPE.SAND, "F_SAND_T_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_U_L = new TileConfig(tileTypes, sandIndex + 25, TILETYPE.SAND, "T_SAND_F_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_U_M = new TileConfig(tileTypes, sandIndex + 26, TILETYPE.SAND, "T_SAND_F_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_U_R = new TileConfig(tileTypes, sandIndex + 27, TILETYPE.SAND, "T_SAND_F_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_M_L = new TileConfig(tileTypes, sandIndex + 28, TILETYPE.SAND, "T_SAND_F_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_M_R = new TileConfig(tileTypes, sandIndex + 29, TILETYPE.SAND, "T_SAND_F_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_B_L = new TileConfig(tileTypes, sandIndex + 30, TILETYPE.SAND, "T_SAND_F_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_B_M = new TileConfig(tileTypes, sandIndex + 31, TILETYPE.SAND, "T_SAND_F_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_EARTH_B_R = new TileConfig(tileTypes, sandIndex + 32, TILETYPE.SAND, "T_SAND_F_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_U_L = new TileConfig(tileTypes, sandIndex + 33, TILETYPE.SAND, "F_SAND_T_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_U_M = new TileConfig(tileTypes, sandIndex + 34, TILETYPE.SAND, "F_SAND_T_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_U_R = new TileConfig(tileTypes, sandIndex + 35, TILETYPE.SAND, "F_SAND_T_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_M_L = new TileConfig(tileTypes, sandIndex + 36, TILETYPE.SAND, "F_SAND_T_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_M_R = new TileConfig(tileTypes, sandIndex + 37, TILETYPE.SAND, "F_SAND_T_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_B_L = new TileConfig(tileTypes, sandIndex + 38, TILETYPE.SAND, "F_SAND_T_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_B_M = new TileConfig(tileTypes, sandIndex + 39, TILETYPE.SAND, "F_SAND_T_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STREET_B_R = new TileConfig(tileTypes, sandIndex + 40, TILETYPE.SAND, "F_SAND_T_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_U_L = new TileConfig(tileTypes, sandIndex + 41, TILETYPE.SAND, "T_SAND_F_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_U_M = new TileConfig(tileTypes, sandIndex + 42, TILETYPE.SAND, "T_SAND_F_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_U_R = new TileConfig(tileTypes, sandIndex + 43, TILETYPE.SAND, "T_SAND_F_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_M_L = new TileConfig(tileTypes, sandIndex + 44, TILETYPE.SAND, "T_SAND_F_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_M_R = new TileConfig(tileTypes, sandIndex + 45, TILETYPE.SAND, "T_SAND_F_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_B_L = new TileConfig(tileTypes, sandIndex + 46, TILETYPE.SAND, "T_SAND_F_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_B_M = new TileConfig(tileTypes, sandIndex + 47, TILETYPE.SAND, "T_SAND_F_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STREET_B_R = new TileConfig(tileTypes, sandIndex + 48, TILETYPE.SAND, "T_SAND_F_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_U_L = new TileConfig(tileTypes, sandIndex + 49, TILETYPE.SAND, "F_SAND_T_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_U_M = new TileConfig(tileTypes, sandIndex + 50, TILETYPE.SAND, "F_SAND_T_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_U_R = new TileConfig(tileTypes, sandIndex + 51, TILETYPE.SAND, "F_SAND_T_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_M_L = new TileConfig(tileTypes, sandIndex + 52, TILETYPE.SAND, "F_SAND_T_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_M_R = new TileConfig(tileTypes, sandIndex + 53, TILETYPE.SAND, "F_SAND_T_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_B_L = new TileConfig(tileTypes, sandIndex + 54, TILETYPE.SAND, "F_SAND_T_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_B_M = new TileConfig(tileTypes, sandIndex + 55, TILETYPE.SAND, "F_SAND_T_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_WATER_B_R = new TileConfig(tileTypes, sandIndex + 56, TILETYPE.SAND, "F_SAND_T_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_U_L = new TileConfig(tileTypes, sandIndex + 57, TILETYPE.SAND, "T_SAND_F_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_U_M = new TileConfig(tileTypes, sandIndex + 58, TILETYPE.SAND, "T_SAND_F_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_U_R = new TileConfig(tileTypes, sandIndex + 59, TILETYPE.SAND, "T_SAND_F_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_M_L = new TileConfig(tileTypes, sandIndex + 60, TILETYPE.SAND, "T_SAND_F_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_M_R = new TileConfig(tileTypes, sandIndex + 61, TILETYPE.SAND, "T_SAND_F_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_B_L = new TileConfig(tileTypes, sandIndex + 62, TILETYPE.SAND, "T_SAND_F_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_B_M = new TileConfig(tileTypes, sandIndex + 63, TILETYPE.SAND, "T_SAND_F_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_WATER_B_R = new TileConfig(tileTypes, sandIndex + 64, TILETYPE.SAND, "T_SAND_F_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_U_L = new TileConfig(tileTypes, sandIndex + 65, TILETYPE.SAND, "F_SAND_T_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_U_M = new TileConfig(tileTypes, sandIndex + 66, TILETYPE.SAND, "F_SAND_T_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_U_R = new TileConfig(tileTypes, sandIndex + 67, TILETYPE.SAND, "F_SAND_T_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_M_L = new TileConfig(tileTypes, sandIndex + 68, TILETYPE.SAND, "F_SAND_T_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_M_R = new TileConfig(tileTypes, sandIndex + 69, TILETYPE.SAND, "F_SAND_T_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_B_L = new TileConfig(tileTypes, sandIndex + 70, TILETYPE.SAND, "F_SAND_T_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_B_M = new TileConfig(tileTypes, sandIndex + 71, TILETYPE.SAND, "F_SAND_T_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig F_SAND_T_STONE_B_R = new TileConfig(tileTypes, sandIndex + 72, TILETYPE.SAND, "F_SAND_T_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_U_L = new TileConfig(tileTypes, sandIndex + 73, TILETYPE.SAND, "T_SAND_F_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_U_M = new TileConfig(tileTypes, sandIndex + 74, TILETYPE.SAND, "T_SAND_F_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_U_R = new TileConfig(tileTypes, sandIndex + 75, TILETYPE.SAND, "T_SAND_F_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 4, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_M_L = new TileConfig(tileTypes, sandIndex + 76, TILETYPE.SAND, "T_SAND_F_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_M_R = new TileConfig(tileTypes, sandIndex + 77, TILETYPE.SAND, "T_SAND_F_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 5, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_B_L = new TileConfig(tileTypes, sandIndex + 78, TILETYPE.SAND, "T_SAND_F_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_B_M = new TileConfig(tileTypes, sandIndex + 79, TILETYPE.SAND, "T_SAND_F_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 6, false, 0, 0, false), sandHestitation, false);
	public static final TileConfig T_SAND_F_STONE_B_R = new TileConfig(tileTypes, sandIndex + 80, TILETYPE.SAND, "T_SAND_F_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 6, false, 0, 0, false), sandHestitation, false);
	
	/** STONE **/
	public static final TileConfig STONE_CLEAN = new TileConfig(tileTypes, stoneIndex + 0, TILETYPE.STONE, "STONE_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_U_L = new TileConfig(tileTypes, stoneIndex + 1, TILETYPE.STONE, "F_STONE_T_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_U_M = new TileConfig(tileTypes, stoneIndex + 2, TILETYPE.STONE, "F_STONE_T_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_U_R = new TileConfig(tileTypes, stoneIndex + 3, TILETYPE.STONE, "F_STONE_T_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_M_L = new TileConfig(tileTypes, stoneIndex + 4, TILETYPE.STONE, "F_STONE_T_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_M_R = new TileConfig(tileTypes, stoneIndex + 5, TILETYPE.STONE, "F_STONE_T_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_B_L = new TileConfig(tileTypes, stoneIndex + 6, TILETYPE.STONE, "F_STONE_T_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_B_M = new TileConfig(tileTypes, stoneIndex + 7, TILETYPE.STONE, "F_STONE_T_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_GRASS_B_R = new TileConfig(tileTypes, stoneIndex + 8, TILETYPE.STONE, "F_STONE_T_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_U_L = new TileConfig(tileTypes, stoneIndex + 9, TILETYPE.STONE, "T_STONE_F_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_U_M = new TileConfig(tileTypes, stoneIndex + 10, TILETYPE.STONE, "T_STONE_F_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_U_R = new TileConfig(tileTypes, stoneIndex + 11, TILETYPE.STONE, "T_STONE_F_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_M_L = new TileConfig(tileTypes, stoneIndex + 12, TILETYPE.STONE, "T_STONE_F_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_M_R = new TileConfig(tileTypes, stoneIndex + 13, TILETYPE.STONE, "T_STONE_F_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_B_L = new TileConfig(tileTypes, stoneIndex + 14, TILETYPE.STONE, "T_STONE_F_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_B_M = new TileConfig(tileTypes, stoneIndex + 15, TILETYPE.STONE, "T_STONE_F_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_GRASS_B_R = new TileConfig(tileTypes, stoneIndex + 16, TILETYPE.STONE, "T_STONE_F_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_U_L = new TileConfig(tileTypes, stoneIndex + 17, TILETYPE.STONE, "F_STONE_T_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_U_M = new TileConfig(tileTypes, stoneIndex + 18, TILETYPE.STONE, "F_STONE_T_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_U_R = new TileConfig(tileTypes, stoneIndex + 19, TILETYPE.STONE, "F_STONE_T_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_M_L = new TileConfig(tileTypes, stoneIndex + 20, TILETYPE.STONE, "F_STONE_T_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_M_R = new TileConfig(tileTypes, stoneIndex + 21, TILETYPE.STONE, "F_STONE_T_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_B_L = new TileConfig(tileTypes, stoneIndex + 22, TILETYPE.STONE, "F_STONE_T_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_B_M = new TileConfig(tileTypes, stoneIndex + 23, TILETYPE.STONE, "F_STONE_T_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_EARTH_B_R = new TileConfig(tileTypes, stoneIndex + 24, TILETYPE.STONE, "F_STONE_T_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_U_L = new TileConfig(tileTypes, stoneIndex + 25, TILETYPE.STONE, "T_STONE_F_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_U_M = new TileConfig(tileTypes, stoneIndex + 26, TILETYPE.STONE, "T_STONE_F_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_U_R = new TileConfig(tileTypes, stoneIndex + 27, TILETYPE.STONE, "T_STONE_F_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_M_L = new TileConfig(tileTypes, stoneIndex + 28, TILETYPE.STONE, "T_STONE_F_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_M_R = new TileConfig(tileTypes, stoneIndex + 29, TILETYPE.STONE, "T_STONE_F_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_B_L = new TileConfig(tileTypes, stoneIndex + 30, TILETYPE.STONE, "T_STONE_F_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_B_M = new TileConfig(tileTypes, stoneIndex + 31, TILETYPE.STONE, "T_STONE_F_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_EARTH_B_R = new TileConfig(tileTypes, stoneIndex + 32, TILETYPE.STONE, "T_STONE_F_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_U_L = new TileConfig(tileTypes, stoneIndex + 33, TILETYPE.STONE, "F_STONE_T_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_U_M = new TileConfig(tileTypes, stoneIndex + 34, TILETYPE.STONE, "F_STONE_T_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_U_R = new TileConfig(tileTypes, stoneIndex + 35, TILETYPE.STONE, "F_STONE_T_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_M_L = new TileConfig(tileTypes, stoneIndex + 36, TILETYPE.STONE, "F_STONE_T_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_M_R = new TileConfig(tileTypes, stoneIndex + 37, TILETYPE.STONE, "F_STONE_T_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_B_L = new TileConfig(tileTypes, stoneIndex + 38, TILETYPE.STONE, "F_STONE_T_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_B_M = new TileConfig(tileTypes, stoneIndex + 39, TILETYPE.STONE, "F_STONE_T_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_STREET_B_R = new TileConfig(tileTypes, stoneIndex + 40, TILETYPE.STONE, "F_STONE_T_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_U_L = new TileConfig(tileTypes, stoneIndex + 41, TILETYPE.STONE, "T_STONE_F_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_U_M = new TileConfig(tileTypes, stoneIndex + 42, TILETYPE.STONE, "T_STONE_F_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_U_R = new TileConfig(tileTypes, stoneIndex + 43, TILETYPE.STONE, "T_STONE_F_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_M_L = new TileConfig(tileTypes, stoneIndex + 44, TILETYPE.STONE, "T_STONE_F_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_M_R = new TileConfig(tileTypes, stoneIndex + 45, TILETYPE.STONE, "T_STONE_F_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_B_L = new TileConfig(tileTypes, stoneIndex + 46, TILETYPE.STONE, "T_STONE_F_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_B_M = new TileConfig(tileTypes, stoneIndex + 47, TILETYPE.STONE, "T_STONE_F_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_STREET_B_R = new TileConfig(tileTypes, stoneIndex + 48, TILETYPE.STONE, "T_STONE_F_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_U_L = new TileConfig(tileTypes, stoneIndex + 49, TILETYPE.STONE, "F_STONE_T_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_U_M = new TileConfig(tileTypes, stoneIndex + 50, TILETYPE.STONE, "F_STONE_T_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_U_R = new TileConfig(tileTypes, stoneIndex + 51, TILETYPE.STONE, "F_STONE_T_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_M_L = new TileConfig(tileTypes, stoneIndex + 52, TILETYPE.STONE, "F_STONE_T_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_M_R = new TileConfig(tileTypes, stoneIndex + 53, TILETYPE.STONE, "F_STONE_T_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_B_L = new TileConfig(tileTypes, stoneIndex + 54, TILETYPE.STONE, "F_STONE_T_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_B_M = new TileConfig(tileTypes, stoneIndex + 55, TILETYPE.STONE, "F_STONE_T_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_WATER_B_R = new TileConfig(tileTypes, stoneIndex + 56, TILETYPE.STONE, "F_STONE_T_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_U_L = new TileConfig(tileTypes, stoneIndex + 57, TILETYPE.STONE, "T_STONE_F_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_U_M = new TileConfig(tileTypes, stoneIndex + 58, TILETYPE.STONE, "T_STONE_F_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_U_R = new TileConfig(tileTypes, stoneIndex + 59, TILETYPE.STONE, "T_STONE_F_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_M_L = new TileConfig(tileTypes, stoneIndex + 60, TILETYPE.STONE, "T_STONE_F_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_M_R = new TileConfig(tileTypes, stoneIndex + 61, TILETYPE.STONE, "T_STONE_F_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_B_L = new TileConfig(tileTypes, stoneIndex + 62, TILETYPE.STONE, "T_STONE_F_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_B_M = new TileConfig(tileTypes, stoneIndex + 63, TILETYPE.STONE, "T_STONE_F_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_WATER_B_R = new TileConfig(tileTypes, stoneIndex + 64, TILETYPE.STONE, "T_STONE_F_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_U_L = new TileConfig(tileTypes, stoneIndex + 65, TILETYPE.STONE, "F_STONE_T_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_U_M = new TileConfig(tileTypes, stoneIndex + 66, TILETYPE.STONE, "F_STONE_T_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_U_R = new TileConfig(tileTypes, stoneIndex + 67, TILETYPE.STONE, "F_STONE_T_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_M_L = new TileConfig(tileTypes, stoneIndex + 68, TILETYPE.STONE, "F_STONE_T_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_M_R = new TileConfig(tileTypes, stoneIndex + 69, TILETYPE.STONE, "F_STONE_T_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_B_L = new TileConfig(tileTypes, stoneIndex + 70, TILETYPE.STONE, "F_STONE_T_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_B_M = new TileConfig(tileTypes, stoneIndex + 71, TILETYPE.STONE, "F_STONE_T_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig F_STONE_T_SAND_B_R = new TileConfig(tileTypes, stoneIndex + 72, TILETYPE.STONE, "F_STONE_T_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_U_L = new TileConfig(tileTypes, stoneIndex + 73, TILETYPE.STONE, "T_STONE_F_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_U_M = new TileConfig(tileTypes, stoneIndex + 74, TILETYPE.STONE, "T_STONE_F_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_U_R = new TileConfig(tileTypes, stoneIndex + 75, TILETYPE.STONE, "T_STONE_F_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 7, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_M_L = new TileConfig(tileTypes, stoneIndex + 76, TILETYPE.STONE, "T_STONE_F_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_M_R = new TileConfig(tileTypes, stoneIndex + 77, TILETYPE.STONE, "T_STONE_F_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 8, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_B_L = new TileConfig(tileTypes, stoneIndex + 78, TILETYPE.STONE, "T_STONE_F_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_B_M = new TileConfig(tileTypes, stoneIndex + 79, TILETYPE.STONE, "T_STONE_F_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 9, false, 0, 0, false), stoneHestitation, false);
	public static final TileConfig T_STONE_F_SAND_B_R = new TileConfig(tileTypes, stoneIndex + 80, TILETYPE.STONE, "T_STONE_F_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 9, false, 0, 0, false), stoneHestitation, false);
	
	/** STREET **/
	public static final TileConfig STREET_CLEAN = new TileConfig(tileTypes, streetIndex + 0, TILETYPE.STREET, "STREET_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_U_L = new TileConfig(tileTypes, streetIndex + 1, TILETYPE.STREET, "F_STREET_T_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_U_M = new TileConfig(tileTypes, streetIndex + 2, TILETYPE.STREET, "F_STREET_T_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_U_R = new TileConfig(tileTypes, streetIndex + 3, TILETYPE.STREET, "F_STREET_T_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_M_L = new TileConfig(tileTypes, streetIndex + 4, TILETYPE.STREET, "F_STREET_T_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_M_R = new TileConfig(tileTypes, streetIndex + 5, TILETYPE.STREET, "F_STREET_T_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_B_L = new TileConfig(tileTypes, streetIndex + 6, TILETYPE.STREET, "F_STREET_T_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_B_M = new TileConfig(tileTypes, streetIndex + 7, TILETYPE.STREET, "F_STREET_T_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_GRASS_B_R = new TileConfig(tileTypes, streetIndex + 8, TILETYPE.STREET, "F_STREET_T_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_U_L = new TileConfig(tileTypes, streetIndex + 9, TILETYPE.STREET, "T_STREET_F_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_U_M = new TileConfig(tileTypes, streetIndex + 10, TILETYPE.STREET, "T_STREET_F_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_U_R = new TileConfig(tileTypes, streetIndex + 11, TILETYPE.STREET, "T_STREET_F_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_M_L = new TileConfig(tileTypes, streetIndex + 12, TILETYPE.STREET, "T_STREET_F_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_M_R = new TileConfig(tileTypes, streetIndex + 13, TILETYPE.STREET, "T_STREET_F_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_B_L = new TileConfig(tileTypes, streetIndex + 14, TILETYPE.STREET, "T_STREET_F_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_B_M = new TileConfig(tileTypes, streetIndex + 15, TILETYPE.STREET, "T_STREET_F_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_GRASS_B_R = new TileConfig(tileTypes, streetIndex + 16, TILETYPE.STREET, "T_STREET_F_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_U_L = new TileConfig(tileTypes, streetIndex + 17, TILETYPE.STREET, "F_STREET_T_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_U_M = new TileConfig(tileTypes, streetIndex + 18, TILETYPE.STREET, "F_STREET_T_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_U_R = new TileConfig(tileTypes, streetIndex + 19, TILETYPE.STREET, "F_STREET_T_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_M_L = new TileConfig(tileTypes, streetIndex + 20, TILETYPE.STREET, "F_STREET_T_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_M_R = new TileConfig(tileTypes, streetIndex + 21, TILETYPE.STREET, "F_STREET_T_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_B_L = new TileConfig(tileTypes, streetIndex + 22, TILETYPE.STREET, "F_STREET_T_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_B_M = new TileConfig(tileTypes, streetIndex + 23, TILETYPE.STREET, "F_STREET_T_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_EARTH_B_R = new TileConfig(tileTypes, streetIndex + 24, TILETYPE.STREET, "F_STREET_T_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_U_L = new TileConfig(tileTypes, streetIndex + 25, TILETYPE.STREET, "T_STREET_F_EARTH_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_U_M = new TileConfig(tileTypes, streetIndex + 26, TILETYPE.STREET, "T_STREET_F_EARTH_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_U_R = new TileConfig(tileTypes, streetIndex + 27, TILETYPE.STREET, "T_STREET_F_EARTH_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_M_L = new TileConfig(tileTypes, streetIndex + 28, TILETYPE.STREET, "T_STREET_F_EARTH_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_M_R = new TileConfig(tileTypes, streetIndex + 29, TILETYPE.STREET, "T_STREET_F_EARTH_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_B_L = new TileConfig(tileTypes, streetIndex + 30, TILETYPE.STREET, "T_STREET_F_EARTH_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_B_M = new TileConfig(tileTypes, streetIndex + 31, TILETYPE.STREET, "T_STREET_F_EARTH_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_EARTH_B_R = new TileConfig(tileTypes, streetIndex + 32, TILETYPE.STREET, "T_STREET_F_EARTH_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 12, false, 0, 0, false), streetHestitation, false);	
	public static final TileConfig F_STREET_T_WATER_U_L = new TileConfig(tileTypes, streetIndex + 33, TILETYPE.STREET, "F_STREET_T_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_U_M = new TileConfig(tileTypes, streetIndex + 34, TILETYPE.STREET, "F_STREET_T_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_U_R = new TileConfig(tileTypes, streetIndex + 35, TILETYPE.STREET, "F_STREET_T_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_M_L = new TileConfig(tileTypes, streetIndex + 36, TILETYPE.STREET, "F_STREET_T_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_M_R = new TileConfig(tileTypes, streetIndex + 37, TILETYPE.STREET, "F_STREET_T_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_B_L = new TileConfig(tileTypes, streetIndex + 38, TILETYPE.STREET, "F_STREET_T_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_B_M = new TileConfig(tileTypes, streetIndex + 39, TILETYPE.STREET, "F_STREET_T_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_WATER_B_R = new TileConfig(tileTypes, streetIndex + 40, TILETYPE.STREET, "F_STREET_T_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_U_L = new TileConfig(tileTypes, streetIndex + 41, TILETYPE.STREET, "T_STREET_F_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_U_M = new TileConfig(tileTypes, streetIndex + 42, TILETYPE.STREET, "T_STREET_F_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_U_R = new TileConfig(tileTypes, streetIndex + 43, TILETYPE.STREET, "T_STREET_F_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_M_L = new TileConfig(tileTypes, streetIndex + 44, TILETYPE.STREET, "T_STREET_F_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_M_R = new TileConfig(tileTypes, streetIndex + 45, TILETYPE.STREET, "T_STREET_F_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_B_L = new TileConfig(tileTypes, streetIndex + 46, TILETYPE.STREET, "T_STREET_F_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_B_M = new TileConfig(tileTypes, streetIndex + 47, TILETYPE.STREET, "T_STREET_F_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_WATER_B_R = new TileConfig(tileTypes, streetIndex + 48, TILETYPE.STREET, "T_STREET_F_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_U_L = new TileConfig(tileTypes, streetIndex + 49, TILETYPE.STREET, "F_STREET_T_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_U_M = new TileConfig(tileTypes, streetIndex + 50, TILETYPE.STREET, "F_STREET_T_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_U_R = new TileConfig(tileTypes, streetIndex + 51, TILETYPE.STREET, "F_STREET_T_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_M_L = new TileConfig(tileTypes, streetIndex + 52, TILETYPE.STREET, "F_STREET_T_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_M_R = new TileConfig(tileTypes, streetIndex + 53, TILETYPE.STREET, "F_STREET_T_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_B_L = new TileConfig(tileTypes, streetIndex + 54, TILETYPE.STREET, "F_STREET_T_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_B_M = new TileConfig(tileTypes, streetIndex + 55, TILETYPE.STREET, "F_STREET_T_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_SAND_B_R = new TileConfig(tileTypes, streetIndex + 56, TILETYPE.STREET, "F_STREET_T_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_U_L = new TileConfig(tileTypes, streetIndex + 57, TILETYPE.STREET, "T_STREET_F_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_U_M = new TileConfig(tileTypes, streetIndex + 58, TILETYPE.STREET, "T_STREET_F_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_U_R = new TileConfig(tileTypes, streetIndex + 59, TILETYPE.STREET, "T_STREET_F_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_M_L = new TileConfig(tileTypes, streetIndex + 60, TILETYPE.STREET, "T_STREET_F_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_M_R = new TileConfig(tileTypes, streetIndex + 61, TILETYPE.STREET, "T_STREET_F_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_B_L = new TileConfig(tileTypes, streetIndex + 62, TILETYPE.STREET, "T_STREET_F_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_B_M = new TileConfig(tileTypes, streetIndex + 63, TILETYPE.STREET, "T_STREET_F_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_SAND_B_R = new TileConfig(tileTypes, streetIndex + 64, TILETYPE.STREET, "T_STREET_F_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_U_L = new TileConfig(tileTypes, streetIndex + 65, TILETYPE.STREET, "F_STREET_T_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_U_M = new TileConfig(tileTypes, streetIndex + 66, TILETYPE.STREET, "F_STREET_T_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_U_R = new TileConfig(tileTypes, streetIndex + 67, TILETYPE.STREET, "F_STREET_T_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_M_L = new TileConfig(tileTypes, streetIndex + 68, TILETYPE.STREET, "F_STREET_T_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_M_R = new TileConfig(tileTypes, streetIndex + 69, TILETYPE.STREET, "F_STREET_T_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_B_L = new TileConfig(tileTypes, streetIndex + 70, TILETYPE.STREET, "F_STREET_T_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_B_M = new TileConfig(tileTypes, streetIndex + 71, TILETYPE.STREET, "F_STREET_T_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig F_STREET_T_STONE_B_R = new TileConfig(tileTypes, streetIndex + 72, TILETYPE.STREET, "F_STREET_T_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_U_L = new TileConfig(tileTypes, streetIndex + 73, TILETYPE.STREET, "T_STREET_F_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_U_M = new TileConfig(tileTypes, streetIndex + 74, TILETYPE.STREET, "T_STREET_F_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_U_R = new TileConfig(tileTypes, streetIndex + 75, TILETYPE.STREET, "T_STREET_F_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 10, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_M_L = new TileConfig(tileTypes, streetIndex + 76, TILETYPE.STREET, "T_STREET_F_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_M_R = new TileConfig(tileTypes, streetIndex + 77, TILETYPE.STREET, "T_STREET_F_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 11, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_B_L = new TileConfig(tileTypes, streetIndex + 78, TILETYPE.STREET, "T_STREET_F_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_B_M = new TileConfig(tileTypes, streetIndex + 79, TILETYPE.STREET, "T_STREET_F_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 12, false, 0, 0, false), streetHestitation, false);
	public static final TileConfig T_STREET_F_STONE_B_R = new TileConfig(tileTypes, streetIndex + 80, TILETYPE.STREET, "T_STREET_F_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 12, false, 0, 0, false), streetHestitation, false);
	
	/** EARTH **/
	public static final TileConfig EARTH_CLEAN = new TileConfig(tileTypes, earthIndex + 0, TILETYPE.EARTH, "EARTH_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_U_L = new TileConfig(tileTypes, earthIndex + 1, TILETYPE.EARTH, "F_EARTH_T_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_U_M = new TileConfig(tileTypes, earthIndex + 2, TILETYPE.EARTH, "F_EARTH_T_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_U_R = new TileConfig(tileTypes, earthIndex + 3, TILETYPE.EARTH, "F_EARTH_T_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_M_L = new TileConfig(tileTypes, earthIndex + 4, TILETYPE.EARTH, "F_EARTH_T_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_M_R = new TileConfig(tileTypes, earthIndex + 5, TILETYPE.EARTH, "F_EARTH_T_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_B_L = new TileConfig(tileTypes, earthIndex + 6, TILETYPE.EARTH, "F_EARTH_T_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_B_M = new TileConfig(tileTypes, earthIndex + 7, TILETYPE.EARTH, "F_EARTH_T_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_GRASS_B_R = new TileConfig(tileTypes, earthIndex + 8, TILETYPE.EARTH, "F_EARTH_T_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_U_L = new TileConfig(tileTypes, earthIndex + 9, TILETYPE.EARTH, "T_EARTH_F_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_U_M = new TileConfig(tileTypes, earthIndex + 10, TILETYPE.EARTH, "T_EARTH_F_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_U_R = new TileConfig(tileTypes, earthIndex + 11, TILETYPE.EARTH, "T_EARTH_F_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_M_L = new TileConfig(tileTypes, earthIndex + 12, TILETYPE.EARTH, "T_EARTH_F_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_M_R = new TileConfig(tileTypes, earthIndex + 13, TILETYPE.EARTH, "T_EARTH_F_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_B_L = new TileConfig(tileTypes, earthIndex + 14, TILETYPE.EARTH, "T_EARTH_F_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_B_M = new TileConfig(tileTypes, earthIndex + 15, TILETYPE.EARTH, "T_EARTH_F_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_GRASS_B_R = new TileConfig(tileTypes, earthIndex + 16, TILETYPE.EARTH, "T_EARTH_F_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_U_L = new TileConfig(tileTypes, earthIndex + 17, TILETYPE.EARTH, "F_EARTH_T_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_U_M = new TileConfig(tileTypes, earthIndex + 18, TILETYPE.EARTH, "F_EARTH_T_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_U_R = new TileConfig(tileTypes, earthIndex + 19, TILETYPE.EARTH, "F_EARTH_T_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_M_L = new TileConfig(tileTypes, earthIndex + 20, TILETYPE.EARTH, "F_EARTH_T_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_M_R = new TileConfig(tileTypes, earthIndex + 21, TILETYPE.EARTH, "F_EARTH_T_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_B_L = new TileConfig(tileTypes, earthIndex + 22, TILETYPE.EARTH, "F_EARTH_T_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_B_M = new TileConfig(tileTypes, earthIndex + 23, TILETYPE.EARTH, "F_EARTH_T_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_WATER_B_R = new TileConfig(tileTypes, earthIndex + 24, TILETYPE.EARTH, "F_EARTH_T_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig T_EARTH_F_WATER_U_L = new TileConfig(tileTypes, earthIndex + 25, TILETYPE.EARTH, "T_EARTH_F_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_U_M = new TileConfig(tileTypes, earthIndex + 26, TILETYPE.EARTH, "T_EARTH_F_WATER_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_U_R = new TileConfig(tileTypes, earthIndex + 27, TILETYPE.EARTH, "T_EARTH_F_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_M_L = new TileConfig(tileTypes, earthIndex + 28, TILETYPE.EARTH, "T_EARTH_F_WATER_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_M_R = new TileConfig(tileTypes, earthIndex + 29, TILETYPE.EARTH, "T_EARTH_F_WATER_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_B_L = new TileConfig(tileTypes, earthIndex + 30, TILETYPE.EARTH, "T_EARTH_F_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_B_M = new TileConfig(tileTypes, earthIndex + 31, TILETYPE.EARTH, "T_EARTH_F_WATER_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_WATER_B_R = new TileConfig(tileTypes, earthIndex + 32, TILETYPE.EARTH, "T_EARTH_F_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_U_L = new TileConfig(tileTypes, earthIndex + 33, TILETYPE.EARTH, "F_EARTH_T_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_U_M = new TileConfig(tileTypes, earthIndex + 34, TILETYPE.EARTH, "F_EARTH_T_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_U_R = new TileConfig(tileTypes, earthIndex + 35, TILETYPE.EARTH, "F_EARTH_T_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_M_L = new TileConfig(tileTypes, earthIndex + 36, TILETYPE.EARTH, "F_EARTH_T_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_M_R = new TileConfig(tileTypes, earthIndex + 37, TILETYPE.EARTH, "F_EARTH_T_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_B_L = new TileConfig(tileTypes, earthIndex + 38, TILETYPE.EARTH, "F_EARTH_T_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_B_M = new TileConfig(tileTypes, earthIndex + 39, TILETYPE.EARTH, "F_EARTH_T_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_SAND_B_R = new TileConfig(tileTypes, earthIndex + 40, TILETYPE.EARTH, "F_EARTH_T_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig T_EARTH_F_SAND_U_L = new TileConfig(tileTypes, earthIndex + 41, TILETYPE.EARTH, "T_EARTH_F_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_U_M = new TileConfig(tileTypes, earthIndex + 42, TILETYPE.EARTH, "T_EARTH_F_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_U_R = new TileConfig(tileTypes, earthIndex + 43, TILETYPE.EARTH, "T_EARTH_F_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_M_L = new TileConfig(tileTypes, earthIndex + 44, TILETYPE.EARTH, "T_EARTH_F_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_M_R = new TileConfig(tileTypes, earthIndex + 45, TILETYPE.EARTH, "T_EARTH_F_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_B_L = new TileConfig(tileTypes, earthIndex + 46, TILETYPE.EARTH, "T_EARTH_F_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_B_M = new TileConfig(tileTypes, earthIndex + 47, TILETYPE.EARTH, "T_EARTH_F_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_SAND_B_R = new TileConfig(tileTypes, earthIndex + 48, TILETYPE.EARTH, "T_EARTH_F_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig F_EARTH_T_STONE_U_L = new TileConfig(tileTypes, earthIndex + 49, TILETYPE.EARTH, "F_EARTH_T_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_U_M = new TileConfig(tileTypes, earthIndex + 50, TILETYPE.EARTH, "F_EARTH_T_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_U_R = new TileConfig(tileTypes, earthIndex + 51, TILETYPE.EARTH, "F_EARTH_T_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_M_L = new TileConfig(tileTypes, earthIndex + 52, TILETYPE.EARTH, "F_EARTH_T_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_M_R = new TileConfig(tileTypes, earthIndex + 53, TILETYPE.EARTH, "F_EARTH_T_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_B_L = new TileConfig(tileTypes, earthIndex + 54, TILETYPE.EARTH, "F_EARTH_T_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_B_M = new TileConfig(tileTypes, earthIndex + 55, TILETYPE.EARTH, "F_EARTH_T_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STONE_B_R = new TileConfig(tileTypes, earthIndex + 56, TILETYPE.EARTH, "F_EARTH_T_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig T_EARTH_F_STONE_U_L = new TileConfig(tileTypes, earthIndex + 57, TILETYPE.EARTH, "T_EARTH_F_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_U_M = new TileConfig(tileTypes, earthIndex + 58, TILETYPE.EARTH, "T_EARTH_F_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_U_R = new TileConfig(tileTypes, earthIndex + 59, TILETYPE.EARTH, "T_EARTH_F_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_M_L = new TileConfig(tileTypes, earthIndex + 60, TILETYPE.EARTH, "T_EARTH_F_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_M_R = new TileConfig(tileTypes, earthIndex + 61, TILETYPE.EARTH, "T_EARTH_F_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_B_L = new TileConfig(tileTypes, earthIndex + 62, TILETYPE.EARTH, "T_EARTH_F_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_B_M = new TileConfig(tileTypes, earthIndex + 63, TILETYPE.EARTH, "T_EARTH_F_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STONE_B_R = new TileConfig(tileTypes, earthIndex + 64, TILETYPE.EARTH, "T_EARTH_F_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig F_EARTH_T_STREET_U_L = new TileConfig(tileTypes, earthIndex + 65, TILETYPE.EARTH, "F_EARTH_T_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_U_M = new TileConfig(tileTypes, earthIndex + 66, TILETYPE.EARTH, "F_EARTH_T_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_U_R = new TileConfig(tileTypes, earthIndex + 67, TILETYPE.EARTH, "F_EARTH_T_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_M_L = new TileConfig(tileTypes, earthIndex + 68, TILETYPE.EARTH, "F_EARTH_T_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_M_R = new TileConfig(tileTypes, earthIndex + 69, TILETYPE.EARTH, "F_EARTH_T_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_B_L = new TileConfig(tileTypes, earthIndex + 70, TILETYPE.EARTH, "F_EARTH_T_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_B_M = new TileConfig(tileTypes, earthIndex + 71, TILETYPE.EARTH, "F_EARTH_T_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig F_EARTH_T_STREET_B_R = new TileConfig(tileTypes, earthIndex + 72, TILETYPE.EARTH, "F_EARTH_T_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 15, false, 0, 0, false), earthHestitation, false);
	public static final TileConfig T_EARTH_F_STREET_U_L = new TileConfig(tileTypes, earthIndex + 73, TILETYPE.EARTH, "T_EARTH_F_STREET_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_U_M = new TileConfig(tileTypes, earthIndex + 74, TILETYPE.EARTH, "T_EARTH_F_STREET_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_U_R = new TileConfig(tileTypes, earthIndex + 75, TILETYPE.EARTH, "T_EARTH_F_STREET_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 13, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_M_L = new TileConfig(tileTypes, earthIndex + 76, TILETYPE.EARTH, "T_EARTH_F_STREET_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_M_R = new TileConfig(tileTypes, earthIndex + 77, TILETYPE.EARTH, "T_EARTH_F_STREET_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 14, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_B_L = new TileConfig(tileTypes, earthIndex + 78, TILETYPE.EARTH, "T_EARTH_F_STREET_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_B_M = new TileConfig(tileTypes, earthIndex + 79, TILETYPE.EARTH, "T_EARTH_F_STREET_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 15, false, 0, 0, false), earthHestitation, false);	
	public static final TileConfig T_EARTH_F_STREET_B_R = new TileConfig(tileTypes, earthIndex + 80, TILETYPE.EARTH, "T_EARTH_F_STREET_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 15, false, 0, 0, false), earthHestitation, false);	

	/** WOOD **/
	public static final TileConfig WOOD_CLEAN = new TileConfig(tileTypes, woodIndex + 0, TILETYPE.WOOD, "WOOD_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_L = new TileConfig(tileTypes, woodIndex + 1, TILETYPE.WOOD, "WOOD_L",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_R = new TileConfig(tileTypes, woodIndex + 2, TILETYPE.WOOD, "WOOD_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_U = new TileConfig(tileTypes, woodIndex + 3, TILETYPE.WOOD, "WOOD_U",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_B = new TileConfig(tileTypes, woodIndex + 4, TILETYPE.WOOD, "WOOD_B",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_ALL = new TileConfig(tileTypes, woodIndex + 5, TILETYPE.WOOD, "WOOD_ALL",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 0, false, 0, 0, false), 1.0f, false);
	public static final TileConfig WOOD_CORNER_B_L = new TileConfig(tileTypes, woodIndex + 6, TILETYPE.WOOD, "WOOD_CORNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_CORNER_B_R = new TileConfig(tileTypes, woodIndex + 7, TILETYPE.WOOD, "WOOD_CORNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_CORNER_U_L = new TileConfig(tileTypes, woodIndex + 8, TILETYPE.WOOD, "WOOD_CORNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_CORNER_R_R = new TileConfig(tileTypes, woodIndex + 9, TILETYPE.WOOD, "WOOD_CORNER_R_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_INNER_U_R = new TileConfig(tileTypes, woodIndex + 10, TILETYPE.WOOD, "WOOD_INNER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_INNER_U_L = new TileConfig(tileTypes, woodIndex + 11, TILETYPE.WOOD, "WOOD_INNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_INNER_B_L = new TileConfig(tileTypes, woodIndex + 12, TILETYPE.WOOD, "WOOD_INNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 0, false, 0, 0, false), woodHestitation, false);
	public static final TileConfig WOOD_INNER_B_R = new TileConfig(tileTypes, woodIndex + 13, TILETYPE.WOOD, "WOOD_INNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 0, false, 0, 0, false), woodHestitation, false);
	
	public static TileConfig getBluePrintByID(int id) {
		return tileTypes[id];
	}
	
	public static TileConfig getBluePrintByName(String name) {
		for (TileConfig tileBlueprint : tileTypes) {
			if (tileBlueprint != null) {
				if (tileBlueprint.name.equals(name)) {
					return tileBlueprint;
				}
			}
		}
		
		return null;
	}
	
	public static int getTilesCount() {
		int count = 0;
		
		for (TileConfig tile : tileTypes) {
			if (tile != null) {
				count++;
			}
		}
		
		return count;
	}
}
