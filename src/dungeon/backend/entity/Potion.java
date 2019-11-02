package dungeon.backend.entity;

import java.time.*;

import Effects.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

public class Potion extends Pickup implements Observer{
	
	public Potion(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new AffectPicker(this);
		this.effects.add(new InstaKillEnemy(this));
	}
	
	
	@Override
	public void update(Player player) {
		
	}


}
