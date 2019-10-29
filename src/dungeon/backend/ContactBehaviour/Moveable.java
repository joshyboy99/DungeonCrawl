package dungeon.backend.ContactBehaviour;

import dungeon.backend.Entity;

public class Moveable implements ContactBehaviour {
	@Override
	public void onTouch(Entity e) {
		int playerPositionX= e.getX();
		int playerPositionY = e.getY();
		
	}

}
