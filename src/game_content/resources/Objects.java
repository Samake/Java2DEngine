package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.entities.objects.ObjectStatic;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.objects.CollectableItem;
import game_content.entities.objects.Fence;
import game_content.entities.objects.FenceDoor;
import game_content.entities.objects.Tree;

public class Objects {
	
	public static final EntityBluePrint[] entityList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint GRASS_01 = new EntityBluePrint(entityList, 0, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "GRASS_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint BUSH_SMALL_01 = new EntityBluePrint(entityList, 1, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 1, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_SMALL_02 = new EntityBluePrint(entityList, 2, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_01 = new EntityBluePrint(entityList, 3, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 3, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_02 = new EntityBluePrint(entityList, 4, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_03 = new EntityBluePrint(entityList, 5, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_03", new SpriteAtlas(Sheets.PLANTS_SHEET, 5, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint MUSHROOM_04 = new EntityBluePrint(entityList, 6, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "MUSHROOM_04", new SpriteAtlas(Sheets.PLANTS_SHEET, 6, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_SMALL_03 = new EntityBluePrint(entityList, 7, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_03", new SpriteAtlas(Sheets.PLANTS_SHEET, 7, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_SMALL_04 = new EntityBluePrint(entityList, 8, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BUSH_SMALL_04", new SpriteAtlas(Sheets.PLANTS_SHEET, 8, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_BIG_01 = new EntityBluePrint(entityList, 9, ENTITYTYPE.OBJECT, RENDERTYPE.R2X2, "BUSH_BIG_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BUSH_BIG_02 = new EntityBluePrint(entityList, 10, ENTITYTYPE.OBJECT, RENDERTYPE.R2X2, "BUSH_BIG_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint TREE_BIG_01 = new EntityBluePrint(entityList, 11, ENTITYTYPE.OBJECT, RENDERTYPE.R4X6, "TREE_BIG_01", new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint TREE_BIG_02 = new EntityBluePrint(entityList, 12, ENTITYTYPE.OBJECT, RENDERTYPE.R4X6, "TREE_BIG_02", new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 3, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint STONE_01 = new EntityBluePrint(entityList, 101, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_02 = new EntityBluePrint(entityList, 102, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 2, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_03 = new EntityBluePrint(entityList, 103, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_03", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_04 = new EntityBluePrint(entityList, 104, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_04", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_05 = new EntityBluePrint(entityList, 105, ENTITYTYPE.OBJECT, RENDERTYPE.R2X2, "STONE_05", new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_06 = new EntityBluePrint(entityList, 106, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_06", new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_07 = new EntityBluePrint(entityList, 107, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_07", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_08 = new EntityBluePrint(entityList, 108, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_08", new SpriteAtlas(Sheets.OBJECTS_SHEET, 8, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_09 = new EntityBluePrint(entityList, 109, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_09", new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint STONE_10 = new EntityBluePrint(entityList, 110, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE_10", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 1, false, 0, 0, false), true, true, true);

	public static final EntityBluePrint IRON_ORE = new EntityBluePrint(entityList, 150, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "IRON_ORE", new SpriteAtlas(Sheets.OBJECTS_SHEET, 12, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint STONE = new EntityBluePrint(entityList, 151, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "STONE", new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SAND = new EntityBluePrint(entityList, 152, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "SAND", new SpriteAtlas(Sheets.OBJECTS_SHEET, 14, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint GOLD_ORE = new EntityBluePrint(entityList, 153, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "GOLD_ORE", new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint COAL = new EntityBluePrint(entityList, 154, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "COAL", new SpriteAtlas(Sheets.OBJECTS_SHEET, 16, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint SIVLER_ORE = new EntityBluePrint(entityList, 155, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "SIVLER_ORE", new SpriteAtlas(Sheets.OBJECTS_SHEET, 17, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint KEY_01 = new EntityBluePrint(entityList, 156, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "KEY_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 14, 1, false, 0, 0, false), false, true, true);
	
	public static final EntityBluePrint BRIDGE_01 = new EntityBluePrint(entityList, 200, ENTITYTYPE.OBJECT, RENDERTYPE.R3X2, "BRIDGE_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 9, 0, false, 0, 0, false), true, true, true);

	public static final EntityBluePrint BARREL_01 = new EntityBluePrint(entityList, 300, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BARREL_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 12, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint BARREL_02 = new EntityBluePrint(entityList, 301, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "BARREL_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint CRATE_01 = new EntityBluePrint(entityList, 302, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "CRATE_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint SCARECROW_01 = new EntityBluePrint(entityList, 303, ENTITYTYPE.OBJECT, RENDERTYPE.R1X2, "SCARECROW_01", new SpriteAtlas(Sheets.OBJECTS_SHEET, 19, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint SCARECROW_02 = new EntityBluePrint(entityList, 304, ENTITYTYPE.OBJECT, RENDERTYPE.R1X2, "SCARECROW_02", new SpriteAtlas(Sheets.OBJECTS_SHEET, 20, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint SCARECROW_03 = new EntityBluePrint(entityList, 305, ENTITYTYPE.OBJECT, RENDERTYPE.R1X2, "SCARECROW_03", new SpriteAtlas(Sheets.OBJECTS_SHEET, 21, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_D_C = new EntityBluePrint(entityList, 400, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_D_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C = new EntityBluePrint(entityList, 401, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_L_C = new EntityBluePrint(entityList, 402, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_L_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_R_C = new EntityBluePrint(entityList, 403, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_N_C = new EntityBluePrint(entityList, 404, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_N_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_D_C_R_C = new EntityBluePrint(entityList, 405, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_D_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_L_C_R_C = new EntityBluePrint(entityList, 406, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_L_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_L_C_D_C = new EntityBluePrint(entityList, 407, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_L_C_D_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_D_C = new EntityBluePrint(entityList, 408, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_D_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_R_C = new EntityBluePrint(entityList, 409, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_L_C = new EntityBluePrint(entityList, 410, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_L_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_D_C_R_C = new EntityBluePrint(entityList, 411, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_D_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_D_C_L_C = new EntityBluePrint(entityList, 412, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_D_C_L_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_D_C_L_C_R_C = new EntityBluePrint(entityList, 413, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_D_C_L_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_U_C_L_C_R_C = new EntityBluePrint(entityList, 414, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_U_C_L_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_D_C_L_C_R_C = new EntityBluePrint(entityList, 415, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_D_C_L_C_R_C", new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_DOOR_H_L = new EntityBluePrint(entityList, 416, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_DOOR_H_L", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint FENCE_DOOR_H_R = new EntityBluePrint(entityList, 417, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "FENCE_DOOR_H_R", new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 4, false, 0, 0, false), true, true, true);

	public static final EntityBluePrint ITEM_CARROT = new EntityBluePrint(entityList, 500, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_CARROT", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 0, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_TOMATO = new EntityBluePrint(entityList, 501, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_TOMATO", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 1, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_STRAWBERRY = new EntityBluePrint(entityList, 502, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_STRAWBERRY", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 2, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_PUMPKIN = new EntityBluePrint(entityList, 503, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_PUMPKIN", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 3, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_CORN = new EntityBluePrint(entityList, 504, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_CORN", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 4, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_POTATO = new EntityBluePrint(entityList, 505, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_POTATO", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 5, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_MELON = new EntityBluePrint(entityList, 506, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_MELON", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 6, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_RADISH = new EntityBluePrint(entityList, 507, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_RADISH", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 7, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_SALAD = new EntityBluePrint(entityList, 508, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_SALAD", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 8, false, 0, 0, false), false, true, true);
	public static final EntityBluePrint ITEM_AUBERGINE = new EntityBluePrint(entityList, 509, ENTITYTYPE.OBJECT, RENDERTYPE.R1X1, "ITEM_AUBERGINE", new SpriteAtlas(Sheets.FARMING_SHEET, 8, 10, false, 0, 0, false), false, true, true);
	
	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			switch(blueprint.name) {
				case "TREE_BIG_01" :
					return level.addEntity(new Tree(blueprint, level, x, y));
				case "TREE_BIG_02" :
					return level.addEntity(new Tree(blueprint, level, x, y));
				case "FENCE_D_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));
				case "FENCE_U_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));
				case "FENCE_L_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));
				case "FENCE_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));
				case "FENCE_N_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));
				case "FENCE_D_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_L_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_L_C_D_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_D_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_L_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_D_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_D_C_L_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_D_C_L_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_U_C_L_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_D_C_L_C_R_C" :
					return level.addEntity(new Fence(blueprint, level, x, y));	
				case "FENCE_DOOR_H_L" :
					return level.addEntity(new FenceDoor(blueprint, level, x, y));
				case "FENCE_DOOR_H_R" :
					return level.addEntity(new FenceDoor(blueprint, level, x, y));
				case "IRON_ORE" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "STONE" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "SAND" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "GOLD_ORE" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "COAL" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "SIVLER_ORE" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "KEY_01" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_CARROT" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_TOMATO" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_STRAWBERRY" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));	
				case "ITEM_PUMPKIN" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_CORN" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_POTATO" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_MELON" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_RADISH" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_SALAD" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				case "ITEM_AUBERGINE" :
					return level.addEntity(new CollectableItem(blueprint, level, x, y));
				default:
					return level.addEntity(new ObjectStatic(blueprint, level, x, y)); 
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
