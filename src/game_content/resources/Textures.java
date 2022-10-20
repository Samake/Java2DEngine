package game_content.resources;

import engine.texture.Texture;

public class Textures {

	public static final Texture[] list = new Texture[128];

	public final static Texture TEXTURE_CORONA = new Texture(list, 0, "/textures/effects/corona.png");

	public static int getListCount() {
		int count = 0;
		
		for (Texture texture : list) {
			if (texture != null) {
				count++;
			}
		}
		
		return count;
	}
}
