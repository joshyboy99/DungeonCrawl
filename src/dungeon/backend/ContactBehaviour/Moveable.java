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
		//if behind obj
		if(playerPositionX - e.getX() < 1 && ) {
			
		}  //if to the left of obj
		else if() {
			
		} //if to the right of obj
		else if() {
			
		} else { //if up top of obj 
			
		}
		
		
		
		
	}

}
