package engine.scene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import engine.camera.Camera;
import engine.core.Config;
import engine.entities.lights.Light.LIGHTTYPE;
import engine.entities.lights.PointLight;
import engine.gui.GUI;
import engine.input.InputHandler;
import engine.level.Level;
import engine.level.environment.RainLayer;

public class GameScene extends Scene {

	public Camera camera = new Camera();
	public Level level;
	public GUI gui;
	
	public static boolean isEditor = false;
	
	public GameScene() {
		super();
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);
		
		if (camera != null) {
			camera.update(input, gameSpeed);
		}
		
		if (level != null) {
			level.update(input, camera, gameSpeed);
		}
		
		if (gui != null) {
			gui.update(input, gameSpeed);
		}
	}
	
	@Override
	public void render() {
		super.render();
		
		if (level != null && screen != null) {

			level.renderTiles(screen, level.environment.weatherManager);
			level.renderDecals(screen);
			level.renderEntities(screen);
			
			if (isEditor) {
				level.renderLights(screen);
			}
		}
	}
	
	@Override
	public void renderGUI(Graphics graphics) {
		if (gui != null) {
			gui.renderGameGUI(graphics, screen, this);
		}
	}
	
	public void renderLights(BufferedImage image) {
		if (level != null) {
			Graphics2D graphic = (Graphics2D) image.getGraphics();
			
			if (level.environment != null) {
				Color ambientColor = level.environment.ambientLight.ambientColor;
				
				if (ambientColor!= null) {
					graphic.setColor(ambientColor);
				}
				
				graphic.fillRect(0, 0, image.getWidth(), image.getHeight());
				
				for (PointLight light : level.renderListLights) {
					if (light != null) {
						if (light.enabled) {
							light.updatePosition(level, screen);
							
							if (light.type.equals(LIGHTTYPE.POINTLIGHT)) {
								drawLight(graphic, light.screenX, light.screenY, light.color, light.radius, light.alphaModifier, ambientColor);
							}
						}
					}
				}
			} else {
				graphic.setColor(new Color(0, 0, 0, 255));
				graphic.fillRect(0, 0, image.getWidth(), image.getHeight());
			}
			
			graphic.dispose();
		}
	}
	
	private void drawLight(Graphics2D graphic, float x, float y, Color lightColor, float radius, float alphaModifier, Color ambientColor) {
        //graphic.setComposite(AlphaComposite.SrcOver);
        
        Point2D center = new Point2D.Float(x, y);
        float[] fractions = {0.0f, 1.0f};
        
        float r = lightColor.getRed();
        float g = lightColor.getGreen();
        float b = lightColor.getBlue();
        float a = lightColor.getAlpha() * alphaModifier;
        
        if (ambientColor != null) {
        	r = r + ambientColor.getRed();
        	
        	if (r < 0) {r = 0;}
        	if (r > 255) {r = 255;}
        	
        	g = g + ambientColor.getGreen();
        	
        	if (g < 0) {g = 0;}
        	if (g > 255) {g = 255;}
        	
        	b = b + ambientColor.getBlue();
        	
        	if (b < 0) {b = 0;}
        	if (b > 255) {b = 255;}
        }
        
        if (radius > 0) {
        	Color[] colors = {new Color(r / 255, g / 255, b / 255, a / 255), new Color(r / 255, g / 255, b / 255, 0)};

            RadialGradientPaint paint = new RadialGradientPaint(center, radius, fractions, colors, CycleMethod.REFLECT);
            
            graphic.setPaint(paint);
            graphic.fillOval((int) x - (int) radius, (int) y - (int) radius, (int) radius * 2, (int) radius * 2);
            
            if (Config.LIGHT_SHINE) {
            	drawLightShine(graphic, x, y, radius, center, fractions, colors, paint);
            }
        }
    }

	private void drawLightShine(Graphics2D graphic, float x, float y, float radius, Point2D center, float[] fractions, Color[] colors, RadialGradientPaint paint) {
	    float radiusShine1 = radius * 0.5f;
	    float radiusShine2 = radiusShine1 / 2;
	    float radiusShine3 = radiusShine2 / 2;
	    
	    if (radiusShine1 > 0) {
	    	paint = new RadialGradientPaint(center, radiusShine1, fractions, colors, CycleMethod.REFLECT);
	    	graphic.setPaint(paint);
	    	graphic.fillOval((int) x - (int) radiusShine1, (int) y - (int) radiusShine1, (int) radiusShine1 * 2, (int) radiusShine1 * 2);
	    	
	    	if (radiusShine2 > 0) {
	    		paint = new RadialGradientPaint(center, radiusShine2, fractions, colors, CycleMethod.REFLECT);
	        	graphic.setPaint(paint);
	        	graphic.fillOval((int) x - (int) radiusShine2, (int) y - (int) radiusShine2, (int) radiusShine2 * 2, (int) radiusShine2 * 2);
	        	
	        	if (radiusShine3 > 0) {
	        		paint = new RadialGradientPaint(center, radiusShine3, fractions, colors, CycleMethod.REFLECT);
	            	graphic.setPaint(paint);
	        		graphic.fillOval((int) x - (int) radiusShine3, (int) y - (int) radiusShine3, (int) radiusShine3 * 2, (int) radiusShine3 * 2);
	        	}
	        }
	    }
	}
	
	public void renderEffects(BufferedImage image) {
		if (level != null) {
			Graphics2D graphic = (Graphics2D) image.getGraphics();

			if (Config.LIGHT_CORONA) {
				for (PointLight light : level.renderListLights) {
					if (light != null) {
						if (light.enabled) {
							light.updatePosition(level, screen);
							
							if (light.type.equals(LIGHTTYPE.POINTLIGHT) && light.coronaEnabled) {
						        drawLightCorona(graphic, light.screenX, light.screenY, light.coronaRadius, light.corona);
							}
						}
					}
				}
			}
			
			if (level.environment.weatherManager.rainLevel > 0) {
				for (RainLayer rainLayer : level.environment.weatherManager.rainLayers) {
					if (rainLayer != null) {
						drawRainLayer(graphic, rainLayer);
					}
				}
			}

			graphic.dispose();
		}
	}
	
	private void drawLightCorona(Graphics2D graphic, float x, float y, float radius, BufferedImage corona) {
		if (corona != null && radius > 0) {
			//graphic.setComposite(AlphaComposite.DstIn);
			graphic.drawImage(corona, (int) x - (int) radius, (int) y - (int) radius, (int) radius * 2, (int) radius * 2, null);
		}
	}
	
	private void drawRainLayer(Graphics2D graphic, RainLayer rainLayer) {
		if (rainLayer != null) {
			//graphic.setComposite(AlphaComposite.DstIn);
			if (rainLayer.texture.image != null) {
				graphic.drawImage(rainLayer.texture.image, (int) rainLayer.x - rainLayer.size / 2, (int) rainLayer.y - rainLayer.size / 2, rainLayer.size, rainLayer.size, null);
			}
		}
	}

	public void setLevel(Level level) {
		this.level = level;
		
		if (camera != null) {
			int shiftOperator = level.getTileAtlas().sheet.getShiftOperator();
			int cameraPositionX = level.width / 2 << shiftOperator;
			int cameraPositionY = level.height / 2 << shiftOperator;
			
			camera.position.set(cameraPositionX, cameraPositionY);
		}
	}
}
