package engine.sound;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import engine.utils.Vector2f;

public class SoundManager {
	
	private static Map<String, Sound> sounds = new HashMap<String, Sound>();
	public static Vector2f listenerPosition = new Vector2f();
	public static boolean isActive = true;
	
	public static void update(int gameSpeed) {
		if (isActive) {
			Map<String, Sound> updateSounds = new HashMap<String, Sound>(sounds);
			
			for (Entry<String, Sound> soundEntry : updateSounds.entrySet()) {
				if (soundEntry != null) {
					soundEntry.getValue().update(gameSpeed);
					
					if (!soundEntry.getValue().isPlaying) {
						sounds.remove(soundEntry.getKey());
					}
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
				
				return sound;
			}
		}
		
		return null;
	}

	private static Sound getSound(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
			String id = soundFile.id + "_" + (int) x + "_" + (int) y + "_" + (int) distance + "_" + looped + "_" + global;
			Sound sound = new Sound(id, soundFile, x, y, volume, distance, looped, global);
			sounds.put(id, sound);
			
			return sound;
	}
	
	public static int getSoundsCountPlayed() {
		return sounds.size();
	}

	public static void cleanUp() {
		isActive = false;
		
		for (Entry<String, Sound> soundEntry : sounds.entrySet()) {
			if (soundEntry != null) {
				soundEntry.getValue().stop();
				soundEntry.getValue().cleanUp();;
			}
		}
		
		sounds.clear();
	}
}
