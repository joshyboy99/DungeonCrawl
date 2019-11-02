package Effects;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

public class InstaKillEnemy extends Behaviour implements Effect {

	public InstaKillEnemy(Entity attached) {
		super(attached);
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, null));
	}

	@Override
	public void endEffect(Entity e) {
		e.setContactBehaviour(new NoContact(e));
	}
	

}
