package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.entity.Player;
import dungeon.backend.*;

public class Locked extends InteractableBehaviour implements ContactBehaviour {

	public Locked(Entity attached) {
		super(attached);
	}	
	
	@Override
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub
		//player cannot go through door if locked!!!!
		entity.setMx(0);
		entity.setMy(0);
		//see if they have the right stuff, possibly changing the contact behaviour from locked.
		attached.wasTouched(entity);
	}

}
