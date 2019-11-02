package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;
import dungeon.backend.*;

public class Moveable extends InteractableBehaviour implements ContactBehaviour {
 
	public Moveable(Entity attached) {
		super(attached);
		this.ValidEntities.add(new Player());
		this.ValidEntities.add(new Boulder());
	}
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
			}  //if bottom of obj
			else if(attached.getY() - entityPositionY == -1 && attached.getY() > 0) {
				attached.setMy(-1);
				attached.scanDungeonTile(attached.getX(), attached.getY() - 1);
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				attached.setY(attached.getY()+ attached.getMy());
			} //if to the right of obj
			else if(attached.getX() - entityPositionX == -1 && attached.getX() > 0) {
				attached.setMx(-1);
				attached.scanDungeonTile(attached.getX() - 1, attached.getY());
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMx() == 0) {
					e.setMx(0);
				}
				attached.setX(attached.getX()+ attached.getMx());
			} else if(attached.getY() - entityPositionY == 1 && attached.getY() < attached.getDungeonHeight() - 1){ //if up top of obj 
				attached.setMy(1);
				attached.scanDungeonTile(attached.getX(), attached.getY() + 1);
				//if attached has failed to move, then obviously entity cannot either!
				if(attached.getMy() == 0) {
					e.setMy(0);
				}
				attached.setY(attached.getY()+ attached.getMy());
			} else {
				//oh no - attached is attempting to go out of bounds, stop entity from moving!!!!!
				e.setMx(0);
				e.setMy(0);
			}
		}
   }
}

/* KNOWN ISSUES:
 * -BOULDER USES SCAN TILE, SO WILL INTERACT WITH ENTITIES JUST LIKE PLAYER. THIS IS INTENDED BEHAVIOUR (MUST SCAN FOR WALLS AND SWITCHES) 
 * AND THE SOLUTION IS ADDING ALLOWED ENTITIES TO EACH CONTACT BEHAVIOUR!!!!
 * 
 * -NOTHING ELSE THIS IS PERFECT (lol)
 */


