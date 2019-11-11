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
	 * this override of ontouch allows the incoming entity to move the attached entity in the same direction
	 * as itself. 
	 */
	@Override
	public void onTouch(Entity e) {
		
		if(checkValidEntityClass(e)) {
			
			int entityPositionX= e.getX();
			int entityPositionY = e.getY();
			
			//if to left of obj
			if(attached.getX() - entityPositionX == 1 && attached.getX() < attached.getDungeonWidth() - 1) {
				attached.setMx(1);
				attached.scanDungeonTile(attached.getX() + 1, attached.getY());
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMx() == 0) {
					e.setMx(0);
				}
				attached.setX(attached.getX()+ attached.getMx());
			}  

			
			else if(attached.getY() - entityPositionY == -1 && attached.getY() > 0) {
				attached.setMy(-1);
				attached.scanDungeonTile(attached.getX(), attached.getY() - 1);
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				attached.setY(attached.getY()+ attached.getMy());
			} 

			
			else if(attached.getX() - entityPositionX == -1 && attached.getX() > 0) {
				attached.setMx(-1);
				attached.scanDungeonTile(attached.getX() - 1, attached.getY());
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMx() == 0) {
					e.setMx(0);
				}
				attached.setX(attached.getX()+ attached.getMx());
			} 
			
			else if(attached.getY() - entityPositionY == 1 && attached.getY() < attached.getDungeonHeight() - 1){ //if up top of obj 
				attached.setMy(1);
				attached.scanDungeonTile(attached.getX(), attached.getY() + 1);
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				attached.setY(attached.getY()+ attached.getMy());
			} 
			
			
			else {
				//oh no - attached is attempting to go out of bounds, stop entity from moving!!!!!
				e.setMx(0);
				e.setMy(0);
			}
		} 
		
		
		
		else { 
			e.setMx(0);
			e.setMy(0);
		}
   }
}