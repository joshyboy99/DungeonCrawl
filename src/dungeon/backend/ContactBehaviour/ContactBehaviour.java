package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;

/**
 * The interface of Contact Behaviour.
 * this interface is appropriate for any derivative of the Entity abstract class
 * which performs an action when another entity is in its square, or attempts to move
 * into it's square.
 * 
 * @author JAG
 *
 */
public interface ContactBehaviour {
	void onTouch(Entity entity);
}
