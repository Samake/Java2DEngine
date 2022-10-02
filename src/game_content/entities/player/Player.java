package game_content.entities.player;

import java.awt.Color;

import engine.animation.Animation;
import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCCore;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.effects.EffectSmokePuffGrey;

public class Player extends NPCCore {
	
	public Player(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Test", x, y, speed, false);
		
		ANIMATION_IDLE = new Animation(16, 0, 100, 2);
		ANIMATION_WALK_UP = new Animation(0, 0, 100, 2);
		ANIMATION_WALK_DOWN = new Animation(4, 0, 100, 2);
		ANIMATION_WALK_LEFT = new Animation(8, 0, 100, 2);
		ANIMATION_WALK_RIGHT = new Animation(12, 0, 100, 2);

		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + collissionOffset;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - collissionOffset;
			collissionBox.minY = collissionOffset;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - collissionOffset;
		}

		debugColor = Color.RED;
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
