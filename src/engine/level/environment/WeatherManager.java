package engine.level.environment;

import java.util.ArrayList;
import java.util.List;

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
	public int dropLayers = 0;
	public boolean isRaining = true;
	public float rainLevel = 0.0f;
	public float maxRainLevel = 25.0f;
	
	public WeatherManager (Level level) {
		this.level = level;
	}

	public void update(Time time, int gameSpeed) {
		dropLayers = (int) rainLevel;
		
		if (isRaining) {
			if (rainLevel < maxRainLevel) {
				rainLevel += 0.05f * gameSpeed;
			} else {
				rainLevel = maxRainLevel;
			}
		} else {
			if (rainLevel > 0) {
				rainLevel -= 0.05f * gameSpeed;
			} else {
				rainLevel = 0;
			}
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
	
	public void addRainLayer() {
		rainLayers.add(new RainLayer(this));
	}
	
	public void removeRainLayer(RainLayer layerIn) {
		if (rainLayers.contains(layerIn)) {
			rainLayers.remove(layerIn);
		}
	}
}
