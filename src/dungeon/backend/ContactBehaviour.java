package dungeon.backend;

import unsw.dungeon.Contactbehaviour;
import unsw.dungeon.Entity;

// Contact Behaviour strategy pattern
public interface ContactBehaviour {
	void onTouch(Entity entity);
}


public class Canpickup implements Contactbehaviour {
	
	@Override
	public void onTouch(Entity e) {
		//if treasure
		//if potion
		//if 
	}

}

public class Destroy implements Contactbehaviour {
	Entity entity; 
	public Killentity(Entity entity) {
		super();
		this.entity = entity;
	}

	@Override
	public void onTouch(Entity e) {
		// TODO Auto-generated method stub
		this.entity.kill(e);
	}
	

}

class Transport implements ContactBehaviour {

	@Override
	public void contactInteraction() {
	}


}
