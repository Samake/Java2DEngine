package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.objects.ObjectStatic;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.objects.CollectableItem;
import game_content.entities.objects.Fence;
import game_content.entities.objects.FenceDoor;
import game_content.entities.objects.Tree;

public class Objects {
	
	public static final EntityConfig[] entityList = new EntityConfig[2048];
	
	public static final EntityConfig GRASS_01 = new EntityConfig(entityList, 0, ENTITYTYPE.OBJECT, "GRASS_01", false, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig BUSH_SMALL_01 = new EntityConfig(entityList, 1, ENTITYTYPE.OBJECT, "BUSH_SMALL_01", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 1, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig BUSH_SMALL_02 = new EntityConfig(entityList, 2, ENTITYTYPE.OBJECT, "BUSH_SMALL_02", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig MUSHROOM_01 = new EntityConfig(entityList, 3, ENTITYTYPE.OBJECT, "MUSHROOM_01", false, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 3, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig MUSHROOM_02 = new EntityConfig(entityList, 4, ENTITYTYPE.OBJECT, "MUSHROOM_02", false, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig MUSHROOM_03 = new EntityConfig(entityList, 5, ENTITYTYPE.OBJECT, "MUSHROOM_03", false, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 5, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig MUSHROOM_04 = new EntityConfig(entityList, 6, ENTITYTYPE.OBJECT, "MUSHROOM_04", false, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 6, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig BUSH_BIG_01 = new EntityConfig(entityList, 9, ENTITYTYPE.OBJECT, "BUSH_BIG_01", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 1, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig BUSH_BIG_02 = new EntityConfig(entityList, 10, ENTITYTYPE.OBJECT, "BUSH_BIG_02", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 2, 1, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig TREE_BIG_01 = new EntityConfig(entityList, 11, ENTITYTYPE.OBJECT, "TREE_BIG_01", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 0, 3, false, 0, 0, false), true, true, RENDERTYPE.R4X6));
	public static final EntityConfig TREE_BIG_02 = new EntityConfig(entityList, 12, ENTITYTYPE.OBJECT, "TREE_BIG_02", true, new EntityRenderData(new SpriteAtlas(Sheets.PLANTS_SHEET, 4, 3, false, 0, 0, false), true, true, RENDERTYPE.R4X6));
	
	public static final EntityConfig STONE_01 = new EntityConfig(entityList, 101, ENTITYTYPE.OBJECT, "STONE_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_02 = new EntityConfig(entityList, 102, ENTITYTYPE.OBJECT, "STONE_02", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 2, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_03 = new EntityConfig(entityList, 103, ENTITYTYPE.OBJECT, "STONE_03", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_04 = new EntityConfig(entityList, 104, ENTITYTYPE.OBJECT, "STONE_04", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_05 = new EntityConfig(entityList, 105, ENTITYTYPE.OBJECT, "STONE_05", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 0, false, 0, 0, false), true, true, RENDERTYPE.R2X2));
	public static final EntityConfig STONE_06 = new EntityConfig(entityList, 106, ENTITYTYPE.OBJECT, "STONE_06", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_07 = new EntityConfig(entityList, 107, ENTITYTYPE.OBJECT, "STONE_07", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_08 = new EntityConfig(entityList, 108, ENTITYTYPE.OBJECT, "STONE_08", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 8, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_09 = new EntityConfig(entityList, 109, ENTITYTYPE.OBJECT, "STONE_09", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE_10 = new EntityConfig(entityList, 110, ENTITYTYPE.OBJECT, "STONE_10", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));

	public static final EntityConfig IRON_ORE = new EntityConfig(entityList, 150, ENTITYTYPE.OBJECT, "IRON_ORE", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 12, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig STONE = new EntityConfig(entityList, 151, ENTITYTYPE.OBJECT, "STONE", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SAND = new EntityConfig(entityList, 152, ENTITYTYPE.OBJECT, "SAND", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 14, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig GOLD_ORE = new EntityConfig(entityList, 153, ENTITYTYPE.OBJECT, "GOLD_ORE", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig COAL = new EntityConfig(entityList, 154, ENTITYTYPE.OBJECT, "COAL", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 16, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SIVLER_ORE = new EntityConfig(entityList, 155, ENTITYTYPE.OBJECT, "SIVLER_ORE", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 17, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig KEY_01 = new EntityConfig(entityList, 156, ENTITYTYPE.OBJECT, "KEY_01", false, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 14, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	
	public static final EntityConfig BRIDGE_01 = new EntityConfig(entityList, 200, ENTITYTYPE.OBJECT, "BRIDGE_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 9, 0, false, 0, 0, false), true, true, RENDERTYPE.R3X2));

	public static final EntityConfig BARREL_01 = new EntityConfig(entityList, 300, ENTITYTYPE.OBJECT, "BARREL_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 12, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig BARREL_02 = new EntityConfig(entityList, 301, ENTITYTYPE.OBJECT, "BARREL_02", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 13, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig CRATE_01 = new EntityConfig(entityList, 302, ENTITYTYPE.OBJECT, "CRATE_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 15, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig SCARECROW_01 = new EntityConfig(entityList, 303, ENTITYTYPE.OBJECT, "SCARECROW_01", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 19, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X2));
	public static final EntityConfig CRATE_02 = new EntityConfig(entityList, 304, ENTITYTYPE.OBJECT, "CRATE_02", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 16, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_D_C = new EntityConfig(entityList, 400, ENTITYTYPE.OBJECT, "FENCE_D_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C = new EntityConfig(entityList, 401, ENTITYTYPE.OBJECT, "FENCE_U_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 1, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_L_C = new EntityConfig(entityList, 402, ENTITYTYPE.OBJECT, "FENCE_L_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_R_C = new EntityConfig(entityList, 403, ENTITYTYPE.OBJECT, "FENCE_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_N_C = new EntityConfig(entityList, 404, ENTITYTYPE.OBJECT, "FENCE_N_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 3, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_D_C_R_C = new EntityConfig(entityList, 405, ENTITYTYPE.OBJECT, "FENCE_D_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_L_C_R_C = new EntityConfig(entityList, 406, ENTITYTYPE.OBJECT, "FENCE_L_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_L_C_D_C = new EntityConfig(entityList, 407, ENTITYTYPE.OBJECT, "FENCE_L_C_D_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_D_C = new EntityConfig(entityList, 408, ENTITYTYPE.OBJECT, "FENCE_U_C_D_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_R_C = new EntityConfig(entityList, 409, ENTITYTYPE.OBJECT, "FENCE_U_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 4, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_L_C = new EntityConfig(entityList, 410, ENTITYTYPE.OBJECT, "FENCE_U_C_L_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 5, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_D_C_R_C = new EntityConfig(entityList, 411, ENTITYTYPE.OBJECT, "FENCE_U_C_D_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_D_C_L_C = new EntityConfig(entityList, 412, ENTITYTYPE.OBJECT, "FENCE_U_C_D_C_L_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 6, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_D_C_L_C_R_C = new EntityConfig(entityList, 413, ENTITYTYPE.OBJECT, "FENCE_U_C_D_C_L_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_U_C_L_C_R_C = new EntityConfig(entityList, 414, ENTITYTYPE.OBJECT, "FENCE_U_C_L_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_D_C_L_C_R_C = new EntityConfig(entityList, 415, ENTITYTYPE.OBJECT, "FENCE_D_C_L_C_R_C", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 7, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_DOOR_H_L = new EntityConfig(entityList, 416, ENTITYTYPE.OBJECT, "FENCE_DOOR_H_L", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig FENCE_DOOR_H_R = new EntityConfig(entityList, 417, ENTITYTYPE.OBJECT, "FENCE_DOOR_H_R", true, new EntityRenderData(new SpriteAtlas(Sheets.OBJECTS_SHEET, 0, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));

	public static final EntityConfig ITEM_CARROT = new EntityConfig(entityList, 500, ENTITYTYPE.OBJECT, "ITEM_CARROT", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 0, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_TOMATO = new EntityConfig(entityList, 501, ENTITYTYPE.OBJECT, "ITEM_TOMATO", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 1, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_STRAWBERRY = new EntityConfig(entityList, 502, ENTITYTYPE.OBJECT, "ITEM_STRAWBERRY", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 2, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_PUMPKIN = new EntityConfig(entityList, 503, ENTITYTYPE.OBJECT, "ITEM_PUMPKIN", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 3, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_CORN = new EntityConfig(entityList, 504, ENTITYTYPE.OBJECT, "ITEM_CORN", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 4, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_POTATO = new EntityConfig(entityList, 505, ENTITYTYPE.OBJECT, "ITEM_POTATO", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 5, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_MELON = new EntityConfig(entityList, 506, ENTITYTYPE.OBJECT, "ITEM_MELON", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 6, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_RADISH = new EntityConfig(entityList, 507, ENTITYTYPE.OBJECT, "ITEM_RADISH", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 7, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_SALAD = new EntityConfig(entityList, 508, ENTITYTYPE.OBJECT, "ITEM_SALAD", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 8, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	public static final EntityConfig ITEM_AUBERGINE = new EntityConfig(entityList, 509, ENTITYTYPE.OBJECT, "ITEM_AUBERGINE", false, new EntityRenderData(new SpriteAtlas(Sheets.FARMING_SHEET, 8, 10, false, 0, 0, false), true, true, RENDERTYPE.R1X1));
	
	public static Entity addInstanceToLevel(EntityConfig config, Level level, int x, int y) {
		if (config != null) {
			switch(config.name) {
				case "TREE_BIG_01" :
					return level.addEntity(new Tree(config, level, x, y));
				case "TREE_BIG_02" :
					return level.addEntity(new Tree(config, level, x, y));
				case "FENCE_D_C" :
					return level.addEntity(new Fence(config, level, x, y));
				case "FENCE_U_C" :
					return level.addEntity(new Fence(config, level, x, y));
				case "FENCE_L_C" :
					return level.addEntity(new Fence(config, level, x, y));
				case "FENCE_R_C" :
					return level.addEntity(new Fence(config, level, x, y));
				case "FENCE_N_C" :
					return level.addEntity(new Fence(config, level, x, y));
				case "FENCE_D_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_L_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_L_C_D_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_D_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_L_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_D_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_D_C_L_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_D_C_L_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_U_C_L_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_D_C_L_C_R_C" :
					return level.addEntity(new Fence(config, level, x, y));	
				case "FENCE_DOOR_H_L" :
					return level.addEntity(new FenceDoor(config, level, x, y));
				case "FENCE_DOOR_H_R" :
					return level.addEntity(new FenceDoor(config, level, x, y));
				case "IRON_ORE" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "STONE" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "SAND" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "GOLD_ORE" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "COAL" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "SIVLER_ORE" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "KEY_01" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_CARROT" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_TOMATO" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_STRAWBERRY" :
					return level.addEntity(new CollectableItem(config, level, x, y));	
				case "ITEM_PUMPKIN" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_CORN" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_POTATO" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_MELON" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_RADISH" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_SALAD" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				case "ITEM_AUBERGINE" :
					return level.addEntity(new CollectableItem(config, level, x, y));
				default:
					return level.addEntity(new ObjectStatic(config, level, x, y)); 
			}
		}
		
		return null;
	}

	public static EntityConfig getBluePrintByID(int id) {
		return entityList[id];
	}
	
	
	public static EntityConfig getBluePrintByName(String name) {
		for (EntityConfig config : entityList) {
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
		
		for (EntityConfig entity : entityList) {
			if (entity != null) {
				count++;
			}
		}
		
		return count;
	}
}
