package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.prefabs.Ball;
import game_content.entities.prefabs.CampFire;
import game_content.entities.prefabs.Fountain;
import game_content.entities.prefabs.GlowWorm;
import game_content.entities.prefabs.LampPost;
import game_content.entities.prefabs.ScareCrowPumpkin;
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
	
	public static final EntityBluePrint[] entityList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint CAMPFIRE = new EntityBluePrint(entityList, 0, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "CAMPFIRE", new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 1, true, 250, 3, false), true, true, true);
	public static final EntityBluePrint BALL_01 = new EntityBluePrint(entityList, 1, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "BALL_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 1, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint SPAWNEGG_WOMAN_01 = new EntityBluePrint(entityList, 101, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_WOMAN_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_WOMAN_02 = new EntityBluePrint(entityList, 102, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_WOMAN_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_WOMAN_03 = new EntityBluePrint(entityList, 103, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_WOMAN_03", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_WOMAN_04 = new EntityBluePrint(entityList, 104, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_WOMAN_04", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);

	public static final EntityBluePrint SPAWNEGG_CHICKEN = new EntityBluePrint(entityList, 200, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_CHICKEN", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_BUNNY_BROWN = new EntityBluePrint(entityList, 201, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_BUNNY_BROWN", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_BUNNY_BROWN_BABY = new EntityBluePrint(entityList, 202, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_BUNNY_BROWN_BABY", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_BUNNY_GREY = new EntityBluePrint(entityList, 203, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_BUNNY_GREY", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_BUNNY_GREY_BABY = new EntityBluePrint(entityList, 204, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_BUNNY_GREY_BABY", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_CHICKEN_BABY_WHITE = new EntityBluePrint(entityList, 205, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_CHICKEN_BABY_WHITE", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_CHICKEN_BABY_YELLOW = new EntityBluePrint(entityList, 206, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_CHICKEN_BABY_YELLOW", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SPAWNEGG_CHICKEN_BABY_BROWN = new EntityBluePrint(entityList, 207, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SPAWNEGG_CHICKEN_BABY_BROWN", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	
	public static final EntityBluePrint LAMPPOST_01 = new EntityBluePrint(entityList, 300, ENTITYTYPE.PREFAB, RENDERTYPE.R1X3, "LAMPPOST_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_02 = new EntityBluePrint(entityList, 301, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_03 = new EntityBluePrint(entityList, 302, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_03", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_04 = new EntityBluePrint(entityList, 303, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_04", new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 5, false, 0, 0, false), true, true, true);	
	public static final EntityBluePrint LAMPPOST_05 = new EntityBluePrint(entityList, 304, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_05", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_06 = new EntityBluePrint(entityList, 305, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_06", new SpriteAtlas(Sheets.OBJECTS_SHEET, 9, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_07 = new EntityBluePrint(entityList, 306, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_07", new SpriteAtlas(Sheets.OBJECTS_SHEET, 11, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint LAMPPOST_08 = new EntityBluePrint(entityList, 307, ENTITYTYPE.PREFAB, RENDERTYPE.R2X3, "LAMPPOST_08", new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint SCARECROW_PUMKIN = new EntityBluePrint(entityList, 308, ENTITYTYPE.PREFAB, RENDERTYPE.R1X2, "SCARECROW_PUMKIN", new SpriteAtlas(Sheets.OBJECTS_SHEET, 20, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint GLOWWORM = new EntityBluePrint(entityList, 309, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "GLOWWORM", new SpriteAtlas(Sheets.OBJECTS_SHEET, 18, 0, false, 0, 0, false), false, false, true);
	
	public static final EntityBluePrint FOUNTAIN_01 = new EntityBluePrint(entityList, 350, ENTITYTYPE.PREFAB, RENDERTYPE.R3X3, "FOUNTAIN_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 6, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint SEED_CARROT = new EntityBluePrint(entityList, 1000, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_CARROT", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 0, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_TOMATO = new EntityBluePrint(entityList, 1001, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_TOMATO", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 1, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_STRAWBERRY = new EntityBluePrint(entityList, 1002, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_STRAWBERRY", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 2, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_PUMPKIN = new EntityBluePrint(entityList, 1003, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_PUMPKIN", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 3, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_CORN = new EntityBluePrint(entityList, 1004, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_CORN", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 4, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_POTATO = new EntityBluePrint(entityList, 1005, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_POTATO", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 5, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_MELON = new EntityBluePrint(entityList, 1006, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_MELON", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 6, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_RADISH = new EntityBluePrint(entityList, 1007, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_RADISH", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 7, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_SALAD = new EntityBluePrint(entityList, 1008, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_SALAD", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 8, false, 0, 6, false), false, true, true);
	public static final EntityBluePrint SEED_AUBERGINE = new EntityBluePrint(entityList, 1009, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "SEED_AUBERGINE", new SpriteAtlas(Sheets.FARMING_SHEET, 1, 10, false, 0, 6, false), false, true, true);
	
	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			switch(blueprint.name) {
				case "CAMPFIRE" :
					return level.addEntity(new CampFire(blueprint, level, x, y));
				case "BALL_01" :
					return level.addEntity(new Ball(blueprint, level, x, y));
				case "SPAWNEGG_WOMAN_01" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.HUMAN_WOMAN_01));
				case "SPAWNEGG_WOMAN_02" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.HUMAN_WOMAN_02));
				case "SPAWNEGG_WOMAN_03" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.HUMAN_WOMAN_03));
				case "SPAWNEGG_WOMAN_04" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.HUMAN_WOMAN_04));
				case "SPAWNEGG_CHICKEN" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_CHICKEN));
				case "SPAWNEGG_BUNNY_BROWN" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_BUNNY_BROWN));
				case "SPAWNEGG_BUNNY_BROWN_BABY" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_BUNNY_BROWN_BABY));
				case "SPAWNEGG_BUNNY_GREY" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_BUNNY_GREY));
				case "SPAWNEGG_BUNNY_GREY_BABY" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_BUNNY_GREY_BABY));
				case "SPAWNEGG_CHICKEN_BABY_WHITE" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_WHITE));
				case "SPAWNEGG_CHICKEN_BABY_YELLOW" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_YELLOW));
				case "SPAWNEGG_CHICKEN_BABY_BROWN" :
					return level.addEntity(new SpawnEgg(blueprint, level, x, y, NPCs.ANIMAL_CHICKEN_BABY_BROWN));
				case "LAMPPOST_01" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_02" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_03" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_04" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_05" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_06" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_07" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "LAMPPOST_08" :
					return level.addEntity(new LampPost(blueprint, level, x, y));
				case "FOUNTAIN_01" :
					return level.addEntity(new Fountain(blueprint, level, x, y));
				case "SCARECROW_PUMKIN" :
					return level.addEntity(new ScareCrowPumpkin(blueprint, level, x, y));	
				case "GLOWWORM" :
					return level.addEntity(new GlowWorm(blueprint, level, x, y));
				case "SEED_CARROT" :
					return level.addEntity(new SeedCarrot(blueprint, level, x, y));
				case "SEED_TOMATO" :
					return level.addEntity(new SeedTomato(blueprint, level, x, y));
				case "SEED_STRAWBERRY" :
					return level.addEntity(new SeedStrawberry(blueprint, level, x, y));
				case "SEED_PUMPKIN" :
					return level.addEntity(new SeedPumpkin(blueprint, level, x, y));
				case "SEED_CORN" :
					return level.addEntity(new SeedCorn(blueprint, level, x, y));
				case "SEED_POTATO" :
					return level.addEntity(new SeedPotato(blueprint, level, x, y));
				case "SEED_MELON" :
					return level.addEntity(new SeedMelon(blueprint, level, x, y));	
				case "SEED_RADISH" :
					return level.addEntity(new SeedRadish(blueprint, level, x, y));	
				case "SEED_SALAD" :
					return level.addEntity(new SeedSalad(blueprint, level, x, y));
				case "SEED_AUBERGINE" :
					return level.addEntity(new SeedAubergine(blueprint, level, x, y));	
			}
		}
		
		return null;
	}

	public static EntityBluePrint getBluePrintByID(int id) {
		return entityList[id];
	}
	
	
	public static EntityBluePrint getBluePrintByName(String name) {
		for (EntityBluePrint bluePrint : entityList) {
			if (bluePrint != null) {
				if (bluePrint.name.equals(name)) {
					return bluePrint;
				}
			}
		}
		
		return null;
	}
	
	public static int getListCount() {
		int count = 0;
		
		for (EntityBluePrint entity : entityList) {
			if (entity != null) {
				count++;
			}
		}
		
		return count;
	}
}
