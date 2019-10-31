package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public abstract class Pickup extends Entity {
	
	protected PickUpBehaviour pickupBehaviour;
	
	public Pickup(int x, int y, MoveBehaviour moveBehaviour, PickUpBehaviour pickupBehaviour) {
		super(x,y);
		this.moveBehaviour = moveBehaviour;
		this.contactBehaviour = new Canpickup(this);
		this.pickupBehaviour = pickupBehaviour;
	}
	
    public Pickup(int x, int y) {
		// TODO Auto-generated constructor stub
    	super(x,y);
	}

	public void useItem(Player p) {
    	
	} 

}