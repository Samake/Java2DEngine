package engine.entities.objects;

import java.awt.Color;

import engine.collission.CollissionBox;
import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class ObjectPhysical extends Prefab {
	
	private boolean ready = true;
	private int duration = 500;
	private long lastTick;
	
	protected boolean isCollidingLeft = false;
	protected boolean isCollidingRight = false;
	protected boolean isCollidingUp = false;
	protected boolean isCollidingDown = false;
	
	protected float xPower = 0.0f;
	protected float yPower = 0.0f;
	
	public ObjectPhysical(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
		
		lastTick = System.currentTimeMillis();
		
		debugColor = Color.GREEN;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		int currentDuration = duration / gameSpeed;
		
		if (player != null) {
			if (player.collissionBox != null && player.config.collission) {
				if (checkCollission(player.collissionBox)) {
					if (ready) {
						doAction(player.collissionBox);
						
						ready = false;
						lastTick = System.currentTimeMillis();
					}
				};
			}
		}
		
		if (!ready) {
			if (lastTick + currentDuration < System.currentTimeMillis()) {
				ready = true;
			}	
		}
	}

	public void doAction(CollissionBox otherBox) {
		isCollidingLeft = false;
		isCollidingRight = false;
		isCollidingUp = false;
		isCollidingDown = false;
		
		if (otherBox.position.x < collissionBox.position.x) {
			isCollidingLeft = true;
		} else {
			isCollidingRight = true;
		}
		
		if (otherBox.position.y < collissionBox.position.y) {
			isCollidingUp = true;
		} else {
			isCollidingDown = true;
		}
		
		double xValueDiff = Math.abs(otherBox.position.x - collissionBox.position.x);
		double yValueDiff = Math.abs(otherBox.position.y - collissionBox.position.y);
		
		double xValue = (1.0 / Math.max(xValueDiff, yValueDiff)) * xValueDiff;
		double yValue = (1.0 / Math.max(xValueDiff, yValueDiff)) * yValueDiff;
		
		xPower = (float) xValue;
		yPower = (float) yValue;
	}
}
