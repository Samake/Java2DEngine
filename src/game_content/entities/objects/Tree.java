package game_content.entities.objects;

import engine.entities.EntityConfig;
import engine.entities.objects.ObjectStatic;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class Tree extends ObjectStatic {

	public Tree(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
		
		collissionBox.minX = (-config.renderData.atlas.sheet.tileSize / 2);
		collissionBox.maxX = (config.renderData.atlas.sheet.tileSize / 2);
		collissionBox.minY = (config.renderData.atlas.sheet.tileSize * 2);
		collissionBox.maxY = (config.renderData.atlas.sheet.tileSize * 3) - collissionOffset;
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.player;

		if (player != null) {
			if (player.collissionBox != null && player.config.collission) {
				if (checkCollission(player.collissionBox)) {
					
				}
			}
		}
	}
}
