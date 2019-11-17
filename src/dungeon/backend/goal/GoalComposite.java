package dungeon.backend.goal;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite type of all Goal composite
 * @author JAG
 *
 */
public class GoalComposite implements Goal {
	
	private GoalCompositeType type;
	private List<Goal> goalList;

	
	public GoalComposite(String type) {
		this.type = createType(type);
		this.goalList = new ArrayList<Goal>();
	}
	
	/**
	 * Creates a new composite goal 
	 * @param type specifies whether 
	 * this goal will be an and or an or condition
	 * for the goals it is composed of.
	 * @return
	 */
	public GoalCompositeType createType(String type) {
		if (type.equals("AND"))
			return new GoalAnd();
		if (type.equals("OR"))
			return new GoalOr();
		return null;
	}
	
	public GoalCompositeType getType() {
		return this.type;
	}
	
	public void addGoal(Goal g) {
		goalList.add(g);
	}
	
	@Override
	public boolean isComplete() {
		return type.isComplete(goalList);
	}
	
	
	
}
