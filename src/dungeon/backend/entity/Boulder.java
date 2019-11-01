package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Boulder extends Entity{

	public Boulder(int x, int y) {
		super(x, y);
		this.contactBehaviour= new Moveable(this);
		this.moveBehaviour = new Static(this);
		// TODO Auto-generated constructor stub
	}
	
	

}
