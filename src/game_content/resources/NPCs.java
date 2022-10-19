package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.npc.AnimalBunny;
import game_content.entities.npc.AnimalChicken;
import game_content.entities.npc.NPCOccupant;
import game_content.entities.player.Player;

public class NPCs {

	public static final EntityConfig[] list = new EntityConfig[2048];
	
	public static final EntityConfig HUMAN_WOMAN_01 = new EntityConfig(list, 0, ENTITYTYPE.NPC, "HUMAN_WOMAN_01", true, new EntityRenderData(new SpriteAtlas(Sheets.WOMEN_01_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_WOMAN_02 = new EntityConfig(list, 1, ENTITYTYPE.NPC, "HUMAN_WOMAN_02", true, new EntityRenderData(new SpriteAtlas(Sheets.WOMEN_02_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_WOMAN_03 = new EntityConfig(list, 2, ENTITYTYPE.NPC, "HUMAN_WOMAN_03", true, new EntityRenderData(new SpriteAtlas(Sheets.WOMEN_03_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_WOMAN_04 = new EntityConfig(list, 3, ENTITYTYPE.NPC, "HUMAN_WOMAN_04", true, new EntityRenderData(new SpriteAtlas(Sheets.WOMEN_04_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	
	public static final EntityConfig ANIMAL_CHICKEN = new EntityConfig(list, 100, ENTITYTYPE.NPC, "ANIMAL_CHICKEN", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_BUNNY_BROWN = new EntityConfig(list, 101, ENTITYTYPE.NPC, "ANIMAL_BUNNY_BROWN", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_BUNNY_BROWN_BABY = new EntityConfig(list, 102, ENTITYTYPE.NPC, "ANIMAL_BUNNY_BROWN_BABY", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_BUNNY_GREY = new EntityConfig(list, 103, ENTITYTYPE.NPC, "ANIMAL_BUNNY_GREY", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_BUNNY_GREY_BABY = new EntityConfig(list, 104, ENTITYTYPE.NPC, "ANIMAL_BUNNY_GREY_BABY", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_CHICKEN_BABY_WHITE = new EntityConfig(list, 105, ENTITYTYPE.NPC, "ANIMAL_CHICKEN_BABY_WHITE", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 5, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_CHICKEN_BABY_YELLOW = new EntityConfig(list, 106, ENTITYTYPE.NPC, "ANIMAL_CHICKEN_BABY_YELLOW", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 6, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ANIMAL_CHICKEN_BABY_BROWN = new EntityConfig(list, 107, ENTITYTYPE.NPC, "ANIMAL_CHICKEN_BABY_BROWN", true, new EntityRenderData(new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 7, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	
	public static final EntityConfig HUMAN_CHAR_1 = new EntityConfig(list, 200, ENTITYTYPE.NPC, "HUMAN_CHAR_1", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_2 = new EntityConfig(list, 201, ENTITYTYPE.NPC, "HUMAN_CHAR_2", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 8, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_3 = new EntityConfig(list, 202, ENTITYTYPE.NPC, "HUMAN_CHAR_3", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 16, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_4 = new EntityConfig(list, 203, ENTITYTYPE.NPC, "HUMAN_CHAR_4", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 32, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_5 = new EntityConfig(list, 204, ENTITYTYPE.NPC, "HUMAN_CHAR_5", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 48, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_6 = new EntityConfig(list, 205, ENTITYTYPE.NPC, "HUMAN_CHAR_6", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 64, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_7 = new EntityConfig(list, 206, ENTITYTYPE.NPC, "HUMAN_CHAR_7", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 80, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig HUMAN_CHAR_8 = new EntityConfig(list, 207, ENTITYTYPE.NPC, "HUMAN_CHAR_8", true, new EntityRenderData(new SpriteAtlas(Sheets.CHARACTER_SHEET, 96, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	
	public static Entity addInstanceToLevel(EntityConfig config, Level level, int x, int y) {
		if (config != null) {
			switch(config.name) {
				case "HUMAN_WOMAN_01":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_WOMAN_02":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_WOMAN_03":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_WOMAN_04":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN":
					return level.addEntity(new AnimalChicken(config, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_BROWN":
					return level.addEntity(new AnimalBunny(config, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_BROWN_BABY":
					return level.addEntity(new AnimalBunny(config, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_GREY":
					return level.addEntity(new AnimalBunny(config, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_GREY_BABY":
					return level.addEntity(new AnimalBunny(config, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_WHITE":
					return level.addEntity(new AnimalChicken(config, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_YELLOW":
					return level.addEntity(new AnimalChicken(config, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_BROWN":
					return level.addEntity(new AnimalChicken(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_1":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_2":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_3":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_4":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_5":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_6":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_7":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
				case "HUMAN_CHAR_8":
					return level.addEntity(new NPCOccupant(config, level, x, y, 1.0f));
			}
		}
		
		return null;
	}
	
	public static Player addPlayerInstanceToLevel(EntityConfig config, Level level, int x, int y) {
		if (config != null) {
			config.entityType = ENTITYTYPE.PLAYER;

			return level.setPlayer(new Player(config, level, x, y, 1.0f));

		}
		
		return null;
	}

	public static EntityConfig getBluePrintByID(int id) {
		return list[id];
	}
	
	
	public static EntityConfig getBluePrintByName(String name) {
		for (EntityConfig config : list) {
			if (config != null) {
				if (config.name.equals(name)) {
					return config;
				}
			}
		}
		
		return null;
	}
	
	public static int getListCount() {
		int count = 0;
		
		for (EntityConfig npc : list) {
			if (npc != null) {
				count++;
			}
		}
		
		return count;
	}
}
