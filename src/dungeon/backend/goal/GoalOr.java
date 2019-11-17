package dungeon.backend.goal;

import java.util.List;

/**
 * A type of composite goal that is completed
 * when any of the contained goals are complete.
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
