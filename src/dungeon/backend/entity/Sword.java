package dungeon.backend.entity;


import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * The Sword Entity class 
 * @author JAG
 *
 */
public class Sword extends Pickup {
	
	//relative coordinates of next swing
	private IntegerProperty sx,sy;
	
	private int successfulSwings;
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
	
	public void Swing(String facing, int x, int y) {
		
		this.aim(facing, x, y);

		this.use();
	}

	public void uninventory(){
		this.dungeon.getPlayer().removeItem(this);
	}
}
