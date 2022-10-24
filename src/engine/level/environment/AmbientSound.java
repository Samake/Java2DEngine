package engine.level.environment;

import engine.level.Level;
import engine.sound.Sound;
import engine.sound.SoundManager;
import game_content.resources.Sounds;

public class AmbientSound {

	private Sound rainSound = SoundManager.playSoundGlobal(Sounds.AMBIENT_RAIN, 65.0f, true);
	
	public AmbientSound(Level level) {
		//SoundManager.playSoundGlobal(Sounds.MUSIC_BG_01, 65.0f, false);
		//SoundManager.playSoundGlobal(Sounds.AMBIENT_RAIN, 65.0f, true);
	}
	
	public void update(Time time, int gameSpeed, WeatherManager weatherManager) {
		if (rainSound != null) {
			//System.err.println(rainSound.clip.isRunning());
			if (weatherManager.rainLevel > 0) {
				if (!rainSound.clip.isRunning()) {
					rainSound.start();
				}
			} else {
				if (rainSound.clip.isRunning()) {
					rainSound.stop();
				}
			}
		}
	}
}
