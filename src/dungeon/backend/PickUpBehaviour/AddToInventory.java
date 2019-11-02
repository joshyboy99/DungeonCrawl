package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.*;

public class AddToInventory extends InteractableBehaviour implements PickUpBehaviour { 

	public AddToInventory(Pickup attached) {
		super(attached);
	}

	@Override
	public void pickup(Player player) {
		
		
	}

	@Override
	public void removeFromDungeon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropEntity(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
