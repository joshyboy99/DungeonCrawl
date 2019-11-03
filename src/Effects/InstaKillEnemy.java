package Effects;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.entity.*;

/**
 * Instant killing of enemy
 * @author amyluo
 *
 */
public class InstaKillEnemy extends Behaviour implements Effect, Observer{

	private boolean inEffect;
	private int counter;
	private int maxDuration;
	
	
	public InstaKillEnemy(Entity attached) {
		super(attached);
		inEffect = false;
		this.counter = 15;
		this.maxDuration = 15;
	}

	@Override
	public void effect(Entity e) {
		e.setContactBehaviour(new Destroy(e));
		e.addValidEntityContact(new Enemy(0,0, e.dungeon));
		
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
		///this.attached.removeEffect(this);
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
