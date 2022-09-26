package engine.entities.npc;

import engine.animation.Animations;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class NPCHuman extends NPCCore {
	
	public NPCHuman(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Svenja", x, y, speed, true);
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

		animation = Animations.HUMAN_IDLE;
		
		// idle
		if (!isMoving) {
			animation = Animations.HUMAN_IDLE;
		}
		
		if (isMoving) {
			// walk up
			if (movingDir == 0) {
				animation = Animations.HUMAN_WALK_UP;
			// walk down
			} else if (movingDir == 1) {
				animation = Animations.HUMAN_WALK_DOWN;
			// walk left
			} else if (movingDir == 2) {
				animation = Animations.HUMAN_WALK_LEFT;
			// walk right
			} else if (movingDir == 3) {
				animation = Animations.HUMAN_WALK_RIGHT;
			}
		}
		
		animation.animate(flipValue);
		
		
		xTile = animation.xTile;
		yTile = animation.yTile;
	}

}