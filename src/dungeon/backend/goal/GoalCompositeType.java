package dungeon.backend.goal;

import java.util.List;

/**
 * This composite interface is used
 * for the different types of goals
 * that can be composed of sub-goals. 
 * @author JAG
 *
 */
public interface GoalCompositeType {
	public boolean isComplete(List<Goal> goalList);
}
