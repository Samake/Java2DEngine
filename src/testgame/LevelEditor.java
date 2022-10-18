package testgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.core.Engine;
import engine.debug.Log;
import engine.entities.EntityBluePrint;
import engine.entities.npc.clothes.ClothesNPC;
import engine.input.InputHandler;
import engine.level.Level;
import engine.level.Level.LEVELTYPE;
import engine.level.LevelLoader;
import engine.rendering.Renderer;
import engine.scene.GameScene;
import game_content.entities.player.Player;
import game_content.resources.Clothes;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Sheets;
import game_content.resources.Sounds;
import game_content.resources.Tiles;
import game_editor.Editor;
import game_editor.gui.EditorGUIEntities;
import game_editor.gui.EditorGUILights;
import game_editor.gui.EditorGUIMenuBar;
import game_editor.gui.EditorGUIPlayer;
import game_editor.gui.EditorGUIPrefabs;
import game_editor.gui.EditorGUISlot7;
import game_editor.gui.EditorGUISlot8;
import game_editor.gui.EditorGUISlots;
import game_editor.gui.EditorGUISounds;
import game_editor.gui.EditorGUITiles;
import game_editor.gui.EditorGUIWorld;
import game_editor.input.ClickSystemEditor;

public class LevelEditor extends Engine {

	private static final long serialVersionUID = 1L;

	public boolean isRunning = false;
	
	public InputHandler input;
	public Renderer renderer;
	public GameScene scene;
	
	public JPanel propertiesPanel;
	public JPanel tileSLots;
	public JPanel entitySettings;
	public JPanel lightSettings;
	public JPanel soundSettings;
	public JPanel playerSettings;
	public JPanel prefabSettings;
	public JPanel slot7Settings;
	public JPanel slot8Settings;
	public JPanel worldSettings;
	
	public LevelEditor() {
		super(1280, 720, 5);

		title = "LevelEditor - " + title;
		
		input = new InputHandler(this);
		renderer = new Renderer();
		scene = new Editor();
		
		Log.print(Sheets.getSpriteSheetsCount() + " tile sheets were loaded.");
		Log.print(Tiles.getTilesCount() + " tiles were loaded.");
		Log.print(Sounds.getSoundsCount() + " sounds were loaded.");
		Log.print(Objects.getListCount() + " objects were loaded.");
		Log.print(Prefabs.getListCount() + " prefabs were loaded.");
		Log.print(NPCs.getListCount() + " npcs were loaded.");
		Log.print(Clothes.getListCount() + " clothes were loaded.");
		
		Log.print("LevelEditor started!");
	}
	
	@Override
	public void buildWindowGUI() {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);

		propertiesPanel = new JPanel();
		Dimension panelDimension = new Dimension(300, 300);
		
		propertiesPanel.setSize(300, 300);
		propertiesPanel.setMaximumSize(panelDimension);
		propertiesPanel.setMinimumSize(panelDimension);
		propertiesPanel.setPreferredSize(panelDimension);
		propertiesPanel.setBackground(Color.DARK_GRAY);

		EditorGUIMenuBar.addMenuBar(this, frame);
		EditorGUISlots.addEditorSlots(this, frame);
		
		tileSLots = EditorGUITiles.generateTileSlots(this);
		propertiesPanel.add(tileSLots);
		
		entitySettings = EditorGUIEntities.generateEntitySettings(this);
		propertiesPanel.add(entitySettings);
		
		lightSettings = EditorGUILights.generateLightSettings(this);
		propertiesPanel.add(lightSettings);
		
		soundSettings = EditorGUISounds.generateSoundSettings(this);
		propertiesPanel.add(soundSettings);
		
		playerSettings = EditorGUIPlayer.generatePlayerSettings(this);
		propertiesPanel.add(playerSettings);
		
		prefabSettings = EditorGUIPrefabs.generatePrefabSettings(this);
		propertiesPanel.add(prefabSettings);
		
		slot7Settings = EditorGUISlot7.generateSlot7Settings(this);
		propertiesPanel.add(slot7Settings);
		
		slot8Settings = EditorGUISlot8.generateSlot8Settings(this);
		propertiesPanel.add(slot8Settings);
		
		worldSettings = EditorGUIWorld.generateWorldSettings(this);
		propertiesPanel.add(worldSettings);
		
		frame.add(propertiesPanel, BorderLayout.EAST);
		
		frame.pack();
		
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setTitle("LevelEditor");
		frame.requestFocusInWindow();
		
		frame.addWindowListener(new WindowAdapter() {
			 @Override
			 public void windowClosing(WindowEvent e) {
				 Log.print("LevelEditor stopped.");
				 stop();
			 }
		});
		
