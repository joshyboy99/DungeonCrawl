package dungeon.backend.ContactBehaviour;

import dungeon.backend.Entity;

public class Destroy implements ContactBehaviour {
	@Override
	public void onTouch(Entity e) {
		// TODO Auto-generated method stub
		this.entity.kill(e);
	}

}
