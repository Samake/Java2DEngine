package game_content.entities.prefabs;

import java.awt.Color;

import engine.entities.EntityBluePrint;
import engine.entities.lights.PointLight;
import engine.entities.prefabs.Prefab;
import engine.input.InputHandler;
import engine.level.Level;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_editor.Editor;

public class GlowWorm extends Prefab {

	private PointLight light;
	private Vector2f lightOffset = new Vector2f();
	
	private Vector2f basePosition = new Vector2f();
	private Vector2f targetPosition = new Vector2f();
	private float targetPositionX = 0.0f;
	private float targetPositionY = 0.0f;
	
	private long lastTimeStamp = System.currentTimeMillis();
	private int delay = Misc.randomInteger(100, 5000);
	private int targetRadius = 48;
	private double animValue = 0;
	private float animSpeed = 0.01f;
	
	public GlowWorm(EntityBluePrint blueprint, Level level, int x, int y) {
		super(blueprint, level, x, y);
		
		basePosition.x = x;
		basePosition.y = y;
		targetPosition.x = position.x + Misc.randomInteger(-targetRadius, targetRadius);
		targetPosition.y = position.y + Misc.randomInteger(-targetRadius, targetRadius);
		targetPositionX = targetPosition.x;
		targetPositionY = targetPosition.y;
		animSpeed = Misc.randomInteger(75, 200) / 10000.0f;
		
		light = new PointLight(level, position.x, position.y, new Color(5, 90, 90, 255), 20, true, false, 0, Misc.randomInteger(5, 25), false);
		light.enabledAtDay = false;
		light.saveToMap = false;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (light != null) {
			
			bluePrint.rendered = light.enabled;
			light.position.x = position.x + lightOffset.x;
			light.position.y = position.y + lightOffset.y;
			
			if (light.enabled) {
				if (!Editor.isEditor) {
					if (targetPositionX < targetPosition.x) {
						targetPositionX += 0.01f;
					} else {
						targetPositionX -= 0.01f;
					}
					
					if (targetPositionY < targetPosition.y) {
						targetPositionY += 0.01f;
					} else {
						targetPositionY -= 0.01f;
					}
					
					animValue = (animValue + animSpeed)%100;
					float positionXModifier = (float) ((targetPositionX - basePosition.x) *  Math.sin(animValue));
					float positionYModifier = (float) ((targetPositionY - basePosition.y) *  Math.cos(animValue));
			
					position.x = basePosition.x + positionXModifier;
					position.y = basePosition.y + positionYModifier;
					
					int finalDelay =  delay / gameSpeed;
					
					if (lastTimeStamp + finalDelay < System.currentTimeMillis()) {
						targetPosition.x = position.x + Misc.randomInteger(-targetRadius, targetRadius);
						targetPosition.y = position.y + Misc.randomInteger(-targetRadius, targetRadius);
						animSpeed = Misc.randomInteger(75, 200) / 10000.0f;
						lastTimeStamp = System.currentTimeMillis();
					}
				}
			}
		}
	}
	
	@Override
	public void cleanUp() {
		super.cleanUp();
		
		if (light != null) {
			level.removeLight(light);
			light = null;
		}
	}
}
