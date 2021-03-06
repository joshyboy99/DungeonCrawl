package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.*;

/**
 * This PickupBehaviour is appropriate whenever an pickup
 * is intended to be added to an inventory.
 * @author JAG
 *
 */
public class Store extends InteractableBehaviour implements PickUpBehaviour { 

	public Store(Entity attached) {
		super(attached);
	}

	@Override
	public void onPickup(Entity entity) {
		if(entity instanceof Player) {
			Inventory i = ((Player)entity).getInventory();			
			
			if(attached instanceof Sword) {
				if(i.itemCount((Pickup)attached) == 1) {
					
					//remove current sword from inventory, adjusting coordinates to current spot. add new key to inventory
					Sword currSword = i.getSword();
					((Player) entity).dropItem(currSword);
					((Player) entity).addItem((Pickup) attached);
					
					return;
				}
			}
			
			if(attached instanceof Key) {
				if(i.itemCount((Pickup)attached) == 1) {
					
					//remove current key from inventory, adjusting coordinates to current spot. add new key to inventory
					Key currKey = i.getKey();
					((Player) entity).dropItem(currKey);
					((Player) entity).addItem((Pickup) attached);
					
					return;
				}
			}
			
			
			((Player) entity).addItem((Pickup) attached);
			
		}
	}

}
