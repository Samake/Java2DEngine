package engine.sound;

import java.util.ArrayList;
import java.util.List;

import engine.debug.Log;
import engine.utils.Vector2f;

public class SoundManager {
	
	private static List<Sound> sounds = new ArrayList<Sound>();
	public static Vector2f listenerPosition = new Vector2f();
	public static boolean isActive = true;

	public static void init() {
		Log.print("Staring sound system...");
		
		SoundFiles.loadFiles();

		Log.print("Sound system started!");
	}
	
	public static void update() {
		List<Sound> updateSounds = new ArrayList<Sound>(sounds);
		
		for (Sound sound: updateSounds) {
			if (sound != null) {
				sound.update();
			}
		}
	}
	
	public static Sound playMusic(SoundFile soundFile, float volume) {
		return playMusic(soundFile, 0, 0, volume, 0, true, true);
	}
	
	public static Sound playMusic(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		 //return new Sound(soundFile.getPath(), x, y, volume, distance, looped, global);
		 return null;
	}
	
	public static Sound playSound(SoundFile soundFile, float volume) {
		return playSound(soundFile, 0, 0, volume, 0, false, true);
	}
	
	public static Sound playSound(SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		//return new Sound(soundFile.getPath(), x, y, volume, distance, looped, global);
		return null;
	}
	
	public static void startSound(Sound sound) {
		if (isActive && sound != null && sounds.contains(sound)) {
			sound.play();
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
		if (isActive && sound != null && sounds.contains(sound)) {
			sounds.remove(sound);
			sound = null;
		}
	}

	public static void cleanUp() {
		isActive = false;
	}
}
