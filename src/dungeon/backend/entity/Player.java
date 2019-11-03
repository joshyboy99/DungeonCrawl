package dungeon.backend.entity;


import dungeon.backend.*;
import java.util.ArrayList;

import java.util.List;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.PlayerControl;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

	private String facing; 
    private int treasureScore;
    private Inventory inventory;
    private List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y, dungeon);
        this.treasureScore = 0;
        this.inventory = new Inventory();
        this.contactBehaviour = new NoContact(this);
        this.moveBehaviour = new PlayerControl(this);
    }

    public Player() {
    	super();
    }

    public void activePickup() {
    	List<Entity> pickList = dungeon.EntitiesOnTile(getX(), getY());
    	for(Entity e: pickList) {
    		if(e instanceof Pickup) {
    			((Pickup) e).performPickup(this);
    		}
    	}
    }
    
    public void swapItem() {
    	List<Entity> pickList = dungeon.EntitiesOnTile(getX(), getY());
    
    	for(Entity e: pickList) {
    		if(e instanceof Pickup) {
    			
	    		if(inventory.checkForItem((Pickup) e)) {
	    			
	    			Pickup p = inventory.getItemType((Pickup) e); 
	    			dropItem((Pickup) p);
	    			((Pickup) e).performPickup(this);
	    		}	
    		}
    	}
    }
    
    public void dropItem(Pickup p){
    	if(inventory.checkForItem(p)) {
    		inventory.remove(p);
    		p.setX(getX());
    		p.setY(getY());
    		dungeon.addEntity(p);
    	}
    }
    
    public void moveUp() {
    	this.facing = "UP";
        if (getY() > 0) {
        	this.setMy(-1);
        	dungeon.scanTile(this, getX(), getY() - 1);
            y().set(getY() + this.getMy());
        }
    }

    public void moveDown() {
    	this.facing = "DOWN";
        if (getY() < dungeon.getHeight() - 1) {
        	this.setMy(1);
        	dungeon.scanTile(this, getX(), getY() + 1);
        	y().set(getY() + getMy());
        }
        
    }

    public void moveLeft() {
    	this.facing = "LEFT";
        if (getX() > 0 ) {
        	this.setMx(-1);
        	dungeon.scanTile(this, getX() -1 , getY());
            x().set(getX() + this.getMx());
        }
    }

    public void moveRight() {
    	this.facing = "RIGHT";
        if (getX() < dungeon.getWidth() - 1){
        	this.setMx(1);
        	dungeon.scanTile(this, getX() + 1 , getY());
            x().set(getX() + this.getMx());
        }
    }
    
    public int getTreasure() {
        return this.treasureScore;
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    
    public void addTreasure(int value) {
        this.treasureScore += value;
    }
    
    public void addItem(Pickup attached) {
    	this.inventory.add(attached);
    	
    }
    
    public void removeItem(Pickup p) {
    	this.inventory.remove(p);
    }
    
    public boolean checkInventory(Pickup p) {
    	return this.inventory.checkForItem(p);
    }
    
    public Dungeon getDungeon() {
    	return this.dungeon;
    }
    
    public boolean hasSword() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof Sword) {
    			return true;
    		}
    	} 
    	return false;
    }
    
    public Sword getSword() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof Sword) {
    			return (Sword)p;
    		}
    	}
    	return null; 
    }
    
    public void useSword() {
    	if(this.hasSword()) {
    		this.getSword().Swing(this.facing, this.getX(), this.getY());
    	} 
    }
    
    public int getCurrentKeyID(){
    	//find key in inventory
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof Key) {
    			Key k0 = (Key) p;
    			return k0.getKeyID();
    		}
    	}
    	return -1;
    }
}
