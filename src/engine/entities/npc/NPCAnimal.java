package engine.entities.npc;

import java.awt.Color;

import engine.animation.Animation;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class NPCAnimal extends NPCCore {
	
	public NPCAnimal(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "NPCAnimal", NPCTYPE.ANIMAL, x, y, speed, true);
		
		ANIMATION_IDLE = new Animation(8, 0, 100, 2);
		ANIMATION_WALK_UP = new Animation(0, 0, 100, 2);
		ANIMATION_WALK_DOWN = new Animation(2, 0, 100, 2);
		ANIMATION_WALK_LEFT = new Animation(4, 0, 100, 2);
		ANIMATION_WALK_RIGHT =  new Animation(6, 0, 100, 2);
		
//		public final static Animation ANIMAL_IDLE = new Animation(16, 0, 100, 2);
//		public final static Animation ANIMAL_WALK_UP = new Animation(0, 0, 100, 2);
//		public final static Animation ANIMAL_WALK_DOWN = new Animation(4, 0, 100, 2);
//		public final static Animation ANIMAL_WALK_LEFT = new Animation(8, 0, 100, 2);
//		public final static Animation ANIMAL_WALK_RIGHT = new Animation(12, 0, 100, 2);
//		
//		public final static Animation ANIMAL_SMALL_IDLE = new Animation(8, 0, 100, 2);
//		public final static Animation ANIMAL_SMALL_WALK_UP = new Animation(0, 0, 100, 2);
//		public final static Animation ANIMAL_SMALL_WALK_DOWN = new Animation(2, 0, 100, 2);
//		public final static Animation ANIMAL_SMALL_WALK_LEFT = new Animation(4, 0, 100, 2);
//		public final static Animation ANIMAL_SMALL_WALK_RIGHT = new Animation(6, 0, 100, 2);
		
		jobs.targetRange = 128;
		jobs.jobDelay = 1000;
		jobs.jobDelayValue = jobs.jobDelay;
		
		debugColor = Color.BLUE;
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

	}
}
