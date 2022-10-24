package engine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

import engine.utils.Misc;
import engine.utils.Vector2f;

public class Sound implements Runnable {
	
	public Clip clip;
	private AudioInputStream audioStream;
	public boolean looped = false;
	public boolean global = true;
	public Vector2f position = new Vector2f();
	public float maxDistance;
	public float maxVolume = 100.0f;
	public boolean saveToMap = true;
	
	public Sound(String path, float x, float y, float volume, float distance, boolean looped, boolean global) {
		this.looped = looped;
		this.global = global;
		this.maxVolume = volume;
		this.maxDistance = distance;
		
		position.x = x;
		position.y = y;
		
		try {
			clip = AudioSystem.getClip();
			
			clip.addLineListener(event -> {
				if (!looped) {
					if (event.getType() == LineEvent.Type.STOP) {
						stop();
					}
				} else {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
		    });
			
			audioStream = AudioSystem.getAudioInputStream(SoundManager.class.getResourceAsStream(path));
			
			clip.open(audioStream);
			
			if (!global) {
				setVolume(0.0f);
			} else {
				setVolume(maxVolume);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

	}
	
	public void update(int gameSpeed) {
		if (clip != null && clip.isRunning()) {
			if (!global) {
				if (SoundManager.listenerPosition != null) {
					double distance = Misc.getDistance(SoundManager.listenerPosition, position);
					
					if (distance <= maxDistance) {
						float volume = (float) (maxVolume - ((maxVolume / maxDistance) * distance));
						setVolume(volume);
					} else {
						setVolume(0.0f);
					}
				} else {
					setVolume(0.0f);
				}
			}
		}
	}
	
	public void setVolume(float volume) {
		if (clip != null) {
			FloatControl volumeBase = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			volume = 100.0f - volume;
			float volumeRange = Math.abs(volumeBase.getMinimum() - volumeBase.getMaximum());
			float volumeValue = volumeBase.getMaximum() - ((volumeRange / 100.0f) * volume);
			
			if (volumeValue < volumeBase.getMinimum()) {
				volumeValue = volumeBase.getMinimum();
			}
			
			if (volumeValue > volumeBase.getMaximum()) {
				volumeValue = volumeBase.getMaximum();
			}
			
			volumeBase.setValue(volumeValue);
		}
	}
	
	public void start() {
		if (clip != null) {
			if (clip.isRunning()) {
				clip.stop();
			}
			
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void stop() {
		if (clip != null) {
			clip.stop();
		}
	}
}
