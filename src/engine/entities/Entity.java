package engine.entities;

import java.awt.Color;
import java.util.List;

import engine.core.Config;
import engine.entities.collision.CollissionBox;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;
import engine.utils.Vector2f;
import game_content.entities.lights.PointLight;

public class Entity {
	
	public enum ENTITYTYPE {
		OBJECT, PREFAB, LIGHT, DECAL, EFFECT, NPC, PLAYER
	}
	
	public enum RENDERTYPE {
		R1X1, R1X2, R1X3, R2X1, R2X2, R2X3, R3X2, R4X4, R4X6, R6X6
	}
	
	public EntityBluePrint bluePrint;
	public CollissionBox collissionBox = new CollissionBox();
	public Vector2f position = new Vector2f();
	public Vector2f velocity = new Vector2f();
	public Vector2f collidingVelocity = new Vector2f();
	
	public int scale = 1;
	public float xOffset = 0;
	public float yOffset = 0;

	public Level level;
	
	public boolean selected = false;
	
	protected int xTile = 0;
	protected int yTile = 0;
	protected float modifier = 0;
	
	public boolean inWater = false;
	public int heightOffsetModifier = 0;
	
	public Color debugColor = Color.YELLOW;
	public boolean saveToMap = true;
	
	public Entity(EntityBluePrint bluePrint, Level level, float x, float y) {
		this.bluePrint = bluePrint;
		this.level = level;
		this.position.x = x;
		this.position.y = y;
		
		if (collissionBox != null) {
			if (bluePrint.renderType.equals(RENDERTYPE.R1X1)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize / 2) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R1X2)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R1X3)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize * 1.5f) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 1.5f) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R2X2)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R2X3)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize * 1.5f) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 1.5f) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R3X2)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize * 1.5f) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize * 1.5f) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R4X4)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize * 2) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize * 2) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize * 2) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 2) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R4X6)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize * 2) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize * 2) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize * 3) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 3) - 2;
			}
			
			if (bluePrint.renderType.equals(RENDERTYPE.R6X6)) {
				collissionBox.minX = (-bluePrint.atlas.sheet.tileSize * 3) + 2;
				collissionBox.maxX = (bluePrint.atlas.sheet.tileSize * 3) - 2;
				collissionBox.minY = (-bluePrint.atlas.sheet.tileSize * 3) + 2;
				collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 3) - 2;
			}
		}
	}
	
	public void update(InputHandler input) {
		if (collissionBox != null) {
			collissionBox.update(position.x, position.y);
		}
		
		if (bluePrint != null) {
			bluePrint.atlas.update();
		}
	}

	public void render(Screen screen, List<PointLight> renderListLights) {
		modifier = bluePrint.atlas.sheet.tileSize * (int) scale;

		if (bluePrint.renderType.equals(RENDERTYPE.R1X1)) {
			float rows = 1;
			float columns = 1;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = position.y - modifier / 2 + heightOffsetModifier;
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R1X2)) {
			float rows = 1;
			float columns = 2;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R1X3)) {
			float rows = 1;
			float columns = 3;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R2X2)) {
			float rows = 2;
			float columns = 2;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R2X3)) {
			float rows = 2;
			float columns = 3;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R3X2)) {
			float rows = 3;
			float columns = 2;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (bluePrint.renderType.equals(RENDERTYPE.R4X6)) {
			float rows = 4;
			float columns = 6;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
	}

	private void renderEntityPart(Screen screen, List<PointLight> renderListLights, int rows, int columns, float baseXOffset, float baseYOffset) {
		int xTileID = bluePrint.atlas.column;
		int yTileID = bluePrint.atlas.row;
		
		if (bluePrint.castShadow) {
			for (int row = 0; row < rows; row++) {
				for (int column = 0; column < columns; column++) {
					if (!inWater) {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderEntityPartShadow(screen, renderListLights, xTileID, yTileID);
					} else {
						if (column < (columns / 2)) {
							xTileID = xTile + row;
							yTileID = yTile + column;
							
							xOffset = baseXOffset + (modifier * row);
							yOffset = baseYOffset + (modifier * column);
							
							renderEntityPartBody(screen, xTileID, yTileID);
						}
					}
				}
			}
		}
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (!inWater) {
					xTileID = xTile + row;
					yTileID = yTile + column;
					
					xOffset = baseXOffset + (modifier * row);
					yOffset = baseYOffset + (modifier * column);
					
					renderEntityPartBody(screen, xTileID, yTileID);
				} else {
					if (column < (columns / 2)) {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderEntityPartBody(screen, xTileID, yTileID);
					}
				}
			}
		}
	}

	private void renderEntityPartShadow(Screen screen, List<PointLight> renderListLights, int xTileID, int yTileID) {
		if (Config.SHADOWS && bluePrint.castShadow) {
			for (PointLight light : renderListLights) {
				if (light != null) {

					int distance = (int) light.position.distance(position);
					
					if (distance < light.radius) {
						int xValue = (int) (Math.ceil(Math.atan(light.position.x - position.x)) - 0.5);
						int yValue = (int) (Math.ceil(Math.atan(light.position.y - position.y)) - 0.5);
						int shadwowDistance = (int) (Math.cbrt(distance) / 1.5);
						
						float shadowStrength = (1.0f - ((1.0f / light.radius) * distance)) / 2;

						renderShadows(screen, xValue, yValue, shadwowDistance, shadowStrength, xTileID, yTileID);
					}
				}
			}
		}
	}

	private void renderShadows(Screen screen, int xValue, int yValue, int shadwowDistance, float shadowStrength, int xTileID, int yTileID) {
		//screen.renderShadow(bluePrint.atlas, xOffset, yOffset - yValue * shadwowDistance * 1, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.55f);
		//screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 1, yOffset, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.55f);
		screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 1, yOffset - yValue * shadwowDistance * 1, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.55f);
		
		//screen.renderShadow(bluePrint.atlas, xOffset, yOffset - yValue * shadwowDistance * 2, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.35f);
		//screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 2, yOffset, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.35f);
		screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 2, yOffset - yValue * shadwowDistance * 2, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.35f);
		
		//screen.renderShadow(bluePrint.atlas, xOffset, yOffset - yValue * shadwowDistance * 3, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.15f);
		//screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 3, yOffset, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.15f);
		screen.renderShadow(bluePrint.atlas, xOffset - xValue * shadwowDistance * 3, yOffset - yValue * shadwowDistance * 3, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, shadowStrength * 0.15f);
	}

	private void renderEntityPartBody(Screen screen, int xTileID, int yTileID) {
		screen.render(bluePrint.atlas, xOffset, yOffset, bluePrint.atlas.getCurrentSprite(xTileID, yTileID), 0x00, 1.0f, 1.0f, 1.0f);
	}

	public void renderDebug(Screen screen) {
		screen.renderDebug(collissionBox, debugColor);
	}
	
	public boolean checkCollission(CollissionBox box) {
		if (collissionBox != null && box != null) {
			if (!collissionBox.equals(box)) {
				if (collissionBox.checkCollission(box)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkCollission(int x, int y) {
		if (this.collissionBox != null) {
			if (this.collissionBox.checkCollission(x, y)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void cleanUp() {
		
	}
}
