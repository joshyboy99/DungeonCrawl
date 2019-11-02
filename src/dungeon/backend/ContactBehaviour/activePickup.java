package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;

public class ActivePickup extends InteractableBehaviour implements ContactBehaviour {

	public ActivePickup(Entity attached) {
		super(attached);
	}

	@Override
	public void onTouch(Entity entity) {

	}

}
