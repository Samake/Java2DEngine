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
		IDLE, WALK_AROUND, WALK_PATH, FOLLOW, FLEE, FIGHT, FOOD, SLEEP, RESPAWN
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
	
	private int stuckFreeAttempts = 0;
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
								reset(false);
								Log.print("NPC >> Job stopped: WALK_AROUND", OUTPUTTYPE.DEBUG);
							} else {
								walkPath();
							}
						}
					} else if (currentJob.equals(JOBS.FLEE)) {
						if (path != null) {
							if (path.get(path.size()).resolved) {
								reset(false);
								Log.print("NPC >> Job stopped: FLEE", OUTPUTTYPE.DEBUG);
							} else {
								walkPath();
							}
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

	public void reset(boolean skipDelay) {
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
				case RESPAWN:
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
			
			int targetMinRangeX = -targetRange;
			int targetMaxRangeX = targetRange;
			
			int targetMinRangeY = -targetRange;
			int targetMaxRangeY = targetRange;
			
			targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(targetMinRangeX, targetMaxRangeX));
			targetPosition.y = (int) (startPosition.y + Misc.randomInteger(targetMinRangeY, targetMaxRangeY));
			
			path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
			
			while (path == null) {
				targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(targetMinRangeX, targetMaxRangeX));
				targetPosition.y = (int) (startPosition.y + Misc.randomInteger(targetMinRangeY, targetMaxRangeY));
				
				path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
			};
		}
	}
	
	private void createFleeJob(Vector2f fleePosition) {
		stuckAttempts = 0;
		
		if (npc != null) {
			int tileSize = npc.bluePrint.atlas.sheet.tileSize;
			int shiftOperator = npc.bluePrint.atlas.sheet.getShiftOperator();
			
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
			
			path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
			
			int attempts = 0;
			
			while (path == null) {
				
				attempts++;

				targetPosition.x = (int) (startPosition.x  +  Misc.randomInteger(targetMinRangeX, targetMaxRangeX));
				targetPosition.y = (int) (startPosition.y + Misc.randomInteger(targetMinRangeY, targetMaxRangeY));
				
				path = pathfinder.calculatePath(startPosition, targetPosition, tileSize, shiftOperator);
				
				if (attempts >= 16) {
					reset(false);
					setJob(JOBS.WALK_AROUND, null);
				}
			};
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
	
	private boolean isStuck() {
		double currentDistance = Misc.getDistance(npc.position, targetPosition);
		double lastDistance = Misc.getDistance(stuckPosition, targetPosition);
		
		double result = Math.abs(currentDistance - lastDistance);

		if (result == stuckDistance) {
			stuckAttempts++;
			
			Log.print("Check if stuck! " + stuckAttempts + " attempts.", OUTPUTTYPE.DEBUG);
			
			if (stuckAttempts >= 16) {
				Log.print("Free stuck entity!", OUTPUTTYPE.DEBUG);
				
				stuckDistance = 9999;
				stuckAttempts = 0;
				stuckPosition.set(0, 0);
				npc.velocity.set(0, 0);
				
				reset(true);
				setJob(JOBS.IDLE, null);
				
				stuckFreeAttempts++;
				
				return true;
			}
			
			if (stuckFreeAttempts >= 16) {
				reset(false);
				setJob(JOBS.RESPAWN, null);
				stuckFreeAttempts = 0;
			}
			
			return false;
		} else {
			stuckAttempts = 0;
			stuckPosition.x = npc.position.x;
			stuckPosition.y = npc.position.y;
			stuckDistance = result;
			
			return false;
		}
	}
}
