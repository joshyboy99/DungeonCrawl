package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
public abstract class Pickup extends Entity {
	
	private PickUpBehaviour pickupBehaviour;
	
	public Pickup(int x, int y, PickUpBehaviour pickupBehaviour) {
		super(x,y);
		this.pickupBehaviour = pickupBehaviour;
	}
	
    public void useItem(Player p) {
	}

}