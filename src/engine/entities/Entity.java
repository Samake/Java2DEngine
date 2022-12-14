package engine.entities;

import java.awt.Color;
import java.util.List;

import engine.collission.CollissionBox;
import engine.core.Config;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.lights.Light.LIGHTTYPE;
import engine.entities.lights.PointLight;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;
import engine.sprites.SpriteAtlas;
import engine.utils.Vector2f;

public class Entity {
	
	public enum ENTITYTYPE {
		OBJECT, PREFAB, LIGHT, DECAL, EFFECT, NPC, PLAYER
	}
	
	public CollissionBox collissionBox = new CollissionBox();
	public Vector2f position = new Vector2f();
	public Vector2f velocity = new Vector2f();
	
	public EntityConfig config;
	public Level level;
	
	public float scale = 1;
	public float brightness = 1.0f;
	public float alpha = 1.0f;
	public float xOffset = 0;
	public float yOffset = 0;
	public int collissionOffset = 2;

	public boolean selected = false;
	
	protected int xTile = 0;
	protected int yTile = 0;
	protected float modifier = 0;
	
	public boolean inWater = false;
	public int heightOffsetModifier = 0;
	
	public Color debugColor = Color.YELLOW;
	public boolean saveToMap = true;
	
	public Entity(EntityConfig config, Level level, float x, float y) {
		this.config = config;
		this.level = level;
		this.position.x = x;
		this.position.y = y;
		
		defineDefaultCollissionBoxes();
	}

