package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;

public class Moveable implements ContactBehaviour {
	private Entity attatched; 
	public Moveable(Entity attatched) {
		this.attatched = attatched;
	}
	@Override
	public void onTouch(Entity e) {
		int playerPositionX= e.getX();
		int playerPositionY = e.getY();
		//if behind obj
		if(playerPositionX - e.getX() <1) {
			
		}  //if to the left of obj
		else if() {
			
		} //if to the right of obj
		else if() {
			
		} else { //if up top of obj 
			
		}
		
		
		
		
	}

}
