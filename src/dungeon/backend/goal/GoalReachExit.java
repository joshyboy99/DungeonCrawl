package dungeon.backend.goal;

import dungeon.backend.*;
import dungeon.backend.entity.*;

/**
 * The Goal that make sure it has reached the EXIT
 * @author JAG
 *
 */
public class GoalReachExit extends GoalBase {
	
	public GoalReachExit(Dungeon dungeon, Player player) {
		super(dungeon, player);		
	}

	public void checkComplete() {
		for (Entity e : dungeon.getEntities()) {

			if (e instanceof Exit) {
				complete = atExit((Exit) e);
				return;
			}
		}
		complete = false;
	}
	
	private boolean atExit(Exit e) {
		
		int playerX = player.getX();
		int playerY = player.getY();
		
		if (e.samePosition(playerX, playerY)) {
			return true;
		}
		return false;
	}

}
