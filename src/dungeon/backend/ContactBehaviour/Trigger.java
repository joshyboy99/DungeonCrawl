package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.Entity;

public class Trigger extends InteractableBehaviour implements ContactBehaviour {

	boolean triggered;
	
	public Trigger(Entity attached) {
		super(attached);
		this.triggered = false;
	}
	
	@Override
	public void onTouch(Entity entity) {
		if(checkValidEntityClass(entity)) {
			changeTriggeredStatus();
			attached.wasTouched();
			attached.isComplete();
			
		} 
	}
	
	public boolean changeTriggeredStatus() {
		return triggered = !triggered;
	}


}
