package engine.utils;

import java.util.Random;

public class Misc {
	
	private static Random rand = new Random();

	public static int randomInteger(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static double getDistance(Vector2f position1, Vector2f position2) {
		return Math.sqrt((position2.y - position1.y) * (position2.y - position1.y) + (position2.x - position1.x) * (position2.x - position1.x));
	}
}
