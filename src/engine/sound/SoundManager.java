package engine.sound;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.utils.Vector2f;

public class SoundManager {
	
	private static Map<SoundFile, Sound> sounds = new HashMap<SoundFile, Sound>();
	public static Vector2f listenerPosition = new Vector2f();
	public static boolean isActive = true;
	
	public static void update(int gameSpeed) {
		if (isActive) {
			for (Entry<SoundFile, Sound> soundEntry : sounds.entrySet()) {
				if (soundEntry != null) {
					soundEntry.getValue().update(gameSpeed);
				}
			}
		}
	}
	
	public static Sound playSoundGlobal(SoundFile soundFile, float volume, boolean looped) {
		if (isActive) {
			return playSound(soundFile, 0, 0, volume, 0, looped, true);
		}
		
		return null;
	}
	
	public static Sound playSoundLocal(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped) {
		if (isActive) {
			return playSound(soundFile, x, y, volume, distance, looped, false);
		}
		
		return null;
	}
	
	private static Sound playSound(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		if (isActive && soundFile != null) {
			Sound sound = getSound(soundFile, x, y, volume, distance, looped, global);
			
			if (sound!= null) {
				sound.global = global;
				sound.position.x = x;
				sound.position.y = x;
				sound.setVolume(volume);
				sound.maxDistance = distance;

				Log.print("Sound " + soundFile.path + " were started!", OUTPUTTYPE.DEBUG);
				
				sound.start();
				
				return sound;
			}
		}
		
		return null;
	}

	private static Sound getSound(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		if (sounds.containsKey(soundFile)) {
			return sounds.get(soundFile);
		} else {
			Sound sound = new Sound(soundFile.path, x, y, volume, distance, looped, global);
			sounds.put(soundFile, sound);
			
			return sound;
		}
	}

	public static void cleanUp() {
		isActive = false;
		
		for (Entry<SoundFile, Sound> soundEntry : sounds.entrySet()) {
			if (soundEntry != null) {
				soundEntry.getValue().clip.close();
			}
		}
	}
}
