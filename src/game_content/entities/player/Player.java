package game_content.entities.player;

import java.awt.Color;

import engine.animation.Animation;
import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCHuman;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.effects.EffectSmokePuffGrey;
import game_content.resources.Clothes;

public class Player extends NPCHuman {
	
	public Player(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);

		ANIMATION_IDLE = new Animation(0, 8, 1000, 2);
		ANIMATION_WALK_UP = new Animation(0, 2, 100, 8);
		ANIMATION_WALK_DOWN = new Animation(0, 0, 100, 8);
		ANIMATION_WALK_LEFT = new Animation(0, 6, 100, 8);
		ANIMATION_WALK_RIGHT =  new Animation(0, 4, 100, 8);
		
		
		//ANIMATION_DEAD = new Animation(0, 56, 100, 2);

		debugColor = Color.RED;
		animSpeed = 2;
		
		//hatSlot.set(Clothes.HAT_COWBOY);
		hairSlot.set(Clothes.HAIR_BOB_PINK);
		eyeSlot.set(Clothes.EYES_08);
		mouthSlot.set(Clothes.MOUTH_01);
		bodySlot.set(Clothes.PULLOVER_PINK);
		legSlot.set(Clothes.PANT_LILA);
		feetSlot.set(Clothes.SHOES_RED);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		handleInputs(input, gameSpeed);
		
		//System.err.println("Player speed: " + speed);
	}

	private void handleInputs(InputHandler input, int gameSpeed) {
		if (input.playerUp.isPressed()) velocity.add(0, -speed);
		if (input.playerDown.isPressed()) velocity.add(0, speed);
		if (input.playerLeft.isPressed()) velocity.add(-speed, 0);
		if (input.playerRight.isPressed()) velocity.add(speed, 0);
		
		if (input.lshift.isPressed() && isMoving) {
			if (!isSprinting) {
				isSprinting = true;
				new EffectSmokePuffGrey(level, position.x, position.y + bluePrint.atlas.sheet.tileSize);
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
}
