package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Boulder extends Entity{

	public Boulder(int x, int y, Dungeon dungeon) {
		super(x, y);
		this.dungeon = dungeon;
		this.contactBehaviour= new Moveable(this);
		this.moveBehaviour = new Static(this);
	}
	
	

}
