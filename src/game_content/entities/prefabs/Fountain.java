package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class Fountain extends Prefab {


	public Fountain(EntityConfig blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		collissionOffset = 8;
		
		collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset);
		collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
		collissionBox.minY = (int) (collissionOffset);
		collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
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
