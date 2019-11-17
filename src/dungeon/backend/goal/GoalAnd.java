package dungeon.backend.goal;

import java.util.List;

/**
 * A type of composite goal that is completed
 * when all of the contained goals are complete.
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
