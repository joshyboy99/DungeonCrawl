package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


/**
 *  The Entity - FloorSwitch, is an inanimate obstacle that contains a boolean state 
 *  which can be toggled by certain entities being on its coordinates. Pressing all 
 *  floor switches is a possible goal for a dungeon.
 *  
 * @author JAG
 *
 */
public class FloorSwitch extends Entity implements Observer {
	// private List<Observer> Observers;
	boolean state;
	
	public FloorSwitch(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new NoContact(this);
		this.state=false; 
	}
	
	/**
	 * This overridden wasTouched that toggles the switche's
	 * state when called. 
	 */
	public void wasTouched() { 
		this.state = !state;
	}
	
	/**
	 * Sets the State attribute of this switch to be 
	 * the one that has been entered in the method.
	 * @param state the desired state of the switch.
	 */
	public void setState(boolean state) {
		this.state = state;
	}
	
	/**
	 * Gets the current state of the switch
	 * @return a boolean value representing 
	 * the boolean state of the switch. 
	 * true = closed, false = open. 
	 */
	public boolean getState() {
		return this.state;
	}

	/**
	 * Determines whether the switched is closed or not.
	 * @return true if closed, false otherwise.
	 */
	public boolean isClosed() {
		return this.getState();
	}

	
	/**
	 * Inherited method for observer pattern.
	 * Updates dungeon when state changes.
	 */
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
