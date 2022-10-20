package game_content.entities.prefabs;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.entities.lights.PointLight;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Canvas;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_editor.Editor;
import testgame.input.ClickSystem;

public class ScareCrowPumpkin extends Prefab {

	private PointLight light;
	private Vector2f lightOffset = new Vector2f();
	
	public boolean enabled = false;
	
	public ScareCrowPumpkin(EntityConfig config, Level level, int x, int y) {
		super(config, level, x, y);
		
		lightOffset.y = (-config.renderData.atlas.sheet.tileSize / 2) + 8;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (!Editor.isEditor) {
			if (player != null) {
				if (Canvas.isOnScreen(position.x, position.y, 16)) {
					double distance = Misc.getDistance(position, player.position);
					
					if (distance <= 48) {
						Entity entity = ClickSystem.selectPrefab(input, level);
						
						if (entity != null) {
							if (entity.equals(this)) {
								if (input.lmouse.isClicked()) {
									if (!enabled) {
										enable();
									} else {
										disable();
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (enabled) {
			if (light != null) {
				light.position.x = position.x + lightOffset.x;
				light.position.y = position.y + lightOffset.y;
			}
		}
	}
	
	public void enable() {
		if (!enabled) {
			light = new PointLight(level, position.x, position.y, new Color(220, 75, 15, 255), 64, false, true, 2, 200, false);
			light.enabledAtDay = true;
			light.saveToMap = false;
			
			xTile = 1;
			
			enabled = true;
		}
	}
	
	public void disable() {
		if (enabled) {
			
			if (light != null) {
				level.removeLight(light);
				light = null;
			}
			
			xTile = 0;
			
			enabled = false;
		}
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();
		
		if (light != null) {
			level.removeLight(light);
			light = null;
		}
	}
}
