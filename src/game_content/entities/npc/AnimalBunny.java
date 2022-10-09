package game_content.entities.npc;

import engine.entities.EntityBluePrint;
import engine.entities.npc.NPCAnimal;
import engine.entities.npc.NPCJobs.JOBS;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Misc;
import game_content.entities.player.Player;

public class AnimalBunny extends NPCAnimal {

	public AnimalBunny(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, x, y, speed);
		
		animSpeed = 2;
		
		jobs.targetRange = 32;
		jobs.jobDelay = 1500;
		jobs.jobDelayValue = jobs.jobDelay;
		
		jobs.setJob(JOBS.WALK_AROUND, null);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		animSpeed = 2;
		
		Player player = level.player;

		if (player != null) {
			if (jobs.currentJob == null || !jobs.currentJob.equals(JOBS.FLEE)) {
				double distance = Misc.getDistance(position, player.position);
				
				if (distance <= 32) {
					animSpeed = 4;

					jobs.setJob(JOBS.FLEE, player.position);
				}
			}
			
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
					
				};
			}
		}
	}
}
