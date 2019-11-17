package dungeon.backend.goal;

import org.json.JSONArray;
import org.json.JSONObject;

import dungeon.backend.*;
import dungeon.backend.entity.*;

/**
 * This Class is responsible for the 
 * adding and checking of goals for 
 * the dungeon.  
 * @author JAG
 *
 */
public class GoalManager {
	private Dungeon dungeon;
	private Player player;
	private Goal goal;
	
	public GoalManager(Dungeon dungeon, Player player) {
		this.dungeon = dungeon;
		this.player = player;
		this.goal = null;
	}
	
	/**
	 * Checks if the overall goal of the
	 * dungeon has been completed.
	 * @return true if all goals passed, false otherwise. 
	 */
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
	
	/**
	 * Processes a JSON object and creates the goals for the level]
	 * from the information stored within.
	 * @param goalCondition a JSON object containing all the goals for the level. 
	 * @return the composite goal for the dungeon as a goal object.
	 */
	public Goal createGoal(JSONObject goalCondition) {
		
    	Goal newGoal = null;
    	String type = goalCondition.getString("goal");
    	
    	if (type.equals("AND") || type.equals("OR")) {
    		GoalComposite goals = new GoalComposite(type);
    		JSONArray s = goalCondition.getJSONArray("subgoals");
    		for (int i = 0; i < s.length(); i++) {
    			JSONObject sg = s.getJSONObject(i); 
    			goals.addGoal(this.createGoal(sg));
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
    			newGoal = exitGoal;
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
