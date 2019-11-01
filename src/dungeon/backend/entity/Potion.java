package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Potion extends Entity implements Observer{
	
	public Potion(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new Canpickup(this);
	}

	@Override
	public void update(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(boolean bool) {
		// TODO Auto-generated method stub
		
	}

}
