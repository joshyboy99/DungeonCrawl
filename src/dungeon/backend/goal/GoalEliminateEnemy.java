package dungeon.backend.goal;
import dungeon.backend.entity.*;
import dungeon.backend.*;

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
