package engine.entities.objects;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
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
		
		if (bluePrint.collission) {
			for (int x = (int) collissionBox.minX; x < (int) collissionBox.maxX; x++) {
				for (int y = (int) collissionBox.minY; y < (int) collissionBox.maxY; y++) {
					Tile tile = level.getTile((int) position.x + x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y + y>> bluePrint.atlas.sheet.getShiftOperator());
					
					if (tile != null) {
						if (!tile.hasCollission) {
							tile.hasCollission = true;
						}
					}
				}
			}
		}
	}
}
