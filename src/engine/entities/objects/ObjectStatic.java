package engine.entities.objects;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class ObjectStatic extends Entity {

	public ObjectStatic(EntityBluePrint bluePrint, Level level, float x, float y) {
		super(bluePrint, level, x, y);
		
		debugColor = Color.GREEN;
	}

	@Override
	public void update(InputHandler input) {
		super.update(input);
		
		Player player = level.getPlayer();

		if (player != null) {
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
//					velocity.x = player.velocity.x / 2;
//					velocity.y = player.velocity.y / 2;
//					position.add(velocity);
				};
			}
		}
	}
}
