package dungeon.backend.PickUpBehaviour;

import dungeon.backend.entity.*;

public interface PickUpBehaviour {
	
	 void pickup(Player player);
	 
	 void removeFromDungeon();
	 
	 void dropEntity(int x, int y);
}
