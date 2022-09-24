package engine.entities.effects;

import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class Effect extends Entity {

	private boolean endless;
	private int duration;
	private boolean alive;
	
	private long lastTick;
	
	public Effect(EntityBluePrint bluePrint, Level level, float x, float y, boolean endless, int duration) {
		super(bluePrint, level, x, y);

		saveToMap = false;
		
		this.endless = endless;
		this.duration = duration;
		
		alive = true;
		lastTick = System.currentTimeMillis();
		
		if (collissionBox != null) {
			collissionBox.minX = -1;
			collissionBox.maxX = 1;
			collissionBox.minY = -1;
			collissionBox.maxY = 1;
		}
		
		level.addEntity(this);
	}
	
	public void update(InputHandler input) {
		super.update(input);
		
		if (!endless) {
			long currentTick = System.currentTimeMillis();
			
			if (lastTick + duration < currentTick) {
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
