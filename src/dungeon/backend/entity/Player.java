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
        super(x, y);
        this.dungeon = dungeon;
        this.treasureScore = 0;
        this.inventory = new Inventory();
        this.contactBehaviour = new NoContact(this);
        //this.moveBehaviour = new PlayerControl();
    }

    public void activePickup() {
    	
    }
    
    public void openInventory() {
    	
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
    
}
