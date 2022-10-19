package game_content.entities.prefabs;

import engine.entities.EntityConfig;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sound.SoundManager;
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
							
							SoundManager.playSound(Sounds.EFFECT_EGG_CRACK, 45.0f);
							
							//new Decal(new EntityConfig(null, 0, ENTITYTYPE.DECAL, RENDERTYPE.R1X1, "DECAL", new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 2, false, 0, 0, false), true, false, true), level, (int) position.x, (int) position.y, 10000);
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
