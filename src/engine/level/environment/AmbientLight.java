package engine.level.environment;

import java.awt.Color;

import engine.level.Level;
import engine.utils.Misc;

public class AmbientLight {
	
	private Color morningColor = new Color(120, 150, 180, 255);
	private Color dayColor = new Color(255, 240, 220, 255);
	private Color eveningColor = new Color(180, 90, 55, 255);
	private Color nightColor = new Color(25, 25, 45, 255);
	
	public Color ambientColor;
	public boolean dayCycle = true;
	
	public SunLight sunlight;
	
	public AmbientLight(Level level) {
		sunlight = new SunLight(level, 0, 0, new Color(0, 0, 0, 255));
		sunlight.saveToMap = false;
	}
	
	public void update(Time time, int gameSpeed, WeatherManager weatherManager) {	
		calculateAmbientLight(time, weatherManager);
		
		if (sunlight != null) {
			sunlight.updateLightValues(time, ambientColor);
		}
	}

	private void calculateAmbientLight(Time time, WeatherManager weatherManager) {
		float r = 0;
		float g = 0;
		float b = 0;

		if (time.hour == 5) { // night to morning
			r = (nightColor.getRed() * (1.0f - time.fadeValue)) + (morningColor.getRed() * time.fadeValue);
			g = (nightColor.getGreen() * (1.0f - time.fadeValue)) + (morningColor.getGreen() * time.fadeValue);
			b = (nightColor.getBlue() * (1.0f - time.fadeValue)) + (morningColor.getBlue() * time.fadeValue);
		} else if (time.hour >= 6 && time.hour <= 7) { // morning
			r = morningColor.getRed();
			g = morningColor.getGreen();
			b = morningColor.getBlue();
		} else if (time.hour == 8) { // morning to day
			r = (morningColor.getRed() * (1.0f - time.fadeValue)) + (dayColor.getRed() * time.fadeValue);
			g = (morningColor.getGreen() * (1.0f - time.fadeValue)) + (dayColor.getGreen() * time.fadeValue);
			b = (morningColor.getBlue() * (1.0f - time.fadeValue)) + (dayColor.getBlue() * time.fadeValue);
		} else if (time.hour >= 9 && time.hour <= 18) { // day
			r = dayColor.getRed();
			g = dayColor.getGreen();
			b = dayColor.getBlue();
		} else if (time.hour == 19) { // day to evening
			r = (dayColor.getRed() * (1.0f - time.fadeValue)) + (eveningColor.getRed() * time.fadeValue);
			g = (dayColor.getGreen() * (1.0f - time.fadeValue)) + (eveningColor.getGreen() * time.fadeValue);
			b = (dayColor.getBlue() * (1.0f - time.fadeValue)) + (eveningColor.getBlue() * time.fadeValue);
		} else if (time.hour >= 20 && time.hour <= 21)  { // evening
			r = eveningColor.getRed();
			g = eveningColor.getGreen();
			b = eveningColor.getBlue();
		} else if (time.hour == 22) { // evening to night
			r = (eveningColor.getRed() * (1.0f - time.fadeValue)) + (nightColor.getRed() * time.fadeValue);
			g = (eveningColor.getGreen() * (1.0f - time.fadeValue)) + (nightColor.getGreen() * time.fadeValue);
			b = (eveningColor.getBlue() * (1.0f - time.fadeValue)) + (nightColor.getBlue() * time.fadeValue);
		} else if (time.hour >= 23 || time.hour <= 4) { // night
			r = nightColor.getRed();
			g = nightColor.getGreen();
			b = nightColor.getBlue();
		} else {
			r = dayColor.getRed();
			g = dayColor.getGreen();
			b = dayColor.getBlue();
		}
		
		if (weatherManager.rainLevel > 0) {
			float greyValue = (r + g + b) / 3;
			float fadeValue = (1.0f / weatherManager.maxRainLevel) * weatherManager.rainLevel;
			r = (greyValue * fadeValue) + (r * (1.0f - fadeValue));
			g = (greyValue * fadeValue) + (g * (1.0f - fadeValue));
			b = (greyValue * fadeValue) + (b * (1.0f - fadeValue));
			
			r *= 1.0f - (fadeValue / 2);
			g *= 1.0f - (fadeValue / 2);
			b *= 1.0f - (fadeValue / 2);
		}
		
		if (weatherManager.performFlash) {
			float greyValue = (r + g + b) / 3;
			
			r = greyValue / 4;
			g = greyValue / 4;
			b = greyValue / 4;
			r += Misc.randomInteger(15, 255);
			g += Misc.randomInteger(15, 255);
			b += Misc.randomInteger(15, 255);
		}
		
		if (r < 0) r = 0;
		if (r > 255) r = 255;
		if (g < 0) g = 0;
		if (g > 255) g = 255;
		if (b < 0) b = 0;
		if (b > 255) b = 255;
		
		ambientColor = new Color((int) r, (int) g, (int) b);
	}
}
