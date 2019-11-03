package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This class looks at the contact behaviour when it being
 * contacted, hence it has it can be pickup up automatically 
 * when walked over by an entity. 
 * @author JAG
 *
 */
public class PassivePickup extends InteractableBehaviour implements ContactBehaviour {
	
	public PassivePickup(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		
		if(attached instanceof Pickup) {
			((Pickup) attached).performPickup(entity);
		}
	}
}

