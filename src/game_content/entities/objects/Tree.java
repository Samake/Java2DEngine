package game_content.entities.objects;

import engine.entities.EntityBluePrint;
import engine.entities.objects.ObjectStatic;
import engine.input.InputHandler;
import engine.level.Level;
import game_content.entities.player.Player;

public class Tree extends ObjectStatic {

	public Tree(EntityBluePrint bluePrint, Level level, float x, float y) {
		super(bluePrint, level, x, y);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2);
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2);
			collissionBox.minY = (bluePrint.atlas.sheet.tileSize * 2);
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize * 3) - collissionOffset;
		}
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		Player player = level.getPlayer();

		if (player != null) {
			if (player.collissionBox != null && player.bluePrint.collission) {
				if (checkCollission(player.collissionBox)) {
					
				}
			}
		}
	}
}
