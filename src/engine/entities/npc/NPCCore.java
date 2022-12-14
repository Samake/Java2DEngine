package engine.entities.npc;

import java.awt.Color;
import java.util.List;

import engine.animation.Animation;
import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.entities.npc.NPCJobs.JOBS;
import engine.input.InputHandler;
import engine.level.Level;
import engine.pathfinding.Pathfinder;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.entities.effects.EffectWaterRipples;
import game_content.resources.Tiles;

public class NPCCore extends Entity {
	
	public enum NPCTYPE {
		ANIMAL, HUMAN
	}
	
	public Animation ANIMATION_IDLE = new Animation(16, 0, 100, 2);
	public Animation ANIMATION_WALK_UP = new Animation(0, 0, 100, 2);
	public Animation ANIMATION_WALK_DOWN = new Animation(4, 0, 100, 2);
	public Animation ANIMATION_WALK_LEFT = new Animation(8, 0, 100, 2);
	public Animation ANIMATION_WALK_RIGHT = new Animation(12, 0, 100, 2);

	public String name;
	public NPCTYPE type;
	public float scale = 1.0f;
	public float maxSpeed = 0;
	public float speed;
	
	public int numSteps = 0;
	
	public int viewDirection = 1;
	
	public boolean isMoving = false;
	public boolean isSwimming = false;
	public boolean isSprinting = false;
	public boolean isSneaking = false;
	
	public boolean isCollidingLeft = false;
	public boolean isCollidingRight = false;
	public boolean isCollidingUp= false;
	public boolean isCollidingDown = false;
	
	public float modifier = 0;
	public int flipValue = 0;
	public int flipSpeed = 2;
	public int flipModifier = 0;
	private boolean flipChanged = false;
	
	public Animation animation;
	public int animSpeed = 1;
	
	private Vector2f spawnPosition = new Vector2f();
	public Pathfinder pathfinder;
	public NPCJobs jobs;
	
	private int waterDripCount = 5;
	
	public NPCCore(EntityConfig config, Level level, String name, NPCTYPE type, float x, float y, float speed, boolean useAI) {
		super(config, level, x, y);
		
		this.name = name;
		this.speed = speed;
		this.maxSpeed = speed;
		
		animation = ANIMATION_IDLE;
		
		debugColor = Color.BLUE;
		
		if (useAI) {
			pathfinder = new Pathfinder(level);
			jobs = new NPCJobs(this, pathfinder);
			jobs.targetRange = 64;
			jobs.jobDelay = 2000;
			jobs.jobDelayValue = jobs.jobDelay;
		}
		
		spawnPosition.x = x;
		spawnPosition.y = y;
	}

	public void move() {
		if (!level.editorMode) {
			if (!hasCollided(velocity.x, velocity.y)) {
				if (velocity.y < 0) {
					if (isCollidingUp) {
						if (velocity.y < 0) {
							velocity.y = 0;
						}
					}
				}
				
				if (velocity.y > 0) {
					if (isCollidingDown) {
						if (velocity.y > 0) {
							velocity.y = 0;
						}
					}
				}
				
				if (velocity.x < 0) {
					if (isCollidingLeft) {
						if (velocity.x < 0) {
							velocity.x = 0;
						}
					}
				}
				
				if (velocity.x > 0) {
					if (isCollidingRight) {
						if (velocity.x > 0) {
							velocity.x = 0;
						}
					}
				}
				
				handleViewDirection();
				
				position.add(velocity);
				numSteps++;
				return;
			} else {
				return;
			}
		}
	}

	public void handleViewDirection() {
		if (velocity.y < 0) {
			viewDirection = 0;
		}
		
		if (velocity.y > 0) {
			viewDirection = 1;
		}
		
		if (velocity.x < 0) {
			viewDirection = 2;
		}
		
		if (velocity.x > 0) {
			viewDirection = 3;
		}
	};
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (!level.editorMode) {
			if (jobs != null) {
				jobs.update(gameSpeed);
				
				if (jobs.currentJob != null && jobs.currentJob.equals(JOBS.RESPAWN)) {
					position.x = spawnPosition.x;
					position.y= spawnPosition.y;
					
					jobs.reset(false);
					jobs.setJob(JOBS.IDLE, null);
				}
			}
		
			flipModifier = (flipModifier + gameSpeed)%100;

			float currentSpeed = maxSpeed;
			
			speed = currentSpeed * gameSpeed;
			
			if (level != null && config.renderData.atlas != null) {
				Tile tile = level.getTile((int) position.x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y >> config.renderData.atlas.sheet.getShiftOperator());
				
				if (tile != null) {
					checkIfInWater(tile);
				}
			}
			
			if (velocity.x != 0 || velocity.y != 0) {
				move();
				isMoving = true;
			} else {
				isMoving = false;
			}

			if (isSprinting) {

			}
			
			flipValue = (flipModifier >> (int) flipSpeed * 2) & 1;

			if (isSwimming) {
				heightOffsetModifier = config.renderData.atlas.sheet.tileSize / 2;
				inWater = true;
			} else {
				heightOffsetModifier = 0;
				inWater = false;
			}
			
			flipValue *= 2;
			
			velocity.set(0, 0);
		}
		
