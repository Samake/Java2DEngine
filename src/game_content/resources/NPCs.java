package game_content.resources;

import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.entities.EntityBluePrint;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.entities.npc.AnimalBunny;
import game_content.entities.npc.AnimalChicken;
import game_content.entities.npc.NPCWoman;
import game_content.entities.player.Player;

public class NPCs {

	public static final EntityBluePrint[] npcList = new EntityBluePrint[2048];
	
	public static final EntityBluePrint PLAYER = new EntityBluePrint(null, 0, ENTITYTYPE.PLAYER, RENDERTYPE.R2X2, "PLAYER", new SpriteAtlas(Sheets.WOMEN_02_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint HUMAN_WOMAN_01 = new EntityBluePrint(npcList, 0, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_01", new SpriteAtlas(Sheets.WOMEN_01_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_02 = new EntityBluePrint(npcList, 1, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_02", new SpriteAtlas(Sheets.WOMEN_02_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_03 = new EntityBluePrint(npcList, 2, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_03", new SpriteAtlas(Sheets.WOMEN_03_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint HUMAN_WOMAN_04 = new EntityBluePrint(npcList, 3, ENTITYTYPE.NPC, RENDERTYPE.R2X2, "HUMAN_WOMAN_04", new SpriteAtlas(Sheets.WOMEN_04_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	
	public static final EntityBluePrint ANIMAL_CHICKEN = new EntityBluePrint(npcList, 100, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_CHICKEN", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 0, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_BUNNY_BROWN = new EntityBluePrint(npcList, 101, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_BUNNY_BROWN", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 1, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_BUNNY_BROWN_BABY = new EntityBluePrint(npcList, 102, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_BUNNY_BROWN_BABY", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 2, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_BUNNY_GREY = new EntityBluePrint(npcList, 103, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_BUNNY_GREY", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 3, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_BUNNY_GREY_BABY = new EntityBluePrint(npcList, 104, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_BUNNY_GREY_BABY", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 4, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_CHICKEN_BABY_WHITE = new EntityBluePrint(npcList, 105, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_CHICKEN_BABY_WHITE", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 5, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_CHICKEN_BABY_YELLOW = new EntityBluePrint(npcList, 106, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_CHICKEN_BABY_YELLOW", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 6, false, 0, 0, false), true, true, true);
	public static final EntityBluePrint ANIMAL_CHICKEN_BABY_BROWN = new EntityBluePrint(npcList, 107, ENTITYTYPE.NPC, RENDERTYPE.R1X1, "ANIMAL_CHICKEN_BABY_BROWN", new SpriteAtlas(Sheets.ANIMALS_SHEET, 0, 7, false, 0, 0, false), true, true, true);
	
	public static Entity addInstanceToLevel(EntityBluePrint blueprint, Level level, int x, int y) {
		if (blueprint != null) {
			switch(blueprint.name) {
				case "PLAYER":
					return level.setPlayer(new Player(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_01":
					return level.addEntity(new NPCWoman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_02":
					return level.addEntity(new NPCWoman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_03":
					return level.addEntity(new NPCWoman(blueprint, level, x, y, 1.0f));
				case "HUMAN_WOMAN_04":
					return level.addEntity(new NPCWoman(blueprint, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN":
					return level.addEntity(new AnimalChicken(blueprint, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_BROWN":
					return level.addEntity(new AnimalBunny(blueprint, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_BROWN_BABY":
					return level.addEntity(new AnimalBunny(blueprint, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_GREY":
					return level.addEntity(new AnimalBunny(blueprint, level, x, y, 1.0f));
				case "ANIMAL_BUNNY_GREY_BABY":
					return level.addEntity(new AnimalBunny(blueprint, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_WHITE":
					return level.addEntity(new AnimalChicken(blueprint, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_YELLOW":
					return level.addEntity(new AnimalChicken(blueprint, level, x, y, 1.0f));
				case "ANIMAL_CHICKEN_BABY_BROWN":
					return level.addEntity(new AnimalChicken(blueprint, level, x, y, 1.0f));
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
	
	public static int getListCount() {
		int count = 0;
		
		for (EntityBluePrint npc : npcList) {
			if (npc != null) {
				count++;
			}
		}
		
		return count;
	}
}
