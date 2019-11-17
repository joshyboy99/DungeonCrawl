package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.Static;

/**
 * An enemy entity that kills the player upon contact, destroys fireballs
 * and hunts the player, will only flee from enemy when enemy is in affect 
 * of potion, otherwise stationary. 
 * @author JAG
 *
 */
public class Mushroom extends Enemy {
	
	private Player player;
	private Dungeon dungeon;
	
	/**
	 * Constructor 
	 * @param x X coordinate
	 * @param y Y coordinate
	 * @param dungeon Dungeon where the mush room is situated in
	 */
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
	
	/**
	 * How it behaves as it "hunts"
	 */
	@Override
	public void Hunt() {
		
		this.contactBehaviour = new Destroy(this);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		
		this.moveBehaviour = new Static(this);

	}
}
