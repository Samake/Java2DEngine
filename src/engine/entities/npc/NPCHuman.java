package engine.entities.npc;

import engine.animation.Animations;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.resources.Tiles;

public class NPCHuman extends NPCCore {
	
	public boolean hasJob = false;
	
	public Vector2f targetPosition = new Vector2f();
	public int targetRange = 64;
	
	private long lastTimeStamp = System.currentTimeMillis();
	private int jobDelay = 1500;
	private int jobDelayValue = jobDelay;

	
	public NPCHuman(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Svenja", x, y, speed);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
			collissionBox.minY = (-bluePrint.atlas.sheet.tileSize) + 2;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - 2;
		}
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

		handleAnimation();
		handleJobs();
	}
	
	public void handleAnimation() {
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