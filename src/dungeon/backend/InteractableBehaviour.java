package dungeon.backend;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.entity.*;

public abstract class InteractableBehaviour {
	
	protected Entity attached;
	protected List<Entity> ValidEntities;
	
	public InteractableBehaviour(Entity attached) {
		this.attached = attached; 
		this.ValidEntities = new ArrayList<Entity>();
	}
	
	protected boolean checkEntity(Entity e) {
		return true;
	}
	
}
