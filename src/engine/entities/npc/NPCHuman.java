package engine.entities.npc;

import java.awt.Color;

import engine.animation.Animation;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class NPCHuman extends NPCCore {
	
	public NPCHuman(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "NPCHuman", x, y, speed, true);
		
		ANIMATION_IDLE = new Animation(16, 0, 100, 2);
		ANIMATION_WALK_UP = new Animation(0, 0, 100, 2);
		ANIMATION_WALK_DOWN = new Animation(4, 0, 100, 2);
		ANIMATION_WALK_LEFT = new Animation(8, 0, 100, 2);
		ANIMATION_WALK_RIGHT = new Animation(12, 0, 100, 2);
		
//		public final static Animation HUMAN_IDLE = new Animation(16, 0, 100, 2);
//		public final static Animation HUMAN_WALK_UP = new Animation(0, 0, 100, 2);
//		public final static Animation HUMAN_WALK_DOWN = new Animation(4, 0, 100, 2);
//		public final static Animation HUMAN_WALK_LEFT = new Animation(8, 0, 100, 2);
//		public final static Animation HUMAN_WALK_RIGHT = new Animation(12, 0, 100, 2);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + collissionOffset;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - collissionOffset;
			collissionBox.minY = collissionOffset;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - collissionOffset;
		}
		
		jobs.targetRange = 256;
		jobs.jobDelay = 1500;
		jobs.jobDelayValue = jobs.jobDelay;
		
		debugColor = Color.WHITE;
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

	}
}