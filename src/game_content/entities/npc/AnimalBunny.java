package game_content.entities.npc;

import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCAnimal;
import engine.entities.npc.NPCJobs.JOBS;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class AnimalBunny extends NPCAnimal {

	public AnimalBunny(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);
		
		animationSpeed = 1;
		
		jobs.targetRange = 256;
		jobs.jobDelay = 500;
		jobs.jobDelayValue = jobs.jobDelay;
		
		
		jobs.setJob(JOBS.WALK_AROUND);
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
