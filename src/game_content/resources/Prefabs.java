package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.prefabs.Ball_01;
import game_content.entities.prefabs.CampFire;
import game_content.entities.prefabs.SpawnEgg;

public class Prefabs {
	
	public static final EntityBluePrint[] entityList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint CAMPFIRE = new EntityBluePrint(entityList, 0, ENTITYTYPE.PREFAB, RENDERTYPE.R1X1, "CAMPFIRE", new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 1, true, 250, 3, false), false, true, true);
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
	
	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			switch(blueprint.name) {
				case "CAMPFIRE" :
					return level.addEntity(new CampFire(blueprint, level, x, y));
				case "BALL_01" :
					return level.addEntity(new Ball_01(blueprint, level, x, y));
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
}
