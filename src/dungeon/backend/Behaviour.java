package dungeon.backend;

import dungeon.backend.entity.*;

public abstract class Behaviour {
	protected Entity attached;
	
	Behaviour (Entity attached) {
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
