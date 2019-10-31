package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y);
        this.contactBehaviour = new Repel(this);
        this.moveBehaviour = new Static(this);
        

    }
    

}
