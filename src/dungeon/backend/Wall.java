package dungeon.backend;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y, new MoveBehaviour(), contactBehaviour, spawnBehaviour);
    }
    

}
