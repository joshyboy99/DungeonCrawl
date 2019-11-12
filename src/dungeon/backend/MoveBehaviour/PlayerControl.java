package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.entity.Entity;

/**
 * Behaviour if player's control
 * @author JAG
 *
 */
public class PlayerControl extends Behaviour implements MoveBehaviour {

	public PlayerControl(Entity attached) {
		super(attached);
	}

	@Override
	public void move() {
		
	}

}