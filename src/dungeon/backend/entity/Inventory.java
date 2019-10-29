package dungeon.backend.entity;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Pickup> items;
	
    public Inventory() {
        this.items = new ArrayList<Pickup>();
    }
    
    public void addToInventory(Pickup item) {
    	items.add(item);
    }
    
    public void removeFromInventory(Pickup item) {
    	items.remove(item);
    }
    
    public boolean checkForItem(Pickup item) {
    	if(items.contains(item)) {
    		return true;
    	} else{
    		return false;
    	}
    }
    

}