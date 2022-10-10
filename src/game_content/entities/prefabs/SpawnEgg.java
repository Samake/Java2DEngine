package game_content.entities.prefabs;

import engine.entities.EntityBluePrint;
import engine.entities.decals.Decal;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sound.SoundManager;
import engine.sprites.SpriteAtlas;
import game_content.entities.effects.EffectSmokePuffGrey;
import game_content.resources.NPCs;
import game_content.resources.Sheets;
import game_content.resources.Sounds;
import game_editor.Editor;

public class SpawnEgg extends Prefab {

	public EntityBluePrint spawnBlueprint;
	public boolean isCracked = false;
	
	public SpawnEgg(EntityBluePrint blueprint, Level level, int x, int y, EntityBluePrint spawnBlueprint) {
		super(blueprint, level, x, y);
		
		if (bluePrint.renderType.equals(RENDERTYPE.R1X1)) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 5;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 5;
			collissionBox.minY = 0;
			collissionBox.maxY = bluePrint.atlas.sheet.tileSize / 2;
		}
		
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
							
							new Decal(new EntityBluePrint(null, 0, ENTITYTYPE.DECAL, RENDERTYPE.R1X1, "DECAL", new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 2, false, 0, 0, false), true, false, true), level, (int) position.x, (int) position.y, 10000);
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
