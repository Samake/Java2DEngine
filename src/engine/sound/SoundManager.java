package engine.sound;

import java.util.ArrayList;
import java.util.List;

import engine.debug.Debug;
import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.utils.Vector2f;

public class SoundManager {
	
	private static List<Sound> sounds = new ArrayList<Sound>();
	public static Vector2f listenerPosition = new Vector2f();
	public static boolean isActive = true;
	
	public static void update(int gameSpeed) {
		List<Sound> updateSounds = new ArrayList<Sound>(sounds);
		
		for (Sound sound: updateSounds) {
			if (sound != null) {
				sound.update(gameSpeed);
			}
		}
	}
	
	public static Sound playSound(SoundFile soundFile, float volume) {
		if (isActive) {
			return playSound(soundFile, 0, 0, volume, 0, false, true);
		}
		
		return null;
	}
	
	public static Sound playSound(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		if (isActive && soundFile != null) {
			Sound sound = new Sound(soundFile.getPath(), x, y, volume, distance, looped, global);
			
			if (sound!= null) {
				sound.start();
				
				if (Debug.enabled) {
					Log.print("Sound " + soundFile.getPath() + " were started!", OUTPUTTYPE.DEBUG);
				}
				
				return sound;
			}
		}
		
		return null;
	}
	
	public static void startSound(Sound sound) {
		if (isActive && sound != null && sounds.contains(sound)) {
			sound.start();
		}
	}
	
	public static void stopSound(Sound sound) {
		if (isActive && sound != null && sounds.contains(sound)) {
			sound.stop();
		}
	}
	
	public static void addSound(Sound sound) {
		if (isActive && sound != null && !sounds.contains(sound)) {
			sounds.add(sound);
		}
	}
	
	public static void removeSound(Sound sound) {
		if (sound != null && sounds.contains(sound)) {
			sounds.remove(sound);
			sound = null;
		}
	}

	public static void cleanUp() {
		isActive = false;
	}
}
