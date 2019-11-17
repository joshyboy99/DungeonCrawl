package dungeon.backend.goal;
import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This Goal is completed once all of the enemies 
 * in the dungeon have been destroyed. 
 * @author JAG
 *
 */
public class GoalEliminateEnemy extends GoalBase {
	
	public GoalEliminateEnemy(Dungeon dungeon, Player player) {
		super(dungeon, player);		
	}

	// @Override
	public void checkComplete() {
		
		for (Entity e : dungeon.getEntities()) {
			if (e instanceof Enemy) {
				this.complete = false;
				return;
			}
		}
		
		this.complete = true;
	}

}
