package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.Entity;

public class Trigger implements ContactBehaviour {
	private Entity attatched; 
	public Trigger(Entity attatched) {
		this.attatched = attatched;
	}
	
	@Override
	public void onTouch(Entity entity) {
	}

}
