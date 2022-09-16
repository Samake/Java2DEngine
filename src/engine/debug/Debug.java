package engine.debug;

public class Debug {

	public static boolean enabled = false;
	public static boolean renderLights = false;
	
	public static int tiles = 0;
	public static int tilesRendered = 0;
	public static int decals = 0;
	public static int decalsRendered = 0;
	public static int entities = 0;
	public static int entitiesRendered = 0;
	public static int lights = 0;
	public static int lightsRendered = 0;
	
	public static void toggle() {
		enabled = !enabled;
	}
}
