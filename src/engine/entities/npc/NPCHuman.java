package engine.entities.npc;

import java.awt.Color;
import java.util.List;

import engine.animation.Animation;
import engine.entities.EntityBluePrint;
import engine.entities.lights.PointLight;
import engine.entities.npc.clothes.ClothSlot;
import engine.entities.npc.clothes.ClothesNPC.CLOTHTYPE;
import engine.input.InputHandler;
import engine.level.Level;
import engine.rendering.Screen;

public class NPCHuman extends NPCCore {
	
	public ClothSlot bodySlot;
	public ClothSlot legSlot;
	public ClothSlot feetSlot;
	public ClothSlot eyeSlot;
	public ClothSlot mouthSlot;
	public ClothSlot beardSlot;
	public ClothSlot accessoiresSlot;
	public ClothSlot earSlot;
	public ClothSlot hairSlot;
	public ClothSlot hatSlot;
	
	public NPCHuman(EntityBluePrint bluePrint, Level level, float x, float y, float speed) {
		super(bluePrint, level, "NPCHuman", NPCTYPE.HUMAN, x, y, speed, !bluePrint.entityType.equals(ENTITYTYPE.PLAYER));
		
		ANIMATION_IDLE = new Animation(16, 0, 100, 2);
		ANIMATION_WALK_UP = new Animation(0, 0, 100, 2);
		ANIMATION_WALK_DOWN = new Animation(4, 0, 100, 2);
		ANIMATION_WALK_LEFT = new Animation(8, 0, 100, 2);
		ANIMATION_WALK_RIGHT = new Animation(12, 0, 100, 2);
		
		if (collissionBox != null) {
			collissionBox.minX = (-bluePrint.atlas.sheet.tileSize / 2) + collissionOffset;
			collissionBox.maxX = (bluePrint.atlas.sheet.tileSize / 2) - collissionOffset;
			collissionBox.minY = collissionOffset;
			collissionBox.maxY = (bluePrint.atlas.sheet.tileSize) - collissionOffset;
		}
		
		if (!bluePrint.entityType.equals(ENTITYTYPE.PLAYER)) {
			jobs.targetRange = 256;
			jobs.jobDelay = 1500;
			jobs.jobDelayValue = jobs.jobDelay;
		}
		
		debugColor = Color.WHITE;
		
		bodySlot = new ClothSlot(CLOTHTYPE.BODY);
		legSlot = new ClothSlot(CLOTHTYPE.LEGS);
		feetSlot = new ClothSlot(CLOTHTYPE.FEET);
		eyeSlot = new ClothSlot(CLOTHTYPE.EYES);
		mouthSlot = new ClothSlot(CLOTHTYPE.MOUTH);
		hairSlot = new ClothSlot(CLOTHTYPE.HAIR);
		hatSlot = new ClothSlot(CLOTHTYPE.HAT);
		beardSlot = new ClothSlot(CLOTHTYPE.BEARD);
		accessoiresSlot = new ClothSlot(CLOTHTYPE.ACCESSOIRES);
		earSlot = new ClothSlot(CLOTHTYPE.EAR);
	}
	
	@Override
	public void update(InputHandler input, int gameSpeed) {
		super.update(input, gameSpeed);

	}
	
	@Override
	public void render(Screen screen, List<PointLight> renderListLights) {
		super.render(screen, renderListLights);
		
		if (eyeSlot != null) {
			if (eyeSlot.cloth != null) {
				renderAtlas(screen, eyeSlot.cloth.atlas);
			}
		}
		
		if (mouthSlot != null) {
			if (mouthSlot.cloth != null) {
				renderAtlas(screen, mouthSlot.cloth.atlas);
			}
		}

		if (earSlot != null) {
			if (earSlot.cloth != null) {
				renderAtlas(screen, earSlot.cloth.atlas);
			}
		}
		
		if (beardSlot != null) {
			if (beardSlot.cloth != null) {
				renderAtlas(screen, beardSlot.cloth.atlas);
			}
		}
		
		if (accessoiresSlot != null) {
			if (accessoiresSlot.cloth != null) {
				renderAtlas(screen, accessoiresSlot.cloth.atlas);
			}
		}
		
		if (feetSlot != null) {
			if (feetSlot.cloth != null) {
				renderAtlas(screen, feetSlot.cloth.atlas);
			}
		}
		
		if (legSlot != null) {
			if (legSlot.cloth != null) {
				renderAtlas(screen, legSlot.cloth.atlas);
			}
		}
		
		if (bodySlot != null) {
			if (bodySlot.cloth != null) {
				renderAtlas(screen, bodySlot.cloth.atlas);
			}
		}
		
		
		if (hairSlot != null) {
			if (hairSlot.cloth != null) {
				renderAtlas(screen, hairSlot.cloth.atlas);
			}
		}
		
		if (hatSlot != null) {
			if (hatSlot.cloth != null) {
				renderAtlas(screen, hatSlot.cloth.atlas);
			}
		}
	}
}