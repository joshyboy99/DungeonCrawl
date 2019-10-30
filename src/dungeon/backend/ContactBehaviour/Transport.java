package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class Transport extends InteractableBehaviour implements ContactBehaviour {
	
	//will attach this behaviour to an entity
	public Transport(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity e) {
		int x = e.getX();
		int y = e.getY();
		this.attached.setX(x);
		this.attached.setY(y);
	}
}
