package game_content.entities.prefabs;

import java.awt.Color;

import engine.entities.EntityBluePrint;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Vector2f;
import game_content.entities.effects.EffectSmokePuff02;
import game_content.entities.lights.PointLight;

public class CampFire extends Prefab {

	private PointLight light;
	private EffectSmokePuff02 smoke;
	
	private Vector2f lightOffset = new Vector2f();
	private Vector2f smokeOffset = new Vector2f();
	
	public CampFire(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		smokeOffset.y = -bluePrint.atlas.sheet.tileSize;
		
		light = new PointLight(level, x, y, new Color(255, 128, 64, 255), 48, false, true, 200, false);
		light.saveToMap = false;
		smoke = new EffectSmokePuff02(level, x, y);
		smoke.saveToMap = false;
		
		//SoundManager.playSound(SoundFiles.AMBIENT_CAMPFIRE, position.x, position.y, 90.0f, 100, true, false);
	}

	@Override
	public void update(InputHandler input) {
		super.update(input);
		
		if (light != null) {
			light.position.x = position.x + lightOffset.x;
			light.position.y = position.y + lightOffset.y;
		}
		
		if (smoke != null) {
			smoke.position.x = position.x + smokeOffset.x;
			smoke.position.y = position.y + smokeOffset.y;
			smoke.collissionBox = collissionBox;
		}
		
		if (player != null) {
			if (player.collissionBox != null) {
				if (checkCollission(player.collissionBox)) {
					
				};
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
		
		if (smoke != null) {
			level.removeEntity(smoke);
			smoke = null;
		}
	}
}
