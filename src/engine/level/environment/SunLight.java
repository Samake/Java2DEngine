package engine.level.environment;

import java.awt.Color;

import engine.core.Config;
import engine.entities.lights.PointLight;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;

public class SunLight extends PointLight {

	public int screenX = 0;
	public int screenY = 0;
	
	private float xOffset = 0;
	
	public SunLight(Level level, float x, float y, Color color) {
		super(level, x, y, color, Config.WINDOW_WIDTH * 2, false, false, 9999, true);

		type = LIGHTTYPE.AMBIENTLIGHT;
		
		level.addLight(this);
		
		debugColor = Color.MAGENTA;
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (enabled) {
			
		}
	}
	
	@Override
	public void updatePosition(Level level, Screen screen) {
		super.updatePosition(level, screen);
		
		if (enabled) {
			position.x = screen.xOffset + xOffset;
			position.y = screen.yOffset + Config.WINDOW_HEIGHT;
		}
	}

	public void updateLightValues(Time time, Color ambientColor) {
		if (enabled) {
			//float xOffsetRange = Config.WINDOW_WIDTH / 24;
			//xOffset = xOffsetRange * time.hour;
			color = ambientColor;
		}
	}
}
