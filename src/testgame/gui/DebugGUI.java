package testgame.gui;

import java.awt.Color;
import java.awt.Graphics;

import engine.camera.Camera;
import engine.debug.Debug;
import engine.gui.GUI;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;
import engine.scene.Scene;
import game_content.entities.player.Player;

public class DebugGUI extends GUI {

	private int x = 0;
	private int y = 0;
	private int width = 350;
	private int height = 115;
	private int lineSpace = 12;
	
	private Color backColor = new Color(0, 0, 0, 220);
	private Color fontColor = new Color(255, 255, 255, 255);
	
	private long totalMemory = 0;
	private long freeMemory = 0;
	private long usedMenory = 0;
	private int percentMemory = 0;
	private int mb = 1024 * 1024;
	
	public DebugGUI() {
		
	}

	public void update(InputHandler input) {
		Runtime runtime = Runtime.getRuntime();
		
		totalMemory = runtime.totalMemory() / mb;
		freeMemory = runtime.freeMemory() / mb;
		usedMenory = totalMemory - freeMemory;
		percentMemory = (int) ((100.0 / totalMemory) * usedMenory);
	}
	
	public void render(Graphics graphics, Screen screen, Scene scene) {
		if (scene != null) {
			Level level = scene.level;
			Camera camera = scene.camera;
			
			if (level != null) {
				Player player = level.getPlayer();
				
				if (player != null && camera != null) {
					int index = 1;
					
					graphics.setColor(backColor);
					graphics.fillRect(x, y, width, height);
	
					graphics.setColor(fontColor);
					
					graphics.drawString("Memory: " + totalMemory + " MB, Free: " + freeMemory + " MB, Used: " + usedMenory + " MB, Percent: " + percentMemory + " %", x + 10, y + lineSpace * index++);
					graphics.drawString("Camera Position: x: " + (int) camera.position.x + ", y: " +  (int) camera.position.y, x + 10, y + lineSpace * index++);
					graphics.drawString("Freecam enabled: : " + String.valueOf(camera.freecam), x + 10, y + lineSpace * index++);
					graphics.drawString("Player Position: x: " + (int) player.position.x + ", y: " +  (int) player.position.y, x + 10, y + lineSpace * index++);
					graphics.drawString("Tiles: " + Debug.tiles + ", Tiles rendered: " + Debug.tilesRendered, x + 10, y + lineSpace * index++);
					graphics.drawString("Decals: " + Debug.decals + ", Decals rendered: " + Debug.decalsRendered, x + 10, y + lineSpace * index++);
					graphics.drawString("Entities: " + Debug.entities + ", Entities rendered: " + Debug.entitiesRendered, x + 10, y + lineSpace * index++);
					graphics.drawString("Lights: " + Debug.lights + ", Lights rendered: " + Debug.lightsRendered, x + 10, y + lineSpace * index++);
				}
			}
		}
	}
}
