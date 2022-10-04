package engine.level.environment;

import engine.level.Level;

public class Environment {
	
	public Time time;
	public AmbientLight ambientLight;
	public AmbientSound ambientSound;
	
	public Environment(Level level) {
		time = new Time(12);
		ambientLight = new AmbientLight(level);
		ambientSound = new AmbientSound(level);
	}
	
	public void update(int gameSpeed) {
		if (time != null) {
			time.update(gameSpeed);
		}
		
		if (ambientLight != null) {
			ambientLight.update(time, gameSpeed);
		}
		
		if (ambientSound != null) {
			ambientSound.update(time, gameSpeed);
		}
	}
}
