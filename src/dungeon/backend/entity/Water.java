package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.Static;


/**
 * Water element! Die once you touch
 * @author JAG
 *
 */
public class Water extends Entity {
    public Water(int x, int y, Dungeon dungeon) {
        super(x, y, dungeon);
		this.contactBehaviour = new Destroy(dungeon.getPlayer());
		this.addValidEntityContact(dungeon.getPlayer());
        this.moveBehaviour = new Static(this);
    }
}
