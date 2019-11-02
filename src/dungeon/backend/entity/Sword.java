package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Sword extends Pickup {
	
	
	
	public Sword(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		
	}
	
	public void use(String facing) {
		
	}

}
