package game_editor.gui.old;

import java.awt.Graphics;

import engine.gui.GUI;
import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.scene.Scene;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class GUIEditor extends GUI {


	public SpriteAtlas atlas = new SpriteAtlas(Sheets.EDITOR_SHEET, 0, 0, false, 0, 0, false);
	
	private GUIEditorInfoFrame infoFrame;
	public GUIEditorSlots slots;
	
	public GUIEditor() {
		//infoFrame = new GUIEditorInfoFrame(atlas);
		//slots = new GUIEditorSlots(atlas);
	}

	public void update(InputHandler input) {
		if (slots != null) {
			//slots.update(input);
		}
	}
	
	public void render(Graphics graphics, Screen screen, Scene scene) {
		if (infoFrame != null) {
			//infoFrame.render(graphics, screen, scene);
		}
		
		if (slots != null) {
			//slots.render(graphics, screen, scene);
		}
	}
}
