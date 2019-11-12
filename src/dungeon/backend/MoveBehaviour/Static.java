package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.entity.Entity;

/**
 * This Movement behaviour is appropriate for entities that
 * do not move. 
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
