package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public abstract class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private boolean paused;
    
    protected MoveBehaviour moveBehaviour;
    protected ContactBehaviour contactBehaviour;

    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
     */
    public Entity(int x, int y, MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.contactBehaviour = contactBehaviour;
        this.moveBehaviour = moveBehaviour;
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
    
    public void performTouch(Entity e) {
    	this.contactBehaviour.onTouch(e);
    }


	public MoveBehaviour getMoveBehaviour() {
		return moveBehaviour;
	}

	public void setMoveBehaviour(MoveBehaviour moveBehaviour) {
		this.moveBehaviour = moveBehaviour;
	}

	public ContactBehaviour getContactBehaviour() {
		return contactBehaviour;
	}

	public void setContactBehaviour(ContactBehaviour contactBehaviour) {
		this.contactBehaviour = contactBehaviour;
	}
    
    
}
