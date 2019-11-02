package Effects;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

public class InstaKillEnemy extends Behaviour implements Effect, Observer{

	private boolean inEffect;
	
	public InstaKillEnemy(Entity attached) {
		super(attached);
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, null));
		this.attached = e;
		this.inEffect = true;
	}
	
	public boolean getInEffect() {
		return inEffect;
	}

	@Override
	public void endEffect() {
		attached.setContactBehaviour(new NoContact(attached));
		this.attached = null;
	}

	@Override
	public void update(Player player) {	
		
	}
	
}
