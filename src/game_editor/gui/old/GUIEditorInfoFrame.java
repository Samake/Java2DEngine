package game_editor.gui.old;

import java.awt.Color;
import java.awt.Graphics;

import engine.camera.Camera;
import engine.level.Level;
import engine.rendering.Screen;
import engine.scene.Scene;
import engine.sprites.SpriteAtlas;

public class GUIEditorInfoFrame {

	private int x = 0;
	private int y = 0;
	private int width = 300;
	private int height = 60;
	private int lineSpace = 12;
	
	private Color backColor = new Color(0, 0, 0, 220);
	private Color fontColor = new Color(255, 255, 255, 255);
	
	public SpriteAtlas atlas;
	
	public GUIEditorInfoFrame(SpriteAtlas atlas) {
		this.atlas = atlas;
	}

	public void render(Graphics graphics, Screen screen, Scene scene) {
		if (scene != null) {
			Level level = scene.level;
			Camera camera = scene.camera;
			
			if (level != null) {
				if (camera != null) {
					graphics.setColor(backColor);
					graphics.fillRect(x, y, width, height);
					
					int line = 1;
	
					graphics.setColor(fontColor);
					graphics.drawString("Camera Position: x: " + (int) camera.position.x + ", y: " +  (int) camera.position.y, x + 10, y + lineSpace * line++);
					graphics.drawString("Freecam enabled: : " + String.valueOf(camera.freecam), x + 10, y + lineSpace * line++);
					graphics.drawString("World Entities: " + level.entities.size(), x + 10, y + lineSpace * line++);
					graphics.drawString("World Lights: " + level.lights.size(), x + 10, y + lineSpace * line++);
				}
			}
		}
	}
}
