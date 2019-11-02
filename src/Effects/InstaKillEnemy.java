package Effects;

import java.time.*;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

public class InstaKillEnemy extends Behaviour implements Effect {

	private Clock Timer;
	private Instant Endtime;
	
	public InstaKillEnemy(Entity attached) {
		super(attached);
		this.Timer = Clock.tickSeconds(null);
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, null));
		//Endtime = Timer.instant().plusSeconds(90);
		
		//while(!Timer.instant().equals(Endtime));
		
		
		
	}

	@Override
	public void endEffect(Entity e) {
		e.setContactBehaviour(new NoContact(e));
	}
	

}
