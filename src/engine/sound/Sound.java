package engine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

import engine.utils.Vector2f;

public class Sound implements Runnable {
	
	private Thread thread;
	public Clip clip;
	private AudioInputStream audioStream;
	public boolean looped = false;
	public boolean global = true;
	public Vector2f position = new Vector2f();
	public float maxDistance;
	public float maxVolume = 100.0f;
	public boolean isStarted = false;
	
	public Sound(String path, float x, float y, float volume, float distance, boolean looped, boolean global) {
		this.looped = looped;
		this.global = global;
		this.maxVolume = volume;
		this.maxDistance = distance;
		
		position.x = x;
		position.y = y;
		
		thread = new Thread(this);
		
		try {
			clip = AudioSystem.getClip();
			
			clip.addLineListener(event -> {
		      if (event.getType() == LineEvent.Type.STOP) {
		        stop();
		      }
		    });
			
			audioStream = AudioSystem.getAudioInputStream(SoundManager.class.getResourceAsStream(path));
			
			if (looped) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			
			clip.open(audioStream);
			
			setVolume(maxVolume);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SoundManager.addSound(this);
	}
	
	@Override
	public void run() {

	}
	
	public void update(int gameSpeed) {
		float currentVolume = maxVolume;
		
		if (clip != null) {
			if (!global) {
				if (SoundManager.listenerPosition != null) {
					float distance = SoundManager.listenerPosition.distance(position);
					
					if (distance >= maxDistance) {
						currentVolume = (maxVolume - ((maxVolume / maxDistance) * distance));
						
						if (currentVolume >= maxVolume) {
							currentVolume = maxVolume;
						}
						
						if (currentVolume <= 0.0f) {
							currentVolume = 0.0f;
						}
					}
				} else {
					currentVolume = 0.0f;
				}
			}
		}
		
		setVolume(currentVolume);
	}
	
	private void setVolume(float volume) {
		FloatControl volumeBase = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		float volumeValue = -1 * (100.0f - volume);
		
		if (volumeValue >= volumeBase.getMaximum()) {
			volumeValue = volumeBase.getMaximum();
		}
		
		if (volumeValue <= volumeBase.getMinimum()) {
			volumeValue = volumeBase.getMinimum();
		}
		
		volumeBase.setValue(volumeValue);
	}
	
	public void start() {
		if (!isStarted) {
			if (clip != null) {
				thread.start();
				clip.start();
				isStarted = true;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void stop() {
		if (clip != null) {
			 clip.close();
			 thread.stop();
			 isStarted = false;
			 SoundManager.removeSound(this);
		}
	}

	public boolean isLooped() {
		return looped;
	}

	public void setLooped(boolean looped) {
		this.looped = looped;
	}

	public boolean isGlobal() {
		return global;
	}

	public void setGlobal(boolean global) {
		this.global = global;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public float getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(float maxDistance) {
		this.maxDistance = maxDistance;
	}
}
