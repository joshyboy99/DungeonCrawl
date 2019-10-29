package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

public class Key extends Pickup {
	private int keyID; 	
	
	public Key(int x, int y, int keyID) {
		super(x, y);
		this.contactBehaviour= new Canpickup(this);
		this.moveBehaviour= new Static();
		this.pickupBehaviour= new AddToInventory();
		this.keyID = keyID;
		// TODO Auto-generated constructor stub
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
