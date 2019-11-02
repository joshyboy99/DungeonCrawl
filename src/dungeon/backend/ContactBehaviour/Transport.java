package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	public Transport(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Boulder());
		this.ValidEntities.add(new Player());
	}

	
	@Override
	public void onTouch(Entity e) {
		e.setMx(0);
		e.setMx(0);
		attached.wasTouched(e);
	}
}

/*PROBLEM:
 * NOT EXTENDABLE - TO FIX SIMPLY MAKE METHOD IN ENTITY THAT IS ONLY USED FOR THINGS THAT TELEPORT YOU. WILL FIX TOMORROW.
 */


