package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Wall Entity class
 * @author amyluo
 *
 */
public class Wall extends Entity {
    public Wall(int x, int y, Dungeon dungeon) {
        super(x, y, dungeon);
        this.contactBehaviour = new Repel(this);
        this.moveBehaviour = new Static(this);
    }
}
