package engine.entities.objects;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import game_content.entities.player.Player;

public class ObjectStatic extends Entity {

	public ObjectStatic(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
		
		debugColor = Color.GREEN;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.player;

		if (player != null) {
			if (player.collissionBox != null && player.config.collission) {

			}
		}
		
		if (config.collission) {
			for (int x = (int) collissionBox.minX; x < (int) collissionBox.maxX; x++) {
				for (int y = (int) collissionBox.minY; y < (int) collissionBox.maxY; y++) {
					Tile tile = level.getTile((int) position.x + x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y + y >> config.renderData.atlas.sheet.getShiftOperator());
					
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
