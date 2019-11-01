package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;

public class Portal extends Entity {
	private int portalID; 
	private Dungeon dungeon; 
	public Portal(int x, int y, Dungeon dungeon,int portalID) {
		super(x, y);
		this.contactBehaviour = new Transport(this);
		this.moveBehaviour = new Static(this);
		this.portalID = portalID;
		this.dungeon = dungeon; 
		// TODO Auto-generated constructor stub
	}

	
	public int getportalID() {
		return portalID;
	}
	//will return the pair's portals X coordinates
	public int getPortX() {
		Portal PortalPair = dungeon.getGetPortalPair(this, this.portalID);
		//return this portal if could not be found (so player does not go anywhere)
		return 1;
	}
	
	//will return the pair's portals X coordinates
	public int getPortY() {
		Portal PortalPair = dungeon.getGetPortalPair(this, this.portalID);
		//return this portal if could not be found (so player does not go anywhere)
		return PortalPair.getY();
	}


}
