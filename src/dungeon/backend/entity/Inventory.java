package dungeon.backend.entity;

import java.util.ArrayList;


public class Inventory {
	
	// change Pickup -> Entity
	
	private ArrayList<Pickup> items;
	
    public Inventory() {
        this.items = new ArrayList<Pickup>();
    }
    
    public ArrayList<Pickup> getItems() {
    	return this.items;
    }
    
    /**
     * This Mehthod returns the first instance in the inventory of any 
     * item that is the same class as the one you are checking for p
     * @param p a 
     * @return
     */
    public Pickup getItemType(Class<Entity> p) {
    	for (Pickup ie : items) {
			if(p.getClass().equals(ie.getClass())) {
					return ie;
			}
		}
    	return null;
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