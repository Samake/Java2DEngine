package game_content.resources;

import java.util.ArrayList;

import engine.entities.npc.clothes.ClothesNPC;
import engine.entities.npc.clothes.ClothesNPC.CLOTHTYPE;
import engine.sprites.SpriteAtlas;

public class Clothes {
	
	private static int bodyIndex = 0;
	private static int legsIndex = 250;
	private static int feetsIndex = 500;
	private static int hairsIndex = 750;
	private static int eyesIndex = 1000;
	private static int mouthIndex = 1250;
	private static int hatIndex = 1500;
	
	public static final ClothesNPC[] list = new ClothesNPC[2048];

	// Body
	public static final ClothesNPC PULLOVER_BLACK = new ClothesNPC(list, bodyIndex++, "PULLOVER_BLACK", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_BLUE = new ClothesNPC(list, bodyIndex++, "PULLOVER_BLUE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_LIGHT_BLUE = new ClothesNPC(list, bodyIndex++, "PULLOVER_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_BROWN = new ClothesNPC(list, bodyIndex++, "PULLOVER_BROWN", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_TURKIS = new ClothesNPC(list, bodyIndex++, "PULLOVER_TURKIS", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_GREEN = new ClothesNPC(list, bodyIndex++, "PULLOVER_GREEN", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_PINK = new ClothesNPC(list, bodyIndex++, "PULLOVER_PINK", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_LILA = new ClothesNPC(list, bodyIndex++, "PULLOVER_LILA", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_RED = new ClothesNPC(list, bodyIndex++, "PULLOVER_RED", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PULLOVER_WHITE = new ClothesNPC(list, bodyIndex++, "PULLOVER_WHITE", new SpriteAtlas(Sheets.CLOTHES_PULLOVER_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC CLOWN_01 = new ClothesNPC(list, bodyIndex++, "CLOWN_01", new SpriteAtlas(Sheets.CLOTHES_CLOWN_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC CLOWN_02 = new ClothesNPC(list, bodyIndex++, "CLOWN_02", new SpriteAtlas(Sheets.CLOTHES_CLOWN_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_BLACK = new ClothesNPC(list, bodyIndex++, "DRESS_BLACK", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_BLUE = new ClothesNPC(list, bodyIndex++, "DRESS_BLUE", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_LIGHT_BLUE = new ClothesNPC(list, bodyIndex++, "DRESS_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_BROWN = new ClothesNPC(list, bodyIndex++, "DRESS_BROWN", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_TURKIS = new ClothesNPC(list, bodyIndex++, "DRESS_TURKIS", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_GREEN = new ClothesNPC(list, bodyIndex++, "DRESS_GREEN", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_PINK = new ClothesNPC(list, bodyIndex++, "DRESS_PINK", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_LILA = new ClothesNPC(list, bodyIndex++, "DRESS_LILA", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_RED = new ClothesNPC(list, bodyIndex++, "DRESS_RED", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC DRESS_WHITE = new ClothesNPC(list, bodyIndex++, "DRESS_WHITE", new SpriteAtlas(Sheets.CLOTHES_DRESS_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_BLACK = new ClothesNPC(list, bodyIndex++, "FLORAL_BLACK", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_BLUE = new ClothesNPC(list, bodyIndex++, "FLORAL_BLUE", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_LIGHT_BLUE = new ClothesNPC(list, bodyIndex++, "FLORAL_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_BROWN = new ClothesNPC(list, bodyIndex++, "FLORAL_BROWN", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_TURKIS = new ClothesNPC(list, bodyIndex++, "FLORAL_TURKIS", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_GREEN = new ClothesNPC(list, bodyIndex++, "FLORAL_GREEN", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_PINK = new ClothesNPC(list, bodyIndex++, "FLORAL_PINK", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_LILA = new ClothesNPC(list, bodyIndex++, "FLORAL_LILA", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_RED = new ClothesNPC(list, bodyIndex++, "FLORAL_RED", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC FLORAL_WHITE = new ClothesNPC(list, bodyIndex++, "FLORAL_WHITE", new SpriteAtlas(Sheets.CLOTHES_FLORAL_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_BLACK = new ClothesNPC(list, bodyIndex++, "OVERALLS_BLACK", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_BLUE = new ClothesNPC(list, bodyIndex++, "OVERALLS_BLUE", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_LIGHT_BLUE = new ClothesNPC(list, bodyIndex++, "OVERALLS_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_BROWN = new ClothesNPC(list, bodyIndex++, "OVERALLS_BROWN", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_TURKIS = new ClothesNPC(list, bodyIndex++, "OVERALLS_TURKIS", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_GREEN = new ClothesNPC(list, bodyIndex++, "OVERALLS_GREEN", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_PINK = new ClothesNPC(list, bodyIndex++, "OVERALLS_PINK", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_LILA = new ClothesNPC(list, bodyIndex++, "OVERALLS_LILA", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_RED = new ClothesNPC(list, bodyIndex++, "OVERALLS_RED", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC OVERALLS_GREY = new ClothesNPC(list, bodyIndex++, "OVERALLS_GREY", new SpriteAtlas(Sheets.CLOTHES_OVERALLS_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PUMPKIN_01 = new ClothesNPC(list, bodyIndex++, "PUMPKIN_01", new SpriteAtlas(Sheets.CLOTHES_PUMPKIN_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.BODY);
	public static final ClothesNPC PUMPKIN_02 = new ClothesNPC(list, bodyIndex++, "PUMPKIN_02", new SpriteAtlas(Sheets.CLOTHES_PUMPKIN_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.BODY);

	// Legs
	public static final ClothesNPC PANT_BLACK = new ClothesNPC(list, legsIndex++, "PANT_BLACK", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_BLUE = new ClothesNPC(list, legsIndex++, "PANT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_LIGHT_BLUE = new ClothesNPC(list, legsIndex++, "PANT_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_BROWN = new ClothesNPC(list, legsIndex++, "PANT_BROWN", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_TURKIS = new ClothesNPC(list, legsIndex++, "PANT_TURKIS", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_GREEN = new ClothesNPC(list, legsIndex++, "PANT_GREEN", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_PINK = new ClothesNPC(list, legsIndex++, "PANT_PINK", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_LILA = new ClothesNPC(list, legsIndex++, "PANT_LILA", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_RED = new ClothesNPC(list, legsIndex++, "PANT_RED", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_GREY = new ClothesNPC(list, legsIndex++, "PANT_GREY", new SpriteAtlas(Sheets.CLOTHES_PANTS_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_BLACK = new ClothesNPC(list, legsIndex++, "PANT_SUIT_BLACK", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_BLUE = new ClothesNPC(list, legsIndex++, "PANT_SUIT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_LIGHT_BLUE = new ClothesNPC(list, legsIndex++, "PANT_SUIT_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_BROWN = new ClothesNPC(list, legsIndex++, "PANT_SUIT_BROWN", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_TURKIS = new ClothesNPC(list, legsIndex++, "PANT_SUIT_TURKIS", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_GREEN = new ClothesNPC(list, legsIndex++, "PANT_SUIT_GREEN", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_PINK = new ClothesNPC(list, legsIndex++, "PANT_SUIT_PINK", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_LILA = new ClothesNPC(list, legsIndex++, "PANT_SUIT_LILA", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_RED = new ClothesNPC(list, legsIndex++, "PANT_SUIT_RED", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.LEGS);
	public static final ClothesNPC PANT_SUIT_WHITE = new ClothesNPC(list, legsIndex++, "PANT_SUIT_WHITE", new SpriteAtlas(Sheets.CLOTHES_PANTS_SUIT_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.LEGS);

	// Feet
	public static final ClothesNPC SHOES_BLACK = new ClothesNPC(list, feetsIndex++, "SHOES_BLACK", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_BLUE = new ClothesNPC(list, feetsIndex++, "SHOES_BLUE", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_LIGHT_BLUE = new ClothesNPC(list, feetsIndex++, "SHOES_LIGHT_BLUE", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_BROWN = new ClothesNPC(list, feetsIndex++, "SHOES_BROWN", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_TURKIS = new ClothesNPC(list, feetsIndex++, "SHOES_TURKIS", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_GREEN = new ClothesNPC(list, feetsIndex++, "SHOES_GREEN", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_PINK = new ClothesNPC(list, feetsIndex++, "SHOES_PINK", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_LILA = new ClothesNPC(list, feetsIndex++, "SHOES_LILA", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_RED = new ClothesNPC(list, feetsIndex++, "SHOES_RED", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	public static final ClothesNPC SHOES_GREY = new ClothesNPC(list, feetsIndex++, "SHOES_GREY", new SpriteAtlas(Sheets.CLOTHES_SHOES_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.FEET);
	
	// Hair
	public static final ClothesNPC HAIR_BOB_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_BRUNETTE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_BLOND", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_GREEN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_WHITE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_BLUE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_PINK", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LILA", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_RED = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_RED", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BOB_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BOB_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_BOB_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_BRAID_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_BRUNETTE", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_BLOND", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_BROWN", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_GREEN", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_WHITE", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_BLUE", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_PINK", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LILA", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_RED = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_RED", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BRAID_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BRAID_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_BRAID_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_BUZZCUT_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_BRUNETTE", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_BLOND", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_BROWN", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_GREEN", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_WHITE", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_BLUE", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_PINK", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LILA", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_RED = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_RED", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_BUZZCUT_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_BUZZCUT_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_BUZZCUT_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_CURLY_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_BRUNETTE", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_BLOND", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_BROWN", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_GREEN", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_WHITE", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_BLUE", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_PINK", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LILA", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_RED = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_RED", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_CURLY_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_CURLY_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_CURLY_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);

	public static final ClothesNPC HAIR_EMO_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_BRUNETTE", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_BLOND", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_BROWN", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_GREEN", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LIGHT_GREEN  = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_WHITE  = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_WHITE", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LIGHT_LILA  = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_BLUE  = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_BLUE", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_PINK  = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_PINK", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LILA", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_RED = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_RED", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EMO_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_EMO_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_EMO_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_EXTRA_LONG_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_BRUNETTE", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_BLOND", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_BROWN", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_GREEN", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_WHITE", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_BLUE", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_PINK", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LILA", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_RED = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_RED", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_EXTRA_LONG_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_EXTRA_LONG_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_EXTRA_LONG_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_FRENCH_CURL_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_BRUNETTE", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_BLOND", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_BROWN", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_GREEN", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_WHITE", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_BLUE", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_PINK", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LILA", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_RED = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_RED", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_FRENCH_CURL_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_FRENCH_CURL_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_FRENCH_CURL_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_GENTLEMAN_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_BRUNETTE", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_BLOND", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_BROWN", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_GREEN", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_WHITE", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_BLUE", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_PINK", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LILA", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_RED = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_RED", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_GENTLEMAN_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_GENTLEMAN_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_GENTLEMAN_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_PONYTAIL_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_BRUNETTE", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_BLOND", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_BROWN", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_GREEN", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_WHITE", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_BLUE", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_PINK", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LILA", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_RED = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_RED", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_PONYTAIL_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_PONYTAIL_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_PONYTAIL_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_SPACEBUNS_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_BRUNETTE", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_BLOND", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_BROWN", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_GREEN", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_WHITE", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_BLUE", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_PINK", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LILA", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_RED = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_RED", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_SPACEBUNS_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_SPACEBUNS_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_SPACEBUNS_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_STRAIGHT_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_BRUNETTE", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_BLOND", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_WHITE", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_PINK", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LILA", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_RED = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_RED", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_STRAIGHT_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_STRAIGHT_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_STRAIGHT_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	public static final ClothesNPC HAIR_WAVY_BRUNETTE = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_BRUNETTE", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_BLOND = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_BLOND", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_BROWN", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LIGHT_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LIGHT_BROWN", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LIGHTER_BROWN = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LIGHTER_BROWN", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_GREEN", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LIGHT_GREEN = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LIGHT_GREEN", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_WHITE = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_WHITE", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LIGHT_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LIGHT_LILA", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_BLUE", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_PINK = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_PINK", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LILA = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LILA", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_RED = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_RED", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	public static final ClothesNPC HAIR_WAVY_LIGHT_BLUE = new ClothesNPC(list, hairsIndex++, "HAIR_WAVY_LIGHT_BLUE", new SpriteAtlas(Sheets.HAIR_WAVY_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.HAIR);
	
	// Eyes
	public static final ClothesNPC EYES_01 = new ClothesNPC(list, eyesIndex++, "EYES_01", new SpriteAtlas(Sheets.EYES_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_02 = new ClothesNPC(list, eyesIndex++, "EYES_02", new SpriteAtlas(Sheets.EYES_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_03 = new ClothesNPC(list, eyesIndex++, "EYES_03", new SpriteAtlas(Sheets.EYES_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_04 = new ClothesNPC(list, eyesIndex++, "EYES_04", new SpriteAtlas(Sheets.EYES_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_05 = new ClothesNPC(list, eyesIndex++, "EYES_05", new SpriteAtlas(Sheets.EYES_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_06 = new ClothesNPC(list, eyesIndex++, "EYES_06", new SpriteAtlas(Sheets.EYES_SHEET, 80, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_07 = new ClothesNPC(list, eyesIndex++, "EYES_07", new SpriteAtlas(Sheets.EYES_SHEET, 96, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_08 = new ClothesNPC(list, eyesIndex++, "EYES_08", new SpriteAtlas(Sheets.EYES_SHEET, 112, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_09 = new ClothesNPC(list, eyesIndex++, "EYES_09", new SpriteAtlas(Sheets.EYES_SHEET, 128, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_10 = new ClothesNPC(list, eyesIndex++, "EYES_10", new SpriteAtlas(Sheets.EYES_SHEET, 144, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_11 = new ClothesNPC(list, eyesIndex++, "EYES_11", new SpriteAtlas(Sheets.EYES_SHEET, 160, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_12 = new ClothesNPC(list, eyesIndex++, "EYES_12", new SpriteAtlas(Sheets.EYES_SHEET, 176, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_13 = new ClothesNPC(list, eyesIndex++, "EYES_13", new SpriteAtlas(Sheets.EYES_SHEET, 192, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	public static final ClothesNPC EYES_14 = new ClothesNPC(list, eyesIndex++, "EYES_14", new SpriteAtlas(Sheets.EYES_SHEET, 208, 0, false, 0, 0, false), CLOTHTYPE.EYES);
	
	// MOUTH
	public static final ClothesNPC MOUTH_01 = new ClothesNPC(list, mouthIndex++, "MOUTH_01", new SpriteAtlas(Sheets.MOUTH_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.MOUTH);
	public static final ClothesNPC MOUTH_02 = new ClothesNPC(list, mouthIndex++, "MOUTH_02", new SpriteAtlas(Sheets.MOUTH_SHEET, 16, 0, false, 0, 0, false), CLOTHTYPE.MOUTH);
	public static final ClothesNPC MOUTH_03 = new ClothesNPC(list, mouthIndex++, "MOUTH_03", new SpriteAtlas(Sheets.MOUTH_SHEET, 32, 0, false, 0, 0, false), CLOTHTYPE.MOUTH);
	public static final ClothesNPC MOUTH_04 = new ClothesNPC(list, mouthIndex++, "MOUTH_04", new SpriteAtlas(Sheets.MOUTH_SHEET, 48, 0, false, 0, 0, false), CLOTHTYPE.MOUTH);
	public static final ClothesNPC MOUTH_05 = new ClothesNPC(list, mouthIndex++, "MOUTH_05", new SpriteAtlas(Sheets.MOUTH_SHEET, 64, 0, false, 0, 0, false), CLOTHTYPE.MOUTH);
		
	// HAT
	public static final ClothesNPC HAT_COWBOY = new ClothesNPC(list, hatIndex++, "HAT_COWBOY", new SpriteAtlas(Sheets.HAT_COWBOY_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAT);
	public static final ClothesNPC HAT_LUCKY = new ClothesNPC(list, hatIndex++, "HAT_LUCKY", new SpriteAtlas(Sheets.HAT_LUCKY_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAT);
	public static final ClothesNPC HAT_PUMPKIN = new ClothesNPC(list, hatIndex++, "HAT_PUMPKIN", new SpriteAtlas(Sheets.HAT_PUMPKIN_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAT);
	public static final ClothesNPC HAT_PUMPKIN_PURPLE = new ClothesNPC(list, hatIndex++, "HAT_PUMPKIN_PURPLE", new SpriteAtlas(Sheets.HAT_PUMPKIN_PURPLE_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAT);
	public static final ClothesNPC HAT_WITCH = new ClothesNPC(list, hatIndex++, "HAT_WITCH", new SpriteAtlas(Sheets.HAT_WITCH_SHEET, 0, 0, false, 0, 0, false), CLOTHTYPE.HAT);
	
		
	public static ClothesNPC getClothesByName(String name) {
		for (ClothesNPC cloth : list) {
			if (cloth != null) {
				if (cloth.name.equals(name)) {
					return cloth;
				}
			}
		}
		
		return null;
	}
	
	public static ArrayList<ClothesNPC> getClothesByType(CLOTHTYPE type) {
		ArrayList<ClothesNPC> clothList = new ArrayList<ClothesNPC>(); // Create an ArrayList object
		
		for (ClothesNPC cloth : list) {
			if (cloth != null) {
				if (cloth.type.equals(type)) {
					clothList.add(cloth);
				}
			}
		}
		
		return clothList;
	}
	
	public static ClothesNPC getClothesByID(int id) {
		return list[id];
	}
	
	public static int getListCount() {
		int count = 0;
		
		for (ClothesNPC cloth : list) {
			if (cloth != null) {
				count++;
			}
		}
		
		return count;
	}
}
