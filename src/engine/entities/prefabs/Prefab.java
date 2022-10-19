package engine.entities.prefabs;

import java.awt.Color;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class Prefab extends Entity {
	
	public Player player;

	public Prefab(EntityConfig config, Level level, float x, float y) {
		super(config, level, x, y);
		
		debugColor = Color.MAGENTA;
	}

	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

		player = level.player;
	}
	
	@Override
	public void cleanUp() {

	}
}
