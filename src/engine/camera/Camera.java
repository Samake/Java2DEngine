package engine.camera;

import engine.debug.Log;
import engine.entities.Entity;
import engine.input.InputHandler;
import engine.sound.SoundManager;
import engine.utils.Vector2f;
import game_editor.input.ClickSystemEditor;
import testgame.input.ClickSystem;

public class Camera {

	public Vector2f position = new Vector2f();
	public Vector2f focus = new Vector2f();
	public Vector2f targetPosition = new Vector2f();
	public Vector2f velocity = new Vector2f();
	public float cameraSpeed = 5.0f;
	public boolean freecam = false;
	
	private Entity target;
	
	public Camera() {

		Log.print("Camera were initialzed.");	
	}
	
	public void update(InputHandler input, int gameSpeed) {
		if (input.toggleCamera.isTyped()) {
			freecam = !freecam;
		}
		
		if (freecam) {
			velocity.set(0, 0);
			
			if (input.cameraUp.isPressed()) velocity.add(0, -cameraSpeed * gameSpeed);
			if (input.cameraDown.isPressed()) velocity.add(0, cameraSpeed * gameSpeed);
			if (input.cameraLeft.isPressed()) velocity.add(-cameraSpeed * gameSpeed, 0);
			if (input.cameraRight.isPressed()) velocity.add(cameraSpeed * gameSpeed, 0);
			
			position.add(velocity);
		} else {
			if (target == null) {
				freecam = true;
			}
		}
		
		if (target != null && !freecam) {
			position.set(target.position);
		}
		
		SoundManager.listenerPosition.set(position.x, position.y);
		ClickSystemEditor.offsetPosition.set(position.x, position.y);
		ClickSystem.offsetPosition.set(position.x, position.y);
	}
	
	public void setPosition(int x, int y) {
		position.set(x, y);
	}
	
	public void setFocus(int x, int y) {
		focus.set(x, y);
	}
	
	public void setTargetPosition(int x, int y) {
		targetPosition.set(x, y);
	}

	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}
}
