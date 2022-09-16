package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.entities.objects.ObjectStatic;
import engine.level.Level;
import engine.sprites.SpriteAtlas;

public class Objects {
	
	public static final EntityBluePrint[] entityList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint GRASS_01 = new EntityBluePrint(entityList, 0, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "GRASS_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint BUSH_SMALL_01 = new EntityBluePrint(entityList, 1, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 1, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint BUSH_SMALL_02 = new EntityBluePrint(entityList, 2, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint MUSHROOM_01 = new EntityBluePrint(entityList, 3, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 3, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_02 = new EntityBluePrint(entityList, 4, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_03 = new EntityBluePrint(entityList, 5, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_03", new SpriteAtlas(Sheets.PLANTS_SHEET, 5, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_04 = new EntityBluePrint(entityList, 6, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_04", new SpriteAtlas(Sheets.PLANTS_SHEET, 6, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_SMALL_03 = new EntityBluePrint(entityList, 7, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_03", new SpriteAtlas(Sheets.PLANTS_SHEET, 7, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_SMALL_04 = new EntityBluePrint(entityList, 8, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_04", new SpriteAtlas(Sheets.PLANTS_SHEET, 8, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_BIG_01 = new EntityBluePrint(entityList, 9, ENTITYTYPE.OBJECT, RENDERTYPE.R2X2, "BUSH_BIG_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 1, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint BUSH_BIG_02 = new EntityBluePrint(entityList, 10, ENTITYTYPE.OBJECT, RENDERTYPE.R2X2, "BUSH_BIG_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 1, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint TREE_BIG_01 = new EntityBluePrint(entityList, 11, ENTITYTYPE.OBJECT, RENDERTYPE.R4X6, "TREE_BIG_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 3, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint TREE_BIG_02 = new EntityBluePrint(entityList, 12, ENTITYTYPE.OBJECT, RENDERTYPE.R4X6, "TREE_BIG_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 3, false, 0, 0, false), false, true, true);
	
	public static final EntityBluePrint STONE_01 = new EntityBluePrint(entityList, 101, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_02 = new EntityBluePrint(entityList, 102, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 2, 0, false, 0, 0, false), false, true, true);

	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			return level.addEntity(new ObjectStatic(blueprint, level, x, y)); 
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
