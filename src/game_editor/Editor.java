package game_editor;

import java.awt.Color;

import engine.debug.Debug;
import engine.debug.Log;
import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.input.InputHandler;
import engine.scene.GameScene;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.entities.lights.PointLight;
import game_content.entities.player.Player;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Tiles;
import game_editor.gui.DebugGUIEditor;
import game_editor.input.ClickSystemEditor;

public class Editor extends GameScene {

	public static int tileSlotIDLeft = 0;
	public static int tileSlotIDRight = 0;
	public static String entitySlot = "";
	public static String prefabSlot = "";
	public static int editorSlot = 1;
	public static int dayTime = 0;
	public static int dayTimeValue = 3;
	public static boolean smoothTiles = false;
	
	public Editor() {
		super();
		Log.print("Starting editor...");
		
		camera.freecam = true;
		
		gui = new DebugGUIEditor();
		
		isEditor = true;
		
		Log.print("Editor were started.");
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (level != null) {
			if (!level.editorMode) {
				level.editorMode = true;
			}
			
			if (level.ambient.dayTime != dayTimeValue) {
				level.ambient.dayTime = dayTimeValue;
			}
			
			if (editorSlot == 1) {
				changeTiles(input);
			} else {
				ClickSystemEditor.deselectTile();
			}
			
			if (editorSlot == 2) {
				changeEntities(input);
			} else {
				ClickSystemEditor.deselectEntity();
			}
			
			if (editorSlot == 3) {
				if (!Debug.renderLights) {
					Debug.renderLights = true;
				}
				
				changeLights(input);
			} else {
				if (Debug.renderLights) {
					Debug.renderLights = false;
				}
				
				ClickSystemEditor.deselectLight();
			}
			
			if (editorSlot == 4) {
				changeSounds(input);
			} else {

			}
			
			if (editorSlot == 5) {
				changePlayer(input);
			} else {
				ClickSystemEditor.deselectPlayer();
			}
			
			if (editorSlot == 6) {
				changePrefabs(input);
			} else {
				ClickSystemEditor.deselectPrefab();
			}
			
			if (editorSlot == 7) {
				
			}
			
			if (editorSlot == 8) {
				
			}
			
			if (editorSlot == 9) {
				
			}
		}
	}

	private void changeTiles(InputHandler input) {
		Tile tile = ClickSystemEditor.selectTile(input, level);
		
		if (tile != null) {
			if (input.lmouse.isClicked()) {
				int id = tile.x + tile.y * level.width;
				
				level.setTile(tile.x, tile.y, new BasicTile(id, tile.x, tile.y, Tiles.getBluePrintByID(tileSlotIDLeft), tile.brightness));
			}
			
			if (input.rmouse.isClicked()) {
				int id = tile.x + tile.y * level.width;
				
				level.setTile(tile.x, tile.y, new BasicTile(id, tile.x, tile.y, Tiles.getBluePrintByID(tileSlotIDRight), tile.brightness));
			}
		}
	}
	
	private void changeEntities(InputHandler input) {
		Entity entity = ClickSystemEditor.selectEntity(input, level);
		
		if (entity != null) {
			if (input.lmouse.isClicked()) {
				if (ClickSystemEditor.pickedEntity == null) {
					ClickSystemEditor.pickedEntity = entity;
				} else {
					ClickSystemEditor.pickedEntity = null;
				}
			}
			
			if (input.rmouse.isClicked()) {
				level.removeEntity(entity);
			}
		} else {
			if (input.rmouse.isClicked()) {
				EntityBluePrint entityBluePrint = Objects.getBluePrintByName(entitySlot);
				
				if (entityBluePrint != null) {
					Vector2f position = ClickSystemEditor.worldPosition;
					Objects.addInstanceToLevel(entityBluePrint, level, (int) position.x, (int) position.y);
				}
			}
		}
	}
	
	private void changeLights(InputHandler input) {
		PointLight light = ClickSystemEditor.selectLight(input, level);
		
		if (light != null) {
			if (input.lmouse.isClicked()) {
				if (ClickSystemEditor.pickedLight == null) {
					ClickSystemEditor.pickedLight = light;
				} else {
					ClickSystemEditor.pickedLight = null;
				}
			}
			
			if (input.rmouse.isClicked()) {
				level.removeLight((PointLight) light);
			}
		} else {
			if (input.rmouse.isClicked()) {
				Vector2f position = ClickSystemEditor.worldPosition;
				
				int r = Misc.randomInteger(64, 255);
				int g = Misc.randomInteger(64, 255);
				int b = Misc.randomInteger(64, 255);
				
				int radius = Misc.randomInteger(25, 150);

				new PointLight(level, (int) position.x, (int) position.y, new Color(r, g, b, 255), radius, false, false, 200, false);
			}
		}
	}
	
	private void changeSounds(InputHandler input) {
		
	}
	
	private void changePlayer(InputHandler input) {
		Player player = ClickSystemEditor.selectPlayer(input, level);
		
		if (player != null) {
			if (input.lmouse.isClicked()) {
				if (ClickSystemEditor.pickedPlayer == null) {
					ClickSystemEditor.pickedPlayer = player;
				} else {
					ClickSystemEditor.pickedPlayer = null;
				}
			}
			
			if (input.rmouse.isClicked()) {
				level.removePlayer();
			}
		} else {
			if (input.rmouse.isClicked()) {
				Vector2f position = ClickSystemEditor.worldPosition;
				
				NPCs.addInstanceToLevel(NPCs.PLAYER, level, (int) position.x, (int) position.y);
			}
		}
	}
	
	private void changePrefabs(InputHandler input) {
		Entity entity = ClickSystemEditor.selectPrefab(input, level);
		
		if (entity != null) {
			if (input.lmouse.isClicked()) {
				if (ClickSystemEditor.pickedPrefab == null) {
					ClickSystemEditor.pickedPrefab = entity;
				} else {
					ClickSystemEditor.pickedPrefab = null;
				}
			}
			
			if (input.rmouse.isClicked()) {
				level.removeEntity(entity); // todo
			}
		} else {
			if (input.rmouse.isClicked()) {
				EntityBluePrint entityBluePrint = Prefabs.getBluePrintByName(prefabSlot);
				
				if (entityBluePrint != null) {
					Vector2f position = ClickSystemEditor.worldPosition;
					Prefabs.addInstanceToLevel(entityBluePrint, level, (int) position.x, (int) position.y);
				}
			}
		}
	}
	
	public static void changeDayTime(int amount) {
		int value = dayTime + amount;
		
		if (value < 0) {
			value = 3;
		}
		
		dayTime = (value)%4;
		
		switch(dayTime) {
			case 0 :
				dayTimeValue = 9;
				return;
			case 1 :
				dayTimeValue = 1;
				return;
			case 2 :
				dayTimeValue = 3;
				return;
			case 3 :
				dayTimeValue = 6;
				return;
			default:
				dayTimeValue = 3;
				return;
		}
	}
}
