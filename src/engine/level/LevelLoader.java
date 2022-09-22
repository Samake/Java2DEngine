package engine.level;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.entities.Entity;
import engine.entities.Entity.ENTITYTYPE;
import engine.entities.EntityBluePrint;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import game_content.entities.lights.PointLight;
import game_content.entities.player.Player;
import game_content.resources.NPCs;
import game_content.resources.Objects;
import game_content.resources.Prefabs;
import game_content.resources.Tiles;

public class LevelLoader {
	
	private static final String MAP_PATH = "/maps/";
	private static BufferedReader bufferedReader;
	
	public static Level loadLevel(String levelFileName) {
		Log.print("Loading level " + levelFileName + "...");
		
		if (!levelFileName.isEmpty()) {
			URL pathURL = LevelLoader.class.getResource(MAP_PATH);
			String path = new String(pathURL + levelFileName).replace("file:/", "").trim();
			
			File fileObject = new File(path);

			try {
				if (fileObject.exists()) {
					
					int width = 0;
				    int height = 0;
				    
				    Level level = new Level(width, height, null);
				    
					bufferedReader = new BufferedReader(new FileReader(fileObject));
					
					if (bufferedReader != null) {
						List<String> tiles = new ArrayList<String>();
						
						String line;

					    while ((line = bufferedReader.readLine()) != null) {
					    	line = line.trim();

					    	if (line.contains("levelSize")) {
					    		String[] levelSizeLine = line.split(":");
					    		String[] levelSize = levelSizeLine[1].split("x");
						    		
						    	width = Integer.valueOf(levelSize[0]);
						    	height = Integer.valueOf(levelSize[1]);
						    }
					    	
					    	if (line.contains("tile:")) {
					    		line = line.replace("{", "");
					    		line = line.replace("}", "");
					    		tiles.add(line);
					    	}
					    	
					    	if (line.contains("type:Player")) {
					    		line = line.replace("{", "");
					    		line = line.replace("}", "");

					    		parsePlayerFromMap(level, line);
					    	}
					    	
					    	if (line.contains("type:Entity")) {
					    		line = line.replace("{", "");
					    		line = line.replace("}", "");

					    		parseEntityFromMap(level, line);
					    	}
					    	
					    	if (line.contains("type:Prefab")) {
					    		line = line.replace("{", "");
					    		line = line.replace("}", "");

					    		parsePrefabFromMap(level, line);
					    	}
					    	
					    	if (line.contains("type:PointLight")) {
					    		line = line.replace("{", "");
					    		line = line.replace("}", "");

					    		parseLightFromMap(level, line);
					    	}
					    }
					    
					    level.setSize(width, height);
					    
					    parseTilesFromMap(level, tiles);
					}

					Log.print("Level " + levelFileName + " were loaded successfully!");
					
					return level;
				} else {
					return null;
				}
			} catch (Exception e) {
				Log.print("An error occurred by loading level file: " + path, OUTPUTTYPE.ERROR);
				Log.print(e.getMessage(), OUTPUTTYPE.EXCEPTION);
			}
		}
		
		return null;
	}

	private static void parseTilesFromMap(Level level, List<String> tiles) {
		for (String tileLine : tiles) {
			String[] tileLineParts = tileLine.split(",");
			
			if (tileLineParts != null && tileLineParts.length == 4) {
				String[] idParts = tileLineParts[0].split(":");
				String[] blueprintParts = tileLineParts[1].split(":");
				String[] posXParts = tileLineParts[2].split(":");
				String[] posYParts = tileLineParts[3].split(":");
				
				int id = Integer.valueOf(idParts[1]);
				int blueprint = Integer.valueOf(blueprintParts[1]);
				int x = Integer.valueOf(posXParts[1]);
				int y = Integer.valueOf(posYParts[1]);
				
				level.tiles[x][y] = new BasicTile(id, x, y, Tiles.getBluePrintByID(blueprint), 1.0f);
			}
		}
	}
	
	private static void parsePlayerFromMap(Level level, String playerData) {
		//{type:Player,x:194.0,y:85.0,speed:1.0}
		
		String[] playerDataParts = playerData.split(",");
		
		if (playerDataParts != null && playerDataParts.length == 4) {
			String[] posXParts = playerDataParts[1].split(":");
			String[] posYParts = playerDataParts[2].split(":");
			//String[] speedParts = playerDataParts[3].split(":");
			
			float x = Float.valueOf(posXParts[1]);
			float y = Float.valueOf(posYParts[1]);
			//float speed = Float.valueOf(speedParts[1]);
			
			NPCs.addInstanceToLevel(NPCs.PLAYER, level, (int) x, (int) y);
		}
	}
	
