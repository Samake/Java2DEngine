package engine.tiles;

import engine.level.Level;
import engine.rendering.Screen;
import engine.sprites.SpriteAtlas;

public abstract class Tile {

	public SpriteAtlas atlas;
	public TileBluePrint blueprint;
	public int id;
	public int x;
	public int y;
	public boolean solid;
	public boolean updated = false;
	public int mapColor;
	public float hesitation;
	public boolean selected = false;
	
	public Tile(int id, int x, int y, TileBluePrint blueprint) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.blueprint = blueprint;
		this.atlas = blueprint.atlas;
		this.solid = blueprint.solid;
		this.mapColor = blueprint.mapColor;
		this.hesitation = blueprint.hestitation;
	}
	
	public abstract void update();
	public abstract void render(Screen screen, Level level, int x, int y);
	public abstract void renderDebug(Screen screen, Level level, int x, int y);
}
