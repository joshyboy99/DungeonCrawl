package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.ContactBehaviour;
import dungeon.backend.MoveBehaviour.MoveBehaviour;

public class Treasure extends Entity {

	public Treasure(int x, int y, MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour) {
		super(x, y, moveBehaviour, contactBehaviour);
	}

}
