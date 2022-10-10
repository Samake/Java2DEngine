package game_content.entities.prefabs.farming;

import engine.entities.EntityBluePrint;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.resources.Tiles;
import game_editor.Editor;
import game_editor.input.ClickSystemEditor;

public class Seed extends Prefab {
	
	public Tile placingTile = null;
	private Vector2f placePosition = new Vector2f();
	
	private long lastTimeStamp = System.currentTimeMillis();
	private int baseGrowSpeed = 100000;
	public int growDelay = baseGrowSpeed;
	private int currentGrowDelay = 99999999;
	public int growState = 0;

	public Seed(EntityBluePrint bluePrint, Level level, int x, int y, int baseGrowSpeed) {
		super(bluePrint, level, x, y);
		
		if (bluePrint.renderType.equals(RENDERTYPE.R1X1)) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 5;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 5;
			collissionBox.minY = 0;
			collissionBox.maxY = bluePrint.atlas.sheet.tileSize / 2;
		}
		
		initPlacePosition();
		
		this.baseGrowSpeed = baseGrowSpeed;
		growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
		growState = 0;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (growState == 0) {
			castShadow = false;
		} else {
			castShadow = bluePrint.castShadow;
		}
		
		if (Editor.isEditor) {
			if (ClickSystemEditor.pickedPrefab != null && ClickSystemEditor.pickedPrefab.equals(this)) {
				calculatePlacePosition();
			} else {
				if (placingTile != null) {
					level.deMarkTiles();
					position.x = placePosition.x;
					position.y = placePosition.y;
				}
			}
		} else {
			if (placingTile != null) {	
				currentGrowDelay = growDelay;
				
				if (!placingTile.bluePrint.equals(Tiles.EARTH_CLEAN)) {
					currentGrowDelay = growDelay * 9999999;
					
					if (placingTile.bluePrint.equals(Tiles.GRASS_CLEAN) || placingTile.bluePrint.equals(Tiles.GRASS_LUSH_01) || placingTile.bluePrint.equals(Tiles.GRASS_LUSH_02) || placingTile.bluePrint.equals(Tiles.GRASS_LUSH_03)) {
						currentGrowDelay = growDelay * 5;
					}
				}
				
				int finalGrowDelay =  currentGrowDelay / gameSpeed;
				
				if (growState < 5) {
					if (lastTimeStamp + finalGrowDelay < System.currentTimeMillis()) {
						growState++;
						lastTimeStamp = System.currentTimeMillis();
						growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
						xTile = growState;
					}
				}
			} else {
				placingTile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
			}
		}
	}
	
	private void calculatePlacePosition() {
		if (level != null && bluePrint.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placePosition.x = (int) (currentTile.x << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				
				if (placingTile == null) {
					placingTile = currentTile;
					
					if (placingTile.equals(currentTile)) {
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
		if (level != null && bluePrint.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> bluePrint.atlas.sheet.getShiftOperator(), (int) position.y >> bluePrint.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placingTile = currentTile;
				
				placePosition.x = (int) (currentTile.x << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << bluePrint.atlas.sheet.getShiftOperator()) + (bluePrint.atlas.sheet.tileSize / 2);
				
				position.x = placePosition.x;
				position.y = placePosition.y;
			}
		}
	}
	
	@Override
	public void cleanUp() {
		
	}
}
