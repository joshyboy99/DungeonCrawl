	package dungeon.backend.goal;
import dungeon.backend.entity.*;
import dungeon.backend.*;

/**
 * This Goal object is completed when all of the
 * treasure entities in the dungeon have been 
 * collected.
 * @author JAG
 *
 */
public class GoalCollectTreasure extends GoalBase {
	
	public GoalCollectTreasure(Dungeon dungeon, Player player) {
		super(dungeon, player);
	}

	// @Override
	public void checkComplete() {
		
		for (Entity e : dungeon.getEntities()) {
			if (e instanceof Treasure) {
				this.complete = false;
				return;
			}
		}
		this.complete = true;
	}
	

}
