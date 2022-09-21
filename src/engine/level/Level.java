package engine.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import engine.camera.Camera;
import engine.core.Config;
import engine.debug.Debug;
import engine.entities.Entity;
import engine.entities.decals.Decal;
import engine.entities.lights.Light;
import engine.input.InputHandler;
import engine.rendering.Canvas;
import engine.rendering.Screen;
import engine.scene.environment.Ambient;
import engine.sprites.SpriteAtlas;
import engine.tiles.Tile;
import game_content.entities.lights.PointLight;
import game_content.entities.player.Player;
import game_content.resources.Sheets;

public class Level {
	
	public Tile[][] tiles;
	
	public int width;
	public int height;
	
	public boolean editorMode = false;
	
	public List<Entity> entities = new ArrayList<Entity>();
	public List<Decal> decals = new ArrayList<Decal>();
	public List<PointLight> lights = new ArrayList<PointLight>();
	public Player player;
	public Camera camera;
	
	private List<Tile> renderListTiles = new ArrayList<Tile>();
	
	private List<Decal> rawListDecals = new ArrayList<Decal>();
	private List<Decal> updateListDecals = new ArrayList<Decal>();
	public List<Decal> renderListDecals = new ArrayList<Decal>();
	
	private List<Entity> rawListEntities = new ArrayList<Entity>();
	private List<Entity> updateListEntities = new ArrayList<Entity>();
	public List<Entity> renderListEntities = new ArrayList<Entity>();
	public List<Entity> collidingListEntities = new ArrayList<Entity>();
	
	private List<PointLight> rawListLights = new ArrayList<PointLight>();
	private List<PointLight> updateListLights = new ArrayList<PointLight>();
	public List<PointLight> renderListLights = new ArrayList<PointLight>();
	
	private int xOffset = 0;
	private int yOffset = 0;
	
	public Level(int width, int height, String tileName) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
		
