package engine.entities.npc;

import java.awt.Color;
import java.util.List;

import engine.animation.Animation;
import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import engine.pathfinding.Pathfinder;
import engine.tiles.Tile;
import game_content.resources.Tiles;

public class NPCCore extends Entity {

	public String name;
	public float scale = 1.0f;
	public float maxSpeed = 0;
	public float speed;
	
	public int animValue = 0;
	public int numSteps = 0;
	
	public int movingDir = 1;
	
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
	
	public Animation animation;
	public int animationSpeed = 2;
	
	public Pathfinder pathfinder;
	public NPCJobs jobs;
	
	public NPCCore(EntityBluePrint bluePrint, Level level, String name, float x, float y, float speed) {
		super(bluePrint, level, x, y);
		
		this.name = name;
		this.speed = speed;
		this.maxSpeed = speed;
		
		debugColor = Color.BLUE;
		
		pathfinder = new Pathfinder(level);
	}

	public void move() {
		if (!level.editorMode) {
			if (!hasCollided(velocity.x, velocity.y)) {
				if (velocity.y < 0) {
					movingDir = 0;
					
					if (isCollidingUp) {
						velocity.y = 0;
						velocity.x = collidingVelocity.x;
					}
				}
				
				if (velocity.y > 0) {
					movingDir = 1;
					
					if (isCollidingDown) {
						velocity.y = 0;
						velocity.x = collidingVelocity.x;
					}
				}
				
				if (velocity.x < 0) {
					movingDir = 2;
					
					if (isCollidingLeft) {
						velocity.x = 0;
						velocity.y = collidingVelocity.y;
					}
				}
				
				if (velocity.x > 0) {
					movingDir = 3;
					
					if (isCollidingRight) {
						velocity.x = 0;
						velocity.y = collidingVelocity.y;
					}
				}
				
				position.add(velocity);
				numSteps++;
				return;
			}
		}
	};
	
	@Override
	public void update(InputHandler input) {
		super.update(input);
		
		if (!level.editorMode) {
			if (jobs != null) {
				jobs.update();
			}
		
			animValue = (animValue + 1)%100;
			
			if (level != null && bluePrint.atlas != null) {
				Tile tile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
				
				if (tile != null) {
					speed = maxSpeed * tile.hesitation;
					
					checkIfInWater(tile);
				} else {
					speed = maxSpeed;
				}
			}
			
			if (velocity.x != 0 || velocity.y != 0) {
				move();
				isMoving = true;
			} else {
				isMoving = false;
			}
			
			if (isMoving) {
				speed = maxSpeed;
			}
			
			if (isSprinting) {
				speed = maxSpeed * 1.25f;
			}
			
			if (isSneaking) {
				speed = maxSpeed * 0.75f;
			}
			
			float animSpeed = 3.0f;
			float walkingSpeed = animSpeed / ((speed * animSpeed) / (maxSpeed * animSpeed));
			flipValue = (numSteps >> (int) walkingSpeed) & 1;
			
			if (isSwimming) {
				flipValue = (animValue >> (int) animationSpeed * animationSpeed) & 1;
				heightOffsetModifier = bluePrint.atlas.sheet.tileSize / 2;
				inWater = true;
			} else {
				heightOffsetModifier = 0;
				inWater = false;
			}
				
			if (!isMoving && !isSwimming) {
				flipValue = (animValue >> (int) animationSpeed * 3) & 1;
			}
			
			flipValue *= 2;
			
			velocity.set(0, 0);
		}
	}

	private void checkIfInWater(Tile tile) {
		Tile leftCornerTile = level.getTile((int) (collissionBox.minX + position.x) >> bluePrint.atlas.sheet.getShiftOperator(), (int) (collissionBox.maxY + position.y) >> bluePrint.atlas.sheet.getShiftOperator());
		Tile rightCornerTile = level.getTile((int) (collissionBox.maxX + position.x)>> bluePrint.atlas.sheet.getShiftOperator(), (int) (int) (collissionBox.maxY + position.y) >> bluePrint.atlas.sheet.getShiftOperator());
		
		if (leftCornerTile!= null && rightCornerTile != null) {
			if (leftCornerTile.bluePrint.equals(Tiles.WATER_CLEAN) && rightCornerTile.bluePrint.equals(Tiles.WATER_CLEAN)) {
				isSwimming = true;
				speed = maxSpeed / 2;
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
			if (entity.bluePrint.entityType.equals(ENTITYTYPE.OBJECT) || entity.bluePrint.entityType.equals(ENTITYTYPE.PREFAB)) {
				if (entity.checkCollission(collissionBox)) {
					isCollidingLeft = entity.collissionBox.isCollidingLeft(collissionBox);
					isCollidingRight = entity.collissionBox.isCollidingRight(collissionBox);
					isCollidingUp = entity.collissionBox.isCollidingUp(collissionBox);
					isCollidingDown = entity.collissionBox.isCollidingDown(collissionBox);
					
					if (isCollidingLeft || isCollidingRight || isCollidingUp || isCollidingDown) {
						collidingVelocity.x = entity.collissionBox.collidingVelocity.x;
						collidingVelocity.y = entity.collissionBox.collidingVelocity.y;
					}
				};
			}
		}
	}

	protected boolean isSolidTile(int xa, int ya, int x, int y) {
		if (level != null && bluePrint.atlas != null) {
			Tile lastTile = level.getTile(((int) position.x + (int) x) >> bluePrint.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y) >> bluePrint.atlas.sheet.getShiftOperator());
			Tile newTile = level.getTile(((int) position.x + (int) x + xa) >> bluePrint.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y + ya) >> bluePrint.atlas.sheet.getShiftOperator());
			
			if (lastTile != null && newTile != null) {
				if (!lastTile.equals(newTile) && newTile.isSolid) {
					return true;
				}
				
				return false;
			}
		}

		return true;
	}
	
	protected Tile getTile(int x, int y) {
		return level.getTile(((int) position.x + (int) x) >> bluePrint.atlas.sheet.getShiftOperator(), ((int) position.y + (int) y) >> bluePrint.atlas.sheet.getShiftOperator());
	}
	
	protected Entity getEntity(int x, int y) {
		return level.getEntity(x, y);
	}
	
	public String getName() {
		return name;
	}
}
