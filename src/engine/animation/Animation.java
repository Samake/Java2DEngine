package engine.animation;

import engine.entities.EntityRenderData.RENDERTYPE;

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
	
		int currentOffset = 1;
		int currentLength = length;
		
		if (renderType.equals(RENDERTYPE.R2X2)) {
			currentOffset *= 2;
			currentLength *= 2;
		}
		
		if (lastTick + currentDelay < currentTick) {
			if (xTile < currentLength - currentOffset) {
				xTile += currentOffset;
			} else {
				xTile = xTileDefault;
			}
			
			lastTick = currentTick;
		}
	}
}
