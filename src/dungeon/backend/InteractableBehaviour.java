package dungeon.backend;

import dungeon.backend.entity.*;

public abstract class InteractableBehaviour {
	
	protected Entity attached;

	public InteractableBehaviour(Entity attached) {
		super();
		this.attached = attached;
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
}
