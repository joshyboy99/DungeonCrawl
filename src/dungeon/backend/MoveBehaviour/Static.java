package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.entity.Entity;

public class Static extends Behaviour implements MoveBehaviour {

	public Static(Entity attached) {
		super(attached);
	}

	@Override
	public void move() {
	}

}
