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
		this.dungeon = dungeon; 
		this.moveBehaviour = new MoveTowards(this, this.player, dungeon);
		
	}
	
	/**
	 * Constructor for addition to valid entity list. 
	 */
	public Enemy() {
		super();
	}
	
	/**
	 * Will change enemy's movement behavior to flee. Called after player has collected a potion. 
	 */

	public void Flee() {
		this.moveBehaviour = new Flee(this, this.player, this.dungeon);
		this.contactBehaviour = new NoContact(this);
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
