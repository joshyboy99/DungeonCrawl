package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This Behavior belongs to the group which extends ContactBehaviour.
 * This Behavior is suitable for entities which should not allow any 
 * Incoming entity to enter it's position, and this cancels that entities 
 * next move.
 * @author JAG
 *
 */
public class Repel extends InteractableBehaviour implements ContactBehaviour {
	
	
	public Repel(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		entity.resetNextMove();
	}
}
