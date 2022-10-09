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
	private long lastStuckTimeStamp = System.currentTimeMillis();
	
	public boolean hasJob = false;
	public JOBS currentJob = null;
	
	public Vector2f startPosition = new Vector2f();
	public Vector2f targetPosition = new Vector2f();
	public int jobDelay = 1500;
	public int jobDelayValue = jobDelay;
	public int targetRange = 64;
	
	private int stuckAttempts = 0;
	private double stuckDistance = 0;
	private Vector2f stuckPosition = new Vector2f();
	
	public Map<Integer, PathNode> path;

	public NPCJobs(NPCCore npc, Pathfinder pathfinder) {
		this.npc = npc;
		this.pathfinder = pathfinder;
	}

	public void update(int gameSpeed) {
		int currentDelay = jobDelayValue / gameSpeed;
		
		if (hasJob) {
			if (npc != null) {
				if (!currentJob.equals(JOBS.IDLE)) {
					if (currentJob.equals(JOBS.WALK_AROUND)) {
						if (path != null) {
							if (path.get(path.size()).resolved) {
								resetJob(false);
								Log.print("NPC >> Job stopped: WALK_AROUND", OUTPUTTYPE.DEBUG);
							} else {
								walkPath();
							}
						}
					} else if (currentJob.equals(JOBS.FLEE)) {
						if (walkDestination()) {
							resetJob(true);
							Log.print("NPC >> Job stopped: FLEE", OUTPUTTYPE.DEBUG);
						}
					}
				} else {
					if (lastTimeStamp + currentDelay < System.currentTimeMillis()) {
						Log.print("NPC >> Job stopped: IDLE", OUTPUTTYPE.DEBUG);
						
						getRandomJob();
					}
				}
			}
		} else {
			if (lastTimeStamp + currentDelay < System.currentTimeMillis()) {
				getRandomJob();
			}
		}
	}

	private void getRandomJob() {
		int randomizer = Misc.randomInteger(0, 100);
		
		if (randomizer > 25) {
			setJob(JOBS.WALK_AROUND, null);
		} else {
			setJob(JOBS.IDLE, null);
		}
	}

	private void resetJob(boolean skipDelay) {
		currentJob = null;
		hasJob = false;
		lastTimeStamp = System.currentTimeMillis();
		jobDelayValue = 100;
		path = null;
		
		if (!skipDelay) {
			jobDelayValue = Misc.randomInteger(jobDelay / 2, jobDelay * 2);
		}
	}
	
	public void setJob(JOBS job, Vector2f fleePosition) {
		if (currentJob == null || !currentJob.equals(job)) {
			
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
					
					createWalkJob();
	
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
					
					createFleeJob(fleePosition);
	
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

	private void createWalkJob() {
		path = null;
		stuckAttempts = 0;
		
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
	}
	
	private void createFleeJob(Vector2f fleePosition) {
		stuckAttempts = 0;
		
		if (npc != null) {
			startPosition.x = npc.position.x;
			startPosition.y = npc.position.y;
			
			int targetMinRangeX = -targetRange / 2;
			int targetMaxRangeX = targetRange / 2;
			
			int targetMinRangeY = -targetRange / 2;
			int targetMaxRangeY = targetRange / 2;
			
			if (fleePosition != null) {
				if (fleePosition.x < startPosition.x) {
					targetMinRangeX += targetRange;
					targetMaxRangeX += targetRange;
				} else {
					targetMinRangeX -= targetRange;
					targetMaxRangeX -= targetRange;
				}
				
				if (fleePosition.y < startPosition.y) {
					targetMinRangeY += targetRange;
					targetMaxRangeY += targetRange;
				} else {
					targetMinRangeY -= targetRange;
					targetMaxRangeY -= targetRange;
				}
			}
			
			targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(targetMinRangeX, targetMaxRangeX));
			targetPosition.y = (int) (startPosition.y + Misc.randomInteger(targetMinRangeY, targetMaxRangeY));
		}
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
							
							float veloX = 0;
							float veloY = 0;
							
							if ((int) npc.position.x > (int) nodeX) {
								veloX = -npc.speed;
							}
							
							if ((int) npc.position.x < (int) nodeX) {
								veloX = npc.speed;
							}
							
							if ((int) npc.position.y > (int) nodeY) {
								veloY = -npc.speed;
							}
							
							if ((int) npc.position.y < (int) nodeY) {
								veloY = npc.speed;
							}
							
							if (!isStuck()) {
								npc.velocity.set(veloX, veloY);
							} else {
								npc.velocity.set(0, 0);
							}
						} else {
							node.resolved = true;
							node.tile.marked = false;
							node.tile.selected = false;
						}
						
						return;
					}
				}
			}
		}
	}
	
	private boolean walkDestination() {
		double distance = Misc.getDistance(npc.position, targetPosition);
		
		if (distance > 16) {
			float veloX = 0;
			float veloY = 0;
			
			if (npc.position.x <= targetPosition.x) {
				veloX = npc.speed;
			} else {
				veloX = -npc.speed;
			}
			
			if (npc.position.y <= targetPosition.y) {
				veloY = npc.speed;
			} else {
				veloY = -npc.speed;
			}
			
			if (!isStuck()) {
				npc.velocity.set(veloX, veloY);
			} else {
				npc.velocity.set(0, 0);
			}
			
			return false;
		}
		
		return true;
	}
	
	private boolean isStuck() {
		double currentDistance = Misc.getDistance(npc.position, targetPosition);
		double lastDistance = Misc.getDistance(stuckPosition, targetPosition);
		
		double result = Math.abs(currentDistance - lastDistance);

		if (result == stuckDistance) {
			stuckAttempts++;
			
			Log.print("Check if stuck! " + stuckAttempts + " attempts.", OUTPUTTYPE.DEBUG);
		} else {
			stuckAttempts = 0;
		}
		
		if (stuckAttempts >= 16) {
			Log.print("Free stuck entity!", OUTPUTTYPE.DEBUG);
			
			stuckDistance = 0;
			stuckAttempts = 0;
			stuckPosition.x = 0;
			stuckPosition.y = 0;
			npc.velocity.x = 0;
			npc.velocity.y = 0;
			
			resetJob(true);
			setJob(JOBS.WALK_AROUND, null);
			
			return true;
		}
			
		stuckPosition.x = npc.position.x;
		stuckPosition.y = npc.position.y;
		stuckDistance = result;
		
		return false;
	}
}
