package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Exit extends Entity{

	public Exit(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new Locked(this);
	}
	
	public void wasTouched(Entity entity) {
		Player p0 = (Player) entity;
		
		
	}
}
