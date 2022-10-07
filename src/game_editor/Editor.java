package game_editor;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import engine.debug.Debug;
import engine.debug.Log;
import engine.entities.Entity;
import engine.entities.EntityBluePrint;
import engine.entities.lights.PointLight;
import engine.input.InputHandler;
import engine.scene.GameScene;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.entities.player.Player;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Tiles;
import game_editor.gui.DebugGUIEditor;
import game_editor.gui.EditorGUIPlayer;
import game_editor.input.ClickSystemEditor;

public class Editor extends GameScene {

	public static int tileSlotIDLeft = Tiles.waterIndex;
	public static int tileSlotIDRight = Tiles.grassIndex;
	public static String entitySlot = "";
	public static String prefabSlot = "";
	public static int editorSlot = 1;
	public static int dayTime = 0;
	public static int dayTimeValue = 3;
	public static boolean smoothTiles = false;
	
	public double brushSize = 50;
	public Point brushPosition = new Point(0, 0);
	public Shape brush;
	
	public Editor() {
		super();
		Log.print("Starting editor...");
		
		camera.freecam = true;
		
		gui = new DebugGUIEditor();
		brush = new Ellipse2D.Double(brushPosition.x - brushSize / 2, brushPosition.y - brushSize / 2, brushSize * 2, brushSize * 2);
		
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
			
			if (editorSlot == 1) {
				if (brush != null) {
					brushPosition.x = (int) ClickSystemEditor.mousePosition.x;
					brushPosition.y = (int) ClickSystemEditor.mousePosition.y;
					brush = new Ellipse2D.Double(brushPosition.x - brushSize, brushPosition.y - brushSize, brushSize * 2, brushSize * 2);

					changeTiles(input);
				} else {
					changeTile(input);
				}
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

	private void changeTile(InputHandler input) {
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
				
				EntityBluePrint skinBluePrint = NPCs.getBluePrintByName(EditorGUIPlayer.skinName);
				
				if (skinBluePrint == null) {
					skinBluePrint = NPCs.HUMAN_WOMAN_01;
				}
				
				NPCs.addPlayerInstanceToLevel(skinBluePrint, level, (int) position.x, (int) position.y);
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
}
