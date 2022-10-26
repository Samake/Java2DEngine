package game_content.entities.prefabs;

import java.awt.Color;

import engine.entities.EntityConfig;
import engine.entities.lights.PointLight;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sound.Sound;
import engine.sound.SoundManager;
import engine.utils.Vector2f;
import game_content.entities.effects.EffectSmokeWhite;
import game_content.resources.Sounds;

public class CampFire extends Prefab {

	private PointLight light;
	private EffectSmokeWhite smoke;
	private Sound sound;
	
	private Vector2f lightOffset = new Vector2f();
	private Vector2f smokeOffset = new Vector2f();
	
	public CampFire(EntityConfig config, Level level, int x, int y) {
		super(config, level, x, y);
		
		if (collissionBox != null) {
			collissionBox.minX = (-config.renderData.atlas.sheet.tileSize / 2) + 2;
			collissionBox.maxX = (config.renderData.atlas.sheet.tileSize / 2) - 2;
			collissionBox.minY = config.renderData.atlas.sheet.tileSize / 8;
			collissionBox.maxY = config.renderData.atlas.sheet.tileSize / 2;
		}
		
		smokeOffset.y = -config.renderData.atlas.sheet.tileSize;
		
		light = new PointLight(level, x, y, new Color(220, 75, 15, 255), 96, false, true, 5, 200, false);
		light.enabledAtDay = true;
		light.saveToMap = false;
		
		smoke = new EffectSmokeWhite(level, x, y);
		smoke.saveToMap = false;
		
		sound = SoundManager.playSoundLocal(Sounds.AMBIENT_CAMPFIRE, position.x, position.y, 45.0f, 256.0f, true);
		sound.saveToMap = false;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (light != null) {
			light.position.x = position.x + lightOffset.x;
			light.position.y = position.y + lightOffset.y;
		}
		
		if (smoke != null) {
			smoke.position.x = position.x + smokeOffset.x;
			smoke.position.y = position.y + smokeOffset.y;
			smoke.collissionBox.position.x = collissionBox.position.x;
			smoke.collissionBox.position.y = collissionBox.position.y + collissionOffset;
		}
		
		if (sound != null) {
			sound.position.x = position.x;
			sound.position.y = position.y;
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
		
		if (sound != null) {
			sound.stop();
			sound = null;
		}
	}
}
