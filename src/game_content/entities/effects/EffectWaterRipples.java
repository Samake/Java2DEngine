package game_content.entities.effects;

import engine.entities.EntityBluePrint;
import engine.entities.effects.Effect;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class EffectWaterRipples extends Effect {

	public EffectWaterRipples(Level level, float x, float y) {
		super(new EntityBluePrint(null, 0, ENTITYTYPE.EFFECT, RENDERTYPE.R1X1, "EFFECT_WATER_RIPPLES", new SpriteAtlas(Sheets.EFFECTS_SHEET, 3, 0, true, 300, 4, false), false, false, true), level, x, y, false, 1200);
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);
	}
}
