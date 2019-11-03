package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.entity.Pickup;

/**
 * This class is for entities that get picked up only when the 
 * pickerupperer entity does so voluntarily, otherwise walk over. 
 * @author JAG
 *
 */
public class ActivePickup extends InteractableBehaviour implements ContactBehaviour {

	public ActivePickup(Entity attached) {
		super(attached);
	}

	
	@Override
	public void onTouch(Entity entity) {
	}
	
	/**
	 * This function is only called if the pickup button is pressed by the player
	 * @param entity The Entity that picks up.
	 */
	public void doPickup(Entity entity) {
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(entity);
		}
	}
}
