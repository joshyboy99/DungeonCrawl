package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


public class Door extends Entity {
	private Key key; 
	private boolean lockStatus;
	
	
	public Door(int x, int y) {
		super(x, y);
		this.contactBehaviour = new Repel(this);
		this.moveBehaviour = new Static();
		// TODO Auto-generated constructor stub
	}

}