	private static void parseEntityFromMap(Level level, String lightData) {
		String[] entityDataParts = lightData.split(",");
		
		if (entityDataParts != null && entityDataParts.length == 4) {
			String[] nameParts = entityDataParts[1].split(":");
			String[] posXParts = entityDataParts[2].split(":");
			String[] posYParts = entityDataParts[3].split(":");
			
			String name = String.valueOf(nameParts[1]);
			float x = Float.valueOf(posXParts[1]);
			float y = Float.valueOf(posYParts[1]);
			
			EntityBluePrint entityBluePrint = Objects.getBluePrintByName(name);
			
			if (entityBluePrint != null) {
				Objects.addInstanceToLevel(entityBluePrint, level, (int) x, (int) y);
			}
		}
	}
	
	private static void parsePrefabFromMap(Level level, String lightData) {
		String[] prefabDataParts = lightData.split(",");
		
		if (prefabDataParts != null && prefabDataParts.length == 4) {
			String[] nameParts = prefabDataParts[1].split(":");
			String[] posXParts = prefabDataParts[2].split(":");
			String[] posYParts = prefabDataParts[3].split(":");
			
			String name = String.valueOf(nameParts[1]);
			float x = Float.valueOf(posXParts[1]);
			float y = Float.valueOf(posYParts[1]);
			
			EntityBluePrint entityBluePrint = Prefabs.getBluePrintByName(name);
			
			if (entityBluePrint != null) {
				Prefabs.addInstanceToLevel(entityBluePrint, level, (int) x, (int) y);
			}
		}
	}
	
	private static void parseLightFromMap(Level level, String lightData) {
		String[] lightDataParts = lightData.split(",");
		
		if (lightDataParts != null && lightDataParts.length == 11) {
			String[] posXParts = lightDataParts[1].split(":");
			String[] posYParts = lightDataParts[2].split(":");
			String[] redParts = lightDataParts[3].split(":");
			String[] greenParts = lightDataParts[4].split(":");
			String[] blueParts = lightDataParts[5].split(":");
			String[] radiusParts = lightDataParts[6].split(":");
			String[] pulsingParts = lightDataParts[7].split(":");
			String[] flickeringParts = lightDataParts[8].split(":");
			String[] delayParts = lightDataParts[9].split(":");
			String[] enabledAtDayParts = lightDataParts[10].split(":");
			
			float x = Float.valueOf(posXParts[1]);
			float y = Float.valueOf(posYParts[1]);
			int red = Integer.valueOf(redParts[1]);
			int green = Integer.valueOf(greenParts[1]);
			int blue = Integer.valueOf(blueParts[1]);
			int radius = Integer.valueOf(radiusParts[1]);
			boolean pulsing = Boolean.valueOf(pulsingParts[1]);
			boolean flickering = Boolean.valueOf(flickeringParts[1]);
			int delay = Integer.valueOf(delayParts[1]);
			boolean enabledAtDay = Boolean.valueOf(enabledAtDayParts[1]);
			
			new PointLight(level, (int) x, (int) y, new Color(red, green, blue, 255), radius, pulsing, flickering, delay, enabledAtDay);
		}
	}
	
	public static Object[] getLevels() {
		URL pathURL = LevelLoader.class.getResource(MAP_PATH);
		String folderPath = new String(pathURL.toString()).replace("file:/", "").trim();
		
		File folder = new File(folderPath);
		File[] fileArray = folder.listFiles();
		
		List<String> levelNames = new ArrayList<String>();
		
		if (fileArray != null) {
			for (int i = 0; i < fileArray.length; i++) {
				String levelName = fileArray[i].getName();
				
				if (levelName.contains(".dat")) {
					levelNames.add(levelName);
				}
			}
		}
		
		Log.print("List levels. " + levelNames.size() + " levels available!");
		
		return levelNames.toArray();
	}
	
	public static boolean checkLevelAlreadyExists(String levelName) {
		if (!levelName.isEmpty()) {
			String levelFileName = levelName + ".dat";
			URL pathURL = LevelLoader.class.getResource(MAP_PATH);
			String path = new String(pathURL + levelFileName).replace("file:/", "").trim();
			
			try {
				File fileObject = new File(path);
				
				return fileObject.exists();
			} catch (Exception e) {
				Log.print("An error occurred by checking level file: " + path, OUTPUTTYPE.ERROR);
				Log.print(e.getMessage(), OUTPUTTYPE.EXCEPTION);
			}
		}
		
		return false;
	}
	
