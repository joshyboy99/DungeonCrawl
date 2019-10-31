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
		for(Entity portal: dungeon.getEntities() ) {
			if(portal instanceof Portal) {
				Portal p = (Portal) portal;
				System.out.print(p.getportalID() + "\n");				
				if(p.getportalID() == this.getportalID() && p.equals(this) == false ) {
					System.out.print(p.getportalID() + "\n");	
					return portal.getX();					
				}
			}
		}
		//return this portal if could not be found (so player does not go anywhere)
		return this.getX();
		
	}
	//will return the pair's portals X coordinates
	public int getPortY() {
		for(Entity portal: dungeon.getEntities() ) {
			//find portals
			if(portal instanceof Portal) {
				Portal p = (Portal) portal;
				if(p.getportalID() == this.portalID && p.equals(this) == false) {
					return portal.getY();					
				}
			}
		}
		//return this portal if could not be found (so player does not go anywhere)
		return this.getY();
	}

	
	
	
	
	
	
	

}
