package dungeon.backend.goal;

import dungeon.backend.*;
import dungeon.backend.entity.*;

/**
 * This Goal is passed when all of the floor switch
 * entities in the dungeon are in the closed state.
 * @author JAG
 *
 */
public class GoalCloseSwitch extends GoalBase{
	
	public GoalCloseSwitch(Dungeon dungeon, Player player) {
		super(dungeon, player);
	}

	// @Override
	public void checkComplete() {
		for (Entity e : dungeon.getEntities()) {
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
