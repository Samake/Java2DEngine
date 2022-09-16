package game_editor.gui.old;

import java.awt.Graphics;

import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.scene.Scene;
import engine.sprites.SpriteAtlas;

public class GUIEditorSingleSlot {
	
	public String category;
	public SpriteAtlas atlas;
	public int iconID;
	public int slot;
	public int x = 0;
	public int y = 0;
	public int states = 0;
	
	public boolean activateable = true;
	public boolean active = false;
	public int state = 0;
	
	public GUIEditorSingleSlot(String category, SpriteAtlas atlas, int iconID, int slot, int x, int y, int states, int state, boolean activateable) {
		this.category = category;
		this.atlas = atlas;
		this.iconID = iconID;
		this.slot = slot;
		this.x = x;
		this.y = y;
		this.states = states;
		this.state = state;
		this.activateable = activateable;
	}

	public void update(InputHandler input) {
		
	}
	
	public void render(Graphics graphics, Screen screen, Scene scene) {
		int bgID;
		
		if (active) {
			bgID = atlas.getCurrentSprite(1, 0);
		} else {
			bgID = atlas.getCurrentSprite(0, 0);
		}
		
		if (!activateable) {
			bgID = atlas.getCurrentSprite(2, 0);
		}

		// render bg
		screen.renderGUI(atlas, x, y, bgID, 0x00, 1.0f);
		
		// render icon
		screen.renderGUI(atlas, x, y, atlas.getCurrentSprite(iconID + state, 1), 0x00, 1.0f);
	}
	
	public void toggleState() {
		if (states > 0) {
			state = (state + 1)%states;
		}
	}
}
