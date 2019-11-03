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
				if(i.itemCount((Pickup)attached) == 1) {
					Sword currSword = i.getSword();
					entity.getDungeon().addEntity(currSword);
					i.remove(currSword);
					((Player) entity).addItem((Pickup) attached);
					return;
				}
			}
			
			if(attached instanceof Key) {
				if(i.itemCount((Pickup)attached) == 1) {
					Key currKey = i.getKey();
					entity.getDungeon().addEntity(currKey);
					i.remove(currKey);
					((Player) entity).addItem((Pickup) attached);
					return;
				}
			}
			
			
			((Player) entity).addItem((Pickup) attached);
			
		}
	}

}
