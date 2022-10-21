package engine.level.environment;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {

	public List<RainLayer> rainLayers = new ArrayList<RainLayer>();
	public int dropLayers = 25;
	public boolean isRaining = true;
	
	public WeatherManager () {
		 
		if (isRaining) {
			for (int amount = 0; amount < dropLayers; amount++) {
				addRainLayer();
			}
		}
	}

	public void update(Time time, int gameSpeed) {
		if (isRaining) {
			List<RainLayer> updateList = new ArrayList<RainLayer>(rainLayers);
			
			if (updateList.size() < dropLayers) {
				addRainLayer();
			}
			
			for (RainLayer layer : updateList) {
				if (layer != null) {
					layer.update(gameSpeed);
				}
			}
		} else {
			if (!rainLayers.isEmpty()) {
				rainLayers.clear();
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
