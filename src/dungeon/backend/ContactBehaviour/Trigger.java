package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;

public class Trigger extends InteractableBehaviour implements ContactBehaviour {

	boolean triggered;
	
	public Trigger(Entity attached) {
		super(attached);
		triggered = false;
	}
	
	@Override
	public void onTouch(Entity entity) {
		
		if(checkEntity(entity)) {
			triggered = ;
		}
		
	}
	
	@Override
	public boolean checkEntity(Entity e) {
		if(this.ValidEntities.contains(e)) {
			return true;
		}
		
		else return false;
		
	}
}
