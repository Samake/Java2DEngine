package game_content.entities.prefabs.farming;

import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import game_editor.Editor;

public class SeedPumpkin extends Seed {


	public SeedPumpkin(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y, 15000);

	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (!Editor.isEditor) {
			if (player != null) {
				if (player.collissionBox != null) {
					if (checkCollission(player.collissionBox)) {

					};
				}
			}
		}
	}

	
	@Override
	public void cleanUp() {
		
	}
}
