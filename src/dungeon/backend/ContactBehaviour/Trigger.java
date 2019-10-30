package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;

public class Trigger extends InteractableBehaviour implements ContactBehaviour {

	public Trigger(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
	}
	
	@Override
	public boolean checkEntity(Entity e) {
		if(this.ValidEntities.contains(e)) {
			return true;
		}
		
		else return false;
		
	}
}
