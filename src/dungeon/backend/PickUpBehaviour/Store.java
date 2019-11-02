package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.*;

public class Store extends InteractableBehaviour implements PickUpBehaviour { 

	public Store(Entity attached) {
		super(attached);
	}

	@Override
	public void onPickup(Entity entity) {
		if(entity instanceof Player) {
			Inventory i = ((Player)entity).getInventory();			
			
			if(attached instanceof Sword) {
				if(i.itemCount((Pickup)attached) == 5) {
					return;
				}
			}
			
			if(attached instanceof Key) {
				if(i.itemCount((Pickup)attached) == 1) {
					return;
				}
			}
			
			
			((Player) entity).addItem((Pickup) attached);
			
		}
	}

}
