package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;

public class Destroy implements ContactBehaviour {
	private Entity attatched; 
	public Destroy(Entity attatched) {
		this.attatched = attatched;
	}	
	@Override
	public void onTouch(Entity e) {
		// TODO Auto-generated method stub
		this.attatched.kill(e);
	}

}
