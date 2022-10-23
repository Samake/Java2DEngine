package game_content.entities.prefabs.farming;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.entities.effects.EffectSmokePuffWhite;
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
	public boolean cropped = false;
	
	private int colNormalMinX = 0;
	private int colNormalMaxX = 0;
	private int colNormalMinY = 0;
	private int colNormalMaxY = 0;
	
	private int colCroppedMinX = 0;
	private int colCroppedMaxX = 0;
	private int colCroppedMinY = 0;
	private int colCroppedMaxY = 0;
	
	private boolean castShadow = true;

	public Seed(EntityConfig config, Level level, int x, int y, int baseGrowSpeed) {
		super(config, level, x, y);
		
		collissionOffset = 4;
		
		colNormalMinX = (-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset;
		colNormalMaxX = (config.renderData.atlas.sheet.tileSize / 2) - collissionOffset;
		colNormalMinY = (-config.renderData.atlas.sheet.tileSize / 2);
		colNormalMaxY = (config.renderData.atlas.sheet.tileSize / 2) - collissionOffset;
		
		collissionBox.minX = colNormalMinX;
		collissionBox.maxX = colNormalMaxX;
		collissionBox.minY = colNormalMinY;
		collissionBox.maxY = colNormalMaxY;
		
		initPlacePosition();
		
		this.baseGrowSpeed = baseGrowSpeed;
		growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
		growState = 0;
		cropped = false;
		castShadow = config.renderData.castShadow;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (growState == 0 || cropped) {
			config.renderData.castShadow = false;
			
			collissionBox.minX = colCroppedMinX;
			collissionBox.maxX = colCroppedMaxX;
			collissionBox.minY = colCroppedMinY;
			collissionBox.maxY = colCroppedMaxY;
		} else {
			config.renderData.castShadow = castShadow;
			
			collissionBox.minX = colNormalMinX;
			collissionBox.maxX = colNormalMaxX;
			collissionBox.minY = colNormalMinY;
			collissionBox.maxY = colNormalMaxY;
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
				
				if (!placingTile.hasCollission) {
					placingTile.hasCollission = true;
				}
				
				if (!placingTile.config.equals(Tiles.EARTH_CLEAN)) {
					currentGrowDelay = growDelay * 9999999;
					
					if (placingTile.config.equals(Tiles.GRASS_CLEAN) || placingTile.config.equals(Tiles.GRASS_LUSH_01) || placingTile.config.equals(Tiles.GRASS_LUSH_02) || placingTile.config.equals(Tiles.GRASS_LUSH_03)) {
						currentGrowDelay = growDelay * 5;
					}
				}
				
				int finalGrowDelay =  currentGrowDelay / gameSpeed;
				
				if (growState < 5) {
					if (lastTimeStamp + finalGrowDelay < System.currentTimeMillis()) {
						growState++;
						lastTimeStamp = System.currentTimeMillis();
						growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
					}
				}
				
				xTile = growState;
				
				if (cropped) {
					xTile = 6;
					if (lastTimeStamp + finalGrowDelay < System.currentTimeMillis()) {
						reset();
					}
				}
			} else {
				placingTile = level.getTile((int) position.x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y >> config.renderData.atlas.sheet.getShiftOperator());
			}
		}
	}
	
	private void reset() {
		if (cropped) {
			cropped = false;
			growState = 0;
			
			lastTimeStamp = System.currentTimeMillis();
			growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
		}
	}
	
	public void crop() {
		if (!cropped) {
			cropped = true;
			lastTimeStamp = System.currentTimeMillis();
			growDelay = Misc.randomInteger(baseGrowSpeed, baseGrowSpeed * 5);
			
			new EffectSmokePuffWhite(level, position.x, position.y + 4);
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
		if (level != null && config.renderData.atlas != null) {
			Tile currentTile = level.getTile((int) position.x >> config.renderData.atlas.sheet.getShiftOperator(), (int) position.y >> config.renderData.atlas.sheet.getShiftOperator());
		
			if (currentTile != null) {
				placingTile = currentTile;
				
				placePosition.x = (int) (currentTile.x << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				placePosition.y = (int) (currentTile.y << config.renderData.atlas.sheet.getShiftOperator()) + (config.renderData.atlas.sheet.tileSize / 2);
				
				position.x = placePosition.x;
				position.y = placePosition.y;
			}
		}
	}
	
	@Override
	public void cleanUp() {
		
	}
}
