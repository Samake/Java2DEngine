package engine.sprites;

import engine.utils.Misc;

public class SpriteAtlas {

	public SpriteSheet sheet;
	public int column = 0;
	public int row = 0;
	public int length = 1;
	public boolean animated;
	public int delay;
	
	private long lastTick;
	private long currentTick;
	private int currentColumn;
	
	public SpriteAtlas(SpriteSheet sheet, int column, int row, boolean animated, int delay, int length, boolean random) {
		this.sheet = sheet;
		this.column = column;
		this.currentColumn = column;
		this.row = row;
		this.animated = animated;
		this.length = length;
		
		if (random) {
			this.delay = Misc.randomInteger(delay / 2, delay * 2);
		} else {
			this.delay = delay;
		}

		lastTick = System.currentTimeMillis();
	}
	
	public void update() {
		if (animated) {
			currentTick = System.currentTimeMillis();
			
			if (lastTick + delay <= currentTick) {
				lastTick = currentTick;
				
				if (currentColumn < column + (length - 1)) {
					currentColumn++;
				} else {
					currentColumn = column;
				}
			}
		}
	}
	
	public int getCurrentSprite() {
		return getCurrentSprite(0, 0);
	}

	public int getCurrentSprite(int xOffset, int yOffset) {
		return (currentColumn + xOffset) + (row + yOffset) * sheet.slots;
	}
}
