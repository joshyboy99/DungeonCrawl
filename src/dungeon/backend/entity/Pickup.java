package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/** 
 * Pick up Abstract class, looks at all
 * Entity that is allowed to be Picked up 
 *
 * @author JAG
 *
 */
public abstract class Pickup extends Entity {
	
	protected PickUpBehaviour pickupBehaviour;
	
	// protected boolean pickedUp;
	
	public Pickup(int x, int y, Dungeon dungeon) {
		super(x,y, dungeon);
	}

	public PickUpBehaviour getPickupBehaviour() {
		return pickupBehaviour;
	}

	public void setPickupBehaviour(PickUpBehaviour pickupBehaviour) {
		this.pickupBehaviour = pickupBehaviour;
	}

	public void performPickup(Entity entity) {
		this.pickupBehaviour.onPickup(entity);
		this.removeSelf();
	}

}