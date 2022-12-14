package engine.entities.npc.clothes;

import engine.entities.npc.clothes.ClothesNPC.CLOTHTYPE;

public class ClothSlot {

	public CLOTHTYPE type;
	public ClothesNPC cloth;
	
	public ClothSlot(CLOTHTYPE type) {
		this.type = type;
	}
	
	public void set(ClothesNPC cloth) {
		if (cloth != null) {
			if (cloth.type.equals(type)) {
				this.cloth = cloth;
				return;
			}
		}
		
		this.cloth = null;
	}
}
