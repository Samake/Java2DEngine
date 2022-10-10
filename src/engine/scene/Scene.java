package engine.scene;

import java.awt.Graphics;

import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.sound.SoundManager;

public class Scene {
	public Screen screen = new Screen();
	
	public Scene() {

	}
	
	public void update(InputHandler input, int gameSpeed) {
		SoundManager.update(gameSpeed);
	}
	
	public void render() {

	}
	
	public void renderGUI(Graphics graphics) {
		
	}

	public void cleanUp() {
		SoundManager.cleanUp();
	}
}