		setEditorModeTiles();
	}
	
	public static void main(String[] args) {
		new LevelEditor().start();
	}
	
	@Override
	public void update(int gameSpeed) {
		ClickSystemEditor.update(input, gameSpeed);
		
		if (renderer != null) {
			renderer.update(input, gameSpeed);
		}
		
		if (scene != null) {
			scene.update(input, gameSpeed);
			
			if (Editor.editorSlot == 1) {
				
			}

			if (Editor.editorSlot == 2) {
				if (EditorGUIEntities.selectedEntity != ClickSystemEditor.selectedEntity) {
					EditorGUIEntities.updateEntityValues(ClickSystemEditor.selectedEntity);
				}
				
				if (ClickSystemEditor.pickedEntity != null) {
					EditorGUIEntities.updateEntityValues(ClickSystemEditor.pickedEntity);
				}
			}
			
			if (Editor.editorSlot == 3) {
				if (EditorGUILights.selectedLight != ClickSystemEditor.selectedLight) {
					EditorGUILights.updateLightValues(ClickSystemEditor.selectedLight);
				}
				
				if (ClickSystemEditor.pickedLight != null) {
					EditorGUILights.updateLightValues(ClickSystemEditor.pickedLight);
				}
			}
			
			if (Editor.editorSlot == 4) {
				
			}
			
			if (Editor.editorSlot == 5) {
				if (scene.level != null) {
					if (scene.level.player != null) {
						EditorGUIPlayer.updatePlayerValues(scene.level.player);
					} else {
						if (EditorGUIPlayer.player != ClickSystemEditor.selectedPlayer) {
							EditorGUIPlayer.updatePlayerValues(ClickSystemEditor.selectedPlayer);
						}
						
						if (ClickSystemEditor.pickedPlayer != null) {
							EditorGUIPlayer.updatePlayerValues(ClickSystemEditor.pickedPlayer);
						}
					}
				}
			}
			
			if (Editor.editorSlot == 6) {
				if (EditorGUIPrefabs.selectedPrefab != ClickSystemEditor.selectedPrefab) {
					EditorGUIPrefabs.updatePrefabValues(ClickSystemEditor.selectedLight);
				}
				
				if (ClickSystemEditor.pickedPrefab != null) {
					EditorGUIPrefabs.updatePrefabValues(ClickSystemEditor.pickedPrefab);
				}
			}
			
			if (Editor.editorSlot == 7) {
				
			}
			
			if (Editor.editorSlot == 8) {

			}
			
			if (Editor.editorSlot == 9) {
				if (scene.level != null) {
					EditorGUIWorld.updateWorldValues(scene.level);
				}
			}
		}
	}
	
	@Override
	public void render() {
		Editor editorScene = (Editor) scene;
		
		if (renderer != null && editorScene != null) {
			BufferStrategy bufferStrategy = getBufferStrategy();
			
			if (bufferStrategy == null) {
				createBufferStrategy(3);
				return;
			}
			
			Graphics graphics = bufferStrategy.getDrawGraphics();
			
			renderer.preRender(graphics, editorScene);
			renderer.render(this, bufferStrategy, graphics, editorScene);
			
			if (editorScene.brush != null && scene.level != null) {
				renderer.renderShape(bufferStrategy, editorScene.brush, Color.CYAN, 5);
			}
			
			renderer.postRender(bufferStrategy, graphics);
		}
	}
	
	public void newMap() {
		JTextField widthField = new JTextField();
		JTextField heightField = new JTextField();
		
        String comboBoxListe[] = {Tiles.VOID.name, Tiles.GRASS_CLEAN.name, Tiles.EARTH_CLEAN.name, Tiles.STONE_CLEAN.name, Tiles.SAND_CLEAN.name, Tiles.WATER_CLEAN.name};
        JComboBox<String> tileChoose = new JComboBox<String>(comboBoxListe);
		
		Object[] message = {
		    "Level width:", widthField,
		    "Level height:", heightField,
		    "Tile:", tileChoose
		};
		
		Log.print("Create new map...");

		int option = JOptionPane.showConfirmDialog(null, message, "New Level", JOptionPane.OK_CANCEL_OPTION);
		
		if (option == JOptionPane.OK_OPTION) {
			int width = Integer.valueOf(widthField.getText().trim());
			int height = Integer.valueOf(heightField.getText().trim());
			String tileName = tileChoose.getSelectedItem().toString().trim();
			
			scene.setLevel(new Level(width, height, tileName, true));
			
			Log.print("New map with size " + width + "x" + height + " were created!");
		}
	}
	
	public void loadMap() {
		loadMapPopup();
	}
	
	public void loadMapPopup() {
		Object[] levels = LevelLoader.getLevels();
		
		if (levels.length > 0) {
			Object levelName = JOptionPane.showInputDialog(frame, "Select available level...", "Load Level", JOptionPane.INFORMATION_MESSAGE, null, levels, levels[0]);
			
			if (levelName != null) {
				Level level = LevelLoader.loadLevel(levelName.toString());
				
				if (level != null) {
					scene.setLevel(level);
				}
			}
		} else {
			Object[] options = {"Cancel"};
			JOptionPane.showOptionDialog(frame,
				    "No levels available!",
				    "Load Level",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[0]);
		}
	}
	
	public void saveMap() {
		saveMapPopup();
	}
	
	public void saveMapPopup() {
		String levelName = JOptionPane.showInputDialog(frame, "Save level as...", "Save Level", JOptionPane.INFORMATION_MESSAGE);
		
		if (levelName != null && !levelName.isEmpty()) {
			if (LevelLoader.checkLevelAlreadyExists(levelName)) {
				Object[] options = {"Yes",
				                    "No",
				                    "Cancel"};
				int result = JOptionPane.showOptionDialog(frame,
				    "Level already exists, would you " + 
				    		"\n overwrite this level?",
				    "Save Level",
				    JOptionPane.YES_NO_CANCEL_OPTION,
				    JOptionPane.QUESTION_MESSAGE,
				    null,
				    options,
				    options[0]);
				
				switch (result) {
		        case 0:
		        	LevelLoader.saveLevel(scene.level, levelName);
		            break;
		        case 1:
		        	saveMapPopup();
		            break;
		        case 2:
		            break;
				}
			} else {
				LevelLoader.saveLevel(scene.level, levelName);
			}
		}
	}
	
	public void setEditorModeTiles() {
		Editor.editorSlot = 1;
		
		tileSLots.setVisible(true);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModeEntities() {
		Editor.editorSlot = 2;

		tileSLots.setVisible(false);
		entitySettings.setVisible(true);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModeLights() {
		Editor.editorSlot = 3;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(true);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModeSounds() {
		Editor.editorSlot = 4;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(true);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModePlayer() {
		Editor.editorSlot = 5;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(true);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModePrefabs() {
		Editor.editorSlot = 6;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(true);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorMode7() {
		Editor.editorSlot = 7;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(true);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(false);
	}
	
	public void setEditorMode8() {
		Editor.editorSlot = 8;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(true);
		worldSettings.setVisible(false);
	}
	
	public void setEditorModeWorld() {
		Editor.editorSlot = 9;

		tileSLots.setVisible(false);
		entitySettings.setVisible(false);
		lightSettings.setVisible(false);
		soundSettings.setVisible(false);
		playerSettings.setVisible(false);
		prefabSettings.setVisible(false);
		slot7Settings.setVisible(false);
		slot8Settings.setVisible(false);
		worldSettings.setVisible(true);
	}
	
	public void changePlayer(EntityBluePrint skin) {
		Level level = scene.level;
		
		if (level != null && skin != null) {
			Player oldPlayer = level.player;
			
			if (oldPlayer != null) {
				int x = (int) oldPlayer.position.x;
				int y = (int) oldPlayer.position.y;
				
				level.setPlayer(new Player(skin, scene.level, x, y, 1.0f));
			}
		}
	}
	
	public void changePlayerHat(ClothesNPC hat) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.hatSlot.set(hat);
			}
		}
	}
	
	public void changePlayerHair(ClothesNPC hair) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.hairSlot.set(hair);
			}
		}
	}
	
	public void changePlayerEyes(ClothesNPC eye) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.eyeSlot.set(eye);
			}
		}
	}
	
	public void changePlayerMouth(ClothesNPC mouth) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.mouthSlot.set(mouth);
			}
		}
	}
	
	public void changePlayerEar(ClothesNPC ear) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.earSlot.set(ear);
			}
		}
	}
	
	public void changePlayerBeard(ClothesNPC beard) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.beardSlot.set(beard);
			}
		}
	}
	
	public void changePlayerAccessoire(ClothesNPC accessoire) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.accessoiresSlot.set(accessoire);
			}
		}
	}
	
	public void changePlayerBody(ClothesNPC body) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.bodySlot.set(body);
			}
		}
	}
	
	public void changePlayerLegs(ClothesNPC legs) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.legSlot.set(legs);
			}
		}
	}
	
	public void changePlayerFeets(ClothesNPC feets) {
		Level level = scene.level;
		
		if (level != null) {
			Player player = level.player;
			
			if (player != null) {
				player.feetSlot.set(feets);
			}
		}
	}
	
	public void changeLevelType(LEVELTYPE type) {
		if (scene.level != null) {
			scene.level.type = type;
		}
	}
	
	public void setDayTime(int value) {
		if (scene.level != null) {
			scene.level.environment.time.hour = value;
		}
	}
	
	public void setDaycycle(boolean dayCycle) {
		if (scene.level != null) {
			scene.level.environment.time.dayCycle = dayCycle;
		}
	}
	
	public void generateWorld() {
		if (scene.level != null) {
			scene.level.generateNewRandomLevel();
		}
	}
	
	public void smoothLevel() {
		if (scene.level != null) {
			scene.level.smoothLevel();
		}
	}
	
	public void unlockTiles() {
		if (scene.level != null) {
			scene.level.unlockTiles();
		}
	}
}
