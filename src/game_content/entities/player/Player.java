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

		ANIMATION_IDLE = new Animation(0, 8, 500, 2);
		ANIMATION_WALK_UP = new Animation(0, 2, 100, 8);
		ANIMATION_WALK_DOWN = new Animation(0, 0, 100, 8);
		ANIMATION_WALK_LEFT = new Animation(0, 6, 100, 8);
		ANIMATION_WALK_RIGHT =  new Animation(0, 4, 100, 8);
		
		//ANIMATION_IDLE_DOWN = new Animation(0, 8, 100, 2);
		//ANIMATION_IDLE_UP = new Animation(0, 10, 100, 2);
		//ANIMATION_IDLE_RIGHT = new Animation(0, 12, 100, 2);
		//ANIMATION_IDLE_LEFT = new Animation(0, 14, 100, 2);
		
		//ANIMATION_WALK_DOWN = new Animation(0, 0, 100, 8);
		//ANIMATION_WALK_UP = new Animation(0, 2, 100, 8);
		//ANIMATION_WALK_RIGHT =  new Animation(0, 4, 100, 8);
		//ANIMATION_WALK_LEFT = new Animation(0, 6, 100, 8);
		
		//ANIMATION_JUMP_DOWN = new Animation(0, 8, 100, 5);
		//ANIMATION_JUMP_UP = new Animation(0, 10, 100, 5);
		//ANIMATION_JUMP_RIGHT = new Animation(0, 12, 100, 5);
		//ANIMATION_JUMP_LEFT = new Animation(0, 14, 100, 5);
		
		//ANIMATION_CARRY_DOWN = new Animation(0, 16, 100, 5);
		//ANIMATION_CARRY_UP = new Animation(0, 18, 100, 5);
		//ANIMATION_CARRY_RIGHT = new Animation(0, 20, 100, 5);
		//ANIMATION_CARRY_LEFT = new Animation(0, 22, 100, 5);
		
		//ANIMATION_CARRY_WALK_DOWN = new Animation(0, 24, 100, 8);
		//ANIMATION_CARRY_WALK_UP = new Animation(0, 26, 100, 8);
		//ANIMATION_CARRY_WALK_RIGHT =  new Animation(0, 28, 100, 8);
		//ANIMATION_CARRY_WALK_LEFT = new Animation(0, 30, 100, 8);
		
		//ANIMATION_FIGHT_DOWN = new Animation(0, 32, 100, 4);
		//ANIMATION_FIGHT_UP = new Animation(0, 34, 100, 4);
		//ANIMATION_FIGHT_RIGHT = new Animation(0, 36, 100, 4);
		//ANIMATION_FIGHT_LEFT = new Animation(0, 38, 100, 4);
		
		//ANIMATION_BLOCK_DOWN = new Animation(0, 40, 100, 1);
		//ANIMATION_BLOCK_UP = new Animation(0, 42, 100, 1);
		//ANIMATION_BLOCK_RIGHT = new Animation(0, 44, 100, 1);
		//ANIMATION_BLOCK_LEFT = new Animation(0, 46, 100, 1);
		
		//ANIMATION_SIT_DOWN = new Animation(0, 48, 100, 1);
		//ANIMATION_SIT_UP = new Animation(0, 50, 100, 1);
		//ANIMATION_SIT_RIGHT = new Animation(0, 52, 100, 1);
		//ANIMATION_SIT_LEFT = new Animation(0, 54, 100, 1);
		
		//ANIMATION_DIE = new Animation(0, 56, 2000, 2);
		
		//ANIMATION_PICKAXE_DOWN = new Animation(0, 58, 100, 5);
		//ANIMATION_PICKAXE_UP = new Animation(0, 60, 100, 5);
		//ANIMATION_PICKAXE_RIGHT = new Animation(0, 62, 100, 5);
		//ANIMATION_PICKAXE_LEFT = new Animation(0, 64, 100, 5);
		
		//ANIMATION_AXE_DOWN = new Animation(0, 66, 100, 5);
		//ANIMATION_AXE_UP = new Animation(0, 68, 100, 5);
		//ANIMATION_AXE_RIGHT = new Animation(0, 70, 100, 5);
		//ANIMATION_AXE_LEFT = new Animation(0, 72, 100, 5);
		
		//ANIMATION_WATER_DOWN = new Animation(0, 74, 100, 2);
		//ANIMATION_WATER_UP = new Animation(0, 76, 100, 2);
		//ANIMATION_WATER_RIGHT = new Animation(0, 78, 100, 2);
		//ANIMATION_WATER_LEFT = new Animation(0, 80, 100, 2);
		
		//ANIMATION_CROP_DOWN = new Animation(0, 82, 100, 5);
		//ANIMATION_CROP_UP = new Animation(0, 84, 100, 5);
		//ANIMATION_CROP_RIGHT = new Animation(0, 86, 100, 5);
		//ANIMATION_CROP_LEFT = new Animation(0, 88, 100, 5);
		
		//ANIMATION_FISHING_DOWN = new Animation(0, 90, 100, 5);
		//ANIMATION_FISHING_UP = new Animation(0, 92, 100, 5);
		//ANIMATION_FISHING_RIGHT = new Animation(0, 94, 100, 5);
		//ANIMATION_FISHING_LEFT = new Animation(0, 96, 100, 5);
		
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
