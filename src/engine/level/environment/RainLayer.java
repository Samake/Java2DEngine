package engine.level.environment;

import engine.core.Config;
import engine.texture.Texture;
import engine.utils.Misc;
import game_content.resources.Textures;

public class RainLayer {

	private WeatherManager weatherManager;
	public Texture texture;
	
	public float x = 0;
	public float y = 0;
	public int size = 128;
	public float speed = 2.0f;
	private float xSpeed = 0.0f;
	
	public RainLayer(WeatherManager weatherManager) {
		this.weatherManager = weatherManager;
		
		size = Misc.randomInteger(32, 256);
		x = Misc.randomInteger(0, Config.WINDOW_WIDTH);
		speed = Misc.randomInteger(10000, 30000) / (size * 15);
		y = 0;
		
		if (x < Config.WINDOW_WIDTH / 2) {
			texture = Textures.getTextureByID(Misc.randomInteger(3, 4));
			xSpeed = ((size / 128.0f) / 1.0f);
		} else {
			texture = Textures.getTextureByID(Misc.randomInteger(1, 2));
			xSpeed = -((size / 128.0f) / 1.0f);
		}
	}

	public void update(int gameSpeed) {
		y += speed * gameSpeed;
		
		if (y > Config.WINDOW_HEIGHT + size) {
			weatherManager.removeRainLayer(this);
		}
		
		x += xSpeed * gameSpeed;
		
		if (x > Config.WINDOW_WIDTH + size) {
			weatherManager.removeRainLayer(this);
		} else if (x < -size) {
			weatherManager.removeRainLayer(this);
		}
	}
}
