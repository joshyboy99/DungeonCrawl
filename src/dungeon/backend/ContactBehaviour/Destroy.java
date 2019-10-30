package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;
import dungeon.backend.*;

public class Destroy extends InteractableBehaviour implements ContactBehaviour {
	
	public Destroy(Entity attached) {
		super(attached);
	}	
	@Override
	public void onTouch(Entity e) {
		// TODO Auto-generated method stub
		this.attached.kill(e);
	}

}
