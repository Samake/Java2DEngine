package engine.tiles;

import javax.swing.Icon;

import engine.sprites.IconLoader;
import engine.sprites.SpriteAtlas;
import game_content.resources.Tiles.TILETYPE;

public class TileConfig {
	public int id;
	public TILETYPE type;
	public String name;
	public SpriteAtlas atlas;
	public Icon icon;
	public float hestitation;
	public boolean isSolid;
	
	public TileConfig(TileConfig[] list, int id, TILETYPE type, String name, SpriteAtlas atlas, float hestitation, boolean solid) {
		if (list != null) {
			if (list[id] != null) throw new RuntimeException("Duplicate tileType id on " + id);
		}
		
		this.id = id;
		this.type = type;
		this.name = name;
		this.atlas = atlas;
		this.hestitation = hestitation;
		this.isSolid = solid;
		
		int iconScale = 4;
		
		icon = IconLoader.getIconfromSheet(atlas.sheet, atlas.column, atlas.row, 1, 1, iconScale);
		
		list[id] = this;
	}
}
