package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This Behavior belongs to the group which extends ContactBehaviour.
 * This Behavior is suitable for entities which are picked up by the 
 * Incoming entity upon contact, without any voluntary decision from
 * that entity.
 * @author JAG
 *
 */
public class PassivePickup extends InteractableBehaviour implements ContactBehaviour {
	
	public PassivePickup(Entity attached) {
		super(attached);
	}
	
	/**
	 * This overridden onTouch method checks if the attached entity
	 * is valid to be picked up, and if so, calls it's pickup behavior.
	 */
	@Override
	public void onTouch(Entity entity) {	
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(entity);
		}
	}
}

