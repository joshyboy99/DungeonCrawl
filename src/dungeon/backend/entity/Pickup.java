package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
public abstract class Pickup extends Entity {
	
	private PickUpBehaviour pickupBehaviour;
	
	public Pickup(int x, int y,MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour, PickUpBehaviour pickupBehaviour) {
		super(x,y, moveBehaviour, contactBehaviour);
		this.pickupBehaviour = pickupBehaviour;
	}
	
    public void useItem(Player p) {
    	
	}
    
    public 

}