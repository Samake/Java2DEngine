package game_editor.input;

import engine.core.Config;
import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import engine.tiles.Tile;
import engine.utils.Vector2f;
import game_content.entities.lights.PointLight;
import game_content.entities.player.Player;

public class ClickSystemEditor {

	public static Vector2f offsetPosition = new Vector2f();
	public static Tile selectedTile;
	public static Entity selectedEntity;
	public static Entity selectedPrefab;
	public static PointLight selectedLight;
	public static Player selectedPlayer;
	
	public static Entity pickedEntity;
	public static Entity pickedPrefab;
	public static PointLight pickedLight;
	public static Player pickedPlayer;
	
	public static Vector2f mousePosition = new Vector2f();
	public static Vector2f worldPosition = new Vector2f();
	
	public static void update(InputHandler input, int gameSpeed) {
		mousePosition.set(input.mousePosition);
		
		int worldX = (int) (offsetPosition.x + (mousePosition.x - ((Config.WINDOW_WIDTH * Config.WINDOW_SCALE) / 2)) / Config.WINDOW_SCALE);
		int worldY = (int) (offsetPosition.y + (mousePosition.y - ((Config.WINDOW_HEIGHT * Config.WINDOW_SCALE) / 2)) / Config.WINDOW_SCALE);
		
		worldPosition.set(worldX, worldY);
		
		if (pickedEntity != null) {
			pickedEntity.position.set(worldPosition);
		}
		
		if (pickedPrefab != null) {
			pickedPrefab.position.set(worldPosition);
		}
		
		if (pickedPlayer != null) {
			pickedPlayer.position.set(worldPosition);
		}
		
		if (pickedLight != null) {
			pickedLight.position.set(worldPosition);
		}
	}
	
	public static void deselectEntity() {
		if (selectedEntity != null) {
			if (selectedEntity.selected) {
				selectedEntity.selected = false;
			}
			
			selectedEntity = null;
		}
		
		if (pickedEntity != null) {
			if (pickedEntity.selected) {
				pickedEntity.selected = false;
			}
			
			pickedEntity = null;
		}
	}

	public static Entity selectEntity(InputHandler input, Level level) {
		if (level != null) {
			if (pickedEntity != null) {
				level.selectEntity(pickedEntity);
				selectedEntity = pickedEntity;
				
				return pickedEntity;
			}

			Entity entity = level.getEntity((int) worldPosition.x, (int) worldPosition.y);
			
			if (entity != null) {
				if (entity.bluePrint.entityType.equals(ENTITYTYPE.OBJECT)) {
					level.deselectEntities();
					level.selectEntity(entity);
					selectedEntity = entity;
					return entity;
				}
			}
		}
		
		return null;
	}
	
	public static void deselectPrefab() {
		if (selectedPrefab != null) {
			if (selectedPrefab.selected) {
				selectedPrefab.selected = false;
			}
			
			selectedPrefab = null;
		}
		
		if (pickedPrefab != null) {
			if (pickedPrefab.selected) {
				pickedPrefab.selected = false;
			}
			
			pickedPrefab = null;
		}
	}
	
	public static Entity selectPrefab(InputHandler input, Level level) {
		if (level != null) {
			if (pickedPrefab != null) {
				level.selectEntity(pickedPrefab);
				selectedPrefab = pickedPrefab;
				
				return pickedPrefab;
			}

			Entity entity = level.getEntity((int) worldPosition.x, (int) worldPosition.y);
			
			if (entity != null) {
				if (entity.bluePrint.entityType.equals(ENTITYTYPE.PREFAB)) {
					level.deselectEntities();
					level.selectEntity(entity);
					selectedPrefab = entity;
					return entity;
				}
			}
		}
		
		return null;
	}
	
	public static void deselectPlayer() {
		if (selectedPlayer != null) {
			if (selectedPlayer.selected) {
				selectedPlayer.selected = false;
			}
			
			selectedPlayer = null;
		}
		
		if (pickedPlayer != null) {
			if (pickedPlayer.selected) {
				pickedPlayer.selected = false;
			}
			
			pickedPlayer = null;
		}
	}
	
	public static Player selectPlayer(InputHandler input, Level level) {
		if (level != null) {
			if (pickedPlayer != null) {
				level.selectEntity(pickedPlayer);
				selectedPlayer = pickedPlayer;
				
				return pickedPlayer;
			}

			Entity entity = level.getEntity((int) worldPosition.x, (int) worldPosition.y);
			
			if (entity != null) {
				if (entity.bluePrint.entityType.equals(ENTITYTYPE.PLAYER)) {
					level.deselectEntities();
					level.selectEntity(entity);
					selectedPlayer = (Player) entity;
					return (Player) entity;
				}
			}
		}
		
		return null;
	}
	
	public static void deselectLight() {
		if (selectedLight != null) {
			if (selectedLight.selected) {
				selectedLight.selected = false;
			}
			
			selectedLight = null;
		}
		
		if (pickedLight != null) {
			if (pickedLight.selected) {
				pickedLight.selected = false;
			}
			
			pickedLight = null;
		}
	}
	
	public static PointLight selectLight(InputHandler input, Level level) {
		if (level != null) {
			if (pickedLight != null) {
				level.selectLight(pickedLight);
				selectedLight = pickedLight;
				
				return pickedLight;
			}
			
			PointLight light = (PointLight) level.getLight((int) worldPosition.x, (int) worldPosition.y);
			
			if (light != null) {
				if (light.bluePrint.entityType.equals(ENTITYTYPE.LIGHT)) {
					level.deselectLights();
					level.selectLight(light);
					selectedLight = light;
					return light;
				}
			}
		}
		
		return null;
	}
	
	public static void deselectTile() {
		if (selectedTile != null) {
			if (selectedTile.selected) {
				selectedTile.selected = false;
			}
			
			selectedTile = null;
		}
	}
	
	public static Tile selectTile(InputHandler input, Level level) {
		if (level != null) {
			SpriteAtlas atlas = level.getTileAtlas();
			
			Tile tile = level.getTile((int) worldPosition.x >> atlas.sheet.getShiftOperator(), (int) worldPosition.y >> atlas.sheet.getShiftOperator());
			
			if (tile != null) {
				level.selectTile(tile);
				selectedTile = tile;
				return tile;
			}
				
			level.selectTile(null);
		}
		
		return null;
	}
}
