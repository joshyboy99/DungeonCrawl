package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;

public class Repel implements ContactBehaviour {
	private Entity attatched; 
	
	public Repel(Entity attatched) {
		this.attatched = attatched;
	}
	
	@Override
	public void onTouch(Entity entity) {
		// TODO Auto-generated method stub
		
	}

}
