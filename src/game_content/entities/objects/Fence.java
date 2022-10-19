package game_content.entities.objects;

import engine.entities.EntityConfig;
import engine.entities.objects.ObjectStatic;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Vector2f;
import game_editor.input.ClickSystemEditor;

public class Fence extends ObjectStatic {
	
	private Tile placingTile = null;
	private Vector2f placePosition = new Vector2f();
	
	public Fence(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
		
		collissionOffset = 1;
		
		if (collissionBox != null) {
			collissionBox.minX = (-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset;
			collissionBox.maxX = (config.renderData.atlas.sheet.tileSize / 2) - collissionOffset;
			collissionBox.minY = (-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset;
			collissionBox.maxY = (config.renderData.atlas.sheet.tileSize  / 2) - collissionOffset;
		}
		
		initPlacePosition();
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		if (ClickSystemEditor.pickedEntity != null && ClickSystemEditor.pickedEntity.equals(this)) {
			calculatePlacePosition();
		} else {
			if (placingTile != null) {
				level.deMarkTiles();
				placingTile = null;
				position.x = placePosition.x;
				position.y = placePosition.y;
			}
		}
	}

	private void calculatePlacePosition() {
		if (level != null && config.renderData.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y >> config.renderData.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placePosition.x = (int) (currentTile.x << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				
				if (placingTile == null) {
					placingTile = currentTile;
					
					if (!placingTile.equals(currentTile)) {
						placingTile = currentTile;

						position.x = placePosition.x;
						position.y = placePosition.y;

						level.markTile(currentTile);
					}
				}
			}
		}
	}
	
	private void initPlacePosition() {
		if (level != null && config.renderData.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y >> config.renderData.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placingTile = currentTile;
				
				placePosition.x = (int) (currentTile.x << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				
				position.x = placePosition.x;
				position.y = placePosition.y;
				
				level.markTile(currentTile);
			}
		}
	}
}
