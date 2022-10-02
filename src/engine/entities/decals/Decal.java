package engine.entities.decals;

import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;

public class Decal extends Entity {
	
	private long duration;
	private long startTick;

	public Decal(EntityBluePrint bluePrint, Level level, int x, int y, long duration) {
		super(bluePrint, level, x, y);
		
		saveToMap = false;
		
		this.setDuration(duration);
		
		level.addDecal(this);
		
		startTick = System.currentTimeMillis();
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - 2;
			collissionBox.minY = (-bluePrint.atlas.sheet.tileSize / 2) + 2;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize / 2) - 2;
		}
		
		long currentDuration = duration / gameSpeed;
		
		float value = (startTick + currentDuration) - System.currentTimeMillis();
		alpha = (1.0f / currentDuration) * value;
		
		if (alpha <= 0.0f) {
			level.removeDecal(this);
		} else {
			if (alpha > 1.0f) {
				alpha = 1.0f;
			}
		}
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}
}
