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
		
		animSpeed = 2;
		
		jobs.targetRange = 32;
		jobs.jobDelay = 2500;
		jobs.jobDelayValue = jobs.jobDelay;
		
		jobs.setJob(JOBS.WALK_AROUND, null);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.player;

		if (player != null) {
			float distance = position.distance(player.position);
			
			if (distance <= 32) {
				animSpeed = 4;
				if (!jobs.currentJob.equals(JOBS.FLEE)) {
					jobs.setJob(JOBS.FLEE, player.position);
				}
			} else {
				animSpeed = 2;
			}
			
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
					
				};
			}
		}
	}
}
