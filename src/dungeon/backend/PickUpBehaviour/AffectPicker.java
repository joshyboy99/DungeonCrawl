package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * The effect when if it affects a certain entity
 * @author JAG
 *
 */
public class AffectPicker extends InteractableBehaviour implements PickUpBehaviour {

	public AffectPicker(Entity attached) {
		super(attached);
	}

	@Override
	public void onPickup(Entity entity) {
		attached.affect(entity);
	}
}
