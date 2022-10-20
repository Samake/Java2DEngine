package engine.entities.lights;

import java.awt.Color;
import java.awt.image.BufferedImage;

import engine.entities.Entity;
import engine.entities.EntityConfig;
import engine.entities.EntityRenderData;
import engine.entities.EntityRenderData.RENDERTYPE;
import engine.input.InputHandler;
import engine.level.Level;
import engine.sprites.SpriteAtlas;
import engine.utils.Misc;
import engine.utils.Vector2f;
import game_content.resources.Sheets;
import game_content.resources.Textures;

public abstract class Light extends Entity {
	
	public enum LIGHTTYPE {
		POINTLIGHT, AMBIENTLIGHT
	}
	
	public LIGHTTYPE type = LIGHTTYPE.POINTLIGHT;
	public Color color;
	public int radius;
	public boolean pulsing = false;
	public boolean flickering = false;
	public int flickeringOffset = 0;
	public int delay = 0;
	public boolean enabledAtDay = true;
	public boolean enabled = true;
	public boolean coronaEnabled = true;
	public float coronaRadius = 0.0f;
	
	public float alphaModifier = 1.0f;
	private double pulseFactor = 0.0;
	
	private long lastTick = System.currentTimeMillis();
	private Vector2f basePosition = new Vector2f();
	
	public BufferedImage corona;

	public Light(Level level, float x, float y, Color color, int radius, boolean pulsing, boolean flickering, int flickeringOffset, int delay, boolean enabledAtDay) {
		super(new EntityConfig(null, 0, ENTITYTYPE.LIGHT, "LIGHT", false, new EntityRenderData(new SpriteAtlas(Sheets.EDITOR_SHEET, 2, 1, false, 0, 0, false), false, false, RENDERTYPE.R1X1)), level, x, y);
		
		this.position.x = x;
		this.position.y = y;
		this.color = color;
		this.radius = radius;
		this.pulsing = pulsing;
		this.flickering = flickering;
		this.flickeringOffset = flickeringOffset;
		this.delay = delay;
		this.enabledAtDay = enabledAtDay;
		
		basePosition.x = x;
		basePosition.y = y;
		
		generateCorona();
		
		coronaRadius = radius * 0.25f;
	}

	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (enabled) {
			long currentTick = System.currentTimeMillis();
			int currentDelay = delay / gameSpeed;
			
			if (pulsing) {
				pulseFactor = (pulseFactor + (delay / 1000.0))%360;
				
				double pulseValue = Math.abs(Math.sin(pulseFactor));
				alphaModifier = (float) pulseValue;
			}
			
			if (flickering) {
				if (lastTick + currentDelay < currentTick) {
					alphaModifier =  (float) Misc.randomInteger(700, 1000) / 1000;
					lastTick = currentTick;
					position.x = basePosition.x + Misc.randomInteger(-flickeringOffset, flickeringOffset);
					position.y = basePosition.y + Misc.randomInteger(-flickeringOffset, flickeringOffset);
				}
			}
		}
	}
	
	private void generateCorona() {
		if (Textures.TEXTURE_CORONA != null) {
			int[] coronaPixels = Textures.TEXTURE_CORONA.pixels;
			int[] result = new int[coronaPixels.length];
			
			corona = new BufferedImage(Textures.TEXTURE_CORONA.image.getWidth(), Textures.TEXTURE_CORONA.image.getHeight(), BufferedImage.TYPE_INT_ARGB);
			
			if (corona != null) {
				for (int i = 0; i < coronaPixels.length; i++) {
					Color coronaColor = new Color(coronaPixels[i], true);
					
					int coronaColorRed = coronaColor.getRed();
					int coronaColorGreen = coronaColor.getGreen();
					int coronaColorBlue = coronaColor.getBlue();
					int coronaColorAlpha = coronaColor.getAlpha();

					int red = (color.getRed() * coronaColorRed * 3) / 255;
					int green = (color.getGreen() * coronaColorGreen * 3) / 255;
					int blue = (color.getBlue() * coronaColorBlue * 3) / 255;
					int alpha = (int) (coronaColorAlpha * 0.9);
					
					if (red < 0) red = 0;
					if (red > 255) red = 255;
					if (green < 0) green = 0;
					if (green > 255) green = 255;
					if (blue< 0) blue = 0;
					if (blue > 255) blue = 255;
					
					Color output = new Color(red, green, blue, alpha);
					
					result[i] = output.getRGB();
				}
				
				corona.setRGB(0, 0, corona.getWidth(), corona.getHeight(), result, 0, corona.getWidth());
			}
		}
	}
}
