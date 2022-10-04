package engine.level.environment;

import engine.level.Level;
import engine.sound.SoundManager;
import game_content.resources.Sounds;

public class AmbientSound {

	public AmbientSound(Level level) {
		SoundManager.playSound(Sounds.MUSIC_BG_01, 80.0f);
	}
	
	public void update(Time time, int gameSpeed) {	
		
	}
}
