package game_content.resources;

import engine.sprites.SpriteSheet;

public class Sheets {
	
	public static final SpriteSheet[] list = new SpriteSheet[999];
	
	public final static SpriteSheet FONT_SHEET = new SpriteSheet(list, 0, "/textures/fonts.png", 32, 0);
	public final static SpriteSheet EDITOR_SHEET = new SpriteSheet(list, 1, "/textures/editorSheet.png", 32, 0);
	public final static SpriteSheet TILES_SHEET = new SpriteSheet(list, 2, "/textures/tilesSheet.png", 32, 0);
	public final static SpriteSheet OBJECTS_SHEET = new SpriteSheet(list, 3, "/textures/objectsSheet.png", 32, 0);
	public final static SpriteSheet PLANTS_SHEET = new SpriteSheet(list, 4, "/textures/plantsSheet.png", 32, 0);
	public final static SpriteSheet EFFECTS_SHEET = new SpriteSheet(list, 5, "/textures/effectsSheet.png", 32, 0);
	public final static SpriteSheet FARMING_SHEET = new SpriteSheet(list, 6, "/textures/farmingSheet.png", 32, 0);
	public final static SpriteSheet BUILDINGS_SHEET = new SpriteSheet(list, 7, "/textures/buildingsSheet.png", 32, 0);
	
	public final static SpriteSheet WOMEN_01_SHEET = new SpriteSheet(list, 100, "/textures/women01.png", 32, 0);
	public final static SpriteSheet WOMEN_02_SHEET = new SpriteSheet(list, 101, "/textures/women02.png", 32, 0);
	public final static SpriteSheet WOMEN_03_SHEET = new SpriteSheet(list, 102, "/textures/women03.png", 32, 0);
	public final static SpriteSheet WOMEN_04_SHEET = new SpriteSheet(list, 103, "/textures/women04.png", 32, 0);
	
	public final static SpriteSheet ANIMALS_SHEET = new SpriteSheet(list, 200, "/textures/animals.png", 32, 0);
	
	static int offset = 6;
	// Characters
	public final static SpriteSheet CHARACTER_SHEET = new SpriteSheet(list, 300, "/textures/characters/characters.png", 128, offset);
	
	// Clothes
	public final static SpriteSheet CLOTHES_PULLOVER_SHEET = new SpriteSheet(list, 400, "/textures/characters/clothes/pullovers.png", 160, offset);
	public final static SpriteSheet CLOTHES_PANTS_SHEET = new SpriteSheet(list, 401, "/textures/characters/clothes/pants.png", 160, offset);
	public final static SpriteSheet CLOTHES_SHOES_SHEET = new SpriteSheet(list, 402, "/textures/characters/clothes/shoes.png", 160, offset);
	public final static SpriteSheet CLOTHES_CLOWN_SHEET = new SpriteSheet(list, 403, "/textures/characters/clothes/clown.png", 32, offset);
	public final static SpriteSheet CLOTHES_DRESS_SHEET = new SpriteSheet(list, 404, "/textures/characters/clothes/dress.png", 160, offset);
	public final static SpriteSheet CLOTHES_FLORAL_SHEET = new SpriteSheet(list, 405, "/textures/characters/clothes/floral.png", 160, offset);
	public final static SpriteSheet CLOTHES_OVERALLS_SHEET = new SpriteSheet(list, 406, "/textures/characters/clothes/overalls.png", 160, offset);
	public final static SpriteSheet CLOTHES_PANTS_SUIT_SHEET = new SpriteSheet(list, 407, "/textures/characters/clothes/pants_suit.png", 160, offset);
	public final static SpriteSheet CLOTHES_PUMPKIN_SHEET = new SpriteSheet(list, 408, "/textures/characters/clothes/pumpkin.png", 32, offset);;
	public final static SpriteSheet CLOTHES_SAILOR_SHEET = new SpriteSheet(list, 409, "/textures/characters/clothes/sailor.png", 160, offset);
	public final static SpriteSheet CLOTHES_SKIRT_SHEET = new SpriteSheet(list, 410, "/textures/characters/clothes/skirt.png", 160, offset);
	public final static SpriteSheet CLOTHES_SKULL_SHEET = new SpriteSheet(list, 411, "/textures/characters/clothes/skull.png", 160, offset);
	public final static SpriteSheet CLOTHES_SPAGHETTI_SHEET = new SpriteSheet(list, 412, "/textures/characters/clothes/spaghetti.png", 160, offset);
	public final static SpriteSheet CLOTHES_SPOOKY_SHEET = new SpriteSheet(list, 413, "/textures/characters/clothes/spooky.png", 16, offset);
	public final static SpriteSheet CLOTHES_SPORTY_SHEET = new SpriteSheet(list, 414, "/textures/characters/clothes/sporty.png", 160, offset);
	public final static SpriteSheet CLOTHES_STRIPE_SHEET = new SpriteSheet(list, 415, "/textures/characters/clothes/stripe.png", 160, offset);
	public final static SpriteSheet CLOTHES_SUIT_SHEET = new SpriteSheet(list, 416, "/textures/characters/clothes/suit.png", 160, offset);
	public final static SpriteSheet CLOTHES_WITCH_SHEET = new SpriteSheet(list, 417, "/textures/characters/clothes/witch.png", 16, offset);

