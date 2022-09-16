package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCHuman;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.npc.Chicken_01;
import game_content.entities.player.Player;

public class NPCs {

	public static final EntityBluePrint[] npcList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint PLAYER = new EntityBluePrint(null, 0, ENTITYTYPE.PLAYER, RENDERTYPE.R2X2, "PLAYER", new SpriteAtlas(Sheets.WOMEN_02_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint HUMAN_WOMAN_01 = new EntityBluePrint(npcList, 0, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_01", new SpriteAtlas(Sheets.WOMEN_01_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_02 = new EntityBluePrint(npcList, 1, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_02", new SpriteAtlas(Sheets.WOMEN_02_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_03 = new EntityBluePrint(npcList, 2, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_03", new SpriteAtlas(Sheets.WOMEN_03_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_04 = new EntityBluePrint(npcList, 3, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_04", new SpriteAtlas(Sheets.WOMEN_04_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint ANIMAL_CHICKEN_01 = new EntityBluePrint(npcList, 100, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_CHICKEN_01", new SpriteAtlas(Sheets.CHICKEN_01_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	
	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			switch(blueprint.name) {
				case "PLAYER":
					return level.setPlayer(new Player(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_01":
					return level.addEntity(new NPCHuman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_02":
					return level.addEntity(new NPCHuman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_03":
					return level.addEntity(new NPCHuman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_04":
					return level.addEntity(new NPCHuman(blueprint, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_01":
					return level.addEntity(new Chicken_01(blueprint, level, x, y, 1.0f));
			}
		}
		
		return null;
	}

	public static EntityBluePrint getBluePrintByID(int id) {
		return npcList[id];
	}
	
	
	public static EntityBluePrint getBluePrintByName(String name) {
		for (EntityBluePrint bluePrint : npcList) {
			if (bluePrint != null) {
				if (bluePrint.name.equals(name)) {
					return bluePrint;
				}
			}
		}
		
		return null;
	}
}
