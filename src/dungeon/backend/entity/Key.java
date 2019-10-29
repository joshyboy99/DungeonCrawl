package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

public class Key extends Pickup {
	
	
	public Key(int x, int y) {
		super(x, y);
		this.contactBehaviour= new Canpickup(this);
		this.moveBehaviour= new Static();
		this.pickupBehaviour= new AddToInventory();
		// TODO Auto-generated constructor stub
	}

}
