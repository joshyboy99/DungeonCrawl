package dungeon.backend;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.*;

/**
 * The player entity
 * @author Robert Clifton-Everest
 *
 */
public class Player extends Entity {

    private Dungeon dungeon;
    private PlayerState state;
    private int treasureScore;
    private Inventory inventory;
    // private Direction direction;
    private List<Observer> observers = new ArrayList<Observer>();
    
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y);
        this.dungeon = dungeon;
        this.state = PlayerState.NORMAL;
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

    public PlayerState getState() {
        return this.state;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
    
    public void changePlayerState(PlayerState state) {
        this.state = state;
    }
    
    public void addTreasure(int value) {
        this.treasureScore += value;
    }    
    
}
