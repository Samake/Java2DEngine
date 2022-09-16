package game_content.resources;

import engine.sprites.SpriteSheet;

public class Sheets {
	
	public static final SpriteSheet[] sheetTypes = new SpriteSheet[256];
	
	public static SpriteSheet getSpriteSheetByID(int id) {
		return sheetTypes[id];
	}
	
	public final static SpriteSheet FONT_SHEET = new SpriteSheet(sheetTypes, 0, "/textures/fonts.png", 32);
	public final static SpriteSheet EDITOR_SHEET = new SpriteSheet(sheetTypes, 1, "/textures/editorSheet.png", 32);
	public final static SpriteSheet TILES_SHEET = new SpriteSheet(sheetTypes, 2, "/textures/tilesSheet.png", 32);
	public final static SpriteSheet OBJECTS_SHEET = new SpriteSheet(sheetTypes, 3, "/textures/objectsSheet.png", 32);
	public final static SpriteSheet PLANTS_SHEET = new SpriteSheet(sheetTypes, 4, "/textures/plantsSheet.png", 32);
	public final static SpriteSheet EFFECTS_SHEET = new SpriteSheet(sheetTypes, 5, "/textures/effectsSheet.png", 32);
	
	public final static SpriteSheet WOMEN_01_SHEET = new SpriteSheet(sheetTypes, 100, "/textures/women01.png", 32);
	public final static SpriteSheet WOMEN_02_SHEET = new SpriteSheet(sheetTypes, 101, "/textures/women02.png", 32);
	public final static SpriteSheet WOMEN_03_SHEET = new SpriteSheet(sheetTypes, 102, "/textures/women03.png", 32);
	public final static SpriteSheet WOMEN_04_SHEET = new SpriteSheet(sheetTypes, 103, "/textures/women04.png", 32);
	
	public final static SpriteSheet CHICKEN_01_SHEET = new SpriteSheet(sheetTypes, 200, "/textures/chicken01.png", 32);
}
