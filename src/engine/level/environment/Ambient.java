package engine.level.environment;

import java.awt.Color;

public class Ambient {
	
	public int dayTime = 0;
	private int currentTime = 25000;
	private int endOfDay = 100000;//100;
	private int timeSpeed = 1;
	private float fadeValue = 0;
	
	private Color morningColor = new Color(120, 120, 150, 255);
	private Color dayColor = new Color(240, 230, 210, 255);
	private Color eveningColor = new Color(150, 75, 35, 255);
	private Color nightColor = new Color(15, 15, 30, 255);
	
	public Color ambientColor;
	public boolean dayCycle = false;
	
	public Ambient(boolean dayCycle) {
		this.dayCycle = dayCycle;
	}
	
	public void update(int gameSpeed) {
		if (dayCycle) {
			currentTime += timeSpeed * gameSpeed;
			fadeValue = 1.0f;//(1.0f / ((endOfDay)%(endOfDay / 10))) * (currentTime)%(currentTime / 10);
			
			fadeValue = ((1.0f / (endOfDay / 10.0f)) * (currentTime))%1.0f ;
			
			if (currentTime > endOfDay) {
				currentTime = 0;
			}
			
			dayTime = (int) ((10.0f / endOfDay) * currentTime);
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