package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.Static;

/**
 * A funny enemy character only moves when player is 
 * invincible !! 
 * @author JAG
 *
 */
public class Mushroom extends Enemy {
	
	private Player player;
	private Dungeon dungeon;
	
	public Mushroom(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.dungeon = dungeon; 
		this.player = dungeon.getPlayer();
		this.contactBehaviour = new Destroy(this);
		this.addValidEntityContact(player);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		((InteractableBehaviour) contactBehaviour).addEntity(new Fireball());
		this.moveBehaviour = new Static(this);
	}
	
	
	@Override
	public void Hunt() {
		
		this.contactBehaviour = new Destroy(this);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		
		this.moveBehaviour = new Static(this);

	}
}
