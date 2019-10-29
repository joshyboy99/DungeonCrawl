package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.Entity;

public class AddToInventory implements PickUpBehaviour {
	private Entity attatched; 
	
	public AddToInventory (Entity e) {
		attatched = e;
	}
	
	@Override
	public void Pickup(Entity e) {
		
	}

}