		handleAnimation(gameSpeed);
		handleWaterRipples();
	}
	
	public void handleAnimation(int gameSpeed) {
		if (!isMoving) {
			if (jobs != null) {
				if (jobs.currentJob != null) {
					if (jobs.currentJob.equals(JOBS.IDLE)) {
						animation = ANIMATION_IDLE;
					}
				} else {
					animation = ANIMATION_IDLE;
				}
			} else {
				animation = ANIMATION_IDLE;
			}
		} else {
			// walk up
			if (viewDirection == 0) {
				animation = ANIMATION_WALK_UP;
			// walk down
			} else if (viewDirection == 1) {
				animation = ANIMATION_WALK_DOWN;
			// walk left
			} else if (viewDirection == 2) {
				animation = ANIMATION_WALK_LEFT;
			// walk right
			} else if (viewDirection == 3) {
				animation = ANIMATION_WALK_RIGHT;
			}
		}
		
		animation.update(config.renderData.renderType, gameSpeed);

		xTile = animation.xTile;
		yTile = animation.yTile;
	}
	
	private void handleWaterRipples() {
		if (flipValue == 0) {
			if (!flipChanged) {
				flipChanged = true;
			}
		}
		
		if (inWater) {
			waterDripCount = 0;
					
			if (flipValue == 2) {
				if (flipChanged) {
					int randomX = Misc.randomInteger(-(config.renderData.atlas.sheet.tileSize / 4), (config.renderData.atlas.sheet.tileSize / 4));
					int randomY = Misc.randomInteger(0, (config.renderData.atlas.sheet.tileSize / 4));
					
					new EffectWaterRipples(level, position.x + randomX, position.y + randomY + heightOffsetModifier);
					flipChanged = false;
				}
			}
		} else {
			if (flipValue == 2) {
				if (flipChanged) {
					if (waterDripCount < 5) {
						int randomX = Misc.randomInteger(-(config.renderData.atlas.sheet.tileSize / 4), (config.renderData.atlas.sheet.tileSize / 4));
						int randomY = Misc.randomInteger(0, (config.renderData.atlas.sheet.tileSize / 4));
						
						new EffectWaterRipples(level, position.x + randomX, position.y + randomY + config.renderData.atlas.sheet.tileSize);
						flipChanged = false;
						waterDripCount++;
					}
				}
			}
		}
	}

	private void checkIfInWater(Tile tile) {
		Tile leftCornerTile = level.getTile((int) (collissionBox.minX + position.x) >> config.renderData.atlas.sheet.getShiftOperator(), (int) (collissionBox.maxY + position.y) >> config.renderData.atlas.sheet.getShiftOperator());
		Tile rightCornerTile = level.getTile((int) (collissionBox.maxX + position.x)>> config.renderData.atlas.sheet.getShiftOperator(), (int) (collissionBox.maxY + position.y) >> config.renderData.atlas.sheet.getShiftOperator());
		
		if (leftCornerTile!= null && rightCornerTile != null) {
			if (leftCornerTile.config.equals(Tiles.WATER_CLEAN) && rightCornerTile.config.equals(Tiles.WATER_CLEAN)) {
				isSwimming = true;
			} else {
				isSwimming = false;
			}
		}
	}
	
	public boolean hasCollided(float xa, float ya) {
		for (int x = (int) collissionBox.minX; x < (int) collissionBox.maxX; x++) {
			if (isSolidTile((int) xa, (int) ya, x, (int) collissionBox.minY)) {
				return true;
			}
		}
		
		for (int x = (int) collissionBox.minX; x < (int) collissionBox.maxX; x++) {
			if (isSolidTile((int) xa, (int) ya, x, (int) collissionBox.maxY)) {
				return true;
			}
		}
		
		for (int y = (int) collissionBox.minY; y < (int) collissionBox.maxY; y++) {
			if (isSolidTile((int) xa, (int) ya, (int) collissionBox.minX, y)) {
				return true;
			}
		}
		
		for (int y =(int)  collissionBox.minY; y < (int) collissionBox.maxY; y++) {
			if (isSolidTile((int) xa, (int) ya, (int) collissionBox.maxX, y)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void checkCollissionWithEntities(List<Entity> entityList) {
		isCollidingLeft = false;
		isCollidingRight = false;
		isCollidingUp = false;
		isCollidingDown = false;
		
		for (Entity entity : entityList) {
			if (entity.config.entityType.equals(ENTITYTYPE.OBJECT) || entity.config.entityType.equals(ENTITYTYPE.PREFAB)) {
				if (entity.checkCollission(collissionBox)) {
					isCollidingLeft = entity.collissionBox.intersectsLeft(collissionBox);
					isCollidingRight = entity.collissionBox.intersectsRight(collissionBox);
					isCollidingUp = entity.collissionBox.intersectsUp(collissionBox);
					isCollidingDown = entity.collissionBox.intersectsBottom(collissionBox);
				};
			}
		}
	}

	protected boolean isSolidTile(int xa, int ya, int x, int y) {
		if (level != null && config.renderData.atlas != null) {
			Tile lastTile = level.getTile(((int) position.x + (int) x) >> config.renderData.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y) >> config.renderData.atlas.sheet.getShiftOperator());
			Tile newTile = level.getTile(((int) position.x + (int) x + xa) >> config.renderData.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y + ya * 2) >> config.renderData.atlas.sheet.getShiftOperator());
			
			if (lastTile != null && newTile != null) {
				if (!lastTile.equals(newTile) && newTile.isSolid || newTile.hasCollission) {
					return true;
				} else {
					return false;
				}
			}
		}

		return true;
	}
	
	protected Tile getTile(int x, int y) {
		return level.getTile(((int) position.x + (int) x) >> config.renderData.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y) >> config.renderData.atlas.sheet.getShiftOperator());
	}
	
	protected Entity getEntity(int x, int y) {
		return level.getEntity(x, y);
	}
	
	public String getName() {
		return name;
	}
}
