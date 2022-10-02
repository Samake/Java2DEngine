package engine.animation;

import engine.entities.Entity.RENDERTYPE;

public class Animation {

	private int xTileDefault = 0;
	
	public int xTile = 0;
	public int yTile = 0;
	public int delay = 0;
	private int length = 0;
	
	private long lastTick;
	private long currentTick;
	
	public Animation(int xTile, int yTile, int delay, int length) {
		this.xTileDefault = xTile;
		this.xTile = xTile;
		this.yTile = yTile;
		this.delay = delay;
		this.length = length;
		
		lastTick = System.currentTimeMillis();
	}
	
	public void update(RENDERTYPE renderType, int gameSpeed) {
		currentTick = System.currentTimeMillis();
		int currentDelay = delay / gameSpeed;
		
		int offSet = 1;
		
		if (renderType.equals(RENDERTYPE.R2X2)) {
			offSet = 2;
		}
		
		if (renderType.equals(RENDERTYPE.R2X3)) {
			offSet = 2;
		}
		
		if (renderType.equals(RENDERTYPE.R3X2)) {
			offSet = 3;
		}
		
		if (renderType.equals(RENDERTYPE.R4X4)) {
			offSet = 4;
		}
		
		if (renderType.equals(RENDERTYPE.R4X6)) {
			offSet = 4;
		}
		
		if (renderType.equals(RENDERTYPE.R6X6)) {
			offSet = 6;
		}
		
		if (lastTick + currentDelay <= currentTick) {
			lastTick = currentTick;
			
			if (xTile < xTileDefault + (length - 1)) {
				xTile = xTileDefault + offSet;
			} else {
				xTile = xTileDefault;
			}
		}
	}
}
