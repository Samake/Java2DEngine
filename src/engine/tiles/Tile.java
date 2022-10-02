package engine.tiles;

import java.awt.Color;

import engine.level.Level;
import engine.rendering.Screen;
import engine.sprites.SpriteAtlas;

public abstract class Tile {

	public SpriteAtlas atlas;
	public TileBluePrint bluePrint;
	public int id;
	public int x;
	public int y;
	public boolean isSolid = false;
	public boolean hasCollission = false;
	public boolean updated = false;
	public boolean locked = false;
	public float hesitation;
	public boolean marked = false;
	public boolean selected = false;
	public float brightness;
	
	public Color selectedColor = Color.GREEN;
	public Color markedColor = Color.LIGHT_GRAY;
	
	public Tile(int id, int x, int y, TileBluePrint blueprint, float brightness) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.bluePrint = blueprint;
		this.atlas = blueprint.atlas;
		this.isSolid = blueprint.isSolid;
		this.hasCollission = blueprint.isSolid;
		this.hesitation = blueprint.hestitation;
		this.brightness = brightness;
	}
	
	public abstract void update(int gameSpeed);
	public abstract void render(Screen screen, Level level, int x, int y);
	public abstract void renderDebug(Screen screen, Level level, int x, int y);
}
