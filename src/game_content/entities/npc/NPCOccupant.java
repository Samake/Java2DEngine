package game_content.entities.npc;

import engine.entities.EntityConfig;
import engine.entities.npc.NPCHuman;
import engine.entities.npc.NPCJobs.JOBS;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class NPCOccupant extends NPCHuman {

	public NPCOccupant(EntityConfig config, Level level, float x, float y, float speed) {
		super(config, level, x, y, speed);
		
		jobs.setJob(JOBS.WALK_AROUND, null);
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
