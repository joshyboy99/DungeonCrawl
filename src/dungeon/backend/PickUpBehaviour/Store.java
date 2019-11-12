package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.*;

/**
 * Stored upon pick up
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
					currSword.setX(entity.getX());
					currSword.setY(entity.getY());
					entity.getDungeon().addEntity(currSword);
					i.remove(currSword);
					((Player) entity).addItem((Pickup) attached);
					return;
				}
			}
			
			if(attached instanceof Key) {
				if(i.itemCount((Pickup)attached) == 1) {
					//remove current key from inventory, adjusting coordinates to current spot. add new key to inventory
					Key currKey = i.getKey();
					currKey.setX(entity.getX());
					currKey.setY(entity.getY());
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
