package engine.animation;

public class Animation {

	private int xTileDefault = 0;
	private int yTileDefault = 0;
	public int xTile = 0;
	public int yTile = 0;
	
	public Animation(int xTileValue, int yTileValue) {
		xTileDefault = xTileValue;
		yTileDefault = yTileValue;
	}
	
	public void animate(int value) {
		xTile = xTileDefault + value;
		yTile = yTileDefault;
	}
}
