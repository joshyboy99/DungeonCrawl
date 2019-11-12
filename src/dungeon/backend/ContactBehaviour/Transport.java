package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This Behavior belongs to the group which extends ContactBehaviour.
 * This Behavior is suitable for entities which should spontaneously move the 
 * Incoming entity to a new location.
 * @author JAG
 *
 */
public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	public Transport(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Boulder());
		this.ValidEntities.add(new Player());
	}

	/**
	 * This overridden onTouch method, sets the incoming entity's nextMove
	 * to be 0. It then calls the the attached entity's wasTouched to transport
	 * the incoming entity to the desired location. 
	 * If the incoming entity is not valid. Then the attached acts like an 
	 * impassable object. 
	 */
	@Override
	public void onTouch(Entity e) {
		
		e.resetNextMove();
		
		if(checkValidEntityClass(e)) {
			attached.wasTouched(e);
		} 
	}
}


