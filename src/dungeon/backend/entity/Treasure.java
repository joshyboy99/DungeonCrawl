package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

/**
 * The Pickup - Treasure, is an inanimate passive pickup that contributes
 * to a possible goal for the dungeon.
 *  @author JAG
 *
 */
public class Treasure extends Pickup {

	public Treasure(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour =  new PassivePickup(this);
		this.pickupBehaviour = new Store(this);
	}
	
	
	
}