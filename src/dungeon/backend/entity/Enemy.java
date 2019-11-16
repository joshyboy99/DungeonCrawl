package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Entity - Enemy, is an antagonist to the player entity
 * and will normally follow and destroy the player on contact.
 * The enemy can be destroyed with the swing of a sword, or by
 * contacting the player while the InstaKillEnemy effect is active
 * on that player. 
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
		this.addValidEntityContact(player);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		((InteractableBehaviour) contactBehaviour).addEntity(new Fireball());
		this.dungeon = dungeon; 
		this.moveBehaviour = new MoveTowards(this, this.player, dungeon);
	}
	
	/**
	 * Constructor for addition to valid entity list, and testing purposes.
	 */
	public Enemy() {
		super();
	}
	
	/**
	 * Will change enemy's movement behavior to flee. Called after player has collected a potion. 
	 */
	public void Flee() {
		this.moveBehaviour = new Flee(this, this.player, this.dungeon);
		this.contactBehaviour = new Die(this);
	}
	
	/**
	 * Will change enemy's movement behavior to MoveTowards. Called after player's potion has expired. 
	 */
	public void Hunt() {
		
		this.contactBehaviour = new Destroy(this);
		((InteractableBehaviour) contactBehaviour).addEntity(player);
		
		this.moveBehaviour = new MoveTowards(this, this.player, dungeon);

	}

	/**
	 * Observes any changes to dungeon
	 */
	@Override
	public void update(Player player) {
		
		
	}
	
}
