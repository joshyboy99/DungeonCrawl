package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class FloorSwitch extends Entity implements Observable{

	String State;
	
	public FloorSwitch(int x, int y) {
		super(x, y, new Static(), null);
		this.contactBehaviour = new Trigger(this);
		State = "Open";
	}

	public void checkState() {
		
	}
	
	public boolean isClosed() {
		if(State.equals("Open")) {
			return true;
		}
		
		else return false;
	}
	
	public void changeState(){
		
	}
	

}
