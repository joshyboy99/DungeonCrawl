package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Enemy Entity class
 * 
 * @author JAG
 *
 */
public class Enemy extends Entity implements Observer{
	
	private Player player;
	private Dungeon dungeon;
	
	public Enemy(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.player = dungeon.getPlayer();
		this.contactBehaviour = new Destroy(this);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		
		this.moveBehaviour = new MoveTowards(this, this.player, dungeon);
		
	}
	
	public void Flee() {
		this.moveBehaviour = new Flee(this, this.player, this.dungeon);
		this.contactBehaviour = new NoContact(this);
	}
	
	public void Hunt() {
		
		this.contactBehaviour = new Destroy(this);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		
		this.moveBehaviour = new MoveTowards(this, this.player, dungeon);
	}

	@Override
	public void update(Player player) {
		
		
	}
	
}
