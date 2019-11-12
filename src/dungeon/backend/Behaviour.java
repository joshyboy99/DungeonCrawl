package dungeon.backend;

import dungeon.backend.entity.*;

/**
 * This abstract class is responsible for all behaviors below it, passing on the attribute of attached,
 * such that a behavior can interact with the entity to which it belongs. It also allows for the modification
 * of this attribute at runtime. 
 * @author JAG
 *
 */
public abstract class Behaviour {
	protected Entity attached;
	
	protected Behaviour (Entity attached) {
		this.attached = attached;
	}
	
	/**
	 * Removes the attached entity to this behavior.
	 */
	public void removeAttached() {
		this.attached = null;
	}
	
	/**
	 * Gets the entity to which this behavior is attached.
	 * @return the entity to which this behavior is attached. 
	 */
	public Entity getAttached() {
		return this.attached;
	}
	
	/**
	 * Sets the attached entity of this behavior to a specific entity.
	 * @param e the entity for this behavior to be attached to.
	 */
	public void setAttached(Entity e) {
		this.attached = e;
	}
}
