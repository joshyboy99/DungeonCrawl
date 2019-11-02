package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public interface PickUpBehaviour {
	
	 void onPickup(Entity Entity);
	 
	 void removeFromDungeon();
	 
	 
}
