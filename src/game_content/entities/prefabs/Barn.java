package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class Barn extends Prefab {

	public Barn(EntityConfig blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		collissionOffset = 12;
		
		collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 2.5f) + collissionOffset);
		collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset);
		collissionBox.minY = (int) (collissionOffset / 2.0f);
		collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset / 2.0f);
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
