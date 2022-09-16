package testgame;

import engine.level.LevelLoader;
import engine.scene.Scene;
import testgame.gui.DebugGUI;

public class TestGame extends Scene {

	public TestGame(String mapName) {
		super();
		
		
		setLevel(LevelLoader.loadLevel(mapName + ".dat"));
		camera.setTarget(level.getPlayer());
		gui = new DebugGUI();
	}
}
