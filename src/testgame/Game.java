package testgame;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import engine.core.Engine;
import engine.debug.Log;
import engine.input.InputHandler;
import engine.rendering.Renderer;
import engine.scene.GameScene;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Sheets;
import game_content.resources.Sounds;
import game_content.resources.Tiles;
import testgame.input.ClickSystem;

public class Game extends Engine {

	private static final long serialVersionUID = 1L;

	public boolean isRunning = false;
	
	public InputHandler input;
	public Renderer renderer;
	public GameScene scene;
	
	public Game() {
		super(0, 0, 0);
		title = "Game - " + title;
		
		input = new InputHandler(this);
		renderer = new Renderer();
		//scene = new TestGame("demolevel");
		scene = new TestGame("farmland");
		
		
		Log.print(Sheets.getSpriteSheetsCount() + " tile sheets were loaded.");
		Log.print(Tiles.getTilesCount() + " tiles were loaded.");
		Log.print(Sounds.getSoundsCount() + " sounds were loaded.");
		Log.print(Objects.getListCount() + " objects were loaded.");
		Log.print(Prefabs.getListCount() + " prefabs were loaded.");
		Log.print(NPCs.getListCount() + " npcs were loaded.");
		
		Log.print("Game started!");
	}
	
	@Override
	public void update(int gameSpeed) {
		ClickSystem.update(input, gameSpeed);
		
		if (renderer != null) {
			renderer.update(input, gameSpeed);
		}
		
		if (scene != null) {
			scene.update(input, gameSpeed);
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
			
			renderer.preRender(graphics, scene);
			renderer.render(this, bufferStrategy, graphics, scene);
			renderer.postRender(bufferStrategy, graphics);
		}
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
