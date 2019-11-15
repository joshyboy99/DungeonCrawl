package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

public class SpellBook extends Pickup{

	private int mana;
	private Fireball fireball; 
	
	public SpellBook(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.mana = 10;
		this.fireball = new Fireball(x, y, dungeon);
	}	
	
	
	public void shoot(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
		}
		switch (facing) {
		
		case "UP":
			this.fireball.shootUp(x, y);
			this.mana--;
			break;
		
		case "DOWN":
			this.fireball.shootDown(x, y);
			this.mana--;
			break;
		
		case "LEFT":
			this.fireball.shootLeft(x, y);
			this.mana--;
			break;
		
		case "RIGHT":
			System.out.println("here!");
			this.fireball.shootRight(x, y);
			this.mana--;
			break;
	}	
	}
	
	public boolean checkEnoughMana() {
		if (this.mana == 0) {
			return false; 
		}
		return true; 
	}
	
	public void removeFromInventory() {
		Inventory iven = dungeon.getPlayer().getInventory();
		iven.remove(this);
	}
}
