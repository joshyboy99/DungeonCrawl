package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Entity - Portal, is an inanimate entity that either transports
 * valid entities to a corresponding portal elsewhere in the dungeon
 * or acts like an impassable object. 
 * @author JAG
 *
 */
public class Portal extends Entity {
	
	private int portalID; 
	
	public Portal(int x, int y, Dungeon dungeon,int portalID) {
		super(x, y, dungeon);
		this.contactBehaviour = new Transport(this);		
		this.moveBehaviour = new Static(this);
		this.portalID = portalID;
		this.dungeon = dungeon; 
	}
	
	public int getportalID() {
		return portalID;
	}
	
	/**
	 * Returns the X coordinate of the paired portal.
	 * @return the x coordinate of the paired portal as an int.
	 */
	public int getPortX() {
		Portal PortalPair = dungeon.getPortalPair(this);
		return PortalPair.getX();
	}
	
	/**
	 * Returns the Y coordinate of the paired portal.
	 * @return the y coordinate of the paired portal as an int.
	 */
	public int getPortY() {
		Portal PortalPair = dungeon.getPortalPair(this);
		return PortalPair.getY();
	}
	
	/**
	 * Transports the valid to the paired portal's location. 
	 */
	public void wasTouched(Entity e) {
		e.setX(this.getPortX());
		e.setY(this.getPortY());
	}


}
