package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;
public class Die extends InteractableBehaviour implements ContactBehaviour{

	public Die(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Enemy());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onTouch(Entity entity) {
		if(this.checkValidEntityClass(entity)) {
			attached.removeSelf();
		}
	}

}
