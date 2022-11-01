package game_content.resources;

import engine.texture.Texture;

public class Textures {

	public static final Texture[] list = new Texture[128];

	public final static Texture TEXTURE_CORONA = new Texture(list, 0, "/textures/effects/corona.png", 1.0f);
	public final static Texture TEXTURE_RAIN_01 = new Texture(list, 1, "/textures/effects/rain_01.png", 0.25f);
	public final static Texture TEXTURE_RAIN_02 = new Texture(list, 2, "/textures/effects/rain_02.png", 0.25f);
	public final static Texture TEXTURE_RAIN_03 = new Texture(list, 3, "/textures/effects/rain_03.png", 0.25f);
	public final static Texture TEXTURE_RAIN_04 = new Texture(list, 4, "/textures/effects/rain_04.png", 0.25f);
	public final static Texture TEXTURE_FOG_01 = new Texture(list, 5, "/textures/effects/fog_01.png", 0.05f);

	public static Texture getTextureByID(int id) {
		return list[id];
	}
	
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
