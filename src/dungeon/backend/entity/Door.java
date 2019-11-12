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
	public boolean checkKey(int keyID) {
		
		if(keyID == this.keyID) return true;
		
		else return false;
		
	}
	
	/**
	 * Checks if entity is a player, and if so checks the current key that player holds.
	 * If they keyIDs match, then the key is destroyed and the door opens, otherwise 
	 * the player is incoming entity is rejected.
	 */
	public void wasTouched(Entity entity) {
		
		if(entity instanceof Player) {
			
			Player p0 = (Player) entity;
			
			if(checkKey(p0.getCurrentKeyID())) {
				
			    p0.destroyKey(p0.getCurrentKeyID());
				this.contactBehaviour = new NoContact(this);
				
			} 
		}
	}
	
}
