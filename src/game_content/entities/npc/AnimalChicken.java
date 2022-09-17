package game_content.entities.npc;

import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCAnimalSmall;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class AnimalChicken extends NPCAnimalSmall {

	public AnimalChicken(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);
	}
	
	@Override
	public void update(InputHandler input) {
		super.update(input);
		
		Player player = level.getPlayer();

		if (player != null) {
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
					
				};
			}
		}
	}
}
