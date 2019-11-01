package dungeon.backend.entity;

import java.util.ArrayList;

public class Inventory {
	
	// change Pickup -> Entity
	
	private ArrayList<Entity> items;
	
    public Inventory() {
        this.items = new ArrayList<Entity>();
    }
    
    public ArrayList<Entity> getPickUp() {
    	return this.items;
    }
    
    public void add(Entity item) {
    	items.add(item);
    }
    
    public void remove(Entity item) {
    	items.remove(item);
    }
    
    public boolean checkForItem(Entity item) {
    	if(this.items.contains(item)) {
    		return true;
    	} else{
    		return false;
    	}
    }


}