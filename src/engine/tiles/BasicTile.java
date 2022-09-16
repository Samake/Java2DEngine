package engine.tiles;

import engine.level.Level;
import engine.rendering.Screen;

public class BasicTile extends Tile {

	private int tileID;
	
	public BasicTile(int id, int x, int y, TileBluePrint blueprint) {
		super(id, x ,y, blueprint);
		
		setTileID(blueprint.atlas.column + blueprint.atlas.row * blueprint.atlas.sheet.slots);
		updated = blueprint.atlas.animated;
	}
	

	public void update() {
		if (updated) {
			if (atlas.animated) {
				atlas.update();
			}
		}
	}

	public void render(Screen screen, Level level, int x, int y) {
		screen.render(atlas, x, y, atlas.getCurrentSprite(), 0x00, 1.0f, 1.0f);
		
		if (selected) {
			renderSelected(screen, x, y, atlas.sheet.tileSize, atlas.sheet.tileSize);
		}
	}


	public void renderDebug(Screen screen, Level level, int x, int y) {

	}
	
	public void renderSelected(Screen screen, int x, int y, int w, int h) {
		screen.renderSelected(x, y, w, h);
	}


	public int getTileID() {
		return tileID;
	}


	public void setTileID(int tileID) {
		this.tileID = tileID;
	}
}
