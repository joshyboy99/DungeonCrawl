package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


public class Door extends Entity {
		private int keyID; 
	
	
	public Door(int x, int y, int keyID) {
		super(x, y);
		this.contactBehaviour = new Repel(this);
		this.moveBehaviour = new Static(this);
		this.keyID = keyID;
	}
	
	public void checkKey(Key key) {
		if(key.getKeyID() == this.keyID) {
			this.contactBehaviour = new NoContact(this); 
		} 
	}

}
