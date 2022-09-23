package engine.sprites;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {

	public static Icon getIconfromSheet(SpriteSheet sheet, int column, int row, int width, int height, int scale) {
		int columPixels = column * sheet.tileSize;
		int rowPixels = row * sheet.tileSize;
		int iconScale = scale * sheet.tileSize;
		
		Image before = sheet.image.getSubimage(columPixels, rowPixels, sheet.tileSize * width, sheet.tileSize * height).getScaledInstance(iconScale, iconScale, Image.SCALE_AREA_AVERAGING);
		
		return new ImageIcon(before);
	}
}
