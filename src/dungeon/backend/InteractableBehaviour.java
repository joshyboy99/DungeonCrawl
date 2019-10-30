package dungeon.backend;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.entity.*;

public abstract class InteractableBehaviour {
	
	protected Entity attached;
	protected List<Entity> ValidEntities;
	
	public InteractableBehaviour(Entity attached) {
		super();
		this.attached = attached;
		this.ValidEntities = new ArrayList<Entity>();
	}
	
	public void removeAttached() {
		this.attached = null;
	}
	
	public Entity getAttached() {
		return this.attached;
	}
	
	public void setAttached(Entity e) {
		this.attached = e;
	}
	
	protected boolean checkEntity(Entity e) {
		return true;
	}
}
