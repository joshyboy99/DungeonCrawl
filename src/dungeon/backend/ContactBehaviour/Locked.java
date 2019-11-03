package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.entity.Player;
import dungeon.backend.*;

/**
 * This class looks at the contact behaviour when it being
 * contacted, hence it is locked.
 * @author JAG
 *
 */
public class Locked extends InteractableBehaviour implements ContactBehaviour {

	public Locked(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Player());
	}	
	
	@Override
	public void onTouch(Entity entity) {
		if(checkValidEntityClass(entity)) {
			
		// player cannot go through door if locked!!!!
		entity.setMx(0);
		entity.setMy(0);
		// see if they have the right stuff, possibly changing the contact behaviour from locked.
		attached.wasTouched(entity);
		
		} else {
			entity.setMx(0);
			entity.setMy(0);
		}
		
	}

}
