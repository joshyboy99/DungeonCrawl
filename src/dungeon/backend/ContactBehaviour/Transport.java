package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	//will attach this behavior to an entity
	public Transport(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity e) {
		Portal portal = (Portal) attached;
		e.setX(portal.getPortX());
		e.setY(portal.getPortY());
		e.setMx(0);
		e.setMy(0);
	}
}

/*PROBLEM:
 * NOT EXTENDABLE - TO FIX SIMPLY MAKE METHOD IN ENTITY THAT IS ONLY USED FOR THINGS THAT TELEPORT YOU. WILL FIX TOMORROW.
 */


