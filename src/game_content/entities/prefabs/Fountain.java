package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class Fountain extends Prefab {


	public Fountain(EntityConfig blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		collissionOffset = 8;
		
		collissionBox.minX = (-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset;
		collissionBox.maxX = (config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset;
		collissionBox.minY = collissionOffset;
		collissionBox.maxY = (config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		if (player != null) {
			if (player.collissionBox != null) {
				if (checkCollission(player.collissionBox)) {

				};
			}
		}
		
	}
	
	@Override
	public void cleanUp() {
		
	}
}
