package engine.entities;

import javax.swing.Icon;

import engine.entities.Entity.ENTITYTYPE;
import engine.entities.Entity.RENDERTYPE;
import engine.sprites.IconLoader;
import engine.sprites.SpriteAtlas;

public class EntityBluePrint {
	
	public int id;
	public String name;
	public SpriteAtlas atlas;
	public boolean collission;
	public boolean castShadow;
	public boolean rendered;
	public Icon icon;
	public ENTITYTYPE entityType;
	public RENDERTYPE renderType;
	
	public EntityBluePrint(EntityBluePrint[] entityList, int id, ENTITYTYPE entityType, RENDERTYPE renderType, String name, SpriteAtlas atlas, boolean collission, boolean castShadow, boolean rendered) {
		if (entityList != null) {
			if (entityList[id] != null) throw new RuntimeException("Duplicate entityType id on " + id);
			entityList[id] = this;
		}
		
		this.id = id;
		this.entityType = entityType;
		this.renderType = renderType;
		this.name = name;
		this.atlas = atlas;
		this.collission = collission;
		this.castShadow = castShadow;
		this.rendered = rendered;
		
		int iconScale = 4;
		
		
		createIcon(atlas, renderType, iconScale);
	}

	private void createIcon(SpriteAtlas atlas, RENDERTYPE renderType, int iconScale) {
		int width = 1;
		int height = 1;
		
		if (renderType.equals(RENDERTYPE.R1X2)) {
			width = 1;
			height = 2;
		}
		
		if (renderType.equals(RENDERTYPE.R1X3)) {
			width = 1;
			height = 3;
		}
		
		if (renderType.equals(RENDERTYPE.R2X1)) {
			width = 2;
			height = 1;
		}
		
		if (renderType.equals(RENDERTYPE.R2X2)) {
			width = 2;
			height = 2;
		}
		
		if (renderType.equals(RENDERTYPE.R2X3)) {
			width = 2;
			height = 3;
		}
		
		if (renderType.equals(RENDERTYPE.R3X2)) {
			width = 3;
			height = 2;
		}
		
		if (renderType.equals(RENDERTYPE.R3X3)) {
			width = 3;
			height = 3;
		}
		
		if (renderType.equals(RENDERTYPE.R4X4)) {
			width = 4;
			height = 4;
		}
		
		if (renderType.equals(RENDERTYPE.R4X6)) {
			width = 4;
			height = 6;
		}
		
		if (renderType.equals(RENDERTYPE.R6X6)) {
			width = 6;
			height = 6;
		}
		
		icon = IconLoader.getIconfromSheet(atlas.sheet, atlas.column, atlas.row, width, height, iconScale);
	}
}
