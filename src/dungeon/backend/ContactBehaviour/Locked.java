package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.entity.Player;

/**
 * This class is part of the group that Extends ContactBehaviour.
 * When an entity possessing this behavior makes contact with most entities,
 * it will act like a wall, and deny their movement into it's square. 
 * 
 * this behavior will consult the attached entity's wasTouched behavior
 * to account for the case where this behavior may change. 
 * 
 * @author JAG
 *
 */
public class Locked extends InteractableBehaviour implements ContactBehaviour {

	public Locked(Entity attached) {
		super(attached);
	}	
	
	
	/**
	 *This overridden onTouch method resets the incoming entity's 'next position'
	 *to zero, preventing it's movement. It also calls the attached entity's wasTouched method
	 *for the case that this behavior may be changed as a result of the contact. 
	 */
	@Override
	public void onTouch(Entity entity) {
			
		// resets incoming entity next-position
		entity.setMx(0);
		entity.setMy(0);
		
		// calls attached entity's 'wasTouched' and passes in incoming entity. 
		attached.wasTouched(entity);
		

	}
}
