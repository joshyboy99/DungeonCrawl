package dungeon.backend.goal;

import java.util.List;

/**
 * Looks at all the AND goals, if any of the goals are 
 * not working, then return false.
 * @author JAG
 *
 */
public class GoalAnd implements GoalCompositeType {
	
	@Override
	public boolean isComplete(List<Goal> goalList) {
		for (Goal g : goalList) {
			if (!g.isComplete()) {
				return false;
			}
		}
		return true;
	}

}
