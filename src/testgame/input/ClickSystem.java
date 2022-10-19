package testgame.input;

import engine.core.Config;
import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Vector2f;

public class ClickSystem {

	public static Vector2f offsetPosition = new Vector2f();
	public static Entity selectedEntity;
	public static Entity selectedPrefab;

	public static Vector2f mousePosition = new Vector2f();
	public static Vector2f worldPosition = new Vector2f();
	
	public static void update(InputHandler input, int gameSpeed) {
		mousePosition.set(input.mousePosition);
		
		int worldX = (int) (offsetPosition.x + (mousePosition.x - ((Config.WINDOW_WIDTH * Config.WINDOW_SCALE) / 2)) / Config.WINDOW_SCALE);
		int worldY = (int) (offsetPosition.y + (mousePosition.y - ((Config.WINDOW_HEIGHT * Config.WINDOW_SCALE) / 2)) / Config.WINDOW_SCALE);
		
		worldPosition.set(worldX, worldY);
	}

	public static Entity selectEntity(InputHandler input, Level level) {
		if (level != null) {
			Entity entity = level.getEntity((int) worldPosition.x, (int) worldPosition.y);
			
			if (entity != null) {
				if (entity.config.entityType.equals(ENTITYTYPE.OBJECT)) {
					selectedEntity = entity;
					return entity;
				}
			}
		}
		
		return null;
	}

	public static Entity selectPrefab(InputHandler input, Level level) {
		if (level != null) {
			Entity entity = level.getEntity((int) worldPosition.x, (int) worldPosition.y);
			
			if (entity != null) {
				if (entity.config.entityType.equals(ENTITYTYPE.PREFAB)) {
					selectedPrefab = entity;
					return entity;
				}
			}
		}
		
		return null;
	}
}
