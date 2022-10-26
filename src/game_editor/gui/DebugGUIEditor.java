package game_editor.gui;

import java.awt.Color;
import java.awt.Graphics;

import engine.camera.Camera;
import engine.debug.Debug;
import engine.gui.GUI;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;
import engine.scene.GameScene;
import engine.scene.MenuScene;
import engine.sound.SoundManager;

public class DebugGUIEditor extends GUI {

	private int x = 0;
	private int y = 0;
	private int width = 300;
	private int height = 115;
	private int lineSpace = 12;
	
	private Color backColor = new Color(0, 0, 0, 220);
	private Color fontColor = new Color(255, 255, 255, 255);
	
	public DebugGUIEditor() {
		
	}

	public void update(InputHandler input, int gameSpeed) {
		
	}
	
	@Override
	public void renderMenuGUI(Graphics graphics, Screen screen, MenuScene scene) {

	}

	@Override
	public void renderGameGUI(Graphics graphics, Screen screen, GameScene scene) {
		if (scene != null) {
		Level level = scene.level;
		Camera camera = scene.camera;
		
		if (level != null && camera != null) {
				int index = 1;
			
				graphics.setColor(backColor);
				graphics.fillRect(x, y, width, height);
				graphics.setColor(fontColor);
				
				graphics.drawString("Camera Position: x: " + (int) camera.position.x + ", y: " +  (int) camera.position.y, x + 10, y + lineSpace * index++);
				graphics.drawString("Tiles: " + Debug.tiles + ", Tiles rendered: " + Debug.tilesRendered, x + 10, y + lineSpace * index++);
				graphics.drawString("Decals: " + Debug.decals + ", Decals rendered: " + Debug.decalsRendered, x + 10, y + lineSpace * index++);
				graphics.drawString("Entities: " + Debug.entities + ", Entities rendered: " + Debug.entitiesRendered, x + 10, y + lineSpace * index++);
				graphics.drawString("Lights: " + Debug.lights + ", Lights rendered: " + Debug.lightsRendered, x + 10, y + lineSpace * index++);
				graphics.drawString("Sounds played: " + SoundManager.getSoundsCountPlayed(), x + 10, y + lineSpace * index++);
			}
		}
	}
}
