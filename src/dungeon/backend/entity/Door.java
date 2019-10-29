package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


public class Door extends Entity {
		private int keyID; 
		private boolean lockStatus;
	
	
	public Door(int x, int y, int keyID) {
		super(x, y);
		this.contactBehaviour = new Repel(this);
		this.moveBehaviour = new Static();
		this.keyID = keyID;
		this.lockStatus = true; 
		// TODO Auto-generated constructor stub
	}
	
	public void checkKey(Key key) {
		if(key.getKeyID() == this.keyID) {
			this.contactBehaviour = new NoContact(this); 
		} 
	}

}
