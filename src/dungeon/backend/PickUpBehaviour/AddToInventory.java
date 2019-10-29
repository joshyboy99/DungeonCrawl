package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public class AddToInventory implements PickUpBehaviour {
	private Pickup attatched; 
	
	public AddToInventory (Pickup e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Player p) {
		p.addItem(attatched);
	}

}
