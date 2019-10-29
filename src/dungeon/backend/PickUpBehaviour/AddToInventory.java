package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public class AddToInventory implements PickUpBehaviour {
	private Player attatched; 
	
	public AddToInventory (Player p) {
		attatched = p;
	}
	
	@Override
	public void Pickup(Pickup e) {
		attatched.addItem(e);
	}

}
