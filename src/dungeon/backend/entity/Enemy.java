package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import javafx.beans.property.IntegerProperty;

public class Enemy extends Entity {
	

	private Player player;
	private Dungeon dungeon;
	
	public Enemy(int x, int y, Player player, Dungeon dungeon) {
		super(x, y);
		this.player = player;
		this.contactBehaviour = new Destroy(this);
		this.moveBehaviour = new MoveTowards(this, player, dungeon);
		this.dungeon = dungeon;
	}
	
	
}
