package dungeon.backend.goal;

import java.util.List;

/**
 * The Composite type of goals
 * @author JAG
 *
 */
public interface GoalCompositeType {
	public boolean isComplete(List<Goal> goalList);
}
