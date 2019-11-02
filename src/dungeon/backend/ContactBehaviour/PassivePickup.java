package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * this class is for items that are always pickup up automatically when walked over by an entity. 
 * @author simon
 *
 */
public class PassivePickup extends InteractableBehaviour implements ContactBehaviour {
	
	public PassivePickup(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(attached);
		}
	}
}

