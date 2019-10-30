package dungeon.backend.ContactBehaviour;
/**
 * Behaviour for when you can freely walk through attatched object made by JAG
 */
import dungeon.backend.entity.*;
import dungeon.backend.*;

public class NoContact extends InteractableBehaviour implements ContactBehaviour {

	public NoContact(Entity attached) {
		super(attached);
	}
	@Override
	public void onTouch(Entity entity) {

	}

}
