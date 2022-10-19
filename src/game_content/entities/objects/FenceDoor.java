package game_content.entities.objects;

import engine.entities.EntityConfig;
import engine.input.InputHandler;
import engine.level.Level;

public class FenceDoor extends Fence {

	public FenceDoor(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

	}
}
