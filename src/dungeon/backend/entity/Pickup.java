package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public abstract class Pickup extends Entity {
	
	protected PickUpBehaviour pickupBehaviour;
	
	// protected boolean pickedUp;
	
	public Pickup(int x, int y) {
		super(x,y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new Canpickup(this);
		this.pickupBehaviour = new AddToInventory(this);
	}

}