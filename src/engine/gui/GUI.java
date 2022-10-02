package engine.gui;

import java.awt.Graphics;

import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.scene.GameScene;
import engine.scene.MenuScene;

public abstract class GUI {

	public GUI() {

	}
	
	public abstract void update(InputHandler input, int gameSpeed);
	public abstract void renderMenuGUI(Graphics graphics, Screen screen, MenuScene scene);
	public abstract void renderGameGUI(Graphics graphics, Screen screen, GameScene scene);
}
