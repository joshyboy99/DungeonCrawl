package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	//Variables for the destination of the transport
	private int dx,dy;
	
	public Transport(Entity attached) {
		super(attached);
	
	}
	
	//will attach this behavior to an entity
	public Transport(Entity attached, int x, int y) {
		super(attached);
		this.dx = x;
		this.dy = y;
	}
	
	@Override
	public void onTouch(Entity e) {
//		Portal portal = (Portal) attached;
//		e.setX(portal.getPortX());
//		e.setY(portal.getPortY());
		
//		e.setX(((Portal) attached).getPortX());
//		e.setY(((Portal) attached).getPortY());
		
		e.setX(dx);
		e.setY(dy);
		e.setMx(0);
		e.setMy(0);
		
		
	}
}

/*PROBLEM:
 * NOT EXTENDABLE - TO FIX SIMPLY MAKE METHOD IN ENTITY THAT IS ONLY USED FOR THINGS THAT TELEPORT YOU. WILL FIX TOMORROW.
 */


