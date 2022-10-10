package engine.entities.collision;

import engine.utils.Misc;
import engine.utils.Vector2f;

public class CollissionBox {
	
	public Vector2f position = new Vector2f();
	public float minX;
	public float maxX;
	public float minY;
	public float maxY;
	private int collissionGap = 1;
	public Vector2f collidingVelocity = new Vector2f();
	
	public CollissionBox() {
		this.minX = -8;
		this.maxX = 8;
		this.minY = -8;
		this.maxY = 8;
		this.position.x = 0;
		this.position.y = 0;
	}
	
	public void update(float x, float y) {
		this.position.x = x;
		this.position.y = y;
	}
	
	public float getMaxSize() {
		float xSize = maxX - minX;
		float ySize = maxY - minY;
		
		if (xSize > ySize) {
			return xSize;
		}
		
		return ySize;
	}
	
	private boolean isInRange(CollissionBox box) {
		float size = box.getMaxSize();
		
		if (getMaxSize() > size) {
			size = getMaxSize();
		}
		
		if (Misc.getDistance(box.position, this.position) < size * 2) {
			return true;
		}
		
		return false;
	}
	
	public boolean checkCollission(CollissionBox box) {
		if (box != null && !box.equals(this)) {
			if (isInRange(box)) {
				int otherX = (int) box.position.x;
				int otherY = (int) box.position.y;
				int otherLeftX = otherX + (int) box.minX;
				int otherRightX = otherX + (int) box.maxX;
				int otherUpperY = otherY + (int) box.minY;
				int otherDownY = otherY + (int) box.maxY;
				
				int selfX = (int) this.position.x;
				int selfY = (int) this.position.y;
				int selfLeftX = selfX + (int) this.minX;
				int selfRightX = selfX + (int) this.maxX;
				int selfUpperY = selfY + (int) this.minY;
				int selfDownY = selfY + (int) this.maxY;
				
				boolean xAxis = false;
				boolean yAxis = false;
				
				for (int x1 = selfLeftX - collissionGap; x1 < selfRightX + collissionGap; x1++) {
					for (int x2 = otherLeftX - collissionGap; x2 < otherRightX + collissionGap; x2++) {
						if (x1 == x2) {
							xAxis = true;
							break;
						}
					}
				}
				
				for (int y1 = selfUpperY - collissionGap; y1 < selfDownY + collissionGap; y1 ++) {
					for (int y2 = otherUpperY - collissionGap; y2 < otherDownY + collissionGap; y2 ++) {
						if (y1 == y2) {
							yAxis = true;
							break;
						}
					}
				}
				
				if (xAxis && yAxis) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public boolean isCollidingLeft(CollissionBox box) {
		if (box != null && !box.equals(this)) {
			if (isInRange(box)) {
				int otherX = (int) box.position.x;
				int otherY = (int) box.position.y;
				int otherLeftX = otherX + (int) box.minX;
				int otherRightX = otherX + (int) box.maxX;
				
				int selfX = (int) this.position.x;
				int selfY = (int) this.position.y;
				int selfRightX = selfX + (int) this.maxX;

				if (selfRightX > otherLeftX) {
					if (selfRightX < otherRightX) {
						if (selfY < otherY) {
							collidingVelocity.y = 1;
						} else {
							collidingVelocity.y = -1;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isCollidingRight(CollissionBox box) {
		if (box != null && !box.equals(this)) {
			if (isInRange(box)) {
				int otherX = (int) box.position.x;
				int otherY = (int) box.position.y;
				int otherLeftX = otherX + (int) box.minX;
				int otherRightX = otherX + (int) box.maxX;
				
				int selfX = (int) this.position.x;
				int selfY = (int) this.position.y;
				int selfLeftX = selfX + (int) this.minX;

				if (selfLeftX < otherRightX) {
					if (selfLeftX > otherLeftX) {
						if (selfY <= otherY) {
							collidingVelocity.y = 1;
						} else {
							collidingVelocity.y = -1;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isCollidingUp(CollissionBox box) {
		if (box != null && !box.equals(this)) {
			if (isInRange(box)) {
				int otherX = (int) box.position.x;
				int otherY = (int) box.position.y;
				int otherUpperY = otherY + (int) box.minY;
				int otherDownY = otherY + (int) box.maxY;
				
				int selfX = (int) this.position.x;
				int selfY = (int) this.position.y;
				int selfDownY = selfY + (int) this.maxY;

				if (selfDownY > otherUpperY) {
					if (selfDownY < otherDownY) {
						if (selfX <= otherX) {
							collidingVelocity.x = 1;
						} else {
							collidingVelocity.x = -1;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean isCollidingDown(CollissionBox box) {
		if (box != null && !box.equals(this)) {
			if (isInRange(box)) {
				int otherX = (int) box.position.x;
				int otherY = (int) box.position.y;
				int otherUpperY = otherY + (int) box.minY;
				int otherDownY = otherY + (int) box.maxY;
				
				int selfX = (int) this.position.x;
				int selfY = (int) this.position.y;
				int selfUpperY = selfY + (int) this.minY;

				if (selfUpperY < otherDownY) {
					if (selfUpperY > otherUpperY) {
						if (selfX <= otherX) {
							collidingVelocity.x = 1;
						} else {
							collidingVelocity.x = -1;
						}
						
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean checkCollission(int x, int y) {
		int cx = (int) this.position.x;
		int cy = (int) this.position.y;
		int cMinX = cx + (int) this.minX;
		int cMaxX = cx + (int) this.maxX;
		int cMinY = cy + (int) this.minY;
		int cMaxY = cy + (int) this.maxY;
		
		boolean xAxis = false;
		boolean yAxis = false;
		
		for (int x1 = cMinX; x1 < cMaxX; x1++) {
			if (x1 == x) {
				xAxis = true;
				break;
			}
		}
		
		for (int y1 = cMinY; y1 < cMaxY; y1 ++) {
			if (y1 == y) {
				yAxis = true;
				break;
			}
		}
		
		if (xAxis && yAxis) {
			return true;
		} else {
			return false;
		}
	}
}
