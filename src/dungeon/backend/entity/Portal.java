package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The portal Entity class
 * @author JAG
 *
 */
public class Portal extends Entity {
	
	private int portalID; 
	private Portal pair;
	
	public Portal(int x, int y, Dungeon dungeon,int portalID) {
		super(x, y, dungeon);
		this.contactBehaviour = new Transport(this);		
		this.moveBehaviour = new Static(this);
		this.portalID = portalID;
		this.dungeon = dungeon; 
	}

	
	public void addPair(Portal p) {
		pair = p;
	}
	
	public void removePair() {
		pair = null;
	}
	
	public Portal getPair() {
		return this.pair;
	}
	
	public int getportalID() {
		return portalID;
	}
	
	//will return the pair's portals X coordinates
	public int getPortX() {
		Portal PortalPair = dungeon.getGetPortalPair(this, this.portalID);
		//return this portal if could not be found (so player does not go anywhere)
		return PortalPair.getX();
	}
	
	//will return the pair's portals Y coordinates
	public int getPortY() {
		Portal PortalPair = dungeon.getGetPortalPair(this, this.portalID);
		//return this portal if could not be found (so player does not go anywhere)
		return PortalPair.getY();
	}
	
	public void wasTouched(Entity e) {
		e.setX(this.getPortX());
		e.setY(this.getPortY());
	}


}
