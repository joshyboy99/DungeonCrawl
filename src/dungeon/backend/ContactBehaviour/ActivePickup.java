package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.entity.Pickup;

/**
 * this class is for entities that get picked up only when the pickerupperer entity does so voluntarily, otherwise walk over. 
 * @author simon
 *
 */
public class ActivePickup extends InteractableBehaviour implements ContactBehaviour {

	public ActivePickup(Entity attached) {
		super(attached);
	}

	@Override
	public void onTouch(Entity entity) {
		//does nothing.
	}
	
	//this function is only called if the pickup button is pressed by the player
	public void doPickup(Entity entity) {
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(entity);
		}
	}
}
