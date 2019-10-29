package dungeon.backend.entity;

import java.util.ArrayList;

import java.util.List;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private int treasureScore;
    private Inventory inventory;
    private List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y, new PlayerControl(), new NoContact());
        this.dungeon = dungeon;
        this.treasureScore = 0;
        this.inventory = new Inventory();
    }

    public void moveUp() {
        if (getY() > 0)
            y().set(getY() - 1);
    }

    public void moveDown() {
        if (getY() < dungeon.getHeight() - 1)
            y().set(getY() + 1);
    }

    public void moveLeft() {
        if (getX() > 0)
            x().set(getX() - 1);
    }

    public void moveRight() {
        if (getX() < dungeon.getWidth() - 1)
            x().set(getX() + 1);
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
    
    public void addItem(Pickup p) {
    	this.inventory.add(p);
    	
    }
    
    public void removeItem(Pickup p) {
    	this.inventory.remove(p);
    }
}
