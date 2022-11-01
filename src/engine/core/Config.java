package engine.core;

public class Config {

	public static String APPLICATION_NAME = "Java 2D Game Engine";
	public static String APPLICATION_VERSION = "v0.74.014";
	
	/** VISUAL SETTINGS */
	public static int RESOLUTION_WIDTH = 1366;
	public static int RESOLUTION_HEIGHT = 768;
	public static int WINDOW_SCALE = 5;
	public static int WINDOW_WIDTH = RESOLUTION_WIDTH / WINDOW_SCALE;
	public static int WINDOW_HEIGHT = RESOLUTION_HEIGHT / WINDOW_SCALE;
	
	public static float NORMAL_STRENGTH = 0.035f;
	public static boolean ADVANCED_LIGHT = false;
	public static boolean LIGHT_SHINE = true;
	public static boolean LIGHT_CORONA = true;
	public static boolean SHADOWS = true;
	public static boolean HEIGHT_INFORMATIONS = false;
	
	/** GAME SETTINGS */
	public static int GAME_SPEED = 1;
}
