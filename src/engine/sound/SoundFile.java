package engine.sound;

public class SoundFile {
	
	public String path;

	public SoundFile(SoundFile[] soundFiles, int id, String path) {
		if (soundFiles[id] != null) throw new RuntimeException("Duplicate sound id on " + id);
		
		this.path = "/sounds/" + path;
		
		soundFiles[id] = this;
	}
}
