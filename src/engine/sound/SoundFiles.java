package engine.sound;

import engine.debug.Log;

public class SoundFiles {
	public static final SoundFile[] soundFiles = new SoundFile[256];
	
	public static SoundFile MUSIC_BG_01;
	
	public static SoundFile AMBIENT_LAKE_01;
	public static SoundFile AMBIENT_CAMPFIRE;
	
	public static SoundFile EFFECT_EGG_CRACK;
	public static SoundFile EFFECT_FOOTSTEP_GRASS;
	public static SoundFile EFFECT_CHICKEN_01;
	
	public static void loadFiles() {
		Log.print("Loading soundfiles...");
		MUSIC_BG_01 = new SoundFile(soundFiles, 0, "bg_music_01.wav");
		
		AMBIENT_LAKE_01 = new SoundFile(soundFiles, 50, "ambient_lake.wav");
		AMBIENT_CAMPFIRE = new SoundFile(soundFiles, 51, "ambient_campfire.wav");
		
		EFFECT_EGG_CRACK = new SoundFile(soundFiles, 100, "egg_crack.wav");
		EFFECT_FOOTSTEP_GRASS = new SoundFile(soundFiles, 101, "footstep_grass.wav");
		EFFECT_CHICKEN_01 = new SoundFile(soundFiles, 102, "chicken01.wav");
		
		Log.print("Soundfiles loaded.");
	}
}
