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
import engine.entities.EntityConfig;
import engine.entities.lights.PointLight;
import engine.level.Level.LEVELTYPE;
import engine.tiles.BasicTile;
import engine.tiles.Tile;
import game_content.entities.player.Player;
import game_content.resources.Clothes;
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
				    
				    Level level = new Level(width, height, null, false);
				    
					bufferedReader = new BufferedReader(new FileReader(fileObject));
					
					if (bufferedReader != null) {
						List<String> tiles = new ArrayList<String>();
						
						String line;

					    while ((line = bufferedReader.readLine()) != null) {
					    	line = line.trim();
					    	
					    	if (line.contains("leveltype")) {
					    		String[] levelTypeLine = line.split(":");
					    		String levelType = levelTypeLine[1];
					    		
					    		level.type = LEVELTYPE.valueOf(levelType);
					    	}

					    	if (line.contains("size")) {
					    		String[] levelSizeLine = line.split(":");
					    		String[] levelSize = levelSizeLine[1].split("x");
						    		
						    	width = Integer.valueOf(levelSize[0]);
						    	height = Integer.valueOf(levelSize[1]);
						    }
					    	
					    	if (line.contains("daytime")) {
					    		String[] dayTimeLine = line.split(":");
					    		int dayTime = Integer.valueOf(dayTimeLine[1]);
					    		
					    		level.environment.time.hour = dayTime;
					    	}
					    	
					    	if (line.contains("daycycle")) {
					    		String[] dayCycleLine = line.split(":");
					    		boolean dayCycle = Boolean.valueOf(dayCycleLine[1]);
					    		
					    		level.environment.time.dayCycle = dayCycle;
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
				
				level.tiles[x][y] = new BasicTile(id, x, y, Tiles.getConfigByID(blueprint), 1.0f);
			}
		}
	}
	
	private static void parsePlayerFromMap(Level level, String playerData) {
		String[] playerDataParts = playerData.split(",");
		
		if (playerDataParts != null && playerDataParts.length == 15) {
			String[] skinParts = playerDataParts[1].split(":");
			String[] posXParts = playerDataParts[2].split(":");
			String[] posYParts = playerDataParts[3].split(":");
			String[] bodySlotParts = playerDataParts[5].split(":");
			String[] legSlotParts = playerDataParts[6].split(":");
			String[] feetSlotParts = playerDataParts[7].split(":");
			String[] eyeSlotParts = playerDataParts[8].split(":");
			String[] mouthSlotParts = playerDataParts[9].split(":");
			String[] hairSlotParts = playerDataParts[10].split(":");
			String[] hatSlotParts = playerDataParts[11].split(":");
			String[] beardSlotParts = playerDataParts[12].split(":");
			String[] accessoiresSlotParts = playerDataParts[13].split(":");
			String[] earSlotParts = playerDataParts[14].split(":");
			
			String skin = String.valueOf(skinParts[1]);
			float x = Float.valueOf(posXParts[1]);
			float y = Float.valueOf(posYParts[1]);
			//float speed = Float.valueOf(speedParts[1]);
			
			EntityConfig skinBluePrint = NPCs.getConfigByName(skin);
			
			if (skinBluePrint != null) {
				Player player = NPCs.addPlayerInstanceToLevel(skinBluePrint, level, (int) x, (int) y);
				
				if (player != null) {
					player.bodySlot.set(Clothes.getClothesByName(String.valueOf(bodySlotParts[1])));
					player.legSlot.set(Clothes.getClothesByName(String.valueOf(legSlotParts[1])));
					player.feetSlot.set(Clothes.getClothesByName(String.valueOf(feetSlotParts[1])));
					player.eyeSlot.set(Clothes.getClothesByName(String.valueOf(eyeSlotParts[1])));
					player.mouthSlot.set(Clothes.getClothesByName(String.valueOf(mouthSlotParts[1])));
					player.hairSlot.set(Clothes.getClothesByName(String.valueOf(hairSlotParts[1])));
					player.hatSlot.set(Clothes.getClothesByName(String.valueOf(hatSlotParts[1])));
					player.beardSlot.set(Clothes.getClothesByName(String.valueOf(beardSlotParts[1])));
					player.accessoiresSlot.set(Clothes.getClothesByName(String.valueOf(accessoiresSlotParts[1])));
					player.earSlot.set(Clothes.getClothesByName(String.valueOf(earSlotParts[1])));
				}
			}
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
			
			EntityConfig entityBluePrint = Objects.getConfigByName(name);
			
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
			
			EntityConfig entityBluePrint = Prefabs.getConfigByName(name);
			
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
			
			new PointLight(level, (int) x, (int) y, new Color(red, green, blue, 255), radius, pulsing, flickering, 2, delay, enabledAtDay);
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
		bufferedWriter.write("name:" + levelFileName);
		bufferedWriter.newLine();
		bufferedWriter.write("leveltype:" + level.type.name());
		bufferedWriter.newLine();
		bufferedWriter.write("size:" + level.width + "x" + level.height);
		bufferedWriter.newLine();
		bufferedWriter.write("tiles:" + level.width * level.height);
		bufferedWriter.newLine();
		bufferedWriter.write("daytime:" + level.environment.time.hour);
		bufferedWriter.newLine();
		bufferedWriter.write("daycycle:" + level.environment.time.dayCycle);
		bufferedWriter.newLine();
	}
	
	private static void writeLevelData(BufferedWriter bufferedWriter, Level level) throws Exception {
		bufferedWriter.write("[TILES]");
		bufferedWriter.newLine();
		
	
		for (int x = 0; x < level.width; x++) {
			for (int y = 0; y < level.height; y++) {
				Tile tile = level.getTile(x, y);
				
				if (tile != null) {
					bufferedWriter.write("{id:" + tile.id + ",tile:" + tile.config.id + ",x:" + x + ",y:" + y + "}");
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
		
		Player player = level.player;

		if (player != null) {
			if (player.saveToMap) {
				StringBuilder builder = new StringBuilder();
				builder.append("{type:Player");
				builder.append(",skin:" + player.config.name);
				builder.append(",x:" + player.position.x);
				builder.append(",y:" + player.position.y);
				builder.append(",speed:" + player.speed);
				
				if (player.bodySlot.cloth != null) {
					builder.append(",bodySlot:" + player.bodySlot.cloth.name);
				} else {
					builder.append(",bodySlot:NULL");
				}
				
				if (player.legSlot.cloth != null) {
					builder.append(",legSlot:" + player.legSlot.cloth.name);
				} else {
					builder.append(",legSlot:NULL");
				}
				
				if (player.feetSlot.cloth != null) {
					builder.append(",feetSlot:" + player.feetSlot.cloth.name);
				} else {
					builder.append(",feetSlot:NULL");
				}
				
				if (player.eyeSlot.cloth != null) {
					builder.append(",eyeSlot:" + player.eyeSlot.cloth.name);
				} else {
					builder.append(",eyeSlot:NULL");
				}
				
				if (player.mouthSlot.cloth != null) {
					builder.append(",mouthSlot:" + player.mouthSlot.cloth.name);
				} else {
					builder.append(",mouthSlot:NULL");
				}
				
				if (player.hairSlot.cloth != null) {
					builder.append(",hairSlot:" + player.hairSlot.cloth.name);
				} else {
					builder.append(",hairSlot:NULL");
				}
				
				if (player.hatSlot.cloth != null) {
					builder.append(",hatSlot:" + player.hatSlot.cloth.name);
				} else {
					builder.append(",hatSlot:NULL");
				}
				
				if (player.beardSlot.cloth != null) {
					builder.append(",beardSlot:" + player.beardSlot.cloth.name);
				} else {
					builder.append(",beardSlot:NULL");
				}
				
				if (player.accessoiresSlot.cloth != null) {
					builder.append(",accessoiresSlot:" + player.accessoiresSlot.cloth.name);
				} else {
					builder.append(",accessoiresSlot:NULL");
				}
				
				if (player.earSlot.cloth != null) {
					builder.append(",earSlot:" + player.earSlot.cloth.name);
				} else {
					builder.append(",earSlot:NULL");
				}
				
				builder.append("}");
				bufferedWriter.write(builder.toString());
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
				if (entity.config.entityType.equals(ENTITYTYPE.OBJECT)) {
					if (entity.saveToMap) {
						bufferedWriter.write("{type:Entity"
								+ ",name:"+ entity.config.name
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
				if (entity.config.entityType.equals(ENTITYTYPE.PREFAB)) {
					if (entity.saveToMap) {
						bufferedWriter.write("{type:Prefab"
								+ ",name:"+ entity.config.name
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
