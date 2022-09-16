package game_content.entities.effects;

import engine.entities.EntityBluePrint;
import engine.entities.effects.Effect;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class EffectSmokePuff02 extends Effect {

	public EffectSmokePuff02(Level level, float x, float y) {
		super(new EntityBluePrint(null, 0, ENTITYTYPE.EFFECT, RENDERTYPE.R1X1, "EFFECT_SMOKEPUFF_02", new SpriteAtlas(Sheets.EFFECTS_SHEET, 4, 1, true, 100, 8, false), false, false, true), level, x, y, true, 800);
	}
}
