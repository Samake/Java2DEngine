package engine.level.environment;

import engine.debug.Log;
import engine.level.Level;
import engine.utils.Misc;

public class Environment {
	
	public Time time;
	public WeatherManager weatherManager;
	public AmbientLight ambientLight;
	public AmbientSound ambientSound;
	
	public Environment(Level level) {
		time = new Time(12, this);
		weatherManager = new WeatherManager();
		ambientLight = new AmbientLight(level);
		ambientSound = new AmbientSound(level);
	}
	
	public void update(int gameSpeed) {
		if (time != null) {
			time.update(gameSpeed);
		}
		
		if (weatherManager != null) {
			weatherManager.update(time, gameSpeed);
		}
		
		if (ambientLight != null) {
			ambientLight.update(time, gameSpeed, weatherManager);
		}
		
		if (ambientSound != null) {
			ambientSound.update(time, gameSpeed);
		}
	}

	public void changeWeather(int hour) {
		int randomValue = Misc.randomInteger(0, 100);
		
		if (randomValue > 70) {
			weatherManager.isRaining = true;
		} else {
			weatherManager.isRaining = false;
		}
		
		Log.print("Its " + hour + " o´clock. IsRaining: " + weatherManager.isRaining + " ... because random value was: " + randomValue);
	}
}
