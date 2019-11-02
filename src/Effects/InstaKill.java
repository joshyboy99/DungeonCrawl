package Effects;

import dungeon.backend.Behaviour;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.entity.*;

public class InstaKill extends Behaviour implements Effect {

	protected InstaKill(Entity attached) {
		super(attached);
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, null));
	}
	

}
