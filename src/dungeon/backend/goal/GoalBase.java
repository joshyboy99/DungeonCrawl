package dungeon.backend.goal;
import dungeon.backend.*;
import dungeon.backend.entity.*;

/**
 * This base component of the composite pattern
 * used for goals. This base component
 * allows for the setting of different kinds of goal
 * objects that are extended from this abstract 
 * class.
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
