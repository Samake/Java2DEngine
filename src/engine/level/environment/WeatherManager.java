package engine.level.environment;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {

	public List<RainLayer> rainLayers = new ArrayList<RainLayer>();
	public int dropLayers = 0;
	public boolean isRaining = true;
	public float rainLevel = 0.0f;
	public float maxRainLevel = 25.0f;
	
	public WeatherManager () {

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
