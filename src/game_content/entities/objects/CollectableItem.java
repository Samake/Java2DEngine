package game_content.entities.objects;

import engine.entities.EntityBluePrint;
import engine.entities.objects.ObjectStatic;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class CollectableItem extends ObjectStatic {
	
	public Player player;
	
	public CollectableItem(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		player = level.getPlayer();
		
		if (player != null) {
			if (player.collissionBox != null) {
				if (checkCollission(player.collissionBox)) {
					level.removeEntity(this);
				}
			}
		}
	}
}
