package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This Behavior is part of the group that extends Contact Behavior 
 * and is useful for instances of Entity that can be moved by other entities. 
 * @author JAG
 *
 */
public class Moveable extends InteractableBehaviour implements ContactBehaviour {
 
	public Moveable(Entity attached) { 
		super(attached);
		this.ValidEntities.add(new Player());
	}
	
	/**
	 * this override of onTouch allows the incoming entity to move the attached entity in the same direction
	 * as itself. 
	 */
	@Override
	public void onTouch(Entity e) {
		
		if(checkValidEntityClass(e)) {
			
			//Get relevant values for comparisons.
			int eX = e.getX();
			int eY = e.getY();
			int aX = attached.getX();
			int aY = attached.getY();
			attached.resetNextMove();
			
			//If the incoming entity is to the left of the attached entity. 
			if( (aX - eX == 1) && (aX < (attached.getDungeonWidth() - 1)) ) {
				
				//Set the attached entity's next move to be left by one and scan that tile to
				//ensure that the move is valid.
				attached.setMx(1);
				attached.scanDungeonTile(aX + 1, aY);
				
				//If the attached entity's move has been denied, then pass this on 
				//to the incoming entity.
				if(attached.getMx() == 0) {
					e.setMx(0);
				}
				
				//Increment the current location by the value of the nextMove variables.
				attached.nextMove();
			}  

			//If the incoming entity is above of the attached entity.
			else if(aY - eY == -1 && aY > 0) {
				attached.setMy(-1);
				attached.scanDungeonTile(aX, aY - 1);
				
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				
				attached.nextMove();
			}

			//If the incoming entity is to the right of the attached entity. 
			else if( (aX - eX == -1) && (aX > 0) ) {
				attached.setMx(-1);
				attached.scanDungeonTile(aX - 1, aY);
				
				if(attached.getMx() == 0) {
					e.setMx(0);
				}
				
				attached.nextMove();
			} 
			
			//If the incoming entity is below the attached entity.
			else if( (aY - eY == 1) && (aY < attached.getDungeonHeight() - 1) ){
				attached.setMy(1);
				attached.scanDungeonTile(aX, aY + 1);
				
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				
				attached.nextMove();
			} 
			
			//If the incoming entity is attempting to push the attached out of bounds
			//this will reset their movement to 0
			else {
				e.resetNextMove();
			}
			
		} 
		
		
		//If the incoming entity is not on the valid entities list then it's move is rejected.
		else { 
			e.resetNextMove();
		}
   }
}