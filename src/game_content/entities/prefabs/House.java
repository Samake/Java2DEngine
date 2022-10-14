package game_content.entities.prefabs;

import engine.entities.EntityBluePrint;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class House extends Prefab {

	public House(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();

	}
}