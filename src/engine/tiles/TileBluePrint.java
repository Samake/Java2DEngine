package engine.tiles;

import javax.swing.Icon;

import engine.sprites.IconLoader;
import engine.sprites.SpriteAtlas;

public class TileBluePrint {
	public int id;
	public String name;
	public SpriteAtlas atlas;
	public Icon icon;
	public int mapColor;
	public float hestitation;
	public boolean isSolid;
	
	public TileBluePrint(TileBluePrint[] tileTypes, int id, String name, SpriteAtlas atlas, float hestitation, boolean solid) {
		if (tileTypes[id] != null) throw new RuntimeException("Duplicate tileType id on " + id);
		
		this.id = id;
		this.name = name;
		this.atlas = atlas;
		this.hestitation = hestitation;
		this.isSolid = solid;
		
		int iconScale = 4;
		
		icon = IconLoader.getIconfromSheet(atlas.sheet, atlas.column, atlas.row, iconScale);
		
		tileTypes[id] = this;
	}
}
