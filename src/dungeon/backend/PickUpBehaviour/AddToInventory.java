package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class AddToInventory extends InteractableBehaviour implements PickUpBehaviour { 
	
	public AddToInventory (Pickup e) {
		super(e);
	}
	
	@Override
	public void Pickup(Player p) {
		p.addItem(attatched);
	}

}
