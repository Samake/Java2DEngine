package engine.sound;

public class SoundFile {
	
	public int id;
	public String path;

	public SoundFile(SoundFile[] soundFiles, int id, String filePath) {
		if (soundFiles[id] != null) throw new RuntimeException("Duplicate sound id on " + id);
		
		this.id = id;
		this.path = "/sounds/" + filePath;
		
		soundFiles[id] = this;
	}
}
