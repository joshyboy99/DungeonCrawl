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
 * An entity in the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public abstract class Entity {

    // IntegerProperty is used so that changes to the entities position can be
    // externally observed.
    private IntegerProperty x, y;
    private IntegerProperty mx, my;
   
	private boolean paused;
    private String Facing;

    protected MoveBehaviour moveBehaviour;
    protected ContactBehaviour contactBehaviour;
    protected List<Effect> effects;
    protected Dungeon dungeon;
    
    /**
     * Create an entity positioned in square (x,y)
     * @param x
     * @param y
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
    
    public Entity(int x, int y, Dungeon dungeon) {
    	this.dungeon = dungeon;
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
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
    
//    public void performPickup(Entity e) {
//    	((Pickup) e).performPickup();
//    }

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
	
//	public String getContactBehaviourString() {
//		return contactBehaviour.getClass().getSimpleName();
//	}
    
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
		this.x = mx;
		this.y = my;
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
		System.out.print("size:" + dungeon.getEntities().size() + "\n");
		dungeon.removeEntity(this);
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

}
