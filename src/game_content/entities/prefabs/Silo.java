package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class Silo extends Prefab {

	public Silo(EntityConfig blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		collissionOffset = 10;
		
		collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset);
		collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
		collissionBox.minY = (int) (collissionOffset * 2);
		collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset / 2);
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();

	}
}
