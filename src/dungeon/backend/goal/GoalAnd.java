package dungeon.backend.goal;

import java.util.List;

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
