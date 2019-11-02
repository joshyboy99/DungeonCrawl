package dungeon.backend;

import dungeon.backend.entity.*;

/**
 * This abstract class is responsible for all behaviours below it, passing on the attribute of attached,
 * such that a behaviour can interact with the entity to which it belongs. It also allows for the modification
 * of this attribute at runtime. 
 * @author JAG
 *
 */
public abstract class Behaviour {
	protected Entity attached;
	
	protected Behaviour (Entity attached) {
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
