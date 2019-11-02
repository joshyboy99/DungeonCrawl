package dungeon.backend.entity;

import java.time.Duration;

import Effects.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

public class Potion extends Pickup implements Observer{
	
	private Duration Timer;  
	
	
	public Potion(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new AffectPicker(this);
		this.effects.add(new InstaKillEnemy(this));
		this.Timer = 90;
	}
	
	private void PotionTimer() {
		while(int i = Timer; i > 0; i -  )
		for (Effect e: effects) {
			e.endEffect(e);
		}
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
