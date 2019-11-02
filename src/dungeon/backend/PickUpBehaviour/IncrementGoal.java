package dungeon.backend.PickUpBehaviour;


import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

public class IncrementGoal extends InteractableBehaviour implements PickUpBehaviour {

	Goal goal;
	
	public IncrementGoal(Entity attached, Goal goal) {
		super(attached);
		this.goal = goal;
	}
	

	@Override
	public void onPickup(Entity entity) {
		goal.increment();
		removeFromDungeon();
		
	}
	

}
