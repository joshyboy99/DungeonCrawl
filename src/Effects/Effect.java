package Effects;

import dungeon.backend.entity.*;

/**
 * The Effect interface is used to create effects
 * which can be contained within an entity
 * so that they can temporarily change that
 * entities behaviour or the behaviour of those 
 * around it.
 * 
 * @author JAG
 *
 */
public interface Effect {
	public void effect(Entity e);
	public void endEffect();
	public boolean getInEffect();
	public void update(Player player);
}
