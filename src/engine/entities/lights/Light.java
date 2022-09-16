package engine.entities.lights;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import engine.utils.Misc;
import game_content.resources.Sheets;

public abstract class Light extends Entity {
	
	public Color color;
	public int radius;
	public boolean pulsing = false;
	public boolean flickering = false;
	public int delay = 0;
	public boolean enabledAtDay = true;
	public boolean enabled = true;
	
	public float alphaModifier = 1.0f;
	private double pulseFactor = 0.0;
	
	private long lastTick = System.currentTimeMillis();

	public Light(Level level, float x, float y, Color color, int radius, boolean pulsing, boolean flickering, int delay, boolean enabledAtDay) {
		super(new EntityBluePrint(null, 0, ENTITYTYPE.LIGHT, RENDERTYPE.R1X1, "LIGHT", new SpriteAtlas(Sheets.EDITOR_SHEET, 2, 1, false, 0, 0, false), false, false, false), level, x, y);
		
		this.position.x = x;
		this.position.y = y;
		this.color = color;
		this.radius = radius;
		this.pulsing = pulsing;
		this.flickering = flickering;
		this.delay = delay;
		this.enabledAtDay = enabledAtDay;
	}
	
	public void update(InputHandler input) {
		super.update(input);
		
		if (enabled) {
			long currentTick = System.currentTimeMillis();
			
			if (pulsing) {
				pulseFactor = (pulseFactor + (delay / 1000.0))%360;
				
				double pulseValue = Math.abs(Math.sin(pulseFactor));
				alphaModifier = (float) pulseValue;
			}
			
			if (flickering) {
				if (lastTick + delay < currentTick) {
					alphaModifier =  (float) Misc.randomInteger(700, 1000) / 1000;
					lastTick = currentTick;
				}
			}
		}
	}
}
