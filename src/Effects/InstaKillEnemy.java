package Effects;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

public class InstaKillEnemy extends Behaviour implements Effect, Observer{

	private int duration;
	
	public InstaKillEnemy(Entity attached) {
		super(attached);
		this.duration = 15;
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, null));
		this.attached = e;
		
		//Endtime = Timer.instant().plusSeconds(90);
		
		//while(!Timer.instant().equals(Endtime));
		
	}

	@Override
	public void endEffect() {
		attached.setContactBehaviour(new NoContact(attached));
		this.attached = null;
	}

	@Override
	public void update(Player player) {
		duration--;
		if(duration<=0) {
			endEffect();
		}
	}
	

}
