package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class EffectPlayer extends InteractableBehaviour implements PickUpBehaviour {
	
	
	public EffectPlayer (Pickup e) {
		super(e);
	}
	
	@Override
	public void Pickup(Player p) {
		
	}

}
