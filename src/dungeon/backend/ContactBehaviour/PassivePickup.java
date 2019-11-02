package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;


public class PassivePickup extends InteractableBehaviour implements ContactBehaviour {
	
	public PassivePickup(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(entity);
		}
	}
}

