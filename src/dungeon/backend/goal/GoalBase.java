package dungeon.backend.goal;
import dungeon.backend.*;
import dungeon.backend.entity.*;

/**
 * The abstract class that looks at all the possibility of different
 * Goals
 * @author JAG
 *
 */
public abstract class GoalBase implements Goal {
	
	protected Dungeon dungeon;
	protected Player player;
	protected boolean complete; 
	

	public GoalBase(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		this.complete = false;
	}
	
	public abstract void checkComplete();
	
	@Override
	public boolean isComplete() {
		checkComplete();
		return this.complete;
	}
}
