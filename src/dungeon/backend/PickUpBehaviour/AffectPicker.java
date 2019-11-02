package dungeon.backend.PickUpBehaviour;


import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class AffectPicker extends InteractableBehaviour implements PickUpBehaviour {

	public AffectPicker(Entity attached) {
		super(attached);
	}

	@Override
	public void onPickup(Entity entity) {
		attached.affect(entity);
	}


	
}
