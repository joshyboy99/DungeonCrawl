package dungeon.backend.entity;

import java.util.ArrayList;

public class Inventory {
	
	// change Pickup -> Entity
	
	private ArrayList<Pickup> items;
	
    public Inventory() {
        this.items = new ArrayList<Pickup>();
    }
    
    public ArrayList<Pickup> getPickUp() {
    	return this.items;
    }
    
    public void add(Pickup item) {
    	items.add(item);
    }
    
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


}