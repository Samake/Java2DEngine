package game_content.entities.lights;

import java.awt.Color;

import engine.entities.lights.Light;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;

public class PointLight extends Light {

	public int screenX = 0;
	public int screenY = 0;
	
	public PointLight(Level level, float x, float y, Color color, int radius, boolean pulsing, boolean flickering, int delay, boolean fadeOut) {
		super(level, x, y, color, radius, pulsing, flickering, delay, fadeOut);
		
		level.addLight(this);
		
		debugColor = Color.GRAY;
	}
	
	public void update(InputHandler input) {
		super.update(input);
	}
	
	public void updatePosition(Screen screen) {
		screenX = (int) (position.x - screen.xOffset);
		screenY = (int) (position.y - screen.yOffset);
	}
}
