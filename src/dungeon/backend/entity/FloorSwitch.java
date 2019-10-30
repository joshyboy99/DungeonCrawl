package dungeon.backend.entity;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class FloorSwitch extends Entity implements Observable{

	String State;
	List<Observer> Observers;
	
	public FloorSwitch(int x, int y) {
		super(x, y, new Static(), null);
		this.contactBehaviour = new Trigger(this);
		State = "Open";
		Observers = new ArrayList<Observer>();
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
		if(contactBehaviour.)
	}

	@Override
	public void notifyObservers() {
		for (Observer o : Observers) {
			o.update(this.isClosed());
		}
		
	}

	@Override
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		
	}
	

}
