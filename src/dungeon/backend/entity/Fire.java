package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.Static;

/**
 * The Fire entity. This entity kills you when
 * you touch it.
 * @author JAG
 *
 */
public class Fire extends Entity {
    public Fire(int x, int y, Dungeon dungeon) {
        super(x, y, dungeon);
		this.contactBehaviour = new Destroy(dungeon.getPlayer());
		this.addValidEntityContact(dungeon.getPlayer());
        this.moveBehaviour = new Static(this);
    }
}
