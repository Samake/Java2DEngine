package game_content.entities.prefabs;

import engine.entities.EntityBluePrint;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;

public class Fountain extends Prefab {


	public Fountain(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		if (player != null) {
			if (player.collissionBox != null) {
				if (checkCollission(player.collissionBox)) {

				};
			}
		}
		
	}
	
	@Override
	public void cleanUp() {
		
	}
}
