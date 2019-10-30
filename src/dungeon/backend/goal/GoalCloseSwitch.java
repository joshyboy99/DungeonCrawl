package dungeon.backend.goal;

import dungeon.backend.*;
import dungeon.backend.entity.*;

public class GoalCloseSwitch extends GoalBase{
	
	public GoalCloseSwitch(Dungeon dungeon, Player player) {
		super(dungeon, player);
	}

	// @Override
	public void checkComplete() {
		for (Entity e : dungeon.getEntities()) {
			if (e == null) {
				// do nothing 
			}
			if (e instanceof FloorSwitch) {
				if (!((FloorSwitch) e).getState()) { 
					this.complete = false;
					return;
				}
			}
		}
		this.complete = true;
	}
}
