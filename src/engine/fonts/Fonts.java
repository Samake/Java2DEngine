package engine.fonts;

import java.awt.Color;

import engine.rendering.Screen;
import engine.sprites.SpriteAtlas;
import game_content.resources.Sheets;

public class Fonts {

	private static SpriteAtlas atlas = new SpriteAtlas(Sheets.FONT_SHEET, 0, 0, false, 0, 0, false);
	private static String chars = 	"ABCDEFGHIJKLMNOPQRSTUVWXYZ" + 
									"abcdefghijklmnopqrstuvwxyz" +
									"ƒ÷‹‰ˆ¸ﬂ" + 
									"0123456789" +
									".,:;'*\"!?$%()-=+/# ";
 
	public static void render(String msg, Screen screen, float x, float y, float xOffset, float yOffset, float space, float scale, Color color) {
		int length = msg.length();
		float letterSize = Sheets.FONT_SHEET.tileSize * scale * space;
		
		float xBase = (x + xOffset * scale) - (((letterSize * space * scale) / 2) * length);
		float yBase = (y + yOffset * scale);
 
		for (int i = 0; i < msg.length(); i++) {
			int charIndex = chars.indexOf(msg.charAt(i));
			
			float xPos = xBase + (i * letterSize * space);
			float yPos = yBase - (letterSize / 2);
			int tileID = charIndex + 0 * Sheets.FONT_SHEET.tileSize;
			
			if (charIndex >= 0) {
				screen.renderFont(atlas, xPos, yPos, tileID, 0x00, scale, color);
			}
		}
	}
}
