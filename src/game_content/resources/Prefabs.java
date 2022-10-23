package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.prefabs.Ball;
import game_content.entities.prefabs.Barn;
import game_content.entities.prefabs.CampFire;
import game_content.entities.prefabs.Fountain;
import game_content.entities.prefabs.GlowWorm;
import game_content.entities.prefabs.House;
import game_content.entities.prefabs.LampPost;
import game_content.entities.prefabs.ScareCrowPumpkin;
import game_content.entities.prefabs.Silo;
import game_content.entities.prefabs.SpawnEgg;
import game_content.entities.prefabs.farming.SeedAubergine;
import game_content.entities.prefabs.farming.SeedCarrot;
import game_content.entities.prefabs.farming.SeedCorn;
import game_content.entities.prefabs.farming.SeedMelon;
import game_content.entities.prefabs.farming.SeedPotato;
import game_content.entities.prefabs.farming.SeedPumpkin;
import game_content.entities.prefabs.farming.SeedRadish;
import game_content.entities.prefabs.farming.SeedSalad;
import game_content.entities.prefabs.farming.SeedStrawberry;
import game_content.entities.prefabs.farming.SeedTomato;

public class Prefabs {
	
	public static final EntityConfig[] list = new EntityConfig[2048];
	
	public static final EntityConfig CAMPFIRE = new EntityConfig(list, 0, ENTITYTYPE.PREFAB, "CAMPFIRE", true, new EntityRenderData(new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 1, true, 250, 3, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig BALL_01 = new EntityConfig(list, 1, ENTITYTYPE.PREFAB, "BALL_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	
	public static final EntityConfig SPAWNEGG_WOMAN_01 = new EntityConfig(list, 101, ENTITYTYPE.PREFAB, "SPAWNEGG_WOMAN_01", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_WOMAN_02 = new EntityConfig(list, 102, ENTITYTYPE.PREFAB, "SPAWNEGG_WOMAN_02", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_WOMAN_03 = new EntityConfig(list, 103, ENTITYTYPE.PREFAB, "SPAWNEGG_WOMAN_03", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_WOMAN_04 = new EntityConfig(list, 104, ENTITYTYPE.PREFAB, "SPAWNEGG_WOMAN_04", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));

	public static final EntityConfig SPAWNEGG_CHICKEN = new EntityConfig(list, 200, ENTITYTYPE.PREFAB, "SPAWNEGG_CHICKEN", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_BUNNY_BROWN = new EntityConfig(list, 201, ENTITYTYPE.PREFAB, "SPAWNEGG_BUNNY_BROWN", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_BUNNY_BROWN_BABY = new EntityConfig(list, 202, ENTITYTYPE.PREFAB, "SPAWNEGG_BUNNY_BROWN_BABY", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_BUNNY_GREY = new EntityConfig(list, 203, ENTITYTYPE.PREFAB, "SPAWNEGG_BUNNY_GREY", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_BUNNY_GREY_BABY = new EntityConfig(list, 204, ENTITYTYPE.PREFAB, "SPAWNEGG_BUNNY_GREY_BABY", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_CHICKEN_BABY_WHITE = new EntityConfig(list, 205, ENTITYTYPE.PREFAB, "SPAWNEGG_CHICKEN_BABY_WHITE", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_CHICKEN_BABY_YELLOW = new EntityConfig(list, 206, ENTITYTYPE.PREFAB, "SPAWNEGG_CHICKEN_BABY_YELLOW", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SPAWNEGG_CHICKEN_BABY_BROWN = new EntityConfig(list, 207, ENTITYTYPE.PREFAB, "SPAWNEGG_CHICKEN_BABY_BROWN", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	
	public static final EntityConfig LAMPPOST_01 = new EntityConfig(list, 300, ENTITYTYPE.PREFAB, "LAMPPOST_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 5, false, 0, 0, false), true, true, RENDERTYPE.R1X3));
	public static final EntityConfig LAMPPOST_02 = new EntityConfig(list, 301, ENTITYTYPE.PREFAB, "LAMPPOST_02", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_03 = new EntityConfig(list, 302, ENTITYTYPE.PREFAB, "LAMPPOST_03", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_04 = new EntityConfig(list, 303, ENTITYTYPE.PREFAB, "LAMPPOST_04", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_05 = new EntityConfig(list, 304, ENTITYTYPE.PREFAB, "LAMPPOST_05", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_06 = new EntityConfig(list, 305, ENTITYTYPE.PREFAB, "LAMPPOST_06", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 9, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_07 = new EntityConfig(list, 306, ENTITYTYPE.PREFAB, "LAMPPOST_07", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 11, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig LAMPPOST_08 = new EntityConfig(list, 307, ENTITYTYPE.PREFAB, "LAMPPOST_08", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 5, false, 0, 0, false), true, true, RENDERTYPE.R2X3));
	public static final EntityConfig SCARECROW_PUMKIN = new EntityConfig(list, 308, ENTITYTYPE.PREFAB, "SCARECROW_PUMKIN", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 20, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X2));
	public static final EntityConfig GLOWWORM = new EntityConfig(list, 309, ENTITYTYPE.PREFAB, "GLOWWORM", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 18, 0, false, 0, 0, false), false, true, RENDERTYPE.R1X1));
	
	public static final EntityConfig FOUNTAIN_01 = new EntityConfig(list, 350, ENTITYTYPE.PREFAB, "FOUNTAIN_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 6, false, 0, 0, false), true, true, RENDERTYPE.R3X3));
	
	public static final EntityConfig HOUSE_01 = new EntityConfig(list, 500, ENTITYTYPE.PREFAB, "HOUSE_01", true, new EntityRenderData(new SpriteAtlas(Sheets.BUILDINGS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R5X5));
	public static final EntityConfig BARN_01 = new EntityConfig(list, 510, ENTITYTYPE.PREFAB, "BARN_01", true, new EntityRenderData(new SpriteAtlas(Sheets.BUILDINGS_SHEET, 5, 0, false, 0, 0, false), true, true, RENDERTYPE.R5X5));
	public static final EntityConfig SILO_01 = new EntityConfig(list, 520, ENTITYTYPE.PREFAB, "SILO_01", true, new EntityRenderData(new SpriteAtlas(Sheets.BUILDINGS_SHEET, 0, 5, false, 0, 0, false), true, true, RENDERTYPE.R3X5));
	public static final EntityConfig SILO_02 = new EntityConfig(list, 521, ENTITYTYPE.PREFAB, "SILO_02", true, new EntityRenderData(new SpriteAtlas(Sheets.BUILDINGS_SHEET, 3, 5, false, 0, 0, false), true, true, RENDERTYPE.R3X5));
	
	public static final EntityConfig SEED_CARROT = new EntityConfig(list, 1000, ENTITYTYPE.PREFAB, "SEED_CARROT", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 0, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_TOMATO = new EntityConfig(list, 1001, ENTITYTYPE.PREFAB, "SEED_TOMATO", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 1, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_STRAWBERRY = new EntityConfig(list, 1002, ENTITYTYPE.PREFAB, "SEED_STRAWBERRY", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 2, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_PUMPKIN = new EntityConfig(list, 1003, ENTITYTYPE.PREFAB, "SEED_PUMPKIN", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 3, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_CORN = new EntityConfig(list, 1004, ENTITYTYPE.PREFAB, "SEED_CORN", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 4, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_POTATO = new EntityConfig(list, 1005, ENTITYTYPE.PREFAB, "SEED_POTATO", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 5, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_MELON = new EntityConfig(list, 1006, ENTITYTYPE.PREFAB, "SEED_MELON", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 6, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_RADISH = new EntityConfig(list, 1007, ENTITYTYPE.PREFAB, "SEED_RADISH", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 7, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_SALAD = new EntityConfig(list, 1008, ENTITYTYPE.PREFAB, "SEED_SALAD", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 8, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SEED_AUBERGINE = new EntityConfig(list, 1009, ENTITYTYPE.PREFAB, "SEED_AUBERGINE", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 1, 10, false, 0, 6, false), true, true, RENDERTYPE.R1X1));
	
	public static Entity addInstanceToLevel(EntityConfig config, Level level, int x, int y) {
		if (config != null) {
			switch(config.name) {
				case "CAMPFIRE" :
					return level.addEntity(new CampFire(config, level, x, y));
				case "BALL_01" :
					return level.addEntity(new Ball(config, level, x, y));
				case "SPAWNEGG_WOMAN_01" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.HUMAN_WOMAN_01));
				case "SPAWNEGG_WOMAN_02" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.HUMAN_WOMAN_02));
				case "SPAWNEGG_WOMAN_03" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.HUMAN_WOMAN_03));
				case "SPAWNEGG_WOMAN_04" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.HUMAN_WOMAN_04));
				case "SPAWNEGG_CHICKEN" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_CHICKEN));
				case "SPAWNEGG_BUNNY_BROWN" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_BUNNY_BROWN));
				case "SPAWNEGG_BUNNY_BROWN_BABY" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_BUNNY_BROWN_BABY));
				case "SPAWNEGG_BUNNY_GREY" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_BUNNY_GREY));
				case "SPAWNEGG_BUNNY_GREY_BABY" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_BUNNY_GREY_BABY));
				case "SPAWNEGG_CHICKEN_BABY_WHITE" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_WHITE));
				case "SPAWNEGG_CHICKEN_BABY_YELLOW" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_YELLOW));
				case "SPAWNEGG_CHICKEN_BABY_BROWN" :
					return level.addEntity(new SpawnEgg(config, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_BROWN));
				case "LAMPPOST_01" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_02" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_03" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_04" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_05" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_06" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_07" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "LAMPPOST_08" :
					return level.addEntity(new LampPost(config, level, x, y));
				case "FOUNTAIN_01" :
					return level.addEntity(new Fountain(config, level, x, y));
				case "SCARECROW_PUMKIN" :
					return level.addEntity(new ScareCrowPumpkin(config, level, x, y));	
				case "GLOWWORM" :
					return level.addEntity(new GlowWorm(config, level, x, y));
				case "HOUSE_01" :
					return level.addEntity(new House(config, level, x, y));
				case "BARN_01" :
					return level.addEntity(new Barn(config, level, x, y));
				case "SILO_01" :
					return level.addEntity(new Silo(config, level, x, y));
				case "SILO_03" :
					return level.addEntity(new Silo(config, level, x, y));
					
					
					
				case "SEED_CARROT" :
					return level.addEntity(new SeedCarrot(config, level, x, y));
				case "SEED_TOMATO" :
					return level.addEntity(new SeedTomato(config, level, x, y));
				case "SEED_STRAWBERRY" :
					return level.addEntity(new SeedStrawberry(config, level, x, y));
				case "SEED_PUMPKIN" :
					return level.addEntity(new SeedPumpkin(config, level, x, y));
				case "SEED_CORN" :
					return level.addEntity(new SeedCorn(config, level, x, y));
				case "SEED_POTATO" :
					return level.addEntity(new SeedPotato(config, level, x, y));
				case "SEED_MELON" :
					return level.addEntity(new SeedMelon(config, level, x, y));	
				case "SEED_RADISH" :
					return level.addEntity(new SeedRadish(config, level, x, y));	
				case "SEED_SALAD" :
					return level.addEntity(new SeedSalad(config, level, x, y));
				case "SEED_AUBERGINE" :
					return level.addEntity(new SeedAubergine(config, level, x, y));	
			}
		}
		
		return null;
	}

	public static EntityConfig getConfigByID(int id) {
		return list[id];
	}
	
	
	public static EntityConfig getConfigByName(String name) {
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
		
		for (EntityConfig entity : list) {
			if (entity != null) {
				count++;
			}
		}
		
		return count;
	}
}
