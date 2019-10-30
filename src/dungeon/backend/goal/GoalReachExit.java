package dungeon.backend.goal;

import dungeon.backend.*;
import dungeon.backend.entity.*;

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
		int x = e.getX();
		int y = e.getY();
		
		int playerX = player.getX();
		int playerY = player.getY();
		
		if (x == playerX && y == playerY) {
			return true;
		}
		return false;
	}

}
