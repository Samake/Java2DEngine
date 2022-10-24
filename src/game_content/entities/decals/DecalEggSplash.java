package game_content.entities.decals;

import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.decals.Decal;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class DecalEggSplash extends Decal {

	public DecalEggSplash(Level level, float x, float y) {
		super(new EntityConfig(null, 0, ENTITYTYPE.DECAL, "DECAL_EGG_SPLASH", false, new EntityRenderData(new SpriteAtlas(Sheets.EFFECTS_SHEET, 0, 2, false, 0, 0, false), false, true, RENDERTYPE.R1X1)), level, x, y, 12000);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
	}
}