	private void defineDefaultCollissionBoxes() {
		if (config.renderData.renderType.equals(RENDERTYPE.R1X1)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize / 2) - collissionOffset);
			collissionBox.minY = 0;
			collissionBox.maxY =(int) (config.renderData.atlas.sheet.tileSize / 2);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X2)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize / 2) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X3)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize / 2) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize / 2) - collissionOffset);
			collissionBox.minY = (int) ((config.renderData.atlas.sheet.tileSize / 2) + collissionOffset );
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X2)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X3)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X2)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X3)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X5)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 1.5f) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 1.5f) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R4X4)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 2) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 2) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 2) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R4X6)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 2) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 2) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 3) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R5X5)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 2.5f) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 2.5f) - collissionOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R6X6)) {
			collissionBox.minX = (int) ((-config.renderData.atlas.sheet.tileSize * 3) + collissionOffset);
			collissionBox.maxX = (int) ((config.renderData.atlas.sheet.tileSize * 3) - collissionOffset);
			collissionBox.minY = (int) (collissionOffset);
			collissionBox.maxY = (int) ((config.renderData.atlas.sheet.tileSize * 3) - collissionOffset);
		}
	}
	
	public void update(InputHandler input, int gameSpeed) {
		if (collissionBox != null) {
			collissionBox.update(position.x, position.y + heightOffsetModifier);
		}
		
		if (config != null) {
			config.renderData.atlas.update(gameSpeed);
		}
	}

	public void render(Screen screen, List<PointLight> renderListLights) {
		modifier = config.renderData.atlas.sheet.tileSize * scale;

		if (config.renderData.renderType.equals(RENDERTYPE.R1X1)) {
			float rows = 1;
			float columns = 1;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = position.y - modifier / 2 + heightOffsetModifier;
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X2)) {
			float rows = 1;
			float columns = 2;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X3)) {
			float rows = 1;
			float columns = 3;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X2)) {
			float rows = 2;
			float columns = 2;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X3)) {
			float rows = 2;
			float columns = 3;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X3)) {
			float rows = 3;
			float columns = 3;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X5)) {
			float rows = 3;
			float columns = 5;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R4X6)) {
			float rows = 4;
			float columns = 6;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R5X5)) {
			float rows = 5;
			float columns = 5;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R6X6)) {
			float rows = 6;
			float columns = 6;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderEntityPart(screen, renderListLights, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
	}

	private void renderEntityPart(Screen screen, List<PointLight> renderListLights, int rows, int columns, float baseXOffset, float baseYOffset) {
		int xTileID = config.renderData.atlas.column;
		int yTileID = config.renderData.atlas.row;
		
		if (config.renderData.castShadow) {
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
							
							renderEntityPartShadow(screen, renderListLights, xTileID, yTileID);
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
					
					renderPart(screen, xTileID, yTileID, false);
				} else {
					if (column < (columns / 2)) {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderPart(screen, xTileID, yTileID, false);
					} else {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderPart(screen, xTileID, yTileID, true);
					}
				}
			}
		}
	}

	private void renderEntityPartShadow(Screen screen, List<PointLight> renderListLights, int xTileID, int yTileID) {
		if (Config.SHADOWS && config.renderData.castShadow) {
			for (PointLight light : renderListLights) {
				if (light != null) {
					if (light.type.equals(LIGHTTYPE.POINTLIGHT)) {
						int distance = (int) light.position.distance(position);
						
						if (distance < light.radius) {
							int xValue = (int) (Math.ceil(Math.atan(light.position.x - position.x)) - 0.5);
							int yValue = (int) (Math.ceil(Math.atan(light.position.y - position.y)) - 0.5);
							int shadwowDistance = (int) ((int) (scale * Math.cbrt(distance) / 1.5));
							float shadowStrength = (1.0f - ((1.0f / light.radius) * distance)) / 2;

							renderShadows(screen, xValue, yValue, shadwowDistance, shadowStrength, xTileID, yTileID);
						}
					}

					if (light.type.equals(LIGHTTYPE.AMBIENTLIGHT)) {
						int distance = (int) light.position.distance(position);
						
						if (distance < light.radius) {
							int xValue = (int) (Math.ceil(Math.atan(light.position.x - position.x)) - 0.5);
							int yValue = (int) (Math.ceil(Math.atan(light.position.y - position.y)) - 0.5);
							int shadwowDistance = 1;
							float shadowStrength = 0.2f;
	
							renderShadows(screen, xValue, yValue, shadwowDistance, shadowStrength, xTileID, yTileID);
						}
					}
				}
			}
		}
	}
	
	public void renderAtlas(Screen screen, SpriteAtlas atlas) {
		modifier = atlas.sheet.tileSize * scale;

		if (config.renderData.renderType.equals(RENDERTYPE.R1X1)) {
			float rows = 1;
			float columns = 1;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = position.y - modifier / 2 + heightOffsetModifier;
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X2)) {
			float rows = 1;
			float columns = 2;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R1X3)) {
			float rows = 1;
			float columns = 3;
			
			float baseXOffset = position.x - modifier / 2;
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X2)) {
			float rows = 2;
			float columns = 2;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R2X3)) {
			float rows = 2;
			float columns = 3;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X3)) {
			float rows = 3;
			float columns = 3;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R3X5)) {
			float rows = 3;
			float columns = 5;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R4X6)) {
			float rows = 4;
			float columns = 6;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R5X5)) {
			float rows = 5;
			float columns = 5;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
		
		if (config.renderData.renderType.equals(RENDERTYPE.R6X6)) {
			float rows = 6;
			float columns = 6;
			
			float baseXOffset = position.x - (modifier * (rows / 2.0f));
			float baseYOffset = heightOffsetModifier + position.y - (modifier * (columns / 2.0f));
			
			renderAtlasPart(screen, atlas, (int) rows, (int) columns, baseXOffset, baseYOffset);
		}
	}
	
	
	private void renderAtlasPart(Screen screen, SpriteAtlas atlas, int rows, int columns, float baseXOffset, float baseYOffset) {
		int xTileID = atlas.column;
		int yTileID = atlas.row;
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				if (!inWater) {
					xTileID = xTile + row;
					yTileID = yTile + column;
					
					xOffset = baseXOffset + (modifier * row);
					yOffset = baseYOffset + (modifier * column);
					
					renderPartbyAtlas(screen, atlas, xTileID, yTileID, false);
				} else {
					if (column < (columns / 2)) {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderPartbyAtlas(screen, atlas, xTileID, yTileID, false);
					} else {
						xTileID = xTile + row;
						yTileID = yTile + column;
						
						xOffset = baseXOffset + (modifier * row);
						yOffset = baseYOffset + (modifier * column);
						
						renderPartbyAtlas(screen, atlas, xTileID, yTileID, true);
					}
				}
			}
		}
	}

	private void renderShadows(Screen screen, int xValue, int yValue, int shadwowDistance, float shadowStrength, int xTileID, int yTileID) {
		screen.renderShadow(config.renderData.atlas, xOffset - xValue * shadwowDistance * 1, yOffset - yValue * shadwowDistance * 1, config.renderData.atlas.getCurrentSprite(xTileID, yTileID), 0x00, scale, alpha, shadowStrength * 0.45f);
		screen.renderShadow(config.renderData.atlas, xOffset - xValue * shadwowDistance * 2, yOffset - yValue * shadwowDistance * 2, config.renderData.atlas.getCurrentSprite(xTileID, yTileID), 0x00, scale, alpha, shadowStrength * 0.35f);
		screen.renderShadow(config.renderData.atlas, xOffset - xValue * shadwowDistance * 3, yOffset - yValue * shadwowDistance * 3, config.renderData.atlas.getCurrentSprite(xTileID, yTileID), 0x00, scale, alpha, shadowStrength * 0.25f);
	}

	private void renderPart(Screen screen, int xTileID, int yTileID, boolean isInWater) {
		screen.render(config.renderData.atlas, xOffset, yOffset, config.renderData.atlas.getCurrentSprite(xTileID, yTileID), 0x00, scale, alpha, brightness, isInWater);
	}
	
	private void renderPartbyAtlas(Screen screen, SpriteAtlas atlas, int xTileID, int yTileID, boolean isInWater) {
		screen.render(atlas, xOffset, yOffset, atlas.getCurrentSprite(xTileID, yTileID), 0x00, scale, alpha, brightness, isInWater);
	}

	public void renderDebug(Screen screen) {
		screen.renderDebug(collissionBox, debugColor);
	}
	
	public boolean checkCollission(CollissionBox box) {
		if (collissionBox != null && box != null) {
			if (!collissionBox.equals(box)) {
				if (collissionBox.intersects(box)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkCollission(int x, int y) {
		if (this.collissionBox != null) {
			if (this.collissionBox.intersetcs(x, y)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void cleanUp() {
		
	}
}
