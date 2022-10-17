package engine.entities.npc.clothes;

import engine.sprites.SpriteAtlas;

public class ClothesNPC {

	public enum CLOTHTYPE {
		HAT, HAIR, EYES, BODY, LEGS, FEET, GLASSES, MOUTH, MASK, EAR
	}
	
	public String name;
	public SpriteAtlas atlas;
	public CLOTHTYPE type;
	
	public ClothesNPC(ClothesNPC[] list, int id, String name, SpriteAtlas atlas, CLOTHTYPE type) {
		if (list != null) {
			if (list[id] != null) throw new RuntimeException("Duplicate clothType id on " + id);
			list[id] = this;
		}
		
		this.name = name;
		this.atlas = atlas;
		this.type = type;
	}
}
