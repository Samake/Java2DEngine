package engine.pathfinding;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import engine.debug.Debug;
import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.level.Level;
import engine.tiles.Tile;
import engine.utils.Vector2f;
import game_content.resources.Tiles.TILETYPE;

public class Pathfinder {

	private enum DIRECTION {
		LEFT, RIGHT, UP, DOWN;
	}
	
	private Level level;
	private Map<Integer, PathNode> nodeList = new HashMap<Integer, PathNode>();
	private boolean nodeListValid = false;
	
	public Pathfinder(Level level) {
		this.level = level;
	}

	public Map<Integer, PathNode> calculatePath(Vector2f startPosition, Vector2f targetPosition, int tileSize, int shiftOperator) {
		Log.print("Pathfinder >> Calculate route from  " + (int) startPosition.x + ", " + (int) startPosition.y + " to "+ (int) targetPosition.x + ", " + (int) targetPosition.y, OUTPUTTYPE.DEBUG);
		
		nodeList.clear();
		nodeListValid = true;
		
		level.deSelectTiles();
		level.deMarkTiles();

		Tile startTile = level.getTile((int) startPosition.x >> shiftOperator, (int) startPosition.y >> shiftOperator);
		Tile endTile = level.getTile((int) targetPosition.x >> shiftOperator, (int) targetPosition.y >> shiftOperator);
		
		if (startTile != null && endTile != null) {
			if (!endTile.isSolid && !endTile.hasCollission && !endTile.config.type.equals(TILETYPE.WATER)) {
				findPath(startTile, endTile);
				
				if (nodeListValid && nodeList.size() > 2) {
					
					if (Debug.enabled) {
						startTile.selected = true;
						endTile.selected = true;
						
						for (Entry<Integer, PathNode> entry : nodeList.entrySet()) {
							if (entry != null) {
								Tile tile = entry.getValue().tile;
								
								if (tile != null && !tile.equals(startTile) && !tile.equals(endTile)) {
									entry.getValue().tile.marked = true;
								}
							}
						}
					}
					
					return nodeList;
				}
			}
		}
		
		return null;
	}

	private void findPath(Tile startTile, Tile endTile) {
		Tile currentTile = startTile;
		int startX = startTile.x;
		int startY = startTile.y;
		int endX = endTile.x;
		int endY = endTile.y;
		
		int xDistance = Math.abs(startX - endX);
		int yDistance = Math.abs(startY - endY);
		int heuristic = xDistance + yDistance;
		
		Log.print("START >> startX: " + startX + ", startY: " + startY + ", xDistance: " + xDistance + ", yDistance: " + yDistance + ", heuristic: " + heuristic, OUTPUTTYPE.DEBUG);
		
		int id = nodeList.size() + 1;
		nodeList.put(id, new PathNode(id, startX, startY, startTile));

		int tries = 0;
		
		DIRECTION lastDirection = null;
		
		while (heuristic > 2) {
			tries++;
			
			if (tries > level.width) {
				return;
			}
			
			if (nodeList.size() > 0) {
				int nodeID = nodeList.size();
				
				PathNode pathNode = nodeList.get(nodeID);
				
				if (pathNode != null) {
					startX = pathNode.x;
					startY = pathNode.y;
					currentTile = pathNode.tile;
					
					Log.print("nodeID: " + nodeID, OUTPUTTYPE.DEBUG);
				}
			}
				
			xDistance = Math.abs(startX - endX);
			yDistance = Math.abs(startY - endY);
			heuristic = xDistance + yDistance;
			
			Log.print("startX: " + startX + ", startY: " + startY + ", xDistance: " + xDistance + ", yDistance: " + yDistance + ", heuristic: " + heuristic, OUTPUTTYPE.DEBUG);
			
			DIRECTION horizontalDirection = DIRECTION.LEFT;
			DIRECTION verticalDirection = DIRECTION.DOWN;
			
			if (startX >= endX) {
				horizontalDirection = DIRECTION.LEFT;
			} else {
				horizontalDirection = DIRECTION.RIGHT;
			}
			
			if (startY >= endY) {
				verticalDirection = DIRECTION.UP;
			} else {
				verticalDirection = DIRECTION.DOWN;
			}
			
			lastDirection = addNextNode(currentTile, horizontalDirection, verticalDirection, xDistance, yDistance, lastDirection);
		}
		
		id = nodeList.size() + 1;
		nodeList.put(id, new PathNode(id, endX, endY, endTile));
	}

