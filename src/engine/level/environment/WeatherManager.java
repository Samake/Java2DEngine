package engine.level.environment;

import java.util.ArrayList;
import java.util.List;

import engine.debug.Log;
import engine.level.Level;
import engine.rendering.Canvas;
import engine.sound.SoundManager;
import engine.tiles.Tile;
import engine.utils.Misc;
import game_content.entities.effects.EffectRainDrop;
import game_content.entities.effects.EffectWaterRipples;
import game_content.resources.Sheets;
import game_content.resources.Sounds;
import game_content.resources.Tiles.TILETYPE;

public class WeatherManager {

	private Level level;
	public List<RainLayer> rainLayers = new ArrayList<RainLayer>();
	public int dropLayers = 0;
	public boolean changeWeather = true;
	public boolean isRaining = true;
	public boolean isThunderStorm = true;
	public float rainLevel = 0.0f;
	public float maxRainLevel = 25.0f;
	public float thunderLight = 0;
	
	private boolean performThunder = false;
	private long lastTick = System.currentTimeMillis();
	private int flashFrames = Misc.randomInteger(5, 35);
	private int flashFrame = 0;
	private int delay = Misc.randomInteger(1000, 15000);
	
	public WeatherManager (Level level) {
		this.level = level;
		
		lastTick = System.currentTimeMillis();
	}

	public void update(Time time, int gameSpeed) {
		dropLayers = (int) rainLevel;
		
		if (isRaining) {
			if (rainLevel < maxRainLevel) {
				changeRainLevel(0.05f * gameSpeed);
			} else {
				rainLevel = maxRainLevel;
			}
		} else {
			if (rainLevel > 0) {
				changeRainLevel(-0.05f * gameSpeed);
			} else {
				rainLevel = 0;
				isThunderStorm = false;
			}
		}
		
		if (isThunderStorm && rainLevel > 0) {
			long currentTick = System.currentTimeMillis();
			int currentDelay = delay / gameSpeed;
			
			if (lastTick + currentDelay < currentTick) {
				if (flashFrame < flashFrames) {
					flashFrame++;
					thunderLight = Misc.randomInteger(55, 255);
				} else {
					performThunder = true;
					
					if (performThunder) {
						flashFrame = 0;
						flashFrames = Misc.randomInteger(5, 35);
						lastTick = System.currentTimeMillis();
						delay = Misc.randomInteger(1000, 15000);
						
						performThunderSound();
					}
					
					thunderLight = 0;
					performThunder = false;
				}
			} else {
				thunderLight = 0;
				performThunder = false;
			}
		} else {
			thunderLight = 0;
			performThunder = false;
		}
		
		if (rainLevel == 0) {
			if (!rainLayers.isEmpty()) {
				rainLayers.clear();
			}
		} else {
			List<RainLayer> updateList = new ArrayList<RainLayer>(rainLayers);
			
			if (updateList.size() < dropLayers) {
				addRainLayer();
			}
			
			for (RainLayer layer : updateList) {
				if (layer != null) {
					layer.update(gameSpeed);
				}
			}

			if (Misc.randomInteger(0, (int) maxRainLevel) <= rainLevel) {
				int x = Misc.randomInteger(Canvas.minX << Sheets.TILES_SHEET.getShiftOperator(), Canvas.maxX << Sheets.TILES_SHEET.getShiftOperator());
				int y = Misc.randomInteger(Canvas.minY << Sheets.TILES_SHEET.getShiftOperator(), Canvas.maxY << Sheets.TILES_SHEET.getShiftOperator());
				
				Tile tile = level.getWorldTile(x, y);
				
				if (tile != null) {
					if (tile.config.type.equals(TILETYPE.WATER)) {
						new EffectWaterRipples(level, x, y);
					} else {
						new EffectRainDrop(level, x, y);
					}
				}
			}
		}
	}

	private void performThunderSound() {
		int randomValue = Misc.randomInteger(0, 4);
		
		if (randomValue == 0) {
			SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_01, 65.0f, false);
		}
		
		if (randomValue == 1) {
			SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_02, 65.0f, false);
		}
		
		if (randomValue == 2) {
			SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_03, 65.0f, false);
		}
		
		if (randomValue == 3) {
			SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_04, 65.0f, false);
		}
		
		if (randomValue == 4) {
			SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_05, 65.0f, false);
		}
		
		Log.print("Thunder: " + randomValue);
	}

	private void changeRainLevel(float value) {
		if (changeWeather) {
			rainLevel += value;
		}
	}
	
	public void addRainLayer() {
		rainLayers.add(new RainLayer(this));
	}
	
	public void removeRainLayer(RainLayer layerIn) {
		if (rainLayers.contains(layerIn)) {
			rainLayers.remove(layerIn);
		}
	}
	
	public void performWeatherChange(int hour) {
		if (changeWeather) {
			int randomValueRain = Misc.randomInteger(0, 100);
			int randomValueThunderStorm = Misc.randomInteger(0, 100);
			
			if (randomValueRain > 70) {
				isRaining = true;
				
				if (randomValueThunderStorm > 70) {
					isThunderStorm = true;
				} else {
					isThunderStorm = false;
				}
			} else {
				isRaining = false;
				isThunderStorm = false;
			}
			
			Log.print("Its " + hour + " o´clock. IsRaining: " + isRaining + " ... because random value was: " + randomValueRain + " and IsThunderStorm: " + isThunderStorm  + " ... because random value was: " + randomValueThunderStorm);
		}
	}
}
