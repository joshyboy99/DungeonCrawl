package dungeon.backend.goal;

import org.json.JSONObject;

import dungeon.backend.*;
import dungeon.backend.entity.*;

public class GoalManager {
	private Dungeon dungeon;
	private Player player;
	private Goal goal;
	
	public GoalManager(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		this.goal = null;
	}
	
	public boolean checkComplete() {
		if (this.goal == null) {
			return false;
		}
		return this.goal.isComplete();
	}
	
	public void setGoal(JSONObject goalCondition) {
		this.goal = createGoal(goalCondition);
	}
	
	public Goal getGoal() {
		return this.goal;
	}
	
	public Goal createGoal(JSONObject goalCondition) {
		
		return null;
		
	}
	
}
