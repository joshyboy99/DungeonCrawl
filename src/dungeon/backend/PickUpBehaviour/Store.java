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
			((Player) entity).addItem((Pickup) attached);
		}
	}

}
