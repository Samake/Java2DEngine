package engine.entities.npc;

import engine.animation.Animations;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class NPCAnimal extends NPCCore {
	
	public NPCAnimal(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Svenja", x, y, speed, true);
		
		jobs.targetRange = 64;
		jobs.jobDelay = 1500;
		jobs.jobDelayValue = jobs.jobDelay;
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

		handleAnimation();
	}
	
	public void handleAnimation() {
		flipValue /= 2;
		
		animation = Animations.ANIMAL_SMALL_IDLE;
		
		// idle
		if (!isMoving) {
			animation = Animations.ANIMAL_SMALL_IDLE;
		}
		
		if (isMoving) {
			// walk up
			if (movingDir == 0) {
				animation = Animations.ANIMAL_SMALL_WALK_UP;
			// walk down
			} else if (movingDir == 1) {
				animation = Animations.ANIMAL_SMALL_WALK_DOWN;
			// walk left
			} else if (movingDir == 2) {
				animation = Animations.ANIMAL_SMALL_WALK_LEFT;
			// walk right
			} else if (movingDir == 3) {
				animation = Animations.ANIMAL_SMALL_WALK_RIGHT;
			}
		}
		
		animation.animate(flipValue);
		
		xTile = animation.xTile;
		yTile = animation.yTile;
	}
}
