package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.Entity;

public class EffectPlayer implements PickUpBehaviour {
	
	private Entity attatched; 
	
	public EffectPlayer (Entity e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Entity e) {
		
	}

}
