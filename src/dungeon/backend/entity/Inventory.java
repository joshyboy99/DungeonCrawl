package dungeon.backend.entity;

import java.util.ArrayList;


/**
 * The Inventory, is a dynamic list of entities that can be contained by 
 * player. 
 * @author JAG
 *
 */
public class Inventory {
	
	/**
	 * A list of Items within the inventory.
	 */
	private ArrayList<Pickup> items;
	
    public Inventory() {
        this.items = new ArrayList<Pickup>();
    }
    
    /**
     * Returns the list of Item Entities within this inventory.
     * @return a list of Item Objects in this Inventory.
     */
    public ArrayList<Pickup> getItems() {
    	return this.items;
    }
    
    /**
     * This Method returns the first instance in the inventory of any 
     * item that is the same class as the one you are checking for p.
     * @param p a pickup-entity to search for in this inventory
     * @return the pickup itself is returned to be used. 
     */
    public Pickup getItemType(Pickup p) {
    	
    	for (Pickup ie : items) {
			if(p.getClass().equals(ie.getClass())) {
					return ie;
			}
		}
    	
    	return null;
    }
    
    /**
     * Adds an item to the inventory
     * @param item the item to be added to the inventory.
     */
    public void add(Pickup item) {
    	items.add(item);
    }
    
    /**
     * Removes an item from the inventory
     * @param item the item to be removed. 
     */
    public void remove(Pickup item) {
    	items.remove(item);
    }
    
    public boolean checkForItem(Pickup item) {
    	
    	if(this.items.contains(item)) {
    		return true;
    	} else{
    		return false;
    	}
    }
    
    public int itemCount(Pickup item) {
    	int counter = 0;
    	for(Entity e: items) {
    		if(e.getClass().equals(item.getClass())) {
    			counter++;
    		}
    	}
    	
    	return counter;
    }
    
	public Key getKey() {
		for(Pickup p: this.items) {
			if(p instanceof Key) {
				return (Key)p;
			}
		}
		return null;
	}

	public Sword getSword() {
		for(Pickup p: this.items) {
			if(p instanceof Sword) {
				return (Sword)p;
			}
		}
		return null;
	}
    
    
    


}