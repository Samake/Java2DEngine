package game_content.entities.npc;

import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCHuman;
import engine.entities.npc.NPCJobs.JOBS;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class NPCOccupant extends NPCHuman {

	public NPCOccupant(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);
		
		jobs.setJob(JOBS.WALK_AROUND, null);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.player;

		if (player != null) {
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
					
				};
			}
		}
	}
}
