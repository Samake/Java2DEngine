package game_content.entities.objects;

import engine.entities.EntityBluePrint;
import engine.entities.objects.ObjectStatic;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Vector2f;
import game_editor.input.ClickSystemEditor;

public class FenceDoor extends ObjectStatic {
	
	private Tile placingTile = null;
	private Vector2f placePosition = new Vector2f();
	
	public FenceDoor(EntityBluePrint bluePrint, Level level, float x, float y) {
		super(bluePrint, level, x, y);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2);
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2);
			collissionBox.minY = (bluePrint.atlas.sheet.tileSize * 2);
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 3) - collissionOffset;
		}
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

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
		
		initPlacePosition();
	}

	private void calculatePlacePosition() {
		if (level != null && bluePrint.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placePosition.x = (int) (currentTile.x << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				
				if (placingTile == null) {
					placingTile = currentTile;
					
					if (!placingTile.equals(currentTile)) {
						placingTile = currentTile;

						position.x = placePosition.x;
						position.y = placePosition.y;

					}
				}
				
				level.markTile(currentTile);
			}
		}
	}
	
	private void initPlacePosition() {
		if (level != null && bluePrint.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placingTile = currentTile;
				
				placePosition.x = (int) (currentTile.x << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				
				position.x = placePosition.x;
				position.y = placePosition.y;
				
				level.markTile(currentTile);
			}
		}
	}
}
