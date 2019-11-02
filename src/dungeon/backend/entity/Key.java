package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

public class Key extends Pickup {
	private int keyID; 	
		
	public Key(int x, int y, int keyID, Dungeon dungeon) {
		super(x, y, dungeon);
		this.keyID = keyID;
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
	}

	/**
	 * @return the keyID
	 */
	public int getKeyID() {
		return keyID;
	}
	
	//TO DO:
	//CHANGE PICKUPBEHAVIOUR WHEN PLAYER HAS KEY 

	
}
