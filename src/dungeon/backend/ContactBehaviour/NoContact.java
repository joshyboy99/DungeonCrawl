package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This Behavior belongs to the group which extends ContactBehaviour.
 * This Behavior is suitable for entities which should not interact in any way
 * with incoming entities, allowing them to pass through it as if it weren't there.
 * @author JAG
 *
 */
public class NoContact extends InteractableBehaviour implements ContactBehaviour {

	public NoContact(Entity attached) {
		super(attached);
	}
	
	/**
	 * Empty method as the behavior for this class is to do nothing when touched. 
	 */
	@Override
	public void onTouch(Entity entity) {
	}

}
