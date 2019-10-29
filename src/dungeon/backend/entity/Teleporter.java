package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.ContactBehaviour;
import dungeon.backend.MoveBehaviour.MoveBehaviour;
import javafx.beans.property.IntegerProperty;

public class Teleporter extends Entity {
	private IntegerProperty teleportX;
	private IntegerProperty teleportY;
	public Teleporter(int x, int y, ContactBehaviour contactBehaviour) {
		super(x, y);
		this.contactBehaviour = contactBehaviour;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
