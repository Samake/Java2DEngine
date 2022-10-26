package engine.sound;

import engine.utils.Misc;
import engine.utils.Vector2f;
import simple.audio.Audio;
import simple.audio.AudioEvent;
import simple.audio.AudioException;
import simple.audio.StreamedAudio;

public class Sound {
	
	public static final int BUFFER_SIZE = 8192;
	public String id;
	public SoundFile soundFile;
	public boolean looped = false;
	public boolean global = true;
	public Vector2f position = new Vector2f();
	public float maxDistance;
	public float maxVolume = 100.0f;
	public boolean saveToMap = true;
	
	public Audio audio;

	public Sound(String id, SoundFile soundFile, float x, float y, float volume, float distance, boolean looped, boolean global) {
		this.id = id;
		this.soundFile = soundFile;
		this.looped = looped;
		this.global = global;
		position.x = x;
		position.y = y;
		this.maxVolume = volume;
		this.maxDistance = distance;
		
		position.x = x;
		position.y = y;
		
		try {
			audio = new StreamedAudio(Sound.class.getResource(soundFile.path));
			audio.addAudioListener(event -> {
				if(event.getType() == AudioEvent.Type.REACHED_END) {
					stop();
				}
			});
			
			audio.open();
			
			setBalance(0.0f);
			setVolume(0.0f);
			
			play();
		} catch(AudioException exception) {
			exception.printStackTrace();
		}

	}
	
	public void update(int gameSpeed) {
		if (audio != null) {
			if (!global) {
				if (SoundManager.listenerPosition != null) {
					double distance = Misc.getDistance(SoundManager.listenerPosition, position);
					
					if (distance <= maxDistance) {
						float volume = (float) (maxVolume - ((maxVolume / maxDistance) * distance));
						setVolume(volume);
						setBalance(calculateBalance());
					} else {
						setVolume(0.0f);
						setBalance(0.0f);
					}
				} else {
					setVolume(0.0f);
					setBalance(0.0f);
				}
			} else {
				setVolume(maxVolume);
				setBalance(0.0f);
			}
		}
	}
	
	public void setVolume(float volume) {
		if (audio != null) {
			audio.setVolume(calculateVolume(volume));
		}
	}
	
	public void setBalance(float balance) {
		if (audio != null) {
			audio.setBalance(balance);
		}
	}
	
	private float calculateVolume(float volume) {
		float volumeRange = 160;
		float volumeModifier = (volumeRange / 100.0f) * volume;
		float volumeValue = -(volumeRange / 2) + volumeModifier;
		
		if (volumeValue < -80.0f) {volumeValue = -80.0f;}
		if (volumeValue > 80.0f) {volumeValue = 80.0f;}
		
		return volumeValue;
	};
	
	private float calculateBalance() {
		if (SoundManager.listenerPosition != null) {
			float balance = (float) (((position.x - SoundManager.listenerPosition.x) / maxDistance));
			
			if (balance < -1.0f) {balance = -1.0f;}
			if (balance > 1.0f) {balance = 1.0f;}

			return balance;
		}
		
		return 0;
	}
	
	public void play() {
		if (audio != null) {
			stop();
			
			if (looped) {
				audio.loop();
			} else {
				audio.play();
			}
		}
	}
	
	public void stop() {
		if (audio != null) {
			if (audio.isPlaying()) {
				audio.stop();
			}
		}
	}
	
	public void pause() {
		if (audio != null) {
			audio.pause();
		}
	}
	
	public void cleanUp() {
		if (audio != null) {
			audio.close();
		}
	}
}
