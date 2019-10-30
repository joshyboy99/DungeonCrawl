package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;
import dungeon.backend.*;

public class Locked extends InteractableBehaviour implements ContactBehaviour {

	public Locked(Entity attached) {
		super(attached);
	}	
	
	@Override
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub

	}

}
