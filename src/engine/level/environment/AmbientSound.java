package engine.level.environment;

import engine.level.Level;
import engine.sound.Sound;
import engine.sound.SoundManager;
import game_content.resources.Sounds;

public class AmbientSound {

	private Sound rainSound;
	
	public AmbientSound(Level level) {
		SoundManager.playSoundGlobal(Sounds.MUSIC_BG_01, 85.0f, false);
		
		rainSound = SoundManager.playSoundGlobal(Sounds.AMBIENT_RAIN, 70.0f, true);
	}
	
	public void update(Time time, int gameSpeed, WeatherManager weatherManager) {
		if (rainSound != null) {
			if (weatherManager.rainLevel > 0) {
				float volume = (rainSound.maxVolume / 25.0f) * weatherManager.rainLevel;
				
				if (!rainSound.isPlaying) {
					rainSound.looped = true;
					rainSound.play();
				}
				
				rainSound.setVolume(volume);
			} else {
				if (rainSound.isPlaying) {
					rainSound.looped = false;
					rainSound.stop();
				}
			}
		}
	}
}
