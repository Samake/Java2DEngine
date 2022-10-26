package game_content.resources;

import engine.sound.SoundFile;

public class Sounds {
	public static final SoundFile[] list = new SoundFile[256];
	
	public static SoundFile MUSIC_BG_01 = new SoundFile(list, 0, "music_cinematic_piano_01.wav");
	
	public static SoundFile AMBIENT_LAKE_01 = new SoundFile(list, 50, "ambient_lake.wav");
	public static SoundFile AMBIENT_CAMPFIRE = new SoundFile(list, 51, "ambient_campfire.wav");
	public static SoundFile AMBIENT_RAIN = new SoundFile(list, 52, "ambient_rain.wav");
	
	public static SoundFile EFFECT_EGG_CRACK = new SoundFile(list, 100, "egg_crack.wav");
	public static SoundFile EFFECT_FOOTSTEP_GRASS = new SoundFile(list, 101, "footstep_grass.wav");
	public static SoundFile EFFECT_CHICKEN_01 = new SoundFile(list, 102, "chicken01.wav");
	
	public static int getSoundsCount() {
		int count = 0;
		
		for (SoundFile sound : list) {
			if (sound != null) {
				count++;
			}
		}
		
		return count;
	}
}
