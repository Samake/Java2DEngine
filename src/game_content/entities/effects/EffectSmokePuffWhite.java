package game_content.entities.effects;

import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.entities.effects.Effect;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class EffectSmokePuffWhite extends Effect {

	public EffectSmokePuffWhite(Level level, float x, float y) {
		super(new EntityConfig(null, 0, ENTITYTYPE.EFFECT, "EFFECT_SMOKEPUFF_WHITE", false, new EntityRenderData(new SpriteAtlas(Sheets.EFFECTS_SHEET, 4, 2, true, 100, 8, false), false, true, RENDERTYPE.R1X1)), level, x, y, false, 800);
	}
}
