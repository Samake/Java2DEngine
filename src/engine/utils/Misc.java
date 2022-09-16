package engine.utils;

import java.util.Random;

public class Misc {
	
	private static Random rand = new Random();

	public static int randomInteger(int min, int max) {
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
