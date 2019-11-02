package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

public class Treasure extends Pickup {

	public Treasure(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour =  new PassivePickup(this);
		this.pickupBehaviour = new Store(this);
	}
	
}