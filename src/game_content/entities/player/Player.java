package game_content.entities.player;

import java.awt.Color;

import engine.animation.Animations;
import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCCore;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.effects.EffectSmokePuff01;

public class Player extends NPCCore {
	
	private int currentFlip = 0;

	public Player(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "Test", x, y, speed);

		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
			collissionBox.minY = (-bluePrint.atlas.sheet.tileSize) + 2;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - 2;
		}

		debugColor = Color.RED;
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);
		
		handleInputs(input);

		if (flipValue != currentFlip) {
			//SoundManager.playSound(SoundFiles.EFFECT_FOOTSTEP_GRASS, 90.0f);
			currentFlip = flipValue;
		}
		
		handleAnimation();
	}
	
	public void handleAnimation() {
		animation = Animations.HUMAN_IDLE;
		
		// idle
		if (!isMoving) {
			animation = Animations.HUMAN_IDLE;
		}
		
		if (isMoving) {
			// walk up
			if (movingDir == 0) {
				animation = Animations.HUMAN_WALK_UP;
			// walk down
			} else if (movingDir == 1) {
				animation = Animations.HUMAN_WALK_DOWN;
			// walk left
			} else if (movingDir == 2) {
				animation = Animations.HUMAN_WALK_LEFT;
			// walk right
			} else if (movingDir == 3) {
				animation = Animations.HUMAN_WALK_RIGHT;
			}
		}
		
		animation.animate(flipValue);
		
		
		xTile = animation.xTile;
		yTile = animation.yTile;
	}

	private void handleInputs(InputHandler input) {
		if (input.playerUp.isPressed()) velocity.add(0, -speed);
		if (input.playerDown.isPressed()) velocity.add(0, speed);
		if (input.playerLeft.isPressed()) velocity.add(-speed, 0);
		if (input.playerRight.isPressed()) velocity.add(speed, 0);
		
		if (input.lshift.isPressed() && isMoving) {
			if (!isSprinting) {
				isSprinting = true;
				new EffectSmokePuff01(level, position.x, position.y + bluePrint.atlas.sheet.tileSize);
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
