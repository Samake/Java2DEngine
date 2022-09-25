package engine.pathfinding;

import engine.tiles.Tile;

public class PathNode {

	public int id;
	public int x;
	public int y;
	public Tile tile;

	public boolean resolved = false;
	
	public PathNode(int id, int x, int y, Tile tile) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.tile = tile;
	}
}
