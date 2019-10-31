package dungeon.backend.entity;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class FloorSwitch extends Entity implements Observable {

	private boolean state;
	private List<Observer> Observers;
	
	public FloorSwitch(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new Trigger(this);
		this.state = false;
		Observers = new ArrayList<Observer>();
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public boolean getState() {
		return this.state;
	}

	public boolean isClosed() {
		if(this.state = true) {
			return true;
		}
		
		else return false;
	}
//	
//	public void changeState(){
//		if(contactBehaviour.)
//	}

	@Override
	public void notifyObservers() {
		for (Observer o : Observers) {
			o.update(this.isClosed());
		}
		
	}

	@Override
	public void addListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener listener) {
		// TODO Auto-generated method stub
		
	}

}
