package dungeon.backend.goal;

import org.json.JSONArray;
import org.json.JSONObject;

import dungeon.backend.*;
import dungeon.backend.entity.*;

public class GoalManager {
	private Dungeon dungeon;
	private Player player;
	private Goal goal;
	private Goal ExitGoal;
	
	public GoalManager(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		this.goal = null;
		this.ExitGoal = null;
	}
	
	public boolean checkComplete() {
		if (this.goal == null) {
			return false;
		}
		return this.goal.isComplete();
	}
	
	public boolean checkExit() {
		if (this.ExitGoal == null) {
			return false;
		}
		return ExitGoal.isComplete();
	}
	
	
	public void setGoal(JSONObject goalCondition) {
		this.goal = createGoal(goalCondition);
	}
	
	public Goal getGoal() {
		return this.goal;
	}
	
	public Goal createGoal(JSONObject goalCondition) {
		
    	Goal newGoal = null;
    	String type = goalCondition.getString("goal");
    	
    	if (type.equals("AND") || type.equals("OR")) {
    		GoalComposite goals = new GoalComposite(type);
    		JSONArray subGoals = goalCondition.getJSONArray("subgoals");
    		for (int i = 0; i < subGoals.length(); i++) {
    			JSONObject subGoal = subGoals.getJSONObject(i); 
    			goals.addGoal(this.createGoal(subGoal));
    		}
    		newGoal = goals; 
    	}  else {
    		switch(type) {
    		case "enemies":
    			GoalBase enemyGoal = new GoalEliminateEnemy(dungeon, player);
    			newGoal = enemyGoal;
    			break;
    		case "treasure":
    			GoalBase treasureGoal = new GoalCollectTreasure(dungeon, player);
    			newGoal = treasureGoal;
    			break;
    		case "exit":
    			GoalBase exitGoal = new GoalReachExit(dungeon, player);
    			this.ExitGoal = exitGoal;
    			break;
    		case "boulders":
    			GoalBase switchGoal = new GoalCloseSwitch(dungeon, player);
    			newGoal = switchGoal;
    			break;
    		}
    	}
    	return newGoal;
		
	}
	
}
