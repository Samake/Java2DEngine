package game_content.resources;

import engine.sprites.SpriteAtlas;
import engine.tiles.TileBluePrint;

public class Tiles {
	
	public enum TILETYPE {
		VOID, STONE, GRASS, SAND, DIRT, WOOD, WATER
	}
	
	public static final TileBluePrint[] tileTypes = new TileBluePrint[2048];
	
	public static final TileBluePrint VOID = new TileBluePrint(tileTypes, 0, TILETYPE.VOID, "VOID", new SpriteAtlas(Sheets.TILES_SHEET, 0, 0, false, 0, 0, false), 0.2f, false);
	
	public static final TileBluePrint STONE_CLEAN = new TileBluePrint(tileTypes, 100, TILETYPE.STONE, "STONE_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_L = new TileBluePrint(tileTypes, 101, TILETYPE.STONE, "STONE_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_M = new TileBluePrint(tileTypes, 102, TILETYPE.STONE, "STONE_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_R = new TileBluePrint(tileTypes, 103, TILETYPE.STONE, "STONE_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_M_L = new TileBluePrint(tileTypes, 104, TILETYPE.STONE, "STONE_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_M_R = new TileBluePrint(tileTypes, 105, TILETYPE.STONE, "STONE_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_L = new TileBluePrint(tileTypes, 106, TILETYPE.STONE, "STONE_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_M = new TileBluePrint(tileTypes, 107, TILETYPE.STONE, "STONE_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_R = new TileBluePrint(tileTypes, 108, TILETYPE.STONE, "STONE_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_U_L = new TileBluePrint(tileTypes, 109, TILETYPE.STONE, "STONE_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_U_R = new TileBluePrint(tileTypes, 110, TILETYPE.STONE, "STONE_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_B_L = new TileBluePrint(tileTypes, 111, TILETYPE.STONE, "STONE_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_B_R = new TileBluePrint(tileTypes, 112, TILETYPE.STONE, "STONE_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_U_L = new TileBluePrint(tileTypes, 113, TILETYPE.STONE, "STONE_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_U_R = new TileBluePrint(tileTypes, 114, TILETYPE.STONE, "STONE_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_B_L = new TileBluePrint(tileTypes, 115, TILETYPE.STONE, "STONE_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_B_R = new TileBluePrint(tileTypes, 116, TILETYPE.STONE, "STONE_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_U_L = new TileBluePrint(tileTypes, 117, TILETYPE.STONE, "STONE_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_U_R = new TileBluePrint(tileTypes, 118, TILETYPE.STONE, "STONE_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_B_L = new TileBluePrint(tileTypes, 119, TILETYPE.STONE, "STONE_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_B_R = new TileBluePrint(tileTypes, 120, TILETYPE.STONE, "STONE_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 1, false, 0, 0, false), 1.0f, false);
	
	public static final TileBluePrint GRASS_CLEAN = new TileBluePrint(tileTypes, 200, TILETYPE.GRASS, "GRASS_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_01 = new TileBluePrint(tileTypes, 201, TILETYPE.GRASS, "GRASS_LUSH_01",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_02 = new TileBluePrint(tileTypes, 202, TILETYPE.GRASS, "GRASS_LUSH_02",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_03 = new TileBluePrint(tileTypes, 203, TILETYPE.GRASS, "GRASS_LUSH_03",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_FLOWER_01 = new TileBluePrint(tileTypes, 204, TILETYPE.GRASS, "GRASS_FLOWER_01",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_U_L = new TileBluePrint(tileTypes, 205, TILETYPE.GRASS, "GRASS_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_U_R = new TileBluePrint(tileTypes, 206, TILETYPE.GRASS, "GRASS_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_B_L = new TileBluePrint(tileTypes, 207, TILETYPE.GRASS, "GRASS_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_B_R = new TileBluePrint(tileTypes, 208, TILETYPE.GRASS, "GRASS_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_U_L = new TileBluePrint(tileTypes, 209, TILETYPE.GRASS, "GRASS_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_U_R = new TileBluePrint(tileTypes, 210, TILETYPE.GRASS, "GRASS_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_B_L = new TileBluePrint(tileTypes, 211, TILETYPE.GRASS, "GRASS_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_B_R = new TileBluePrint(tileTypes, 212, TILETYPE.GRASS, "GRASS_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_U_L = new TileBluePrint(tileTypes, 213, TILETYPE.GRASS, "GRASS_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_U_R = new TileBluePrint(tileTypes, 214, TILETYPE.GRASS, "GRASS_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_B_L = new TileBluePrint(tileTypes, 215, TILETYPE.GRASS, "GRASS_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_B_R = new TileBluePrint(tileTypes, 216, TILETYPE.GRASS, "GRASS_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_U_L = new TileBluePrint(tileTypes, 217, TILETYPE.GRASS, "GRASS_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_U_R = new TileBluePrint(tileTypes, 218, TILETYPE.GRASS, "GRASS_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_B_L = new TileBluePrint(tileTypes, 219, TILETYPE.GRASS, "GRASS_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_B_R = new TileBluePrint(tileTypes, 220, TILETYPE.GRASS, "GRASS_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 2, false, 0, 0, false), 0.8f, false);
	
	public static final TileBluePrint SAND_CLEAN = new TileBluePrint(tileTypes, 300, TILETYPE.SAND, "SAND_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_L = new TileBluePrint(tileTypes, 301, TILETYPE.SAND, "SAND_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_M = new TileBluePrint(tileTypes, 302, TILETYPE.SAND, "SAND_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_R = new TileBluePrint(tileTypes, 303, TILETYPE.SAND, "SAND_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_M_L = new TileBluePrint(tileTypes, 304, TILETYPE.SAND, "SAND_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_M_R = new TileBluePrint(tileTypes, 305, TILETYPE.SAND, "SAND_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_L = new TileBluePrint(tileTypes, 306, TILETYPE.SAND, "SAND_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_M = new TileBluePrint(tileTypes, 307, TILETYPE.SAND, "SAND_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_R = new TileBluePrint(tileTypes, 308, TILETYPE.SAND, "SAND_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_U_L = new TileBluePrint(tileTypes, 309, TILETYPE.SAND, "SAND_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_U_R = new TileBluePrint(tileTypes, 310, TILETYPE.SAND, "SAND_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_B_L = new TileBluePrint(tileTypes, 311, TILETYPE.SAND, "SAND_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_B_R = new TileBluePrint(tileTypes, 312, TILETYPE.SAND, "SAND_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_U_L = new TileBluePrint(tileTypes, 313, TILETYPE.SAND, "SAND_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_U_R = new TileBluePrint(tileTypes, 314, TILETYPE.SAND, "SAND_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_B_L = new TileBluePrint(tileTypes, 315, TILETYPE.SAND, "SAND_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_B_R = new TileBluePrint(tileTypes, 316, TILETYPE.SAND, "SAND_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_U_L = new TileBluePrint(tileTypes, 317, TILETYPE.SAND, "SAND_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_U_R = new TileBluePrint(tileTypes, 318, TILETYPE.SAND, "SAND_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_B_L = new TileBluePrint(tileTypes, 319, TILETYPE.SAND, "SAND_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_B_R = new TileBluePrint(tileTypes, 320, TILETYPE.SAND, "SAND_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 3, false, 0, 0, false), 0.65f, false);
	
	
	public static final TileBluePrint DIRT_CLEAN = new TileBluePrint(tileTypes, 400, TILETYPE.DIRT, "DIRT_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_HOLES = new TileBluePrint(tileTypes, 401, TILETYPE.DIRT, "DIRT_HOLES",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_HOLE = new TileBluePrint(tileTypes, 402, TILETYPE.DIRT, "DIRT_HOLE",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_3_STONES = new TileBluePrint(tileTypes, 403, TILETYPE.DIRT, "DIRT_3_STONES",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_2_STONES = new TileBluePrint(tileTypes, 404, TILETYPE.DIRT, "DIRT_2_STONES",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_CRACK = new TileBluePrint(tileTypes, 405, TILETYPE.DIRT, "DIRT_CRACK",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_L = new TileBluePrint(tileTypes, 406, TILETYPE.DIRT, "DIRT_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_M = new TileBluePrint(tileTypes, 407, TILETYPE.DIRT, "DIRT_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_R = new TileBluePrint(tileTypes, 408, TILETYPE.DIRT, "DIRT_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_M_L = new TileBluePrint(tileTypes, 409, TILETYPE.DIRT, "DIRT_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_M_R = new TileBluePrint(tileTypes, 410, TILETYPE.DIRT, "DIRT_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_L = new TileBluePrint(tileTypes, 411, TILETYPE.DIRT, "DIRT_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_M = new TileBluePrint(tileTypes, 412, TILETYPE.DIRT, "DIRT_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_R = new TileBluePrint(tileTypes, 413, TILETYPE.DIRT, "DIRT_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_U_L = new TileBluePrint(tileTypes, 414, TILETYPE.DIRT, "DIRT_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_U_R = new TileBluePrint(tileTypes, 415, TILETYPE.DIRT, "DIRT_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_B_L = new TileBluePrint(tileTypes, 416, TILETYPE.DIRT, "DIRT_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_B_R = new TileBluePrint(tileTypes, 417, TILETYPE.DIRT, "DIRT_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_U_L = new TileBluePrint(tileTypes, 418, TILETYPE.DIRT, "DIRT_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_U_R = new TileBluePrint(tileTypes, 419, TILETYPE.DIRT, "DIRT_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_B_L = new TileBluePrint(tileTypes, 420, TILETYPE.DIRT, "DIRT_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_B_R = new TileBluePrint(tileTypes, 421, TILETYPE.DIRT, "DIRT_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_U_L = new TileBluePrint(tileTypes, 422, TILETYPE.DIRT, "DIRT_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_U_R = new TileBluePrint(tileTypes, 423, TILETYPE.DIRT, "DIRT_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_B_L = new TileBluePrint(tileTypes, 424, TILETYPE.DIRT, "DIRT_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_B_R = new TileBluePrint(tileTypes, 425, TILETYPE.DIRT, "DIRT_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 4, false, 0, 0, false), 0.9f, false);
	
	public static final TileBluePrint WOOD_CLEAN = new TileBluePrint(tileTypes, 500, TILETYPE.WOOD, "WOOD_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_L = new TileBluePrint(tileTypes, 501, TILETYPE.WOOD, "WOOD_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_R = new TileBluePrint(tileTypes, 502, TILETYPE.WOOD, "WOOD_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_U = new TileBluePrint(tileTypes, 503, TILETYPE.WOOD, "WOOD_U",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_B = new TileBluePrint(tileTypes, 504, TILETYPE.WOOD, "WOOD_B",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_ALL = new TileBluePrint(tileTypes, 505, TILETYPE.WOOD, "WOOD_ALL",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_B_L = new TileBluePrint(tileTypes, 506, TILETYPE.WOOD, "WOOD_CORNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_B_R = new TileBluePrint(tileTypes, 507, TILETYPE.WOOD, "WOOD_CORNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_U_L = new TileBluePrint(tileTypes, 508, TILETYPE.WOOD, "WOOD_CORNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_R_R = new TileBluePrint(tileTypes, 509, TILETYPE.WOOD, "WOOD_CORNER_R_R",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_U_R = new TileBluePrint(tileTypes, 510, TILETYPE.WOOD, "WOOD_INNER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_U_L = new TileBluePrint(tileTypes, 511, TILETYPE.WOOD, "WOOD_INNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_B_L = new TileBluePrint(tileTypes, 512, TILETYPE.WOOD, "WOOD_INNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_B_R = new TileBluePrint(tileTypes, 513, TILETYPE.WOOD, "WOOD_INNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 5, false, 0, 0, false), 1.0f, false);
	
	public static final TileBluePrint WATER_CLEAN = new TileBluePrint(tileTypes, 700, TILETYPE.WATER, "WATER_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 6, true, 500, 3, true), 0.35f, false);
	public static final TileBluePrint WATER_GRASS_U_L = new TileBluePrint(tileTypes, 701, TILETYPE.WATER, "WATER_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_U_M = new TileBluePrint(tileTypes, 702, TILETYPE.WATER, "WATER_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_U_R = new TileBluePrint(tileTypes, 703, TILETYPE.WATER, "WATER_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_M_L = new TileBluePrint(tileTypes, 704, TILETYPE.WATER, "WATER_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_M_R = new TileBluePrint(tileTypes, 705, TILETYPE.WATER, "WATER_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_L = new TileBluePrint(tileTypes, 706, TILETYPE.WATER, "WATER_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_M = new TileBluePrint(tileTypes, 707, TILETYPE.WATER, "WATER_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_R = new TileBluePrint(tileTypes, 708, TILETYPE.WATER, "WATER_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_L = new TileBluePrint(tileTypes, 709, TILETYPE.WATER, "WATER_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_M = new TileBluePrint(tileTypes, 710, TILETYPE.WATER, "WATER_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_R = new TileBluePrint(tileTypes, 711, TILETYPE.WATER, "WATER_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_M_L = new TileBluePrint(tileTypes, 712, TILETYPE.WATER, "WATER_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_M_R = new TileBluePrint(tileTypes, 713, TILETYPE.WATER, "WATER_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_L = new TileBluePrint(tileTypes, 714, TILETYPE.WATER, "WATER_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_M = new TileBluePrint(tileTypes, 715, TILETYPE.WATER, "WATER_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_R = new TileBluePrint(tileTypes, 716, TILETYPE.WATER, "WATER_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_L = new TileBluePrint(tileTypes, 717, TILETYPE.WATER, "WATER_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_M = new TileBluePrint(tileTypes, 718, TILETYPE.WATER, "WATER_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_R = new TileBluePrint(tileTypes, 719, TILETYPE.WATER, "WATER_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_M_L = new TileBluePrint(tileTypes, 720, TILETYPE.WATER, "WATER_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_M_R = new TileBluePrint(tileTypes, 721, TILETYPE.WATER, "WATER_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_L = new TileBluePrint(tileTypes, 722, TILETYPE.WATER, "WATER_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_M = new TileBluePrint(tileTypes, 723, TILETYPE.WATER, "WATER_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_R = new TileBluePrint(tileTypes, 724, TILETYPE.WATER, "WATER_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_L = new TileBluePrint(tileTypes, 725, TILETYPE.WATER, "WATER_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_M = new TileBluePrint(tileTypes, 726, TILETYPE.WATER, "WATER_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_R = new TileBluePrint(tileTypes, 727, TILETYPE.WATER, "WATER_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_M_L = new TileBluePrint(tileTypes, 728, TILETYPE.WATER, "WATER_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 30, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_M_R = new TileBluePrint(tileTypes, 729, TILETYPE.WATER, "WATER_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 31, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_L = new TileBluePrint(tileTypes, 730, TILETYPE.WATER, "WATER_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 7, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_M = new TileBluePrint(tileTypes, 731, TILETYPE.WATER, "WATER_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 7, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_R = new TileBluePrint(tileTypes, 732, TILETYPE.WATER, "WATER_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 7, false, 0, 0, false), 0.9f, false);
	
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
