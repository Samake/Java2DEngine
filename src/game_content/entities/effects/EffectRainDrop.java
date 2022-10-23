package game_content.entities.effects;

import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.effects.Effect;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class EffectRainDrop extends Effect {

	public EffectRainDrop(Level level, float x, float y) {
		super(new EntityConfig(null, 0, ENTITYTYPE.EFFECT, "EFFECT_RAIN_DROP", false, new EntityRenderData(new SpriteAtlas(Sheets.EFFECTS_SHEET, 7, 0, true, 100, 4, false), false, true, RENDERTYPE.R1X1)), level, x, y, false, 1200);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
	}
}
