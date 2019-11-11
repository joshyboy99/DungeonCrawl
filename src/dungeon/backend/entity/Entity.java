package dungeon.backend.entity;

import java.util.ArrayList;
import java.util.List;

import Effects.Effect;
import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The Entity abstract class which dictates the shared attributes and behaviors
 * of all entities within the dungeon. 
 * @author JAG
 *
 */
public abstract class Entity {

	/**
	* properties x and y pertain to the entity's
	* current position in the dungeon, while mx and my
	* dictate the trajectory of the Entity, describing where
	* it's next location will be relative to where it is.
	 */
    private IntegerProperty x, y;
    private IntegerProperty mx, my;
   
    //Dictates whether or not the entity is in the paused state
    //as directed by the game. 
	private boolean paused;
	
	//describes the direction the entity is facing.
    private String Facing;

    //An interchangeable behavior dictating how the entity moves around the dungeon
    protected MoveBehaviour moveBehaviour;
    
    //An interchangeable behavior dictating what happens when the entity is touched. 
    protected ContactBehaviour contactBehaviour;
    
    //A list of behaviors that may act on an entity when the Affect method is called.
    protected List<Effect> effects;
    
    //The world in which the entity resides. 
    public Dungeon dungeon;
    
   /**
    * Complex constructor for entity in the case that any of its behaviors
    * may be different from those usually assigned in the constructor of
    * its children.
    * @param x Starting x coordinate 
    * @param y Starting y coordinate
    */
    public Entity(int x, int y, MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour) {
    	this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);  
        this.Facing = "DOWN";
        this.contactBehaviour = contactBehaviour;
        this.moveBehaviour = moveBehaviour;
        this.paused = true;
        this.mx = new SimpleIntegerProperty(0);
        this.my = new SimpleIntegerProperty(0);
        this.effects = new ArrayList<Effect>();
    }
    
    /**
     * Standard Constructor for Entity. 
     * @param x Starting x coordinate 
     * @param y Starting y coordinate
     * @param dungeon the world the entity will inhabit
     */
    public Entity(int x, int y, Dungeon dungeon) {
    	this.dungeon = dungeon;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.mx = new SimpleIntegerProperty(0);
        this.my = new SimpleIntegerProperty(0);
        this.paused = true;
        this.effects = new ArrayList<Effect>();

    }
    
    /**
     * Simple constructor for entity, for testing and 
     * validEntity lists. 
     */
    public Entity() {
        this.x = new SimpleIntegerProperty(0);
        this.y = new SimpleIntegerProperty(0);
        this.mx = new SimpleIntegerProperty(0);
        this.my = new SimpleIntegerProperty(0);
        this.paused = true;
        this.effects = new ArrayList<Effect>();
    }
    
    public IntegerProperty x() {
        return x;
    }

    public IntegerProperty y() {
        return y;
    }
    
    /**
     * returns the int value of the integerProperty 'y' 
     * describes the y coordinate of the entity
     * @return int value of y
     */
    public int getY() {
        return y().get();
    }

    /**
     * returns the int value of the integerProperty 'x' 
     * describes the x coordinate of the entity
     * @return int value of x
     */
    public int getX() {
        return x().get();
    }
    
    /**
     * Sets the value of y
     * @param y the desired y coordinate as an int
     */
    public void setY(int y) {
        this.y.set(y);
    }
    
    /**
     * Gets the world this entity inhabits
     * @return the dungeon the entity is in
     */
    public Dungeon getDungeon() {
        return this.dungeon;
    }
    
    /**
     * Gets the max y value of the dungeon
     * @return max y value of dungeon
     */
    public int getDungeonHeight(){
        return this.dungeon.getHeight();
    }
    
    /**
     * Gets the max x value of the dungeon
     * @return the maximum value of x for the dungeon
     */
    public int getDungeonWidth(){
        return this.dungeon.getWidth();
    }
    
    /**
     * Checks if the coordinates entered match the current 
     * coordinates of this entity.
     * @param x coordinate of the target entity
     * @param y coordinate of the target entity
     * @return if the entered coords match this entity's position
     * return true, otherwise false. 
     */
    public boolean samePosition(int x, int y) {
    	if (x == this.getX() && y == this.getY()) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Changes the current x coordinate of this entity 
     * to the entered value.
     * @param x the desired x coordinate.
     */
    public void setX(int x) {
        this.x.set(x);
    }
    
    /**
     * Changes the pause state of this entity.
     */
    public void togglePaused() {
    	paused = !paused;
    }
    
    /**
     * Calls the entity's moveBehaviour
     */
    public void performMove() {
    	//if(this.paused == false) 
    	this.moveBehaviour.move();
    }
    
    /**
     * Calls the entity's touchBehaviour and 
     * passes in the entity with which it has
     * made contact.
     * @param e the entity with which it has 
     * made contact
     */
    public void performTouch(Entity e) {
    	this.contactBehaviour.onTouch(e);
    }
    
    /**
     * Returns the class of moverBehaviour
     * in this entity.
     * @return this entity's moveBehaviour
     */
	public MoveBehaviour getMoveBehaviour() {
		return moveBehaviour;
	}

	/**
	 * Sets the moveBehaviour of this entity to be 
	 * whichever is entered. 
	 * @param moveBehaviour the desired moveBehaviour for this entity.
	 */
	public void setMoveBehaviour(MoveBehaviour moveBehaviour) {
		this.moveBehaviour = moveBehaviour;
	}

	/**
	 * Returns the class of ContactBehaviour
     * in this entity.
     * @return this entity's ContactBehaviour
	 */
	public ContactBehaviour getContactBehaviour() {
		return contactBehaviour;
	}
	
	/**
	 * Sets the ContactBehaviour of this entity to be 
	 * whichever is entered. 
	 * @param contactBehaviour the desired ContactBehaviour for this entity.
	 */
	public void setContactBehaviour(ContactBehaviour contactBehaviour) {
		this.contactBehaviour = contactBehaviour;
	}
	
    /**
     * To get the next x trajectory for this entity.
     * @return the int value of the mx attribute, 
     */
	public int getMx() {
		return this.mx.get();
	}

	/**
	 * sets the x trajectory for this entity's next
	 * move
	 * @param mx the desired next move vector
	 */
	public void setMx(int mx) {
		this.mx.set(mx);
	}

	 /**
     * To get the next y trajectory for this entity.
     * @return the int value of the my attribute, 
     */
	public int getMy() {
		return this.my.get();
	}

	/**
	 * sets the y trajectory for this entity's next
	 * move
	 * @param my the desired next move vector
	 */
	public void setMy(int my) {
		this.my.set(my);
	}
	
	/**
	 * Called when the entity needs to move to the
	 * location directed by its trajectory attributes
	 * mx and my. 
	 * 
	 * Once the new location has been set, the trajectory is set back to 0.
	 */
	public void nextMove() {
		this.x.set(x.get() + mx.get());
		this.y.set(y.get() + my.get());
		this.changeFace();
		this.setMx(0);
		this.setMy(0);
	}
	
	/**
	 * Changes the direction this entity is facing according to their 
	 * next position trajectory.  
	 */
	protected void changeFace() {
    	if(this.getMx() > this.getX()) {
    		this.Facing = "RIGHT";    		
    	}
    	if(this.getMx() > this.getX()) {
    		this.Facing = "LEFT";    		
    	}
    	if(this.getMy() > this.getY()) {
    		this.Facing = "DOWN";
    	}
    	if(this.getMy() < this.getY()) {
    		this.Facing = "UP";
    	}
    }
	
	/**
	 * Returns the string describing which of four
	 * directions this entity is facing. 
	 * @return
	 */
	protected String getFacing() {
		return this.Facing;
	}
	
	/**
	 * A method implemented by some of the entities in order to react to an
	 * entity moving onto their square.
	 * @param entity
	 */
	public void wasTouched(Entity entity) { 
	}
	
	/**
	 * A Method that hands off responsibility to the dungeon to check the behavior
	 * of an entered coordinate. 
	 * @param x the x coordinate to be assessed
	 * @param y the y coordinate to be assessed.
	 */
	public void scanDungeonTile(int x, int y) {
		this.dungeon.scanTile(this, x, y);
	}
	
	/**
	 * A method which removes this entity from the dungeon
	 */
	public void removeSelf(){
		if(dungeon.checkEntitiesOnDungeon(this)) {
			dungeon.removeEntity(this);
		}
	}
	
	/**
	 * A method that calls this entity to start the effects
	 * in it's 'effect list'
	 * @param entity the entity that may be involved in the
	 *  effect. 
	 */
	public void affect(Entity entity) {
	};
	
	/**
	
	 */
	public void addValidEntityContact(Entity e) {
		((InteractableBehaviour)contactBehaviour).addEntity(e);
	}
	
	/**
	 * Adds a type of entity to a list of Valid entities for a specific Effect of this entity.
	 * @param eff the effect to be modified. 
	 * @param ent the entity type to be added to the valid list. 
	 */
	public void addValidEntityEffect(Effect eff, Entity ent) {
		Effect e = effects.get(effects.indexOf(eff));
		((InteractableBehaviour)e).addEntity(ent);
	}
	
	/**
	 * Checks if the dungeon is complete.
	 */
	public void isComplete(){
		this.dungeon.isComplete();
	}

	/**
	 * Adds an effect to the effect list of this entity. 
	 * @param e the effect to be added to this entity's effect list.
	 */
	public void addEffect(Effect e) {
		this.effects.add(e);
	}
	
	/**
	 * Returns the list of effects of this entity. 
	 * @return a list of the effect objects contained in this entity.
	 */
	public List<Effect> getEffects() {
		return this.effects;
	}
	
	/**
	 * Removes an effect from the effect list of this entity
	 * @param e the effect object that should be removed. 
	 */
	public void removeEffect(Effect e) {
		for(Effect eff: effects) {
			if(e.getClass().equals(eff.getClass())) {
				effects.remove(eff);
			}
		}
	}
	
	/**
	 * Sets the trajectory of the next move to 0.
	 * Useful if the entity is being stopped in it's tracks.
	 */
	public void resetNextMove() {
		this.setMx(0);
		this.setMy(0);
	}
	
}
