package dungeon.backend.ContactBehaviour;
/**
 * Behaviour for when you can freely walk through attatched object made by JAG
 */
import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This class looks at the contact behaviour when it being
 * contacted, hence it has it can be walked passed on.
 * @author JAG
 *
 */
public class NoContact extends InteractableBehaviour implements ContactBehaviour {

	public NoContact(Entity attached) {
		super(attached);
	}
	@Override
	public void onTouch(Entity entity) {

	}

}
