package dungeon.backend;

public class Wall extends Entity {

    public Wall(int x, int y) {
        super(x, y);
    }
    
    // cannot make sure its blocked
    @Override
    public boolean isPassable() {
    	return false;
    }

}