	private DIRECTION addNextNode(Tile currentTile, DIRECTION horizontalDirection, DIRECTION verticalDirection, int xDistance, int yDistance, DIRECTION lastDirection) {
		if (currentTile != null) {
			int cx = currentTile.x;
			int cy = currentTile.y;
			int lx = cx - 1;
			int rx = cx + 1;
			int uy = cy - 1;
			int dy = cy + 1;
			
			Tile leftTile = null;
			Tile rightTile = null;
			Tile upTile = null;
			Tile downTile = null;
			
			int leftCost = 9999;
			int rightCost = 9999;
			int upCost = 9999;
			int downCost = 9999;
			
			if (lx >= 0 && lx < level.width) {
				leftTile = level.tiles[lx][cy];
			}
			
			if (rx >= 0 && rx < level.width) {
				rightTile = level.tiles[rx][cy];
			}
			
			if (uy >= 0 && uy < level.height) {
				upTile = level.tiles[cx][uy];
			}
			
			if (dy >= 0 && dy < level.height) {
				downTile = level.tiles[cx][dy];
			}
			
			if (leftTile != null) {
				leftCost = 100 - ((int) (leftTile.hesitation * 100.0f));
				
				if (!horizontalDirection.equals(DIRECTION.LEFT)) {
					leftCost += 1000;
				}
				
				if (leftTile.config.type.equals(TILETYPE.WATER)) {
					leftCost += 5;
				}
				
				if (xDistance < yDistance) {
					leftCost += 15;
				}
				
				if (lastDirection != null && !lastDirection.equals(DIRECTION.LEFT)) {
					leftCost += 15;
				}
				
				if (leftTile.isSolid || leftTile.hasCollission) {
					leftTile = null;
				}
			}
			
			if (rightTile != null) {
				rightCost = 100 - ((int) (rightTile.hesitation * 100.0f));
				
				if (!horizontalDirection.equals(DIRECTION.RIGHT)) {
					rightCost += 1000;
				}
				
				if (rightTile.config.type.equals(TILETYPE.WATER)) {
					rightCost += 5;
				}
				
				if (xDistance < yDistance) {
					rightCost += 15;
				}
				
				if (lastDirection != null && !lastDirection.equals(DIRECTION.RIGHT)) {
					rightCost += 15;
				}
				
				if (rightTile.isSolid || rightTile.hasCollission) {
					rightTile = null;
				}
			}
			
			if (upTile != null) {
				upCost = 100 - ((int) (upTile.hesitation * 100.0f));
				
				if (!verticalDirection.equals(DIRECTION.UP)) {
					upCost += 1000;
				}
				
				if (upTile.config.type.equals(TILETYPE.WATER)) {
					upCost += 5;
				}
				
				if (yDistance < xDistance) {
					upCost += 15;
				}
				
				if (lastDirection != null && !lastDirection.equals(DIRECTION.UP)) {
					upCost += 15;
				}
				
				if (upTile.isSolid || upTile.hasCollission) {
					upTile = null;
				}
			}
			
			if (downTile != null) {
				downCost = 100 - ((int) (downTile.hesitation * 100.0f));
				
				if (!verticalDirection.equals(DIRECTION.DOWN)) {
					downCost += 1000;
				}
				
				if (downTile.config.type.equals(TILETYPE.WATER)) {
					downCost += 5;
				}
				
				if (yDistance < xDistance) {
					downCost += 15;
				}
				
				if (lastDirection != null && !lastDirection.equals(DIRECTION.DOWN)) {
					downCost += 15;
				}
				
				if (downTile.isSolid || downTile.hasCollission) {
					downTile = null;
				}
			}
			
			Log.print("Costs >> " + horizontalDirection + ", " + verticalDirection + " << l: " + leftCost + ", r: " + rightCost + ", u: " + upCost + ", d: " + downCost, OUTPUTTYPE.DEBUG);
			
			Tile nextTile = null;
			int finalCost = 9999;
			DIRECTION direction = null;
			
			if (leftCost < finalCost) {
				finalCost = leftCost;
				nextTile = leftTile;
				direction = DIRECTION.LEFT;
			}
			
			if (rightCost < finalCost) {
				finalCost = rightCost;
				nextTile = rightTile;
				direction = DIRECTION.RIGHT;
			}
			
			if (upCost < finalCost) {
				finalCost = upCost;
				nextTile = upTile;
				direction = DIRECTION.UP;
			}
			
			if (downCost < finalCost) {
				finalCost = downCost;
				nextTile = downTile;
				direction = DIRECTION.DOWN;
			}
			
			Log.print("Result >> " + direction + " << cost: " + finalCost, OUTPUTTYPE.DEBUG);
			
			if (nextTile != null) {
				int id = nodeList.size() + 1;
				nodeList.put(id, new PathNode(id, nextTile.x, nextTile.y, nextTile));
				
				return direction;
			} else {
				nodeListValid = false;
			}
		}
		
		return null;
	}
}
