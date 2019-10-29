package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Treasure extends Entity {

	public Treasure(int x, int y) {
		super(x, y, new Static(), new Canpickup());
	}

}
