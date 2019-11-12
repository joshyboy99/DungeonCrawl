package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Entity - Exit, is an inanimate entity that can be walked through.
 * If all previous goals of the dungeon have been completed, walking through
 * this entity will complete the dungeon. 
 * 
 * @author JAG
 *
 */
public class Exit extends Entity{

	public Exit(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new NoContact(this);
	}

}
