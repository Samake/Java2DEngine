package engine.entities;

import javax.swing.Icon;

import engine.entities.Entity.ENTITYTYPE;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.sprites.IconLoader;

public class EntityConfig {
	
	public int id;
	public String name;
	public ENTITYTYPE entityType;
	public boolean collission;
	public EntityRenderData renderData;
	public Icon icon = null;
	
	public EntityConfig(EntityConfig[] list, int id, ENTITYTYPE entityType, String name, boolean collission, EntityRenderData renderData) {
		if (list != null) {
			if (list[id] != null) throw new RuntimeException("Duplicate entity id on " + id);
			list[id] = this;
		}
		
		this.id = id;
		this.name = name;
		this.entityType = entityType;
		this.collission = collission;
		this.renderData = renderData;
		
		int iconScale = 4;

		if (renderData != null) {
			createIcon(iconScale);
		}
	}

	private void createIcon(int iconScale) {
		int width = 1;
		int height = 1;
		
		if (renderData.renderType.equals(RENDERTYPE.R1X2)) {
			width = 1;
			height = 2;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R1X3)) {
			width = 1;
			height = 3;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R2X1)) {
			width = 2;
			height = 1;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R2X2)) {
			width = 2;
			height = 2;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R2X3)) {
			width = 2;
			height = 3;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R3X2)) {
			width = 3;
			height = 2;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R3X3)) {
			width = 3;
			height = 3;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R3X5)) {
			width = 3;
			height = 5;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R4X4)) {
			width = 4;
			height = 4;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R4X6)) {
			width = 4;
			height = 6;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R5X5)) {
			width = 5;
			height = 5;
		}
		
		if (renderData.renderType.equals(RENDERTYPE.R6X6)) {
			width = 6;
			height = 6;
		}
		
		icon = IconLoader.getIconfromSheet(renderData.atlas.sheet, renderData.atlas.column, renderData.atlas.row, width, height, iconScale);
	}
}
