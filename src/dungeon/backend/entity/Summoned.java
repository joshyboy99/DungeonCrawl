package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;

/**
 * The Entity - summoned, is an antagonist to the enemy entity
 * and will normally follow and destroy the enemy on contact.
 * The player can summon one of these entities using a SpellBook.
 * 
 * @author JAG
 *
 */
public class Summoned extends Entity{
	
	private Entity target;
	private Player player;
	private Dungeon dungeon;
	
	public Summoned(int x, int y, Entity target, Dungeon dungeon) {
		super(x, y, dungeon);
		this.player = dungeon.getPlayer();
		this.contactBehaviour = new Repel(this);
		this.dungeon = dungeon; 
		this.target = target; 
		this.moveBehaviour = new SummonedMovement(this, target, dungeon);
	}
	
	public Summoned() {
	}

	/**
	 * Changes the target of the summoned entity to a new enemy once one has been removed from play.
	 */
	public void update() {
		if(this.moveBehaviour instanceof SummonedMovement) {
			this.moveBehaviour = new MoveTowards(this, player, dungeon);
		} else {
			
			//pick new enemy
			for(Entity e: dungeon.getEntities()) {
				if(e instanceof Enemy && e != null && ! e.equals(this.target)) {
					this.target = e; 
					this.moveBehaviour = new SummonedMovement(this, e, dungeon);
					return;
				}
			}
			//check if target only one left
			if(this.target != null) {
				this.moveBehaviour = new SummonedMovement(this, this.target, dungeon);
				return;
			}
			this.moveBehaviour = new MoveTowards(this, player, dungeon);
		}
		
	}
	
	
	
	
	
	
	
}