	// Hairs
	public final static SpriteSheet HAIR_BOB_SHEET = new SpriteSheet(list, 500, "/textures/characters/hairs/bob.png", 224, offset);
	public final static SpriteSheet HAIR_BRAID_SHEET = new SpriteSheet(list, 501, "/textures/characters/hairs/braids.png", 224, offset);
	public final static SpriteSheet HAIR_BUZZCUT_SHEET = new SpriteSheet(list, 502, "/textures/characters/hairs/buzzcut.png", 224, offset);
	public final static SpriteSheet HAIR_CURLY_SHEET = new SpriteSheet(list, 503, "/textures/characters/hairs/curly.png", 224, offset);
	public final static SpriteSheet HAIR_EMO_SHEET = new SpriteSheet(list, 504, "/textures/characters/hairs/emo.png", 224, offset);
	public final static SpriteSheet HAIR_EXTRA_LONG_SHEET = new SpriteSheet(list, 505, "/textures/characters/hairs/extra_long.png", 224, offset);
	public final static SpriteSheet HAIR_FRENCH_CURL_SHEET = new SpriteSheet(list, 506, "/textures/characters/hairs/french_curl.png", 224, offset);
	public final static SpriteSheet HAIR_GENTLEMAN_SHEET = new SpriteSheet(list, 507, "/textures/characters/hairs/gentleman.png", 224, offset);
	public final static SpriteSheet HAIR_PONYTAIL_SHEET = new SpriteSheet(list, 508, "/textures/characters/hairs/ponytail.png", 224, offset);
	public final static SpriteSheet HAIR_SPACEBUNS_SHEET = new SpriteSheet(list, 509, "/textures/characters/hairs/spacebuns.png", 224, offset);
	public final static SpriteSheet HAIR_STRAIGHT_SHEET = new SpriteSheet(list, 510, "/textures/characters/hairs/straight.png", 224, offset);
	public final static SpriteSheet HAIR_WAVY_SHEET = new SpriteSheet(list, 511, "/textures/characters/hairs/wavy.png", 224, offset);
	
	// Beards
	public final static SpriteSheet BEARD_SHEET = new SpriteSheet(list, 525, "/textures/characters/face/beard.png", 224, offset);

	// Ear
	public final static SpriteSheet EAR_EMERALD_SHEET = new SpriteSheet(list, 530, "/textures/characters/ear/earring_emerald.png", 16, offset);
	public final static SpriteSheet EAR_EMERALD_SILVER_SHEET = new SpriteSheet(list, 531, "/textures/characters/ear/earring_emerald_silver.png", 16, offset);
	public final static SpriteSheet EAR_RED_SHEET = new SpriteSheet(list, 532, "/textures/characters/ear/earring_red.png", 16, offset);
	public final static SpriteSheet EAR_RED_SILVER_SHEET = new SpriteSheet(list, 533, "/textures/characters/ear/earring_red_silver.png", 16, offset);
	
	// Eyes
	public final static SpriteSheet EYES_SHEET = new SpriteSheet(list, 550, "/textures/characters/face/eyes.png", 224, offset);
	
	// Mouth
	public final static SpriteSheet MOUTH_SHEET = new SpriteSheet(list, 600, "/textures/characters/face/mouth.png", 80, offset);
		
	// HAT
	public final static SpriteSheet HAT_COWBOY_SHEET = new SpriteSheet(list, 700, "/textures/characters/hats/hat_cowboy.png", 16, offset);
	public final static SpriteSheet HAT_LUCKY_SHEET = new SpriteSheet(list, 701, "/textures/characters/hats/hat_lucky.png", 16, offset);
	public final static SpriteSheet HAT_PUMPKIN_SHEET = new SpriteSheet(list, 702, "/textures/characters/hats/hat_pumpkin.png", 16, offset);
	public final static SpriteSheet HAT_PUMPKIN_PURPLE_SHEET = new SpriteSheet(list, 703, "/textures/characters/hats/hat_pumpkin_purple.png", 16, offset);
	public final static SpriteSheet HAT_WITCH_SHEET = new SpriteSheet(list, 704, "/textures/characters/hats/hat_witch.png", 16, offset);
	
	// Accessoires
	public final static SpriteSheet GLASSES_SHEET = new SpriteSheet(list, 800, "/textures/characters/accessoires/glasses.png", 160, offset);
	public final static SpriteSheet SUN_GLASSES_SHEET = new SpriteSheet(list, 801, "/textures/characters/accessoires/glasses_sun.png", 160, offset);
	public final static SpriteSheet MASK_CLOWN_BLUE_SHEET = new SpriteSheet(list, 802, "/textures/characters/accessoires/mask_clown_blue.png", 16, offset);
	public final static SpriteSheet MASK_CLOWN_RED_SHEET = new SpriteSheet(list, 803, "/textures/characters/accessoires/mask_clown_red.png", 16, offset);
	public final static SpriteSheet MASK_SPOOKY_SHEET = new SpriteSheet(list, 804, "/textures/characters/accessoires/mask_spooky.png", 16, offset);
	
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
