package engine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

import engine.debug.Log;
import engine.debug.Log.OUTPUTTYPE;
import engine.utils.Misc;
import engine.utils.Vector2f;

public class Sound implements Runnable {
	
	public String id;
	public SoundFile soundFile;
	public boolean looped = false;
	public boolean global = true;
	public Vector2f position = new Vector2f();
	public float maxDistance;
	public float maxVolume = 100.0f;
	public boolean saveToMap = true;
	
	public Thread thread;
	public Clip audio;

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

		thread = new Thread(this, id);
		thread.start();
		
		try {
			audio = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(soundFile.path));
	        audio.open(inputStream);

	        audio.addLineListener(event -> {
	            if (event.getType() == LineEvent.Type.STOP) {
	            	if (!looped) {
						stop();
					}
	            }
	        });
		
			setVolume(0.0f);
			setBalance(0.0f);
			
			audio.flush();
		} catch(Exception ex) {
			Log.print(ex.getStackTrace().toString(), OUTPUTTYPE.EXCEPTION);
		}
		
		Log.print("Sound " + id + " were started!", OUTPUTTYPE.TEXT);
	}
	
	@Override
	public void run() {

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
						//audio.flush();
						setVolume(0.0f);
						setBalance(0.0f);
					}
				}
			} else {
				setVolume(maxVolume);
			}
		}
	}
	
	public void setVolume(float volume) {
		if (audio != null) {
			FloatControl volumeControl = (FloatControl) audio.getControl(FloatControl.Type.MASTER_GAIN);
			float volumeModifier = calculateVolume(volume);
			float dB = 20f * (float) Math.log10(volumeModifier);
			//audio.flush();
			volumeControl.shift(volumeControl.getValue(), dB, 0);
		}
	}
	
	public void setBalance(float balance) {
		if (audio != null) {
			FloatControl balanceControl = (FloatControl) audio.getControl(FloatControl.Type.BALANCE);
			float balanceValue = calculateBalance();
			//audio.flush();
			balanceControl.shift(balanceControl.getValue(), balanceValue, 0);
		}
	}
	
	private float calculateVolume(float volume) {
		float volumeModifier = (1.0f / 100.0f) * volume;
		
		if (volumeModifier < 0.0001f) {volumeModifier = 0.0001f;}
		if (volumeModifier > 1.0f) {volumeModifier = 1.0f;}
		
		return volumeModifier;
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
			
			audio.setFramePosition(0);
			
			if (looped) {
				audio.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				audio.start();;
			}
		}
	}
	
	public void stop() {
		if (audio != null) {
			audio.setFramePosition(0);
			audio.stop();
		}
	}
	
	public void pause() {
		if (audio != null) {

		}
	}
	
	public void cleanUp() {
		if (audio != null) {
			audio.close();
		}
	}
}
