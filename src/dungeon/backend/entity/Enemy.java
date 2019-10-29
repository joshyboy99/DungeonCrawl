package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.ContactBehaviour;
import dungeon.backend.MoveBehaviour.MoveBehaviour;

public class Enemy extends Entity {
	

	private Player player;
	private boolean dead;
	
	public Enemy(int x, int y, Player player,MoveBehaviour moveBehaviour, ContactBehaviour contactBehaviour) {
		super(x, y, moveBehaviour, contactBehaviour);
		this.player = player;
		this.dead = false;
	}
	
	

}
