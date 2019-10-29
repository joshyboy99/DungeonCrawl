package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;

public class Transport implements ContactBehaviour {
	private Entity attatched;
	//will attatch this behaviour to an entity
	public Transport(Entity attatched) {
		this.attatched = attatched;
	}
	@Override
	public void onTouch(Entity e) {
		int x = e.getX();
		int y = e.getY();
		attatched.setX(x);
		attatched.setY(y);
	}
}
