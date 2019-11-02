package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;


public class Canpickup extends InteractableBehaviour implements ContactBehaviour {
	
	public Canpickup(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		attached.pickup();
		
	}


}

