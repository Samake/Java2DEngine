package engine.level.environment;

import engine.core.Config;
import engine.texture.Texture;
import engine.utils.Misc;
import game_content.resources.Textures;

public class FogLayer {

	private WeatherManager weatherManager;
	public Texture texture;
	
	public float x = 0;
	public float y = 0;
	public int size = 128;
	public double rotation = 0;
	
	private float ySpeed = 0.0f;
	private float xSpeed = 0.0f;
	private float rotSpeed = 0.0f;
	
	public FogLayer(WeatherManager weatherManager) {
		this.weatherManager = weatherManager;
		
		texture = Textures.TEXTURE_FOG_01;
		size = Misc.randomInteger(256, 1024);
		x = Misc.randomInteger(0, Config.WINDOW_WIDTH);
		y = Misc.randomInteger(0, Config.WINDOW_HEIGHT);

		if (x < Config.WINDOW_WIDTH / 2) {
			xSpeed = Misc.randomInteger(10, 35) / (float) size;
		} else {
			xSpeed = -Misc.randomInteger(10, 35) / (float) size;
		}
		
		if (y < Config.WINDOW_HEIGHT / 2) {
			ySpeed = Misc.randomInteger(10, 35) / (float) size;
		} else {
			ySpeed = -Misc.randomInteger(10, 35) / (float) size;
		}
		
		rotSpeed = Misc.randomInteger(-1000, 1000) / (size * 10.0f);
	}

	public void update(int gameSpeed) {
		y += ySpeed;
		
		if (y > Config.WINDOW_HEIGHT + size) {
			weatherManager.removeFogLayer(this);
		}
		
		x += xSpeed;
		
		if (x > Config.WINDOW_WIDTH + size) {
			weatherManager.removeFogLayer(this);
		} else if (x < -size) {
			weatherManager.removeFogLayer(this);
		}
		
		rotation = (rotation + rotSpeed * gameSpeed)%180;
	}
}
