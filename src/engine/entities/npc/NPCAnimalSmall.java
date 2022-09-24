package engine.entities.npc;

import engine.animation.Animations;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.resources.Tiles;

public class NPCAnimalSmall extends NPCCore {
	
	public boolean hasJob = false;
	
	public Vector2f targetPosition = new Vector2f();
	public int targetRange = 48;
	
	private long lastTimeStamp = System.currentTimeMillis();
	public int jobDelay = 1000;
	public int jobDelayValue = jobDelay;

	
	public NPCAnimalSmall(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Svenja", x, y, speed);
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

		handleAnimation();
		handleJobs();
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

	private void handleJobs() {
		if (!hasJob) {
			if (lastTimeStamp + jobDelayValue < System.currentTimeMillis()) {
				int targetX = (int) (position.x+ Misc.randomInteger(-targetRange, targetRange));
				int targetY = (int) (position.y + Misc.randomInteger(-targetRange, targetRange));
	
				Tile tile = level.getTile(targetX >> bluePrint.atlas.sheet.getShiftOperator(), targetY >> bluePrint.atlas.sheet.getShiftOperator());
				
				if (tile != null) {
					if (!tile.isSolid && !tile.hasCollission && tile.bluePrint != Tiles.WATER_CLEAN) {
						targetPosition.set(targetX, targetY);
						hasJob = true;
						isSneaking = true;
					}
				}
			}
		} else {
			if ((int) position.x> (int) targetPosition.x) {
				velocity.add(-speed, 0);
			}
			
			if ((int) position.x< (int) targetPosition.x) {
				velocity.add(speed, 0);
			}
			
			if ((int) position.y > (int) targetPosition.y) {
				velocity.add(0, -speed);
			}
			
			if ((int) position.y < (int) targetPosition.y) {
				velocity.add(0, speed);
			}

			int distance = (int) (position.distance(targetPosition) / 16);
			
			if (distance <= 0) {
				hasJob = false;
				lastTimeStamp = System.currentTimeMillis();
				jobDelayValue = Misc.randomInteger(jobDelay / 2, jobDelay * 2);
			}
		}
	}
}
