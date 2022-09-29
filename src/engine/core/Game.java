package engine.core;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import engine.debug.Log;
import engine.input.InputHandler;
import engine.rendering.Renderer;
import engine.scene.Scene;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Sheets;
import game_content.resources.Sounds;
import game_content.resources.Tiles;
import testgame.TestGame;

public class Game extends Engine {

	private static final long serialVersionUID = 1L;

	public boolean isRunning = false;
	
	public InputHandler input;
	public Renderer renderer;
	public Scene scene;
	
	public Game() {
		super(0, 0, 0);
		title = "Game - " + title;
		
		input = new InputHandler(this);
		renderer = new Renderer();
		//scene = new TestGame("worldgen");
		//scene = new TestGame("devmap");
		scene = new TestGame("demolevel");
		
		Log.print(Sheets.getSpriteSheetsCount() + " tile sheets were loaded.");
		Log.print(Tiles.getTilesCount() + " tiles were loaded.");
		Log.print(Sounds.getSoundsCount() + " sounds were loaded.");
		Log.print(Objects.getListCount() + " objects were loaded.");
		Log.print(Prefabs.getListCount() + " prefabs were loaded.");
		Log.print(NPCs.getListCount() + " npcs were loaded.");
		
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
