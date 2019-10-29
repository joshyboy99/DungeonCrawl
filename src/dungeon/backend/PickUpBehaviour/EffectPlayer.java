package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public class EffectPlayer implements PickUpBehaviour {
	
	private Pickup attatched; 
	
	public EffectPlayer (Pickup e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Player p) {
		
	}

}
