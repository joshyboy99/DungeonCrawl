package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


/**
 * The Entity - Door, is an inanimate obstacle that can be unlocked by a single 
 * valid key to turn it into an open path that can be walked through. 
 * 
 * @author JAG
 *
 */
public class Door extends Entity {
		private int keyID; 
	
	
	public Door(int x, int y, int keyID, Dungeon dungeon) {
		super(x, y, dungeon);
		this.contactBehaviour = new Locked(this);
		this.moveBehaviour = new Static(this);
		this.keyID = keyID;
	}
	
	/**
	 * This method checks if the current key is the one which can
	 * unlock this door. If the key is correct, the door changes
	 * Behavior to be 'unlocked'.
	 * @param key the key entity that is being tested. 
	 */
	public void checkKey(Key key) {
		
		if(key.getKeyID() == this.keyID) {
			this.contactBehaviour = new NoContact(this); 
		} 
		
	}
	
	/**
	 * The wasTouched of the door, will ensure that the 
	 * 
	 */
	public void wasTouched(Entity entity) {
		Player p0 = (Player) entity;
		if(this.keyID == p0.getCurrentKeyID()) {
			//player has required key, open door and delete key
		    p0.destroyKey(p0.getCurrentKeyID());
			this.contactBehaviour = new NoContact(this);
		} //if not, keep locked. 
		
	}
	
}
