package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Treasure extends Entity {
	
	int value;

	public Treasure(int x, int y, int val) {
		super(x, y);
		this.value = val;
		this.moveBehaviour = new Static(this);
		this.contactBehaviour =  new Canpickup(this);
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
	
	

}
