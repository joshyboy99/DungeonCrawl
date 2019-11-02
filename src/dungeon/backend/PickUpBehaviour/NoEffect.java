package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.PickUpBehaviour.PickUpBehaviour;
import dungeon.backend.entity.Entity;

public class NoEffect extends InteractableBehaviour implements PickUpBehaviour {

	public NoEffect(Entity attached) {
		super(attached);
		
	}

	@Override
	public void onPickup(Entity Entity) {
		//placeholder behaviour, does nothng
	}

}
