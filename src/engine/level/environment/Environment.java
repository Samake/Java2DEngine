package engine.level.environment;

import engine.level.Level;

public class Environment {
	
	public Time time;
	public WeatherManager weatherManager;
	public AmbientLight ambientLight;
	public AmbientSound ambientSound;
	
	public Environment(Level level) {
		time = new Time(12, this);
		weatherManager = new WeatherManager(level);
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
			ambientSound.update(time, gameSpeed, weatherManager);
		}
	}

	public void recalculateWeather(int hour) {
		if (weatherManager != null) {
			weatherManager.performWeatherChange(hour);
		}
	}
}
