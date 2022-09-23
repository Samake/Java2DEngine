package engine.scene.environment;

import java.awt.Color;

public class Ambient {
	
	public int dayTime = 0;
	private int dayTimeCounter = 0;
	private int dayTimeFactor = 15000;//100;
	private float fadeValue = 0;
	
	private Color morningColor = new Color(120, 120, 150, 255);
	private Color dayColor = new Color(240, 230, 210, 255);
	private Color eveningColor = new Color(150, 75, 35, 255);
	private Color nightColor = new Color(15, 15, 30, 255);
	
	public Color ambientColor;
	public boolean dayCycle = false;
	
	public Ambient(boolean dayCycle) {
		this.dayCycle = dayCycle;

		fadeValue = (1.0f / dayTimeFactor) * (dayTimeCounter);
	}
	
	public void update() {
		if (dayCycle) {
			dayTimeCounter++;;
			fadeValue = (1.0f / dayTimeFactor) * (dayTimeCounter);
			
			if (dayTimeCounter > dayTimeFactor) {
				dayTimeCounter = 0;
				dayTime = (dayTime + 1)%9;
			}
		}
			
		float r = 0;
		float g = 0;
		float b = 0;

		if (dayTime == 0) { // night to morning
			r = (nightColor.getRed() * (1.0f - fadeValue)) + (morningColor.getRed() * fadeValue);
			g = (nightColor.getGreen() * (1.0f - fadeValue)) + (morningColor.getGreen() * fadeValue);
			b = (nightColor.getBlue() * (1.0f - fadeValue)) + (morningColor.getBlue() * fadeValue);
		} else if (dayTime == 1) { // morning
			r = (morningColor.getRed() * (1.0f - fadeValue)) + (morningColor.getRed() * fadeValue);
			g = (morningColor.getGreen() * (1.0f - fadeValue)) + (morningColor.getGreen() * fadeValue);
			b = (morningColor.getBlue() * (1.0f - fadeValue)) + (morningColor.getBlue() * fadeValue);
		} else if (dayTime == 2) { // morning to day
			r = (morningColor.getRed() * (1.0f - fadeValue)) + (dayColor.getRed() * fadeValue);
			g = (morningColor.getGreen() * (1.0f - fadeValue)) + (dayColor.getGreen() * fadeValue);
			b = (morningColor.getBlue() * (1.0f - fadeValue)) + (dayColor.getBlue() * fadeValue);
		} else if (dayTime > 2 && dayTime <= 4) { // day
			r = (dayColor.getRed() * (1.0f - fadeValue)) + (dayColor.getRed() * fadeValue);
			g = (dayColor.getGreen() * (1.0f - fadeValue)) + (dayColor.getGreen() * fadeValue);
			b = (dayColor.getBlue() * (1.0f - fadeValue)) + (dayColor.getBlue() * fadeValue);
		} else if (dayTime == 5) { // day to evening
			r = (dayColor.getRed() * (1.0f - fadeValue)) + (eveningColor.getRed() * fadeValue);
			g = (dayColor.getGreen() * (1.0f - fadeValue)) + (eveningColor.getGreen() * fadeValue);
			b = (dayColor.getBlue() * (1.0f - fadeValue)) + (eveningColor.getBlue() * fadeValue);
		} else if (dayTime == 6) { // evening
			r = (eveningColor.getRed() * (1.0f - fadeValue)) + (eveningColor.getRed() * fadeValue);
			g = (eveningColor.getGreen() * (1.0f - fadeValue)) + (eveningColor.getGreen() * fadeValue);
			b = (eveningColor.getBlue() * (1.0f - fadeValue)) + (eveningColor.getBlue() * fadeValue);
		} else if (dayTime == 7) { // evening to night
			r = (eveningColor.getRed() * (1.0f - fadeValue)) + (nightColor.getRed() * fadeValue);
			g = (eveningColor.getGreen() * (1.0f - fadeValue)) + (nightColor.getGreen() * fadeValue);
			b = (eveningColor.getBlue() * (1.0f - fadeValue)) + (nightColor.getBlue() * fadeValue);
		} else if (dayTime > 7 && dayTime <= 9) { // night
			r = (nightColor.getRed() * (1.0f - fadeValue)) + (nightColor.getRed() * fadeValue);
			g = (nightColor.getGreen() * (1.0f - fadeValue)) + (nightColor.getGreen() * fadeValue);
			b = (nightColor.getBlue() * (1.0f - fadeValue)) + (nightColor.getBlue() * fadeValue);
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
