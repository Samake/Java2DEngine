package game_content.entities.prefabs;

import engine.entities.EntityBluePrint;
import engine.entities.collision.CollissionBox;
import engine.entities.objects.ObjectPhysical;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.effects.EffectSmokePuff01;

public class Ball extends ObjectPhysical {
	
	private float xAxisValue = 0;
	private float yAxisValue = 0;
	
	private float shootPower = 2.5f;
	private float frictionValue = 1.035f;
	
	private boolean isMoving = false;

	public Ball(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
	}

	@Override
	public void update(InputHandler input) {
		super.update(input);

		if (xAxisValue != 0 || yAxisValue != 0) {
			velocity.x = xAxisValue;
			velocity.y = yAxisValue;
			
			position.add(velocity);
			
			isMoving = true;
		} else {
			isMoving = false;
		}
		
		//scale += 0.01f;
		//System.err.println(scale);
		
		xAxisValue /= frictionValue;
		yAxisValue /= frictionValue;
		
		if (Math.abs(xAxisValue) < 0.01) {
			xAxisValue = 0;
		}
		
		if (Math.abs(yAxisValue) < 0.01) {
			yAxisValue = 0;
		}
		
		if (isMoving) {

		}
	}
	
	@Override
	public void doAction(CollissionBox otherBox) {
		super.doAction(otherBox);
		
		if (isCollidingLeft) {
			xAxisValue = shootPower * xPower;
		}
		
		if (isCollidingRight) {
			xAxisValue = -shootPower * xPower;
		}
		
		if (isCollidingUp) {
			yAxisValue = shootPower * yPower;
		}
		
		if (isCollidingDown) {
			yAxisValue = -shootPower * yPower;
		}
		
		EffectSmokePuff01 effect = new EffectSmokePuff01(level, position.x, position.y);
		effect.velocity.x = (float) (xAxisValue * 0.35);
		effect.velocity.y = (float) (yAxisValue * 0.35);
	}
	
	@Override
	public void cleanUp() {
		
	}
}
