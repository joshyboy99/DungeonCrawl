package dungeon.backend.entity;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The Pickup - Sword, is an inanimate passive pickup that can be swung
 * to kill other entities in the dungeon. 
 * @author JAG
 *
 */
public class Sword extends Pickup {
	
	/**
	 * Relative coordinates of next swing
	 */
	private IntegerProperty sx,sy;
	
	/**
	 * The number of swings that destroyed another
	 * entity.
	 */
	private int successfulSwings;
	
	/**
	 * The maximum number of successful swings this sword
	 * can perform before removing itself from play.
	 */
	private int maxSwings;
	
	public Sword(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.sx = new SimpleIntegerProperty(0);
		this.sy = new SimpleIntegerProperty(0);
		this.maxSwings = 5;
		this.successfulSwings = 0;
		
	}
	
	/**
	 * Directs the sword correctly for the next attack.
	 * @param facing the direction the holder entity is facing
	 * @param x current location of the holder entity
	 * @param y current location of the holder entity
	 */
	public void aim(String facing, int x, int y) {
		switch (facing) {
		
			case "UP":
				sx.set(x);
				sy.set(y-1);
				break;
			
			case "DOWN":
				sx.set(x);
				sy.set(y+1);
				break;
			
			case "LEFT":
				this.sx.set(x-1);
				this.sy.set(y);
				break;
			
			case "RIGHT":
				sx.set(x+1);
				sy.set(y);
				break;
		}	
	}
	
	public int swingNum() {
		return successfulSwings;
	}
	
	public int getSwingX() {
		return sx.get();
	}
	
	public int getSwingY() {
		return sy.get();
	}
	
	/**
	 * This Method swings the sword and removes enemies that are in
	 * the square the sword is aimed at. 
	 */
	public void use() {
		for(Entity e: this.dungeon.EntitiesOnTile(this.sx.get(), this.sy.get()) ) {
			if(e instanceof Enemy) {
				
				e.removeSelf();
				successfulSwings++;
				
				if(successfulSwings == maxSwings) {
					this.removeSelf();
					uninventory();
				}
			}
		}
	}
	
	/**
	 * Manager method that both aims and uses the sword
	 * @param facing the direction the holder entity is facing
	 * @param x current location of the holder entity
	 * @param y current location of the holder entity
	 */
	public void Swing(String facing, int x, int y) {
		
		this.aim(facing, x, y);

		this.use();
	}
	
	/**
	 * Removes this sword from the inventory of the player. 
	 */
	public void uninventory(){
		Player p = dungeon.getPlayer();
		Inventory i = p.getInventory();
		i.remove(this);
	}

	public int getSwordHits() {
		return this.maxSwings - this.successfulSwings;
	}
}
