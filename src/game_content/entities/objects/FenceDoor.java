package game_content.entities.objects;

import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class FenceDoor extends Fence {

	public FenceDoor(EntityBluePrint bluePrint, Level level, float x, float y) {
		super(bluePrint, level, x, y);
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);

	}
}
