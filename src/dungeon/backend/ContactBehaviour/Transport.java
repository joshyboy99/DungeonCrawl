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
		Portal p = (Portal) attached;
		this.attached.setX(p.getPortX());
		this.attached.setY(p.getPortY());
	}
}
