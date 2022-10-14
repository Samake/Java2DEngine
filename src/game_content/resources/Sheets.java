package game_content.resources;

import engine.sprites.SpriteSheet;

public class Sheets {
	
	public static final SpriteSheet[] list = new SpriteSheet[999];
	
	public final static SpriteSheet FONT_SHEET = new SpriteSheet(list, 0, "/textures/fonts.png", 32);
	public final static SpriteSheet EDITOR_SHEET = new SpriteSheet(list, 1, "/textures/editorSheet.png", 32);
	public final static SpriteSheet TILES_SHEET = new SpriteSheet(list, 2, "/textures/tilesSheet.png", 32);
	public final static SpriteSheet OBJECTS_SHEET = new SpriteSheet(list, 3, "/textures/objectsSheet.png", 32);
	public final static SpriteSheet PLANTS_SHEET = new SpriteSheet(list, 4, "/textures/plantsSheet.png", 32);
	public final static SpriteSheet EFFECTS_SHEET = new SpriteSheet(list, 5, "/textures/effectsSheet.png", 32);
	public final static SpriteSheet FARMING_SHEET = new SpriteSheet(list, 6, "/textures/farmingSheet.png", 32);
	public final static SpriteSheet BUILDINGS_SHEET = new SpriteSheet(list, 7, "/textures/buildingsSheet.png", 32);
	
	public final static SpriteSheet WOMEN_01_SHEET = new SpriteSheet(list, 100, "/textures/women01.png", 32);
	public final static SpriteSheet WOMEN_02_SHEET = new SpriteSheet(list, 101, "/textures/women02.png", 32);
	public final static SpriteSheet WOMEN_03_SHEET = new SpriteSheet(list, 102, "/textures/women03.png", 32);
	public final static SpriteSheet WOMEN_04_SHEET = new SpriteSheet(list, 103, "/textures/women04.png", 32);
	
	public final static SpriteSheet ANIMALS_SHEET = new SpriteSheet(list, 200, "/textures/animals.png", 32);
	
	// Characters
	public final static SpriteSheet CHARACTER_SHEET = new SpriteSheet(list, 300, "/textures/characters/characters.png", 128);
	
	// Clothes
	public final static SpriteSheet CLOTHES_PULLOVER_SHEET = new SpriteSheet(list, 400, "/textures/characters/clothes/pullovers.png", 160);
	public final static SpriteSheet CLOTHES_PANT_SHEET = new SpriteSheet(list, 401, "/textures/characters/clothes/pants.png", 160);
	public final static SpriteSheet CLOTHES_SHOES_SHEET = new SpriteSheet(list, 402, "/textures/characters/clothes/shoes.png", 160);
	
	// Hairs
	public final static SpriteSheet HAIR_BOB_SHEET = new SpriteSheet(list, 500, "/textures/characters/hairs/bob.png", 224);
	
	public static SpriteSheet getSpriteSheetByID(int id) {
		return list[id];
	}
	
	public static int getSpriteSheetsCount() {
		int count = 0;
		
		for (SpriteSheet sheet : list) {
			if (sheet != null) {
				count++;
			}
		}
		
		return count;
	}
}
