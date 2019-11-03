package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.entity.Entity;

/**
 * The motion of not not moving
 * @author JAG
 *
 */
public class Static extends Behaviour implements MoveBehaviour {

	public Static(Entity attached) {
		super(attached);
	}

	@Override
	public void move() {
	}

}
