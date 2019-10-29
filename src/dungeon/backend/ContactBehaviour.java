package dungeon.backend;

// Contact Behaviour strategy pattern
public interface ContactBehaviour {
	
	void contactInteraction();
	
}

class PickUp implements ContactBehaviour {
	
	@Override
	public void contactInteraction() {
		
	}
}

class Destructive implements ContactBehaviour {
	
	@Override
	public void contactInteraction() {
	}
	
}

class Transport implements ContactBehaviour {
	
	@Override
	public void contactInteraction() {
	}
	

}