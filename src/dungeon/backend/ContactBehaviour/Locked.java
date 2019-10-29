package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.Entity;

public class Locked implements ContactBehaviour {
	private Entity attatched; 
	public Locked(Entity attatched) {
		this.attatched = attatched;
	}	
	
	@Override
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub

	}

}
