package engine.level.environment;

import java.util.ArrayList;
import java.util.List;

import engine.debug.Log;
import engine.level.Level;
import engine.rendering.Canvas;
import engine.tiles.Tile;
import engine.utils.Misc;
import game_content.entities.effects.EffectRainDrop;
import game_content.entities.effects.EffectWaterRipples;
import game_content.resources.Sheets;
import game_content.resources.Tiles.TILETYPE;

public class WeatherManager {

	private Level level;
	public List<RainLayer> rainLayers = new ArrayList<RainLayer>();
	public List<FogLayer> fogLayers = new ArrayList<FogLayer>();

	public boolean changeWeather = true;
	public boolean isFoggy = false;
	public boolean isRaining = false;
	public boolean isThunderStorm = false;
	public float fogLevel = 0.0f;
	public float maxFogLevel = 25.0f;
	public float rainLevel = 0.0f;
	public float maxRainLevel = 25.0f;

	public boolean performFlash = false;
	public boolean performThunder = false;
	
	public int rainLayerCount = 0;
	public int fogLayerCount = 0;
	
	private long lastTick = System.currentTimeMillis();
	private int flashFrames = Misc.randomInteger(15, 45);
	private int flashFrame = 0;
	private int delay = Misc.randomInteger(1000, 15000);
	
	public WeatherManager (Level level) {
		this.level = level;
		
		lastTick = System.currentTimeMillis();
	}

	public void update(Time time, int gameSpeed) {
		rainLayerCount = (int) rainLevel;
		fogLayerCount = (int) fogLevel;
		
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
		
		if (isFoggy) {
			if (fogLevel < maxFogLevel) {
				changeFogLevel(0.05f * gameSpeed);
			} else {
				fogLevel = maxFogLevel;
			}
		} else {
			if (fogLevel > 0) {
				changeFogLevel(-0.05f * gameSpeed);
			} else {
				fogLevel = 0;
			}
		}
		
		if (fogLevel == 0) {
			if (!fogLayers.isEmpty()) {
				fogLayers.clear();
			}
		} else {
			List<FogLayer> updateListFog = new ArrayList<FogLayer>(fogLayers);
			
			if (updateListFog.size() < fogLayerCount) {
				addFogLayer();
			}
			
			for (FogLayer layer : updateListFog) {
				if (layer != null) {
					layer.update(gameSpeed);
				}
			}
		}
		
		if (rainLevel == 0) {
			if (!rainLayers.isEmpty()) {
				rainLayers.clear();
			}
			
			if (performFlash) {
				performFlash = false;
			}
			
			if (performThunder) {
				performThunder = false;
			}
			
			if (isThunderStorm) {
				isThunderStorm = false;
			}
		} else {
			List<RainLayer> updateListRain = new ArrayList<RainLayer>(rainLayers);
			
			if (updateListRain.size() < rainLayerCount) {
				addRainLayer();
			}
			
			for (RainLayer layer : updateListRain) {
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
			
			if (isThunderStorm) {
				long currentTick = System.currentTimeMillis();
				int currentDelay = delay / gameSpeed;
				
				if (lastTick + currentDelay < currentTick) {
					if (flashFrame < flashFrames) {
						flashFrame++;
						performFlash = true;
						performThunder = false;
					} else {
						performFlash = false;
						performThunder = true;
						flashFrame = 0;
						flashFrames = Misc.randomInteger(15, 45);
						lastTick = System.currentTimeMillis();
						delay = Misc.randomInteger(1000, 15000);
					}
				} else {
					performThunder = false;
					performFlash = false;
				}
			} else {
				performThunder = false;
				performFlash = false;
			}
		}
	}
	
	private void changeFogLevel(float value) {
		if (changeWeather) {
			fogLevel += value;
		}
	}

	private void changeRainLevel(float value) {
		if (changeWeather) {
			rainLevel += value;
		}
	}
	
	public void addFogLayer() {
		fogLayers.add(new FogLayer(this));
	}
	
	public void removeFogLayer(FogLayer layerIn) {
		if (fogLayers.contains(layerIn)) {
			fogLayers.remove(layerIn);
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
			
			Log.print("Its " + hour + " o?clock. IsRaining: " + isRaining + " ... because random value was: " + randomValueRain + " and IsThunderStorm: " + isThunderStorm  + " ... because random value was: " + randomValueThunderStorm);
		}
	}
}
