package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.NoEffect;

public class Treasure extends Pickup {
	
	int value;

	public Treasure(int x, int y, int val) {
		super(x, y);
		this.value = val;
		this.moveBehaviour = new Static(this);
		this.contactBehaviour =  new PassivePickup(this);
		this.pickupBehaviour = new NoEffect(this);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int val) {
		this.value = val;
	}


}
