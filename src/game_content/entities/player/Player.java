package game_content.entities.player;

import java.awt.Color;

import engine.animation.Animation;
import engine.entities.EntityConfig;
import engine.entities.npc.NPCHuman;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Vector2f;
import game_content.entities.effects.EffectSmokePuffGrey;
import testgame.input.ClickSystem;

public class Player extends NPCHuman {
	
	private Vector2f directionVector = new Vector2f();
	
	public Player(EntityConfig config, Level level, float x, float y, float speed) {
		super(config, level, x, y, speed);

		ANIMATION_IDLE = new Animation(0, 0, 1000, 2);
		ANIMATION_WALK_UP = new Animation(0, 2, 100, 8);
		ANIMATION_WALK_DOWN = new Animation(0, 0, 100, 8);
		ANIMATION_WALK_LEFT = new Animation(0, 6, 100, 8);
		ANIMATION_WALK_RIGHT =  new Animation(0, 4, 100, 8);
		
		
		//ANIMATION_DEAD = new Animation(0, 56, 100, 2);

		debugColor = Color.RED;
		animSpeed = 2;
		
//		hatSlot.set(null);
//		hairSlot.set(Clothes.HAIR_BOB_BRUNETTE);
//		eyeSlot.set(Clothes.EYES_01);
//		mouthSlot.set(Clothes.MOUTH_01);
//		earSlot.set(null);
//		beardSlot.set(null);
//		accessoiresSlot.set(null);
//		bodySlot.set(Clothes.PULLOVER_BLACK);
//		legSlot.set(Clothes.PANT_BLACK);
//		feetSlot.set(Clothes.SHOES_BLACK);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		handleDirection();
		handleInputs(input, gameSpeed);
		
		//System.err.println("Player speed: " + speed);
	}

	private void handleInputs(InputHandler input, int gameSpeed) {
		if (input.moveForward.isPressed()) velocity.add(0, -speed);
		if (input.moveBack.isPressed()) velocity.add(0, speed);
		if (input.moveLeft.isPressed()) velocity.add(-speed, 0);
		if (input.moveRight.isPressed()) velocity.add(speed, 0);
		
//		if (input.moveForward.isPressed()) velocity.set(directionVelocity.x, directionVelocity.y);
//		if (input.moveBack.isPressed()) velocity.set(-directionVelocity.x, -directionVelocity.y);
//		if (input.moveLeft.isPressed()) velocity.set(directionVelocity.y, -directionVelocity.x);
//		if (input.moveRight.isPressed()) velocity.set(-directionVelocity.y, directionVelocity.x);
		
		if (input.lshift.isPressed() && isMoving) {
			if (!isSprinting) {
				isSprinting = true;
				new EffectSmokePuffGrey(level, position.x, position.y + config.renderData.atlas.sheet.tileSize);
			}
		} else {
			isSprinting = false;
		}
		
		if (input.lctrl.isPressed() && isMoving) {
			isSneaking = true;
		} else {
			isSneaking = false;
		}
	}
	
	public void handleDirection() {
		float xValueDiff = position.x - ClickSystem.worldPosition.x;
		float yValueDiff = position.y - ClickSystem.worldPosition.y;
		float length = (float) Math.sqrt(xValueDiff * xValueDiff + yValueDiff * yValueDiff);
		xValueDiff /= length;
		yValueDiff /= length;
		
		directionVector.set(-xValueDiff, -yValueDiff);
	}
	
	@Override
	public void handleViewDirection() {
		float xValue = Math.abs(directionVector.x);
		float yValue = Math.abs(directionVector.y);
		
		if (yValue >= xValue) {
			if (directionVector.y < 0) {
				viewDirection = 0;
			}
			
			if (directionVector.y > 0) {
				viewDirection = 1;
			}
		} else {
			if (directionVector.x < 0) {
				viewDirection = 2;
			}
			
			if (directionVector.x > 0) {
				viewDirection = 3;
			}
		}
	};
}
