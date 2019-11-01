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
		System.out.print("hello!");
		e.setX(portal.getPortX());
		e.setY(portal.getPortY());
		e.setMx(0);
		e.setMy(0);
	}
}
