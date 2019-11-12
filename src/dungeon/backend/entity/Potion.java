package dungeon.backend.entity;


import Effects.*;
import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.*;

/**
 * The Potion entity class 
 * @author JAG
 *
 */
public class Potion extends Pickup implements Observer{
	
	public Potion(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new AffectPicker(this);
		this.effects.add(new InstaKillEnemy(this));
	}
	
	@Override
	public void update(Player player) {
		for(Effect e: effects) {
			e.update(player);
		}
	}

	public boolean potionInEffect() {
		for(Effect e: effects) {
			if(e instanceof InstaKillEnemy) {
				return e.getInEffect();
			}
		}
		return false;
	}
	
	@Override
	public void affect(Entity entity) {
		for(Effect e: effects) {
			e.effect(entity);
		}
	}
}
