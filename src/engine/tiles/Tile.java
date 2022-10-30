package engine.tiles;

import java.awt.Color;

import engine.level.Level;
import engine.level.environment.WeatherManager;
import engine.rendering.Screen;
import engine.sprites.SpriteAtlas;

public abstract class Tile {

	public SpriteAtlas atlas;
	public TileConfig config;
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
	
	public Tile(int id, int x, int y, TileConfig config, float brightness) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.config = config;
		this.atlas = config.atlas;
		this.isSolid = config.isSolid;
		this.hasCollission = config.isSolid;
		this.hesitation = config.hestitation;
		this.brightness = brightness;
	}
	
	public abstract void update(int gameSpeed);
	public abstract void render(Screen screen, Level level, int x, int y, WeatherManager weatherManager);
	public abstract void renderDebug(Screen screen, Level level, int x, int y);
}
