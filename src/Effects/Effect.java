package Effects;

import dungeon.backend.entity.*;

/**
 * Effects of the entity
 * @author amyluo
 *
 */
public interface Effect {
	public void effect(Entity e);
	public void endEffect();
	public boolean getInEffect();
	public void update(Player player);
}
