package Effects;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

/**
 * This Effect Changes the behavior of enemy entities
 * and allows the effected entity to kill them on contact.
 * It has a time limit of 15 cycles.
 * @author JAG
 *
 */
public class InstaKillEnemy extends Behaviour implements Effect, Observer{
	
	/**
	 * Describes whether or not
	 * this effect is still active
	 * true if active, false otherwise.
	 */
	private boolean inEffect;
	
	/**
	 * This attribute keeps track
	 * of how many cycles the effect
	 * has been active for.
	 */
	private int counter;
	
	/**
	 * This attribute specified the 
	 * maximum number of cycles for 
	 * which the effect can stay active.
	 */
	private int maxDuration;
	
	
	public InstaKillEnemy(Entity attached) {
		super(attached);
		inEffect = false;
		this.counter = 15;
		this.maxDuration = 15;
	}
	
	/**
	 * This Method begins the effects of this effect
	 * and changes the behaviors of the effected entity to
	 * destroy enemies. 
	 */
	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy());
		
		this.attached = e;
		e.addEffect(this);
		
		this.inEffect = true;
	}
	
	public boolean getInEffect() {
		return inEffect;
	}

	@Override
	public void endEffect() {
		inEffect = false;
		attached.setContactBehaviour(new NoContact(attached));
		this.attached = null;
		
	}

	@Override
	public void update(Player player) {	
		Dungeon dungeon = player.dungeon;
		
		if(inEffect) {
			
			if(counter == maxDuration) {
				for(Entity e: dungeon.getEntities()) {
					if(e instanceof Enemy) {
						((Enemy) e).Flee();
					}
				}
			}
			
			
			if(counter <= 0) {
				endEffect();
				for(Entity e: dungeon.getEntities()) {
					if(e instanceof Enemy) {
						((Enemy) e).Hunt();
					}
				}
			}
			counter--;
		}
	}
}
