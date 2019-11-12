package dungeon.backend.entity;

import dungeon.backend.PickUpBehaviour.*;
import dungeon.backend.Dungeon;

/** 
 * The Pickup Abstract class is for objects that can be picked up. 
 * Pickups have a special set of behaviour that defines what will
 * occur when they are picked up and subsequently removed from the
 * dungeon. 
 *
 * @author JAG
 *
 */
public abstract class Pickup extends Entity {
	
	/**
	 * Behavior which defines what happens when
	 * a pickup is picked up. 
	 */
	protected PickUpBehaviour pickupBehaviour;
	
	public Pickup(int x, int y, Dungeon dungeon) {
		super(x,y, dungeon);
	}

	public PickUpBehaviour getPickupBehaviour() {
		return pickupBehaviour;
	}

	public void setPickupBehaviour(PickUpBehaviour pickupBehaviour) {
		this.pickupBehaviour = pickupBehaviour;
	}
	
	/**
	 * Wrapper function for calling pickup behavior. 
	 * @param entity that is picking up this pickup.
	 */
	public void performPickup(Entity entity) {
		this.pickupBehaviour.onPickup(entity);
		this.removeSelf();
	}

}