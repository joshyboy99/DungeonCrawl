package dungeon.backend.entity;


import dungeon.backend.*;

import java.util.List;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.PlayerControl;

/**
 * The Entity - Player, is a user controlled entity which inhabits the dungeon. 
 * the player can complete goals, unlock doors, and perform many other unique tasks
 * within the dungeon, and many other entities depend on it.
 * Always ensure that the dungeon contains a player before adding other entities. 
 * 
 * @author JAG
 *
 */
public class Player extends Entity {
	
	/**
	 * Contains a list of pickup entities
	 * contained within the player. 
	 */
    private Inventory inventory;
    
    /**
     * Create a player positioned in square (x,y)
     * @param x
     * @param y
     */
    public Player(Dungeon dungeon, int x, int y) {
        super(x, y, dungeon);
        //this.treasureScore = 0;
        this.inventory = new Inventory();
        this.contactBehaviour = new Die(this);
        this.moveBehaviour = new PlayerControl(this);
    }

    public Player() {
    	super();
    }

    /**
     * This method performs the action required
     * to pick up an entity with the ActivePickup
     * Behavior.
     */
    public void activePickup() {
    	List<Entity> pickList = dungeon.EntitiesOnTile(getX(), getY());
    	for(Entity e: pickList) {
    		if(e instanceof Pickup) {
    			((Pickup) e).performPickup(this);
    		}
    	}
    }
    
    /**
     * This Method allows the player to switch an item from its inventory
     * with one in the dungeon. This is useful when the item limit for the
     * player has been reached.
     */
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
    
    /**
     * This Method is used to return an item from the inventory, to the
     * dungeon at the current location.
     * @param p the item to be dropped.
     */
    public void dropItem(Pickup p){
    	if(inventory.checkForItem(p)) {
    		inventory.remove(p);
    		p.setX(getX());
    		p.setY(getY());
    		dungeon.addEntity(p);
    	}
    }
    
    /**
     * Increments the player's y coordinate by one,
     * moving them up. 
     */
    public void moveUp() {
    	this.setFacing("UP");
        if (getY() > 0) {
        	this.setMy(-1);
        	dungeon.scanTile(this, getX(), getY() - 1);
            y().set(getY() + this.getMy());
        }
    }
    
    /**
     * Decrements the player's y coordinate by one,
     * moving them down.
     */
    public void moveDown() {
    	this.setFacing("DOWN");
        if (getY() < dungeon.getHeight() - 1) {
        	this.setMy(1);
        	dungeon.scanTile(this, getX(), getY() + 1);
        	y().set(getY() + getMy());
        }
    }

    /**
     * Decrements the player's x coordinate by one,
     * moving them left. 
     */
    public void moveLeft() {
    	this.setFacing("LEFT");
        if (getX() > 0 ) {
        	this.setMx(-1);
        	dungeon.scanTile(this, getX() -1 , getY());
            x().set(getX() + this.getMx());
        }
    }
    
    /**
     * Increments the player's x coordinate by one,
     * moving them right. 
     */
    public void moveRight() {
    	this.setFacing("RIGHT");
        if (getX() < dungeon.getWidth() - 1){
        	this.setMx(1);
        	dungeon.scanTile(this, getX() + 1 , getY());
            x().set(getX() + this.getMx());
        }
    }
 
    
    public Inventory getInventory() {
        return this.inventory;
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
    
    /**
     * Checks if the Player has a sword.
     * @return true if the player has a sword,
     * false otherwise. 
     */
    public boolean hasSword() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof Sword) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Returns the first instance of sword in the player's
     * inventory
     * @return the first sword in the inventory.
     */
    public Sword getSword() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof Sword) {
    			return (Sword)p;
    		}
    	}
    	return null; 
    }
    
    /**
     * Calls the sword swing method on sword.
     */
    public void useSword() {
    	if(this.hasSword()) {
    		this.getSword().Swing(this.getFacing(), this.getX(), this.getY());
    	} 
    }
    
    /**
     * Returns the keyID of the key currently possessed by the player
     * @return the KeyID of the key the player possesses.
     */
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

    /**
     * Removes key from player.
     * @param keyID the ID of the key to be destroyed. 
     */
	public void destroyKey(int keyID) {
	
		Key k1 = null;
		for(Pickup p : this.getInventory().getItems()) {
			if(p instanceof Key) {
				Key k0 = (Key) p;
				if( k0.getKeyID() == keyID)
					k1 = k0;
			}
		}
		this.removeItem((Pickup) k1);
	}
	
	/**
	 * Shoots magic in the direction player is currently facing
	 */
	
	public void shootMagic(){
		if(playerHasSpellBook()) {
			this.getSpellBook().shoot(this.getFacing(), this.getX(), this.getY());
		}
	}
	
	/**
	 * Returns spell book in players inventory
	 * @return spell book
	 */

	private SpellBook getSpellBook() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof SpellBook) {
    			return (SpellBook)p;
    		}
    	}
    	return null; 
	}
	
	/**
	 * Will check if player has spellbook.
	 * @return true or false, depending on whether or not player has spellbook. 
	 */

	private boolean playerHasSpellBook() {
    	for(Pickup p: this.getInventory().getItems()) {
    		if(p instanceof SpellBook) {
    			return true;
    		}
    	}
    	return false;
	}
	
	/**
	 * Will summon entity on map
	 */
	public void summon(){
		if(playerHasSpellBook()) {
			this.getSpellBook().summon(this.getFacing(), this.getX(), this.getY());
		}
	}
	
	/**
	 * updates summoners to either follow player or attack!
	 */
	public void updateSummoners() {
		this.dungeon.updateSummoned();
	}
	/**
	 * Gets mana left from spell book
	 * @return mana from spell book
	 */
	public int getMana() {
		if(! playerHasSpellBook()) {
			return -1; 
		} else {
			return this.getSpellBook().getMana();
		}
	}
	
	public int getSwordSwings() {
		if(! hasSword()) {
			return -1; 
		} else {
			return this.getSword().getSwordHits();
		}
	}
	
}
