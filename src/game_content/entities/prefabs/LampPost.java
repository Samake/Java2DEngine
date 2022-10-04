package game_content.entities.prefabs;

import java.awt.Color;

import engine.entities.EntityBluePrint;
import engine.entities.lights.PointLight;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Vector2f;

public class LampPost extends Prefab {

	private PointLight light;
	
	private Vector2f lightOffset = new Vector2f();
	private Vector2f smokeOffset = new Vector2f();
	
	private int yTileEnabled = 0;
	private int yTileDisabled = 0;
	
	public LampPost(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		smokeOffset.y = -bluePrint.atlas.sheet.tileSize;
		yTileEnabled = yTile;
		yTileDisabled = yTile + 3;
		
		light = new PointLight(level, x, y, new Color(255, 200, 90, 255), 96, false, false, 200, false);
		light.enabledAtDay = false;
		light.saveToMap = false;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (light != null) {
			light.position.x = position.x + lightOffset.x;
			light.position.y = position.y + lightOffset.y;
			
			if (!light.enabledAtDay) {
				if (light.enabled) {
					yTile = yTileEnabled;
				} else {
					yTile = yTileDisabled;
				}
			}
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
