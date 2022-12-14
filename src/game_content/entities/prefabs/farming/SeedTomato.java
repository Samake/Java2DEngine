package game_content.entities.prefabs.farming;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Canvas;
import engine.utils.Misc;
import game_content.resources.Objects;
import game_editor.Editor;
import testgame.input.ClickSystem;

public class SeedTomato extends Seed {


	public SeedTomato(EntityConfig blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y, 3500);

	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (!Editor.isEditor) {
			if (player != null) {
				if (Canvas.isOnScreen(position.x, position.y, 16)) {
					double distance = Misc.getDistance(position, player.position);
					
					if (distance <= 48) {
						Entity entity = ClickSystem.selectPrefab(input, level);
						
						if (entity != null) {
							if (entity.equals(this)) {
								if (input.lmouse.isClicked()) {
									if (!cropped && growState == 5) {
										crop();

										int randomizer = Misc.randomInteger(1, 3);
										
										for (int i = 0; i < randomizer; i++) {
											int x = Misc.randomInteger(-8, 8);
											int y = Misc.randomInteger(-8, 0);
											
											Objects.addInstanceToLevel(Objects.ITEM_TOMATO, level, (int) position.x + x, (int) position.y + y);
										}
									}
								}
							}
						}
					}
					
//					if (player.collissionBox != null) {
//						if (checkCollission(player.collissionBox)) {
//
//						};
//					}
				}
			}
		}
	}

	
	@Override
	public void cleanUp() {
		
	}
}
