package dungeon.backend.entity;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class FloorSwitch extends Entity implements Observer {
	// private List<Observer> Observers;
	boolean state;
	
	public FloorSwitch(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new NoContact(this);
		this.state=false; 
		// Observers = new ArrayList<Observer>();
	}
	
	public void wasTouched() { 
		if(this.state == true) {
			this.state =false; 
		} else {
			this.state =true; 
		}
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


	@Override
	public void update(Player player) {
		Dungeon dungeon = player.getDungeon();
		for (Entity e: dungeon.getEntities()) {
			if (e.samePosition(this.getX(), this.getY()) && e instanceof Boulder) {
				setState(true);
				return;
			}
		}
		setState(false);
		return;
		
	}

}
