package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;

public class Portal extends Entity {
	private IntegerProperty teleportX;
	private IntegerProperty teleportY;
	public Portal(int x, int y) {
		super(x, y);
		
		this.contactBehaviour = new Transport(this);
		this.moveBehaviour = new Static();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the teleportX
	 */
	public int getTeleportX() {
		return teleportX.get();
	}
	/**
	 * @return the teleportY
	 */
	public int getTeleportY() {
		return teleportY.get();
	}
	
	
	
	
	
	
	

}
