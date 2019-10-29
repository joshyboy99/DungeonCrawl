package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.Entity;

public class IncrementGoal implements PickUpBehaviour {
	
	private Entity attatched; 
	
	public IncrementGoal (Entity e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Entity e) {
		
	}

}
