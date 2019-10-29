package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Boulder extends Entity{

	public Boulder(int x, int y) {
		super(x, y, new Static(), new Moveable());
		// TODO Auto-generated constructor stub
	}

}
