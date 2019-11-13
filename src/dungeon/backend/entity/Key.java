package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.Static;
import dungeon.backend.PickUpBehaviour.Store;

/**
 * The Pickup - Key, is an inanimate active pickup that is used to unlock doors.
 * Each key has a unique keyID and a player can only hold a single key at any 
 * one time.  
 * 
 * @author JAG
 *
 */
public class Key extends Pickup {
	private int keyID; 	
		
	public Key(int x, int y, int keyID, Dungeon dungeon) {
		super(x, y, dungeon);
		this.keyID = keyID;
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.moveBehaviour = new Static(this);
	}

	/**
	 * @return the keyID
	 */
	public int getKeyID() {
		return keyID;
	}

	
}
