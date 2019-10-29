package dungeon.backend;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private boolean paused;
    
    private MoveBehaviour moveBehaviour;
    private ContactBehaviour contactBehaviour;
    private SpawnBehaviour spawnBehaviour;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    public Entity(int x, int y, MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour, SpawnBehaviour spawnBehaviour) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.contactBehaviour = contactBehaviour;
        this.moveBehaviour = moveBehaviour;
        this.spawnBehaviour = spawnBehaviour;
        this.paused = true;
    }

    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }
    
    public void setY(int y) {
        this.y.set(y);
    }

    public void setX(int x) {
        this.x.set(x);
    }
    
    public void togglePaused() {
    	paused = !paused;
    }
    
    public void performMove() {
    	this.moveBehaviour.move();
    }
    
    public void performTouch() {
    	this.contactBehaviour.onTouch(entity);
    }
    
    public void performSpawn() {
    	this.spawnBehaviour.spawn();
    }
    
    
    
    
    
}