	public static void saveLevel(Level level, String levelName) {
		if (!levelName.isEmpty()) {
			Log.print("Saving level " + levelName + "...");
			
			String levelFileName = levelName + ".dat";
			URL pathURL = LevelLoader.class.getResource(MAP_PATH);
			String path = new String(pathURL + levelFileName).replace("file:/", "").trim();
			
			try {
				File fileObject = new File(path);
			      
				if (fileObject.createNewFile()) {
					Log.print("Level file " + levelFileName + " not exist and will be generated!");
				} else {
					Log.print("Level file " + levelFileName + " already exist and will be overwritten!");
				}
				
				FileOutputStream fileOutputStream = new FileOutputStream(fileObject);
				BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
				
				writeHeader(bufferedWriter, level, levelFileName);
				writeLevelData(bufferedWriter, level);
				writePlayerData(bufferedWriter, level);
				writeEntityData(bufferedWriter, level);
				writePrefabData(bufferedWriter, level);
				writeLightData(bufferedWriter, level);
				
				bufferedWriter.close();
			} catch (Exception e) {
				Log.print("An error occurred by saving level file: " + path, OUTPUTTYPE.ERROR);
				Log.print(e.getMessage(), OUTPUTTYPE.EXCEPTION);
			}
			
			Log.print("Level " + levelFileName + " saved successfully!");
		} else {
			Log.print("Level couldnt be saved. Level name is empty!", OUTPUTTYPE.ERROR);
		}
	}

	private static void writeHeader(BufferedWriter bufferedWriter, Level level, String levelFileName) throws Exception {
		bufferedWriter.write("[HEADER]");
		bufferedWriter.newLine();
		bufferedWriter.write("levelFileName:" + levelFileName);
		bufferedWriter.newLine();
		bufferedWriter.write("levelSize:" + level.width + "x" + level.height);
		bufferedWriter.newLine();
		bufferedWriter.write("levelTiles:" + level.width * level.height);
		bufferedWriter.newLine();
	}
	
	private static void writeLevelData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[TILES]");
		bufferedWriter.newLine();
		
	
		for (int x = 0; x < level.width; x++) {
			for (int y = 0; y < level.height; y++) {
				Tile tile = level.getTile(x, y);
				
				if (tile != null) {
					bufferedWriter.write("{id:" + tile.id + ",tile:" + tile.bluePrint.id + ",x:" + x + ",y:" + y + "}");
					bufferedWriter.newLine();
				} else {
					bufferedWriter.write("{NULL"+ ",x:" + x + ",y:" + y + "}");
					bufferedWriter.newLine();
				}
			}
		}
	}
	
	private static void writePlayerData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[Player]");
		bufferedWriter.newLine();
		
		Player player = level.getPlayer();

		if (player != null) {
			if (player.saveToMap) {
				bufferedWriter.write("{type:Player" + 
						",x:" + player.position.x + 
						",y:" + player.position.y + 
						",speed:" + player.speed 
						+ "}");
				
				bufferedWriter.newLine();
			}
		} else {
			bufferedWriter.write("{NULL}");
			bufferedWriter.newLine();
		}
	}

	private static void writeEntityData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[ENTITIES]");
		bufferedWriter.newLine();
		
		for (Entity entity : level.entities) {
			if (entity != null) {
				if (entity.bluePrint.entityType.equals(ENTITYTYPE.OBJECT)) {
					if (entity.saveToMap) {
						bufferedWriter.write("{type:Entity"
								+ ",name:"+ entity.bluePrint.name
								+ ",x:"+ entity.position.x 
								+ ",y:" + entity.position.y
						+ "}");
						
						bufferedWriter.newLine();
					}
				}
			}
		}
	}
	
	private static void writePrefabData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[PREFABS]");
		bufferedWriter.newLine();
		
		for (Entity entity : level.entities) {
			if (entity != null) {
				if (entity.bluePrint.entityType.equals(ENTITYTYPE.PREFAB)) {
					if (entity.saveToMap) {
						bufferedWriter.write("{type:Prefab"
								+ ",name:"+ entity.bluePrint.name
								+ ",x:"+ entity.position.x 
								+ ",y:" + entity.position.y
						+ "}");
						
						bufferedWriter.newLine();
					}
				}
			}
		}
	}
	
	private static void writeLightData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[LIGHTS]");
		bufferedWriter.newLine();

		for (PointLight light : level.lights) {
			if (light != null) {
				if (light.saveToMap) {
					bufferedWriter.write("{type:PointLight"
							+ ",x:"+ light.position.x 
							+ ",y:" + light.position.y 
							+ ",r:" + light.color.getRed()
							+ ",g:" + light.color.getGreen()
							+ ",b:" + light.color.getBlue()
							+ ",radius:" + light.radius
							+ ",pulsing:" + light.pulsing
							+ ",flickering:" + light.flickering
							+ ",delay:" + light.delay
							+ ",enabledAtDay:" + light.enabledAtDay
					+ "}");
					
					bufferedWriter.newLine();
				}
			} else {
				bufferedWriter.write("{NULL}");
				bufferedWriter.newLine();
			}
		}

	}
}
