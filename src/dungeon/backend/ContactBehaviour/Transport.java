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
		System.out.print("Portx:" + portal.getPortX() + "\n");
		
		e.setY(portal.getPortY());
		System.out.print("Porty:" + portal.getPortY() + "\n");
		e.setMx(0);
		e.setMy(0);
	}
}
