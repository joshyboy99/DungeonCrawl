package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Key extends Entity {
	private int keyID;
	public Key(int x, int y) {
		super(x, y, new Static(), new Canpickup());
		// TODO Auto-generated constructor stub
	}

}
