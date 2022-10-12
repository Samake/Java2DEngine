package engine.entities.lights;

import java.awt.Color;

import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;

public class PointLight extends Light {

	public int screenX = 0;
	public int screenY = 0;
	
	public PointLight(Level level, float x, float y, Color color, int radius, boolean pulsing, boolean flickering, int flickeringOffset, int delay, boolean enabledAtDay) {
		super(level, x, y, color, radius, pulsing, flickering, flickeringOffset,delay, enabledAtDay);
		
		type = LIGHTTYPE.POINTLIGHT;
		
		level.addLight(this);
		
		debugColor = Color.GRAY;
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
	}
	
	public void updatePosition(Level level, Screen screen) {
		screenX = (int) (position.x - screen.xOffset);
		screenY = (int) (position.y - screen.yOffset);
	}
}
