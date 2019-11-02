package dungeon.backend.entity;

import Effects.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

public class Potion extends Pickup implements Observer{
	
	private int Timer  
	
	public Potion(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new AffectPicker(this);
		this.effects.add(new InstaKillEnemy(this));
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
