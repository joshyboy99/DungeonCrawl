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

    public int getY() {
        return y().get();
    }

    public int getX() {
        return x().get();
    }
    
    public void setY(int y) {
        this.y.set(y);
    }
    
    public Dungeon getDungeon() {
        return this.dungeon;
    }
    
    public int getDungeonHeight(){
        return this.dungeon.getHeight();
    }
    public int getDungeonWidth(){
        return this.dungeon.getWidth();
    }
    
    public boolean samePosition(int x, int y) {
    	if (x == this.getX() && y == this.getY()) {
    		return true;
    	}
    	return false;
    }

    public void setX(int x) {
        this.x.set(x);
    }
    
    public void togglePaused() {
    	paused = !paused;
    }
    
    public void performMove() {
    	//if(this.paused == false) 
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
	
    
	public int getMx() {
		return this.mx.get();
	}

	public void setMx(int mx) {
		this.mx.set(mx);
	}

	public int getMy() {
		return this.my.get();
	}

	public void setMy(int my) {
		this.my.set(my);
	}
	
	public void setToChangeTiles() {
		this.setX(this.mx.intValue());
		this.setY(this.my.intValue());
	}
	
	public void nextMove() {
		this.x.set(x.get() + mx.get());
		this.y.set(y.get() + my.get());
		this.changeFace();
		this.setMx(0);
		this.setMy(0);
	}
	
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
	
	protected String getFacing() {
		return this.Facing;
	}
	
	public void wasTouched(Entity entity) { 
	}
	
	public void scanDungeonTile(int x, int y) {
		this.dungeon.scanTile(this, x, y);
	}
	
	public void removeSelf(){
		if(dungeon.checkEntitiesOnDungeon(this)) {
			//System.out.print("size:" + dungeon.getEntities().size() + "\n");
			dungeon.removeEntity(this);
		}
		
	}
	
	public void affect(Entity entity) {
	};
	
	public void addValidEntityContact(Entity e) {
		((InteractableBehaviour)contactBehaviour).addEntity(e);
	}
	
	public void addValidEntityEffect(Effect eff, Entity ent) {
		Effect e = effects.get(effects.indexOf(eff));
		((InteractableBehaviour)e).addEntity(ent);
	}
	
	public void isComplete(){
		this.dungeon.isComplete();
	}

	public void addEffect(Effect e) {
		this.effects.add(e);
	}
	
	public List<Effect> getEffects() {
		return this.effects;
	}
	
	public void removeEffect(Effect e) {
		for(Effect eff: effects) {
			if(e.getClass().equals(eff.getClass())) {
				effects.remove(eff);
			}
		}
	}
	
	public void resetNextMove() {
		this.setMx(0);
		this.setMy(0);
	}
	
}
