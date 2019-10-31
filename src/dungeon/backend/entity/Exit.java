package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Exit extends Entity{

	public Exit(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new Trigger(this);
	}

}
