package engine.gui;

import java.awt.Graphics;

import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.scene.Scene;

public abstract class GUI {

	public GUI() {

	}
	
	public abstract void update(InputHandler input);
	public abstract void render(Graphics graphics, Screen screen, Scene scene);
}
