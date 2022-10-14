package game_content.resources;

import engine.entities.npc.clothes.ClothesNPC;
import engine.entities.npc.clothes.ClothesNPC.CLOTHTYPE;
import engine.sprites.SpriteAtlas;

public class Clothes {

	public static final ClothesNPC[] list = new ClothesNPC[2048];

	// Body
	public static final ClothesNPC PULLOVER_BLACK = new ClothesNPC(list, 100, "PULLOVER_BLACK", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_BLUE = new ClothesNPC(list, 101, "PULLOVER_BLUE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_LIGHT_BLUE = new ClothesNPC(list, 102, "PULLOVER_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_BROWN = new ClothesNPC(list, 103, "PULLOVER_BROWN", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_TURKIS = new ClothesNPC(list, 104, "PULLOVER_TURKIS", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_GREEN = new ClothesNPC(list, 105, "PULLOVER_GREEN", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_PINK = new ClothesNPC(list, 106, "PULLOVER_PINK", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_LILA = new ClothesNPC(list, 107, "PULLOVER_LILA", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_RED = new ClothesNPC(list, 108, "PULLOVER_RED", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_WHITE = new ClothesNPC(list, 109, "PULLOVER_WHITE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.BODY);

	// Legs
	public static final ClothesNPC PANT_BLACK = new ClothesNPC(list, 200, "PANT_BLACK", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_BLUE = new ClothesNPC(list, 201, "PANT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_LIGHT_BLUE = new ClothesNPC(list, 202, "PANT_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_BROWN = new ClothesNPC(list, 203, "PANT_BROWN", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_TURKIS = new ClothesNPC(list, 204, "PANT_TURKIS", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_GREEN = new ClothesNPC(list, 205, "PANT_GREEN", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_PINK = new ClothesNPC(list, 206, "PANT_PINK", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_LILA = new ClothesNPC(list, 207, "PANT_LILA", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_RED = new ClothesNPC(list, 208, "PANT_RED", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_GREY = new ClothesNPC(list, 209, "PANT_GREY", new SpriteAtlas(Sheets.CLOTHES_PANT_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.LEGS);

	// Feet
	public static final ClothesNPC SHOES_BLACK = new ClothesNPC(list, 300, "SHOES_BLACK", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_BLUE = new ClothesNPC(list, 301, "SHOES_BLUE", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_LIGHT_BLUE = new ClothesNPC(list, 302, "SHOES_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_BROWN = new ClothesNPC(list, 303, "SHOES_BROWN", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_TURKIS = new ClothesNPC(list, 304, "SHOES_TURKIS", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_GREEN = new ClothesNPC(list, 305, "SHOES_GREEN", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_PINK = new ClothesNPC(list, 306, "SHOES_PINK", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_LILA = new ClothesNPC(list, 307, "SHOES_LILA", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_RED = new ClothesNPC(list, 308, "SHOES_RED", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_GREY = new ClothesNPC(list, 309, "SHOES_GREY", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	
	// Hair
	public static final ClothesNPC HAIR_BOB_BRUNETTE = new ClothesNPC(list, 400, "HAIR_BOB_BRUNETTE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BLOND = new ClothesNPC(list, 401, "HAIR_BOB_BLOND", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BROWN = new ClothesNPC(list, 402, "HAIR_BOB_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_BROWN = new ClothesNPC(list, 403, "HAIR_BOB_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHTER_BROWN = new ClothesNPC(list, 404, "HAIR_BOB_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_GREEN = new ClothesNPC(list, 405, "HAIR_BOB_GREEN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_GREEN = new ClothesNPC(list, 406, "HAIR_BOB_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_WHITE = new ClothesNPC(list, 407, "HAIR_BOB_WHITE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_LILA = new ClothesNPC(list, 408, "HAIR_BOB_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BLUE = new ClothesNPC(list, 409, "HAIR_BOB_BLUE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_PINK = new ClothesNPC(list, 410, "HAIR_BOB_PINK", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LILA = new ClothesNPC(list, 411, "HAIR_BOB_LILA", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_RED = new ClothesNPC(list, 412, "HAIR_BOB_RED", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_BLUE = new ClothesNPC(list, 413, "HAIR_BOB_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static ClothesNPC getClothesByName(String name) {
		for (ClothesNPC clothes : list) {
			if (clothes != null) {
				if (clothes.name.equals(name)) {
					return clothes;
				}
			}
		}
		
		return null;
	}
	
	public static ClothesNPC getClothesByID(int id) {
		return list[id];
	}
	
	public static int getListCount() {
		int count = 0;
		
		for (ClothesNPC clothes : list) {
			if (clothes != null) {
				count++;
			}
		}
		
		return count;
	}
}
