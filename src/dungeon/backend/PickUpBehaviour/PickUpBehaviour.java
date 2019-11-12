package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

/**
 * This Interface is appropriate for any behavior which 
 * occurs the moment an item is picked up. 
 * @author JAG
 *
 */
public interface PickUpBehaviour {
	
	 void onPickup(Entity Entity);
	 
	 
}
