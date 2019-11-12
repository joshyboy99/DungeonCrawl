package dungeon.backend.goal;

import java.util.List;

/**
 * Looks at all the OR goals, if any of the goals are 
 * completed, then return true
 * @author JAG
 *
 */
public class GoalOr implements GoalCompositeType {
	
	@Override
	public boolean isComplete(List<Goal> goalList) {
		for (Goal g : goalList) {
			if (g.isComplete()) {
				return true;
			}
		}
		return false;
	}

}
