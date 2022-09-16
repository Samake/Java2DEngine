package engine.sound;

import engine.debug.Log;

public class SoundFile {
	
	private String path;

	public SoundFile(SoundFile[] soundFiles, int id, String path) {
		if (soundFiles[id] != null) throw new RuntimeException("Duplicate sound id on " + id);
		
		this.path = "/sounds/" + path;
		
		soundFiles[id] = this;
		
		Log.print("SoundFile " + id + ": " + this.path + " were loaded.");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
