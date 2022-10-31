package engine.level.environment;

import engine.debug.Log;
import engine.level.Level;
import engine.sound.Sound;
import engine.sound.SoundManager;
import engine.utils.Misc;
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
				
				if (!rainSound.audio.isRunning()) {
					rainSound.looped = true;
					rainSound.play();
				}
				
				rainSound.setVolume(volume);
			} else {
				if (rainSound.audio.isRunning()) {
					rainSound.setVolume(0);
					rainSound.looped = false;
					rainSound.stop();
				}
			}
			
			if (weatherManager.isThunderStorm) {
				if (weatherManager.performThunder) {
					performThunderSound();
					weatherManager.performThunder = false;
				}
			}
		}
	}
	
	private void performThunderSound() {
		int thunderSound = Misc.randomInteger(0, 4);
		
		switch(thunderSound) {
			case 0:	
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_01, 65.0f, false);
				break;
			case 1:	
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_02, 65.0f, false);
				break;
			case 2:	
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_03, 65.0f, false);
				break;
			case 3:	
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_04, 65.0f, false);
				break;
			case 4:	
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_05, 65.0f, false);
				break;
			default:
				SoundManager.playSoundGlobal(Sounds.AMBIENT_THUNDER_01, 65.0f, false);
				break;
		}
		
		Log.print("Thunder: " + thunderSound);
	}
}
