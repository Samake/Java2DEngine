package engine.entities.npc;

import java.util.Map;

import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.pathfinding.PathNode;
import engine.pathfinding.Pathfinder;
import engine.utils.Misc;
import engine.utils.Vector2f;

public class NPCJobs {
	
	public enum JOBS {
		IDLE, WALK_AROUND, WALK_PATH, FOLLOW, FLEE, FIGHT, FOOD, SLEEP
	}
	
	private NPCCore npc;
	private Pathfinder pathfinder;
	private long lastTimeStamp = System.currentTimeMillis();
	
	public boolean hasJob = false;
	public JOBS currentJob = null;
	
	public Vector2f startPosition = new Vector2f();
	public Vector2f targetPosition = new Vector2f();
	public int jobDelay = 1500;
	public int jobDelayValue = jobDelay;
	public int targetRange = 64;
	
	public Map<Integer, PathNode> path;

	public NPCJobs(NPCCore npc, Pathfinder pathfinder) {
		this.npc = npc;
		this.pathfinder = pathfinder;
	}

	public void update() {
		if (hasJob) {
			if (npc != null) {
				if (currentJob.equals(JOBS.WALK_AROUND)) {
					if (path != null) {
						if (path.get(path.size()).resolved) {
							resetJob();
							Log.print("NPC >> Job stopped: WALK_AROUND", OUTPUTTYPE.DEBUG);
						} else {
							walkPath();
						}
					}
				}
			}
		} else {
			if (lastTimeStamp + jobDelayValue < System.currentTimeMillis()) {
				setJob(JOBS.WALK_AROUND);
			}
		}
	}

	private void resetJob() {
		hasJob = false;
		lastTimeStamp = System.currentTimeMillis();
		jobDelayValue = Misc.randomInteger(jobDelay / 2, jobDelay * 2);
	}
	
	private void walkPath() {
		if (npc != null && path != null) {
			int shiftOperator = npc.bluePrint.atlas.sheet.getShiftOperator();
			int tileSize = npc.bluePrint.atlas.sheet.tileSize;
			
			for (int id = 0; id < path.size() + 1; id++) {
				PathNode node = path.get(id);
				
				if (node != null) {
					if (!node.resolved) {
						int nodeX = (node.x << shiftOperator) + tileSize / 2;
						int nodeY = (node.y << shiftOperator) + tileSize / 2;
						
						int xDistance = (int) Math.abs(npc.position.x - nodeX);
						int yDistance = (int) Math.abs(npc.position.y - nodeY);
						int distance = xDistance + yDistance;
						
						if (distance > 0) {
							if ((int) npc.position.x > (int) nodeX) {
								npc.velocity.add(-npc.speed, 0);
							}
							
							if ((int) npc.position.x < (int) nodeX) {
								npc.velocity.add(npc.speed, 0);
							}
							
							if ((int) npc.position.y > (int) nodeY) {
								npc.velocity.add(0, -npc.speed);
							}
							
							if ((int) npc.position.y < (int) nodeY) {
								npc.velocity.add(0, npc.speed);
							}
						} else {
							node.resolved = true;
							node.tile.marked = false;
						}
						return;
					}
				}
			}
		}
	}
	
	public void setJob(JOBS job) {
		switch(job) {
			case IDLE:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				break;
			case WALK_AROUND:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				path = null;
				
				if (npc != null) {
					int tileSize = npc.bluePrint.atlas.sheet.tileSize;
					int shiftOperator = npc.bluePrint.atlas.sheet.getShiftOperator();
					startPosition.x = npc.position.x;
					startPosition.y = npc.position.y;
					
					targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(-targetRange, targetRange));
					targetPosition.y = (int) (startPosition.y + Misc.randomInteger(-targetRange, targetRange));
					
					path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
					
					while (path == null) {
						targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(-targetRange, targetRange));
						targetPosition.y = (int) (startPosition.y + Misc.randomInteger(-targetRange, targetRange));
						
						path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
					};
				}

				break;
			case WALK_PATH:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				break;
			case FOLLOW:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;

				break;
			case FLEE:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				break;
			case FIGHT:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				break;
			case FOOD:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				break;
			case SLEEP:
				Log.print("NPC >> Job started: " + job.toString(), OUTPUTTYPE.DEBUG);
				
				currentJob = job;
				hasJob = true;
				
				break;
		}
	}
}
