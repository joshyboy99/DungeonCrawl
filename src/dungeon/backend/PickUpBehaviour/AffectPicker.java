package dungeon.backend.PickUpBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * The Pickup Behavior AffectPicker is appropriate whenn the
 * pickup casts some sort of effect on the entity which picked it up. 
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
