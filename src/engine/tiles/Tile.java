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
	public boolean isSolid;
	public boolean hasCollission;
	public boolean updated = false;
	public int mapColor;
	public float hesitation;
	public boolean selected = false;
	public float brightness;
	
	public Tile(int id, int x, int y, TileBluePrint blueprint, float brightness) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.blueprint = blueprint;
		this.atlas = blueprint.atlas;
		this.isSolid = blueprint.isSolid;
		this.hasCollission = blueprint.isSolid;
		this.mapColor = blueprint.mapColor;
		this.hesitation = blueprint.hestitation;
		this.brightness = brightness;
	}
	
	public abstract void update();
	public abstract void render(Screen screen, Level level, int x, int y);
	public abstract void renderDebug(Screen screen, Level level, int x, int y);
}
