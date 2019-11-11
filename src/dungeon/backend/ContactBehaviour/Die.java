package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;


/**
 * This class is part of the group that Extends ContactBehaviour.
 * If the player is touched by an enemy ( the only allowed class of this contact behaviour)
 * , it will kill the player. 
 * 
 * 
 * @author JAG
 *
 */

public class Die extends InteractableBehaviour implements ContactBehaviour{

	public Die(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Enemy());
		// TODO Auto-generated constructor stub
	}
/**
 * This onTouch will kill the attached as long as the entity that touches it is on the valid entities list. 
 */
	@Override
	public void onTouch(Entity entity) {
		if(this.checkValidEntityClass(entity)) {
			attached.removeSelf();
		}
	}

}
