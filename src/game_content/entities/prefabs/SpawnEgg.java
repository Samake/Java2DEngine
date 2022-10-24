package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sound.SoundManager;
import game_content.entities.decals.DecalEggSplash;
import game_content.entities.effects.EffectSmokePuffGrey;
import game_content.resources.NPCs;
import game_content.resources.Sounds;
import game_editor.Editor;

public class SpawnEgg extends Prefab {

	public EntityConfig spawnBlueprint;
	public boolean isCracked = false;
	
	public SpawnEgg(EntityConfig config, Level level, int x, int y, EntityConfig spawnBlueprint) {
		super(config, level, x, y);
		
		collissionBox.minX = (-config.renderData.atlas.sheet.tileSize / 2) + 5;
		collissionBox.maxX = (config.renderData.atlas.sheet.tileSize / 2) - 5;
		collissionBox.minY = 0;
		collissionBox.maxY = config.renderData.atlas.sheet.tileSize / 2;
		
		this.spawnBlueprint = spawnBlueprint;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		if (!Editor.isEditor) {
			if (player != null) {
				if (player.collissionBox != null) {
					if (checkCollission(player.collissionBox)) {
						if (!isCracked) {
							isCracked = true;
							
							SoundManager.playSoundGlobal(Sounds.EFFECT_EGG_CRACK, 75.0f, false);
							
							new DecalEggSplash(level, position.x, position.y);
							new EffectSmokePuffGrey(level, position.x, position.y);
							
							if (spawnBlueprint != null) {
								NPCs.addInstanceToLevel(spawnBlueprint, level, (int) position.x, (int) position.y);
							}
							
							level.removeEntity(this);
						}
					};
				}
			}
		}
	}
	
	@Override
	public void cleanUp() {
		
	}
}
