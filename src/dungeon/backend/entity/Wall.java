package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.ContactBehaviour;
import dungeon.backend.MoveBehaviour.MoveBehaviour;

public class Wall extends Entity {

    public Wall(int x, int y, MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour) {
        super(x, y, moveBehaviour, contactBehaviour);
    }
    

}
