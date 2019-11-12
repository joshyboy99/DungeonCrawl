package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This behaviour is part of the group that implements contactBehaviour.
 * This behaviour is appropriate when a particular entity will destroy 
 * particular entities on contact.
 * @author JAG
 *
 */
public class Destroy extends InteractableBehaviour implements ContactBehaviour {
	
	
	public Destroy(Entity attached) {
		super(attached);
	}	
	
	/**
	 * this version of on touch removes entities contained within this entities' 
	 * 'valid entities list' from the dungeon altogether.
	 */
	@Override
	public void onTouch(Entity e) {
		if(this.checkValidEntityClass(e)) {
			e.removeSelf();
		}
	}

}
