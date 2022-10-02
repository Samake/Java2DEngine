package game_content.entities.prefabs;

import engine.entities.EntityBluePrint;
import engine.entities.collision.CollissionBox;
import engine.entities.objects.ObjectPhysical;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.effects.EffectSmokePuffGrey;

public class Ball extends ObjectPhysical {
	
	private float xAxisValue = 0;
	private float yAxisValue = 0;
	
	private float shootPower = 2.5f;
	private float frictionValue = 1.035f;
	
	private boolean isMoving = false;
	
	private float basisScale = 1.0f;
	private float moveSpeed = 0.0f;

	public Ball(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		if (xAxisValue != 0 || yAxisValue != 0) {
			velocity.x = xAxisValue * gameSpeed;
			velocity.y = yAxisValue * gameSpeed;
			
			position.add(velocity);
			
			isMoving = true;
		} else {
			isMoving = false;
		}
		
		moveSpeed = Math.abs((xAxisValue + yAxisValue) / 2);
		scale = (float) (basisScale + (Math.sin(moveSpeed) / 2.0f));
		
		xAxisValue /= frictionValue * gameSpeed;
		yAxisValue /= frictionValue * gameSpeed;
		
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
		
		EffectSmokePuffGrey effect = new EffectSmokePuffGrey(level, position.x, position.y);
		effect.velocity.x = (float) (xAxisValue * 0.35);
		effect.velocity.y = (float) (yAxisValue * 0.35);
	}
	
	@Override
	public void cleanUp() {
		
	}
}
