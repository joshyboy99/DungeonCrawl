package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;


public class Door extends Entity {
		private int keyID; 
	
	
	public Door(int x, int y, int keyID, Dungeon dungeon) {
		super(x, y, dungeon);
		this.contactBehaviour = new Locked(this);
		this.moveBehaviour = new Static(this);
		this.keyID = keyID;
	}
	
	public void checkKey(Key key) {
		if(key.getKeyID() == this.keyID) {
			this.contactBehaviour = new NoContact(this); 
		} 
	}
	
	public void wasTouched(Entity entity) {
		Player p0 = (Player) entity;
		if(this.keyID == p0.getCurrentKeyID()) {
			//player has required key, open door and delete key
		    p0.destroyKey(p0.getCurrentKeyID());
			this.contactBehaviour = new NoContact(this);
		} //if not, keep locked. 
		
	}
	
}
