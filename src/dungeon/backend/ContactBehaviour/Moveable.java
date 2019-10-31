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
		if(attached.getX() - entityPositionX == 1 && ) {
			attached.setX(attached.getX()+1);
		}  //if bottom of obj
		else if(attached.getY() - entityPositionY == -1) {
			attached.setY(attached.getY()-1);
		} //if to the right of obj
		else if(attached.getX() - entityPositionX == -1) {
			attached.setX(attached.getX()-1);
		} else { //if up top of obj 
			attached.setY(attached.getY()+1);
		}
		
		
		
		
	}

}
