package engine.entities.effects;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.input.InputHandler;
import engine.level.Level;

public class Effect extends Entity {

	private boolean endless;
	private int duration;
	private boolean alive;
	
	private long lastTick;
	
	public Effect(EntityConfig config,Level level, float x, float y, boolean endless, int duration) {
		super(config, level, x, y);

		collissionBox.minX = -1;
		collissionBox.maxX = 1;
		collissionBox.minY = -1;
		collissionBox.maxY = 1;
		
		saveToMap = false;
		
		this.endless = endless;
		this.duration = duration;
		
		alive = true;
		lastTick = System.currentTimeMillis();

		level.addEntity(this);
	}
	
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (!endless) {
			long currentTick = System.currentTimeMillis();
			int currentDuration = duration / gameSpeed;
			
			if (lastTick + currentDuration < currentTick) {
				alive = false;
				level.removeEntity(this);
			}	
		}
		
		if (velocity.x != 0 || velocity.y != 0) {
			position.add(velocity);
		}
	}

	public boolean isEndless() {
		return endless;
	}

	public void setEndless(boolean endless) {
		this.endless = endless;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
