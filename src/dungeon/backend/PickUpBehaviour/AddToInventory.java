package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.*;

public class AddToInventory extends InteractableBehaviour implements PickUpBehaviour { 

	public AddToInventory(Pickup attached) {
		super(attached);
	}

	@Override
	public void onTouch(Player player) {
		player.addItem((Pickup) this.attached);
	}

}
