package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public abstract class Pickup extends Entity {
	
	protected PickUpBehaviour pickupBehaviour;
	
	// protected boolean pickedUp;
	
	public Pickup(int x, int y, ContactBehaviour contactBehaviour, PickUpBehaviour pickupBehaviour) {
		super(x,y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = contactBehaviour;
		this.pickupBehaviour = pickupBehaviour;
	}

	public PickUpBehaviour getPickupBehaviour() {
		return pickupBehaviour;
	}

	public void setPickupBehaviour(PickUpBehaviour pickupBehaviour) {
		this.pickupBehaviour = pickupBehaviour;
	}

	protected void performPickup(Entity entity) {
		this.pickupBehaviour.onPickup(entity);
		this.removeSelf();
	}

}