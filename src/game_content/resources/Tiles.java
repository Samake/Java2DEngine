package game_content.resources;

import engine.sprites.SpriteAtlas;
import engine.tiles.TileBluePrint;

public class Tiles {
	public static final TileBluePrint[] tileTypes = new TileBluePrint[2048];
	
	public static final TileBluePrint VOID = new TileBluePrint(tileTypes, 0, "VOID", new SpriteAtlas(Sheets.TILES_SHEET, 0, 0, false, 0, 0, false), 0.2f, false);
	
	public static final TileBluePrint STONE_CLEAN = new TileBluePrint(tileTypes, 100, "STONE_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_L = new TileBluePrint(tileTypes, 101, "STONE_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_M = new TileBluePrint(tileTypes, 102, "STONE_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_U_R = new TileBluePrint(tileTypes, 103, "STONE_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_M_L = new TileBluePrint(tileTypes, 104, "STONE_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_M_R = new TileBluePrint(tileTypes, 105, "STONE_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_L = new TileBluePrint(tileTypes, 106, "STONE_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_M = new TileBluePrint(tileTypes, 107, "STONE_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_GRASS_B_R = new TileBluePrint(tileTypes, 108, "STONE_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_U_L = new TileBluePrint(tileTypes, 109, "STONE_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_U_R = new TileBluePrint(tileTypes, 110, "STONE_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_B_L = new TileBluePrint(tileTypes, 111, "STONE_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_WATER_B_R = new TileBluePrint(tileTypes, 112, "STONE_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_U_L = new TileBluePrint(tileTypes, 113, "STONE_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_U_R = new TileBluePrint(tileTypes, 114, "STONE_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_B_L = new TileBluePrint(tileTypes, 115, "STONE_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_DIRT_B_R = new TileBluePrint(tileTypes, 116, "STONE_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_U_L = new TileBluePrint(tileTypes, 117, "STONE_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_U_R = new TileBluePrint(tileTypes, 118, "STONE_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_B_L = new TileBluePrint(tileTypes, 119, "STONE_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 1, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint STONE_SAND_B_R = new TileBluePrint(tileTypes, 120, "STONE_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 1, false, 0, 0, false), 1.0f, false);
	
	
	public static final TileBluePrint GRASS_CLEAN = new TileBluePrint(tileTypes, 200, "GRASS_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_01 = new TileBluePrint(tileTypes, 201, "GRASS_LUSH_01",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_02 = new TileBluePrint(tileTypes, 202, "GRASS_LUSH_02",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_LUSH_03 = new TileBluePrint(tileTypes, 203, "GRASS_LUSH_03",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_FLOWER_01 = new TileBluePrint(tileTypes, 204, "GRASS_FLOWER_01",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_U_L = new TileBluePrint(tileTypes, 205, "GRASS_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_U_R = new TileBluePrint(tileTypes, 206, "GRASS_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_B_L = new TileBluePrint(tileTypes, 207, "GRASS_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_STONE_B_R = new TileBluePrint(tileTypes, 208, "GRASS_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_U_L = new TileBluePrint(tileTypes, 209, "GRASS_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_U_R = new TileBluePrint(tileTypes, 210, "GRASS_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_B_L = new TileBluePrint(tileTypes, 211, "GRASS_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_WATER_B_R = new TileBluePrint(tileTypes, 212, "GRASS_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_U_L = new TileBluePrint(tileTypes, 213, "GRASS_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_U_R = new TileBluePrint(tileTypes, 214, "GRASS_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_B_L = new TileBluePrint(tileTypes, 215, "GRASS_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_DIRT_B_R = new TileBluePrint(tileTypes, 216, "GRASS_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_U_L = new TileBluePrint(tileTypes, 217, "GRASS_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_U_R = new TileBluePrint(tileTypes, 218, "GRASS_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_B_L = new TileBluePrint(tileTypes, 219, "GRASS_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 2, false, 0, 0, false), 0.8f, false);
	public static final TileBluePrint GRASS_SAND_B_R = new TileBluePrint(tileTypes, 220, "GRASS_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 2, false, 0, 0, false), 0.8f, false);

	
	public static final TileBluePrint SAND_CLEAN = new TileBluePrint(tileTypes, 300, "SAND_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_L = new TileBluePrint(tileTypes, 301, "SAND_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_M = new TileBluePrint(tileTypes, 302, "SAND_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_U_R = new TileBluePrint(tileTypes, 303, "SAND_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_M_L = new TileBluePrint(tileTypes, 304, "SAND_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_M_R = new TileBluePrint(tileTypes, 305, "SAND_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_L = new TileBluePrint(tileTypes, 306, "SAND_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_M = new TileBluePrint(tileTypes, 307, "SAND_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_GRASS_B_R = new TileBluePrint(tileTypes, 308, "SAND_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_U_L = new TileBluePrint(tileTypes, 309, "SAND_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_U_R = new TileBluePrint(tileTypes, 310, "SAND_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_B_L = new TileBluePrint(tileTypes, 311, "SAND_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_STONE_B_R = new TileBluePrint(tileTypes, 312, "SAND_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_U_L = new TileBluePrint(tileTypes, 313, "SAND_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_U_R = new TileBluePrint(tileTypes, 314, "SAND_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_B_L = new TileBluePrint(tileTypes, 315, "SAND_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_DIRT_B_R = new TileBluePrint(tileTypes, 316, "SAND_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_U_L = new TileBluePrint(tileTypes, 317, "SAND_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_U_R = new TileBluePrint(tileTypes, 318, "SAND_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_B_L = new TileBluePrint(tileTypes, 319, "SAND_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 3, false, 0, 0, false), 0.65f, false);
	public static final TileBluePrint SAND_WATER_B_R = new TileBluePrint(tileTypes, 320, "SAND_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 3, false, 0, 0, false), 0.65f, false);
	
	
	public static final TileBluePrint DIRT_CLEAN = new TileBluePrint(tileTypes, 400, "DIRT_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_HOLES = new TileBluePrint(tileTypes, 401, "DIRT_HOLES",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_HOLE = new TileBluePrint(tileTypes, 402, "DIRT_HOLE",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_3_STONES = new TileBluePrint(tileTypes, 403, "DIRT_3_STONES",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_2_STONES = new TileBluePrint(tileTypes, 404, "DIRT_2_STONES",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_CRACK = new TileBluePrint(tileTypes, 405, "DIRT_CRACK",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_L = new TileBluePrint(tileTypes, 406, "DIRT_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_M = new TileBluePrint(tileTypes, 407, "DIRT_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_U_R = new TileBluePrint(tileTypes, 408, "DIRT_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_M_L = new TileBluePrint(tileTypes, 409, "DIRT_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_M_R = new TileBluePrint(tileTypes, 410, "DIRT_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_L = new TileBluePrint(tileTypes, 411, "DIRT_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_M = new TileBluePrint(tileTypes, 412, "DIRT_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_GRASS_B_R = new TileBluePrint(tileTypes, 413, "DIRT_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_U_L = new TileBluePrint(tileTypes, 414, "DIRT_WATER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_U_R = new TileBluePrint(tileTypes, 415, "DIRT_WATER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_B_L = new TileBluePrint(tileTypes, 416, "DIRT_WATER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_WATER_B_R = new TileBluePrint(tileTypes, 417, "DIRT_WATER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_U_L = new TileBluePrint(tileTypes, 418, "DIRT_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_U_R = new TileBluePrint(tileTypes, 419, "DIRT_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_B_L = new TileBluePrint(tileTypes, 420, "DIRT_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_STONE_B_R = new TileBluePrint(tileTypes, 421, "DIRT_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_U_L = new TileBluePrint(tileTypes, 422, "DIRT_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_U_R = new TileBluePrint(tileTypes, 423, "DIRT_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_B_L = new TileBluePrint(tileTypes, 424, "DIRT_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 4, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint DIRT_SAND_B_R = new TileBluePrint(tileTypes, 425, "DIRT_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 4, false, 0, 0, false), 0.9f, false);
	
	
	public static final TileBluePrint WOOD_CLEAN = new TileBluePrint(tileTypes, 500, "WOOD_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_L = new TileBluePrint(tileTypes, 501, "WOOD_L",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_R = new TileBluePrint(tileTypes, 502, "WOOD_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_U = new TileBluePrint(tileTypes, 503, "WOOD_U",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_B = new TileBluePrint(tileTypes, 504, "WOOD_B",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_ALL = new TileBluePrint(tileTypes, 505, "WOOD_ALL",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_B_L = new TileBluePrint(tileTypes, 506, "WOOD_CORNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_B_R = new TileBluePrint(tileTypes, 507, "WOOD_CORNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_U_L = new TileBluePrint(tileTypes, 508, "WOOD_CORNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_CORNER_R_R = new TileBluePrint(tileTypes, 509, "WOOD_CORNER_R_R",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_U_R = new TileBluePrint(tileTypes, 510, "WOOD_INNER_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_U_L = new TileBluePrint(tileTypes, 511, "WOOD_INNER_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_B_L = new TileBluePrint(tileTypes, 512, "WOOD_INNER_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 5, false, 0, 0, false), 1.0f, false);
	public static final TileBluePrint WOOD_INNER_B_R = new TileBluePrint(tileTypes, 513, "WOOD_INNER_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 5, false, 0, 0, false), 1.0f, false);
	
	
	public static final TileBluePrint WATER_CLEAN = new TileBluePrint(tileTypes, 700, "WATER_CLEAN",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 6, true, 500, 3, true), 0.35f, false);
	public static final TileBluePrint WATER_GRASS_U_L = new TileBluePrint(tileTypes, 701, "WATER_GRASS_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 3, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_U_M = new TileBluePrint(tileTypes, 702, "WATER_GRASS_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 4, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_U_R = new TileBluePrint(tileTypes, 703, "WATER_GRASS_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 5, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_M_L = new TileBluePrint(tileTypes, 704, "WATER_GRASS_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 6, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_M_R = new TileBluePrint(tileTypes, 705, "WATER_GRASS_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 7, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_L = new TileBluePrint(tileTypes, 706, "WATER_GRASS_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 8, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_M = new TileBluePrint(tileTypes, 707, "WATER_GRASS_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 9, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_GRASS_B_R = new TileBluePrint(tileTypes, 708, "WATER_GRASS_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 10, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_L = new TileBluePrint(tileTypes, 709, "WATER_STONE_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 11, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_M = new TileBluePrint(tileTypes, 710, "WATER_STONE_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 12, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_U_R = new TileBluePrint(tileTypes, 711, "WATER_STONE_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 13, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_M_L = new TileBluePrint(tileTypes, 712, "WATER_STONE_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 14, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_M_R = new TileBluePrint(tileTypes, 713, "WATER_STONE_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 15, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_L = new TileBluePrint(tileTypes, 714, "WATER_STONE_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 16, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_M = new TileBluePrint(tileTypes, 715, "WATER_STONE_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 17, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_STONE_B_R = new TileBluePrint(tileTypes, 716, "WATER_STONE_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 18, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_L = new TileBluePrint(tileTypes, 717, "WATER_DIRT_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 19, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_M = new TileBluePrint(tileTypes, 718, "WATER_DIRT_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 20, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_U_R = new TileBluePrint(tileTypes, 719, "WATER_DIRT_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 21, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_M_L = new TileBluePrint(tileTypes, 720, "WATER_DIRT_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 22, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_M_R = new TileBluePrint(tileTypes, 721, "WATER_DIRT_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 23, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_L = new TileBluePrint(tileTypes, 722, "WATER_DIRT_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 24, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_M = new TileBluePrint(tileTypes, 723, "WATER_DIRT_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 25, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_DIRT_B_R = new TileBluePrint(tileTypes, 724, "WATER_DIRT_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 26, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_L = new TileBluePrint(tileTypes, 725, "WATER_SAND_U_L",  new SpriteAtlas(Sheets.TILES_SHEET, 27, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_M = new TileBluePrint(tileTypes, 726, "WATER_SAND_U_M",  new SpriteAtlas(Sheets.TILES_SHEET, 28, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_U_R = new TileBluePrint(tileTypes, 727, "WATER_SAND_U_R",  new SpriteAtlas(Sheets.TILES_SHEET, 29, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_M_L = new TileBluePrint(tileTypes, 728, "WATER_SAND_M_L",  new SpriteAtlas(Sheets.TILES_SHEET, 30, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_M_R = new TileBluePrint(tileTypes, 729, "WATER_SAND_M_R",  new SpriteAtlas(Sheets.TILES_SHEET, 31, 6, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_L = new TileBluePrint(tileTypes, 730, "WATER_SAND_B_L",  new SpriteAtlas(Sheets.TILES_SHEET, 0, 7, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_M = new TileBluePrint(tileTypes, 731, "WATER_SAND_B_M",  new SpriteAtlas(Sheets.TILES_SHEET, 1, 7, false, 0, 0, false), 0.9f, false);
	public static final TileBluePrint WATER_SAND_B_R = new TileBluePrint(tileTypes, 732, "WATER_SAND_B_R",  new SpriteAtlas(Sheets.TILES_SHEET, 2, 7, false, 0, 0, false), 0.9f, false);
	
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
