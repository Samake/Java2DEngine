package engine.rendering;

public class Canvas {

	public static int minX = 0;
	public static int maxX = 0;
	public static int minY = 0;
	public static int maxY = 0;
	public static int shiftOperator = 0;;
	
	
	public static boolean isOnScreen(float x, float y, float tolerance) {
		return isOnScreen((int) x, (int) y, (int) tolerance);
	}
	
	public static boolean isOnScreen(int x, int y, int tolerance) {
		if (x >= (minX << shiftOperator) - tolerance && x <= (maxX << shiftOperator) + tolerance) {
			if (y >= (minY << shiftOperator) - tolerance && y <= (maxY << shiftOperator) + tolerance) {
				return true;
			}
		}
	
		return false;
	}
}
