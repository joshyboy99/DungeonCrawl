package dungeon.backend;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.entity.*;

public abstract class InteractableBehaviour extends Behaviour {
	
	protected Entity attached;
	protected List<Entity> ValidEntities;
	
	public InteractableBehaviour(Entity attached) {
		super(attached);
		this.ValidEntities = new ArrayList<Entity>();
	}
	
	protected boolean checkEntity(Entity e) {
		return true;
	}
	
}
