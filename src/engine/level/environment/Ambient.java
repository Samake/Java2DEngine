package engine.level.environment;

import java.awt.Color;

public class Ambient {
	
	public int hour = 12;
	public int minute = 0;
	
	private int timeOperator = 3600;
	private int minuteValue = 0;

	private int timeSpeed = 1;
	private float fadeValue = 0;
	
	private Color morningColor = new Color(120, 150, 180, 255);
	private Color dayColor = new Color(255, 240, 220, 255);
	private Color eveningColor = new Color(180, 90, 55, 255);
	private Color nightColor = new Color(25, 25, 45, 255);
	
	public Color ambientColor;
	public boolean dayCycle = false;
	
	public Ambient(boolean dayCycle) {
		this.dayCycle = dayCycle;
	}
	
	public void update(int gameSpeed) {
		if (dayCycle) {
			minuteValue += timeSpeed * gameSpeed;
			minute = minuteValue / 60;
			
			if (minuteValue >= timeOperator) {
				hour += 1;
				
				if (hour > 23) {
					hour = 0;
				}

				minuteValue = 0;	
			}
			
			fadeValue = ((1.0f / timeOperator) * minuteValue);
		}
			
		float r = 0;
		float g = 0;
		float b = 0;

		if (hour == 5) { // night to morning
			r = (nightColor.getRed() * (1.0f - fadeValue)) + (morningColor.getRed() * fadeValue);
			g = (nightColor.getGreen() * (1.0f - fadeValue)) + (morningColor.getGreen() * fadeValue);
			b = (nightColor.getBlue() * (1.0f - fadeValue)) + (morningColor.getBlue() * fadeValue);
		} else if (hour >= 6 && hour <= 7) { // morning
			r = morningColor.getRed();
			g = morningColor.getGreen();
			b = morningColor.getBlue();
		} else if (hour == 8) { // morning to day
			r = (morningColor.getRed() * (1.0f - fadeValue)) + (dayColor.getRed() * fadeValue);
			g = (morningColor.getGreen() * (1.0f - fadeValue)) + (dayColor.getGreen() * fadeValue);
			b = (morningColor.getBlue() * (1.0f - fadeValue)) + (dayColor.getBlue() * fadeValue);
		} else if (hour >= 9 && hour <= 18) { // day
			r = dayColor.getRed();
			g = dayColor.getGreen();
			b = dayColor.getBlue();
		} else if (hour == 19) { // day to evening
			r = (dayColor.getRed() * (1.0f - fadeValue)) + (eveningColor.getRed() * fadeValue);
			g = (dayColor.getGreen() * (1.0f - fadeValue)) + (eveningColor.getGreen() * fadeValue);
			b = (dayColor.getBlue() * (1.0f - fadeValue)) + (eveningColor.getBlue() * fadeValue);
		} else if (hour >= 20 && hour <= 21)  { // evening
			r = eveningColor.getRed();
			g = eveningColor.getGreen();
			b = eveningColor.getBlue();
		} else if (hour == 22) { // evening to night
			r = (eveningColor.getRed() * (1.0f - fadeValue)) + (nightColor.getRed() * fadeValue);
			g = (eveningColor.getGreen() * (1.0f - fadeValue)) + (nightColor.getGreen() * fadeValue);
			b = (eveningColor.getBlue() * (1.0f - fadeValue)) + (nightColor.getBlue() * fadeValue);
		} else if (hour >= 23 || hour <= 4) { // night
			r = nightColor.getRed();
			g = nightColor.getGreen();
			b = nightColor.getBlue();
		} else {
			r = dayColor.getRed();
			g = dayColor.getGreen();
			b = dayColor.getBlue();
		}
		
		if (r < 0) r = 0;
		if (r > 255) r = 255;
		if (g < 0) g = 0;
		if (g > 255) g = 255;
		if (b < 0) b = 0;
		if (b > 255) b = 255;
		
		ambientColor = new Color((int) r, (int) g,(int) b);
		
	}
}
