package dungeon.backend.entity;

import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

public class Enemy extends Entity {
	

	private Player player;
	
	public Enemy(int x, int y, Player player) {
		super(x, y, new MoveTowards(), new Destroy());
		this.player = player;
	}
	
	
}
