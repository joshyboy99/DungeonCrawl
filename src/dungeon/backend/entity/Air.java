package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.NoContact;
import dungeon.backend.MoveBehaviour.Static;


/**
 * The Air entity. This entity kills you when
 * you touch it.
 * @author JAG
 *
 */
public class Air extends Entity {
    public Air(int x, int y, Dungeon dungeon) {
        super(x, y, dungeon);
		this.contactBehaviour = new NoContact(this);
        this.moveBehaviour = new Static(this);
    }
}
