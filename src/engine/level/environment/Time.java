package engine.level.environment;

public class Time {

	private Environment environment;
	private int timeOperator = 3600;
	private int minuteValue = 0;
	private int timeSpeed = 1;

	public int hour = 12;
	public int minute = 0;
	
	public boolean dayCycle = true;
	public float fadeValue = 0;
	
	public Time(int hour, Environment environment) {
		this.hour = hour;
		this.environment = environment;
	}
	
	public void update(int gameSpeed) {
		if (dayCycle) {
			minuteValue += timeSpeed * gameSpeed;
			minute = minuteValue / 60;
			
			if (minuteValue >= timeOperator) {
				hour += 1;
				environment.changeWeather(hour);
				
				if (hour > 23) {
					hour = 0;
				}

				minuteValue = 0;	
			}
			
			fadeValue = ((1.0f / timeOperator) * minuteValue);
		}
	}
}
