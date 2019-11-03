package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The boulder Entity Class
 * @author JAG
 *
 */
public class Boulder extends Entity{

	public Boulder(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.contactBehaviour= new Moveable(this);
		this.moveBehaviour = new Static(this);
	}

	public Boulder() {
		super();
	}
	
	

}
