package dungeon.backend.entity;

import dungeon.backend.MoveBehaviour.MoveBehaviour;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y, new MoveBehaviour(), contactBehaviour);
    }
    

}
