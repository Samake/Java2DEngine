package engine.entities;

import engine.sprites.SpriteAtlas;

public class EntityRenderData {
	
	public enum RENDERTYPE {
		R1X1, R1X2, R1X3, R2X1, R2X2, R2X3, R3X2, R3X3, R3X5, R4X4, R4X6, R5X5, R6X6
	}

	public SpriteAtlas atlas;
	public boolean castShadow = true;
	public boolean rendered = true;
	public RENDERTYPE renderType = RENDERTYPE.R1X1;
	
	public EntityRenderData(SpriteAtlas atlas, boolean castShadow, boolean rendered, RENDERTYPE renderType) {
		this.atlas = atlas;
		this.castShadow = castShadow;
		this.rendered = rendered;
		this.renderType = renderType;
	}
}
