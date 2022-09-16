package engine.sprites;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconLoader {

	public static Icon getIconfromSheet(SpriteSheet sheet, int column, int row, int scale) {
		int columPixels = column * sheet.tileSize;
		int rowPixels = row * sheet.tileSize;
		int iconScale = scale * sheet.tileSize;
		
		//System.err.println("columPixels:" + columPixels + ", rowPixels: " + rowPixels + ", scale: " + scale + ", iconScale: " + iconScale);
		
		Image before = sheet.image.getSubimage(columPixels, rowPixels, sheet.tileSize, sheet.tileSize).getScaledInstance(iconScale, iconScale, Image.SCALE_SMOOTH);
		
		return new ImageIcon(before);
	}
}
