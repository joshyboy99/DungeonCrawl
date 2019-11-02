package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public interface PickUpBehaviour {
	
	 void onPickup();
	 
	 void removeFromDungeon();
	 
	 void dropEntity(int x, int y);
	 
	 
}
