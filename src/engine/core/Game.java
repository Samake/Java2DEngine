package engine.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import engine.debug.Log;
import engine.input.InputHandler;
import engine.rendering.Renderer;
import engine.scene.Scene;
import testgame.TestGame;

public class Game extends Engine {

	private static final long serialVersionUID = 1L;

	public boolean isRunning = false;
	
	public InputHandler input;
	public Renderer renderer;
	public Scene scene;
	
	public Game() {
		super(0, 0, 0);
		
		Log.print("Game starting...");
		
		title = "Game - " + title;
		
		input = new InputHandler(this);
		renderer = new Renderer();
		//scene = new TestGame("worldgen");
		//scene = new TestGame("devmap");
		scene = new TestGame("pathtest");
		
		Log.print("Game started!");
	}
	
	@Override
	public void update() {
		if (renderer != null) {
			renderer.update(input);
		}
		
		if (scene != null) {
			scene.update(input);
		}
	}
	
	@Override
	public void render() {
		if (renderer != null) {
			BufferStrategy bufferStrategy = getBufferStrategy();
			
			if (bufferStrategy == null) {
				createBufferStrategy(3);
				return;
			}
			
			Graphics graphics = bufferStrategy.getDrawGraphics();
			
			renderer.render(this, bufferStrategy, graphics, scene);
		}
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
