package dungeon.backend.entity;


import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sword extends Pickup {
	
	//relative coordinates of next swing
	private IntegerProperty sx,sy;
	
	private int successfulSwings;
	private int maxSwings;
	
	public Sword(int x, int y) {
		super(x, y);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.sx = new SimpleIntegerProperty();
		this.sy = new SimpleIntegerProperty();
		this.maxSwings = 5;
		this.successfulSwings = 0;
		
	}
	
	public void aim(String facing, int x, int y) {
		switch (facing) {
		
			case "UP":
				sx.set(x);
				sy.set(y-1);
			
			case "DOWN":
				sx.set(x);
				sy.set(y+1);
			
			case "LEFT":
				sx.set(x-1);
				sy.set(y);
			
			case "RIGHT":
				sx.set(x+1);
				sy.set(y);
		}	
	}
	
	public void use() {
		
		for(Entity e: this.dungeon.EntitiesOnTile(sx.get(), sy.get()) ) {
			
			if(e instanceof Enemy) {
				
				e.removeSelf();
				successfulSwings++;
				
				if(successfulSwings == maxSwings) {
					this.removeSelf();
				}
				
			}
		}
	}
	
	public void Swing(String facing, int x, int y) {
		aim(facing, x, y);
		use();
	}

}
