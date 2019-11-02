package Effects;

import dungeon.backend.entity.*;

public interface Effect {
	public void effect(Entity e);
	public void endEffect();
	public boolean getInEffect();
}
