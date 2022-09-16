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
		
		icon = IconLoader.getIconfromSheet(atlas.sheet, atlas.column, atlas.row, iconScale);
	}
}