		generateNewEmptyLevel(tileName);
	}
	
	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
	}
	
	private void generateNewEmptyLevel(String tileName) {
		LevelGenerator.generateEmptyLevel(width, height, tileName, this);
		
	}
	
	public void generateNewRandomLevel() {
		LevelGenerator.generateRandomLevel(width, height, this);
	}
	
	public void smoothLevel() {
		LevelGenerator.smoothWorld(tiles, width, height, this);
	}
	
	public void update(InputHandler input, Camera camera, Ambient ambient) {
		this.camera = camera;
		
		if (camera != null) {
			xOffset = (int) camera.position.x - (Config.WINDOW_WIDTH / 2);
			yOffset = (int) camera.position.y - (Config.WINDOW_HEIGHT / 2);
			
			Canvas.minY = (yOffset >> Sheets.TILES_SHEET.getShiftOperator());
			Canvas.maxY = (yOffset + Config.WINDOW_HEIGHT >> Sheets.TILES_SHEET.getShiftOperator()) + 1;
			Canvas.minX = (xOffset >> Sheets.TILES_SHEET.getShiftOperator());
			Canvas.maxX = (xOffset + Config.WINDOW_WIDTH >> Sheets.TILES_SHEET.getShiftOperator()) + 1;
			Canvas.shiftOperator = Sheets.TILES_SHEET.getShiftOperator();
			
			if (camera.getTarget() == null) {
				camera.setTarget(player);	
			}
		}
		
		updateTiles();
		updateDecals(input);
		updateEntities(input);
		updateLights(input, ambient);
	}

	private void updateTiles() {
		renderListTiles.clear();
		
		for (int y = Canvas.minY; y < Canvas.maxY; y++) {
			for (int x = Canvas.minX; x < Canvas.maxX; x++) {
				Tile tile = getTile(x, y);

				if (tile != null) {
					tile.update();
					renderListTiles.add(tile);
				}
			}
		}

		Debug.tiles = tiles[0].length * tiles[1].length;
	}
	
	private void updateDecals(InputHandler input) {
		rawListDecals.clear();
		updateListDecals.clear();
		renderListDecals.clear();
		
		rawListDecals.addAll(decals);
		
		Debug.decals = rawListDecals.size();
		
		for (Decal decal : rawListDecals) {
			if (Canvas.isOnScreen(decal.position.x, decal.position.y, 16)) {
				decal.update(input);
				updateListDecals.add(decal);
			}
		}
		
		renderListDecals.addAll(updateListDecals);
		
		Debug.decalsRendered = renderListDecals.size();
	}

	private void updateEntities(InputHandler input) {
		rawListEntities.clear();
		updateListEntities.clear();
		renderListEntities.clear();
		collidingListEntities.clear();
		
		rawListEntities.addAll(entities);
		
		Debug.entities = rawListEntities.size();
		
		for (Entity entity : rawListEntities) {
			if (Canvas.isOnScreen(entity.position.x, entity.position.y, 16)) {
				entity.update(input);
				updateListEntities.add(entity);
				
				if (entity.bluePrint.collission) {
					collidingListEntities.add(entity);
				}
			}
		}
		
		if (updateListEntities.size() > 1) {
			Collections.sort(updateListEntities, new Comparator<Entity>() {
		        @Override
		        public int compare(Entity e1, Entity e2) {
		        	float posY1 = e1.collissionBox.position.y + e1.collissionBox.maxY;
		        	float posY2 = e2.collissionBox.position.y + e2.collissionBox.maxY;
		        	
		        	if (posY1 > posY2) {
		        		return 1;
		        	} else if (posY1 < posY2) {
		        		return -1;
		        	} else {
		        		return 0;
		        	}
		        }
		    });
		}

		renderListEntities.addAll(updateListEntities);
		
		if (player != null) {
			player.checkCollissionWithEntities(collidingListEntities);
		}

		Debug.entitiesRendered = renderListEntities.size();
	}
	
	private void updateLights(InputHandler input, Ambient ambient) {
		rawListLights.clear();
		updateListLights.clear();
		renderListLights.clear();
		
		rawListLights.addAll(lights);
		
		Debug.lights = rawListLights.size();
		
		for (PointLight light : rawListLights) {
			if (Canvas.isOnScreen(light.position.x, light.position.y, 64)) {
				if (ambient.dayTime <= 2 || ambient.dayTime >= 6) {
					light.enabled = true;
				} else {
					if (light.enabledAtDay) {
						light.enabled = true;
					} else {
						light.enabled = false;
				
					}
				}
				
				if (light.enabled) {
					light.update(input);
					updateListLights.add(light);
				}
			}
		}
		
		if (updateListLights.size() > 1) {
			Collections.sort(updateListLights, new Comparator<Light>() {
		        @Override
		        public int compare(Light l1, Light l2) {
		        	float posY1 = l1.collissionBox.position.y + l1.collissionBox.maxY;
		        	float posY2 = l2.collissionBox.position.y + l2.collissionBox.maxY;
		        	
		        	if (posY1 > posY2) {
		        		return 1;
		        	} else if (posY1 < posY2) {
		        		return -1;
		        	} else {
		        		return 0;
		        	}
		        }
		    });
		}
		
		renderListLights.addAll(updateListLights);
		
		Debug.lightsRendered = renderListLights.size();
	}
	
	public void renderTiles(Screen screen) {
		if (renderListTiles != null) {
			screen.setOffset(xOffset, yOffset);
			
			for (Tile tile : renderListTiles) {
				if (tile != null) {
					tile.render(screen, this, tile.x << Sheets.TILES_SHEET.getShiftOperator(), tile.y << Sheets.TILES_SHEET.getShiftOperator());
					
					if (Debug.enabled) {
						tile.renderDebug(screen, this, tile.x << Sheets.TILES_SHEET.getShiftOperator(), tile.y << Sheets.TILES_SHEET.getShiftOperator());
					}
				}
			}
			
			Debug.tilesRendered = renderListTiles.size();
		}
	}
	
	public void renderDecals(Screen screen) {
		if (renderListDecals != null) {
			for (Decal decal : renderListDecals) {
				if (decal.bluePrint.rendered) {
					decal.render(screen, renderListLights);
				}
			}
		};
	}
	
	public void renderEntities(Screen screen) {
		if (renderListEntities.size() > 0) {
			for (Entity entity : renderListEntities) {
				if (entity.bluePrint.rendered) {
					entity.render(screen, renderListLights);
					
					if (Debug.enabled|| entity.selected) {
						entity.renderDebug(screen);
					}
				}
			}
		};
	}
	
	public void renderLights(Screen screen) {
		if (renderListLights != null) {
			for (Light light : renderListLights) {
				if (Debug.renderLights) {
					light.render(screen, renderListLights);
					
					if (Debug.enabled || light.selected) {
						light.renderDebug(screen);
					}
				}
			}
		};
	}
	
	public SpriteAtlas getTileAtlas() {
		for (int x = 0; x < 999999; x++) {
			for (int y = 0; y < 999999; y++) {
				Tile tile = tiles[x][y];
				
				if (tile != null) {
					return tile.atlas;
				}
			}
		}
		
		return null;
	}
	
	public Entity getEntity(int x, int y) {
		for (Entity entity : entities) {
			if (entity.checkCollission(x, y)) {
				return entity;
			}
		}
		
		return null;
	}
	
	public Light getLight(int x, int y) {
		for (Light light : lights) {
			if (light.checkCollission(x, y)) {
				return light;
			}
		}
		
		return null;
	}
	
	public void setTile(int x, int y, Tile tile) {
		if (tiles[x][y] != null) {
			tiles[x][y] = null;
		}
		
		tiles[x][y] = tile;
		
		deMarkTiles();
		
		LevelGenerator.smoothBorders(this, x, y, tile);
	}
	
	public Tile getTile(int x, int y) {
		if (x < 0 || x > width - 1 || y < 0 || y > height - 1) {
			return null;
		}
		
		return tiles[x][y];
	}
	
	public void selectTile(Tile tileToSelect) {
		if (tileToSelect != null) {
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					Tile tile = getTile(x, y);
					
					if (tile != null) { 
						if (tile.equals(tileToSelect)) { 
							tile.selected = true;
						} else {
							tile.selected = false;
						}
					}
				}
			}
		}
	}
	
	public void deMarkTiles() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				Tile tile = getTile(x, y);
				
				if (tile != null) { 
					tile.marked = false;
				}
			}
		}
	}
	
	public void deselectEntities() {
		for (Entity entity : entities) {
			entity.selected = false;
		}
	}
	
	public void selectEntity(Entity entityToSelect) {
		if (entityToSelect != null) {
			for (Entity entity : entities) {
				if (entity.equals(entityToSelect)) {
					entity.selected = true;
				} else {
					entity.selected = false;
				}
			}
		}
	}
	
	public void deselectLights() {
		for (Light light : lights) {
			light.selected = false;
		}
	}
	
	public void selectLight(Light lightToSelect) {
		if (lightToSelect != null) {
			for (Light light : lights) {
				if (light.equals(lightToSelect)) {
					light.selected = true;
				} else {
					light.selected = false;
				}
			}
		}
	}
	
	public void addDecal(Decal decal) {
		if (!decals.contains(decal)) {
			decals.add(decal);
		}		
	}
	
	public void removeDecal(Decal decal) {
		if (decals.contains(decal)) {
			decals.remove(decal);
			decal = null;
		}
	}

	public Entity addEntity(Entity entity) {
		if (!entities.contains(entity)) {
			entities.add(entity);
		}
		
		return entity;
	}
	
	public void removeEntity(Entity entity) {
		if (entities.contains(entity)) {
			entities.remove(entity);
			entity.cleanUp();
			entity = null;
		}
	}
	
	public void addLight(PointLight light) {
		lights.add(light);
	}
	
	public void removeLight(PointLight light) {
		if (lights.contains(light)) {
			lights.remove(light);
			light = null;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public Player setPlayer(Player player) {
		if (this.player == null) {
			this.player = player;
			addEntity(player);
		} else {
			removeEntity(player);
			this.player = null;
			this.player = player;
		}
		
		return player;
	}
	
	public void removePlayer() {
		if (player != null) {
			removeEntity(player);
			player = null;
		}
	}
}
