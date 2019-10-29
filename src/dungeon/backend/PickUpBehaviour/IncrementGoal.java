package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public class IncrementGoal implements PickUpBehaviour {
	
	private Entity attatched; 
	
	public IncrementGoal (Entity e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Pickup e) {
		
	}

}
