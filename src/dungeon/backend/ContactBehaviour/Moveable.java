package dungeon.backend.ContactBehaviour;

import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;
import dungeon.backend.*;

public class Moveable extends InteractableBehaviour implements ContactBehaviour {
 
	public Moveable(Entity attached) {
		super(attached);
	}
	@Override
	public void onTouch(Entity e) {
		int entityPositionX= e.getX();
		int entityPositionY = e.getY();
		//if to left of obj
		if(attached.getX() - entityPositionX == 1 && attached.getX() < attached.getDungeonWidth() - 1) {
			attached.setX(attached.getX()+1);
		}  //if bottom of obj
		else if(attached.getY() - entityPositionY == -1 && attached.getY() > 0) {
			attached.setY(attached.getY()-1);
		} //if to the right of obj
		else if(attached.getX() - entityPositionX == -1 && attached.getX() > 0) {
			attached.setX(attached.getX()-1);
		} else if(attached.getY() < attached.getDungeonHeight() - 1){ //if up top of obj 
			attached.setY(attached.getY()+1);
		} else {
			//oh no - something has blocked the boulders path, stop entity from moving!!!!!
			attached.setMx(0);
			attached.setMy(0);
		}
	}

}
