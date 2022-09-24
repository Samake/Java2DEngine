package game_content.entities.npc;

import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCAnimalSmall;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class AnimalBunny extends NPCAnimalSmall {

	public AnimalBunny(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);
		
		animationSpeed = 1;
		targetRange = 36;
		jobDelay = 500;
		jobDelayValue = jobDelay;
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
