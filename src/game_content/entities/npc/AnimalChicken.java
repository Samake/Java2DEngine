package game_content.entities.npc;

import engine.entities.EntityConfig;
import engine.entities.npc.NPCAnimal;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class AnimalChicken extends NPCAnimal {

	public AnimalChicken(EntityConfig config, Level level, float x, float y, float speed) {
		super(config, level, x, y, speed);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.player;

		if (player != null) {
			if (player.collissionBox != null && player.config.collission) {
				if (checkCollission(player.collissionBox)) {
					
				};
			}
		}
	}
}
