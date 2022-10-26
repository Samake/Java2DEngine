package engine.level.environment;

import engine.level.Level;
import engine.sound.Sound;

public class AmbientSound {

	private Sound rainSound;
	
	public AmbientSound(Level level) {
		//SoundManager.playSoundGlobal(Sounds.MUSIC_BG_01, 65.0f, false);
		// = SoundManager.playSoundGlobal(Sounds.AMBIENT_RAIN, 55.0f, true);
	}
	
	public void update(Time time, int gameSpeed, WeatherManager weatherManager) {
//		if (rainSound != null) {
//			if (weatherManager.rainLevel > 0) {
////				if (!rainSound.clip.isRunning()) {
////					rainSound.start();
////				}
//			} else {
////				if (rainSound.soundFile.clip.isRunning()) {
////					rainSound.stop();
////				}
//			}
//		}
	}
}
