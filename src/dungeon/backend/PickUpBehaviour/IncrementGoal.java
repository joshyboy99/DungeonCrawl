package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public class IncrementGoal implements PickUpBehaviour {
	
	private Pickup attatched; 
	
	public IncrementGoal (Pickup e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Player p) {
		
	}

}
