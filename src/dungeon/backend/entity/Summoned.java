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
public class Summoned extends Entity{
	
	private Player player;
	private Dungeon dungeon;
	
	public Summoned(int x, int y, Entity target, Dungeon dungeon) {
		super(x, y, dungeon);
		this.contactBehaviour = new Destroy(this);
		this.addValidEntityContact(new Enemy());
		((InteractableBehaviour) contactBehaviour).addEntity(new Enemy());;
		this.dungeon = dungeon; 
		this.moveBehaviour = new SummonedMovement(this, target, dungeon);
	}
	
	public Summoned() {
		
	}
	
	
	
	
	
	
	
}