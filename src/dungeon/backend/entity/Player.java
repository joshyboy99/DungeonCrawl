package dungeon.backend.entity;


import dungeon.backend.*;
import java.util.ArrayList;

import java.util.List;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

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
        //this.moveBehaviour = new PlayerControl();
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
    
    public void swapItem(Pickup p) {
    	List<Entity> pickList = dungeon.EntitiesOnTile(getX(), getY());
    	for(Entity e: pickList) {
    		if(e.getClass().equals(p.getClass())) {
    			((Pickup) e).performPickup(this);
    			dropItem((Pickup) e);
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
        if (getY() > 0) {
        	this.setMy(-1);
        	dungeon.scanTile(this, getX(), getY() - 1);
            y().set(getY() + this.getMy());
        }
    }

    public void moveDown() {
        if (getY() < dungeon.getHeight() - 1) {
        	this.setMy(1);
        	dungeon.scanTile(this, getX(), getY() + 1);
        	y().set(getY() + getMy());
        }
        
    }

    public void moveLeft() {
        if (getX() > 0 ) {
        	this.setMx(-1);
        	dungeon.scanTile(this, getX() -1 , getY());
            x().set(getX() + this.getMx());
        }
    }

    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1){
        	this.setMx(1);
        	dungeon.scanTile(this, getX() + 1 , getY());
            x().set(getX() + this.getMx());
        }
    }
    
    public void move(int dx, int dy) {
//    	System.out.println("observers: " + observers);

    	int mx = getX() + dx;
    	int my = getY() + dy;
    	if (mx < 0 || my < 0 || mx > dungeon.getWidth() - 1 || my > dungeon.getHeight() -1) {
    		//notifyObservers();
    		return;
    	}
    	
    	if (dungeon.getEntities() != null) {
			for (int i = 0; i < dungeon.getEntities().size(); i++) {
				Entity e = dungeon.getEntities().get(i);
				if (e == null) continue;
				if (e.samePosition(mx,my)) {
					// cannot interact
//					if (!e.interact(this)) {
//						//notifyObservers();
//						return;
//					}
				}
			}
    	}
    	this.changeFace();
    	this.nextMove();
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
    
    public void useSword() {
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
