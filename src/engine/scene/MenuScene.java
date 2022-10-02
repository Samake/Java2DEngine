package engine.scene;

import java.awt.Graphics;

import engine.gui.GUI;
import engine.input.InputHandler;

public class MenuScene extends Scene {
	
	public GUI gui;
	
	public MenuScene() {
		super();
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (gui != null) {
			gui.update(input, gameSpeed);
		}
	}
	
	@Override
	public void render() {
		super.render();

	}
	
	@Override
	public void renderGUI(Graphics graphics) {
		super.renderGUI(graphics);
		if (gui != null) {
			gui.renderMenuGUI(graphics, screen, this);
		}
	}
}
