package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This class looks at the contact behaviour when it being
 * contacted, hence it has it Transport upon contact
 * @author JAG
 *
 */
public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	public Transport(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Boulder());
		this.ValidEntities.add(new Player());
	}

	
	@Override
	public void onTouch(Entity e) {
		if(checkValidEntityClass(e)) {
			e.setMx(0);
			e.setMx(0);
			attached.wasTouched(e);
		} else {
			e.setMx(0);
			e.setMx(0);
		}
	}
}


