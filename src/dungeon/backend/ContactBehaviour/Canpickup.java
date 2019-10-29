package dungeon.backend.ContactBehaviour;

import dungeon.backend.entity.*;


public class Canpickup implements ContactBehaviour {
	private Entity attatched; 
	
	public Canpickup(Entity attatched) {
		
		this.attatched = attatched;
		
	}
	
	@Override
		public void onTouch(Entity e) {
			//if treasure
			//if potion
			//if 
	}

}

