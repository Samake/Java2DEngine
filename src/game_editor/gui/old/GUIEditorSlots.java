package game_editor.gui.old;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map.Entry;

import engine.core.Config;
import engine.input.InputHandler;
import engine.rendering.Screen;
import engine.scene.Scene;
import engine.sprites.SpriteAtlas;

public class GUIEditorSlots {
	
	public SpriteAtlas atlas;
	public HashMap<Integer, GUIEditorSingleSlot> slotMap = new HashMap<Integer, GUIEditorSingleSlot>();
	public int currentSlot = 1;
	
	public GUIEditorSlots(SpriteAtlas atlas) {
		this.atlas = atlas;
		
		int tileSize = atlas.sheet.tileSize;
		int x = Config.WINDOW_WIDTH / 2;
		int y = Config.WINDOW_HEIGHT - tileSize;
		
		slotMap.put(1, new GUIEditorSingleSlot("TILES", atlas, 0, 1, x - (tileSize * 4), y, 0, 0, true));
		slotMap.put(2, new GUIEditorSingleSlot("ENTITIES", atlas, 1, 2, x - (tileSize * 3), y, 0, 0, true));
		slotMap.put(3, new GUIEditorSingleSlot("LIGHTS", atlas, 2, 3, x - (tileSize * 2), y, 0, 0, true));
		slotMap.put(4, new GUIEditorSingleSlot("EMPTY", atlas, 3, 4, x - (tileSize * 1), y, 0, 0, true));
		slotMap.put(5, new GUIEditorSingleSlot("EMPTY", atlas, 4, 5, x + (tileSize * 0), y, 0, 0, true));
		slotMap.put(6, new GUIEditorSingleSlot("EMPTY", atlas, 5, 6, x + (tileSize * 1), y, 0, 0, true));
		slotMap.put(7, new GUIEditorSingleSlot("EMPTY", atlas, 6, 7, x + (tileSize * 2), y, 0, 0, true));
		slotMap.put(8, new GUIEditorSingleSlot("EMPTY", atlas, 7, 8, x + (tileSize * 3), y, 0, 0, true));
		slotMap.put(9, new GUIEditorSingleSlot("TIME", atlas, 8, 9, x + (tileSize * 4), y, 4, 2, false));
		
		toogleActiveSlot(currentSlot);
	}
	
	public void update(InputHandler input) {
		if (input.num1.isTyped()) {
			toogleActiveSlot(1);
		}
		
		if (input.num2.isTyped()) {
			toogleActiveSlot(2);
		}
		
		if (input.num3.isTyped()) {
			toogleActiveSlot(3);
		}
		
		if (input.num4.isTyped()) {
			toogleActiveSlot(4);
		}
		
		if (input.num5.isTyped()) {
			toogleActiveSlot(5);
		}
		
		if (input.num6.isTyped()) {
			toogleActiveSlot(6);
		}
		
		if (input.num7.isTyped()) {
			toogleActiveSlot(7);
		}
		
		if (input.num8.isTyped()) {
			toogleActiveSlot(8);
		}
		
		if (input.num9.isTyped()) {
			toogleActiveSlot(9);
		}
	}
	
	public void toogleActiveSlot(int slotID) {
		GUIEditorSingleSlot slot = slotMap.get(slotID);
		if (slot != null) {
			
			if (slot.activateable) {
				for (Entry<Integer, GUIEditorSingleSlot> slotEntry : slotMap.entrySet()) {
					slotEntry.getValue().active = false;
				}
				
				slot.active = true;
				
				currentSlot = slotID;
			}
			
			if (slot.states > 0) {
				slot.toggleState();
			}
		}
	}

	public void render(Graphics graphics, Screen screen, Scene scene) {
		for (Entry<Integer, GUIEditorSingleSlot> slotEntry : slotMap.entrySet()) {
			slotEntry.getValue().render(graphics, screen, scene);
		}
	}
}
