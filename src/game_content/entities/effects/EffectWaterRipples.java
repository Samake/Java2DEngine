package game_content.entities.effects;

import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.effects.Effect;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class EffectWaterRipples extends Effect {

	public EffectWaterRipples(Level level, float x, float y) {
		super(new EntityConfig(null, 0, ENTITYTYPE.EFFECT, "EFFECT_WATER_RIPPLES", false, new EntityRenderData(new SpriteAtlas(Sheets.EFFECTS_SHEET, 3, 0, true, 300, 4, false), false, true, RENDERTYPE.R1X1)), level, x, y, false, 1200);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
	}
}
