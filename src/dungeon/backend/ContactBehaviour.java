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

class Destroy implements ContactBehaviour {

	@Override
	public void contactInteraction() {
	}

}

class Transport implements ContactBehaviour {

	@Override
	public void contactInteraction() {
	}


}
