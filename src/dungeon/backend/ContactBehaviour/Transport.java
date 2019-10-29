package dungeon.backend.ContactBehaviour;

import dungeon.backend.Entity;

public class Transport implements ContactBehaviour {
	@Override
	public void onTouch(Entity e) {
		int x = getteleportXTeleport().get();
		int y = getteleportYTeleport().get();
		e.setX(x);
		e.setY(y);
	}
}
