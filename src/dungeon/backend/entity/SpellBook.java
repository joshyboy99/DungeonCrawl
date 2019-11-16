package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

public class SpellBook extends Pickup{

	private int mana;
	
	public SpellBook(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.mana = 10;
	}	
	
	
	public void shoot(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
		}
		switch (facing) {
		
		case "UP":
			Fireball f0 = new Fireball(x, y, dungeon);
			dungeon.addEntity(f0);
			f0.shootUp(x, y);
			this.mana--;
			break;
		
		case "DOWN":
			Fireball f1 = new Fireball(x, y, dungeon);
			dungeon.addEntity(f1);
			f1.shootUp(x, y);
			this.mana--;
			break;
		
		case "LEFT":
			Fireball f2 = new Fireball(x, y, dungeon);
			dungeon.addEntity(f2);
			f2.shootLeft(x, y);
			this.mana--;
			break;
		
		case "RIGHT":
			Fireball f3 = new Fireball(x, y, dungeon);
			dungeon.addEntity(f3);
			System.out.println("size:" + dungeon.getEntities().size());
			f3.shootRight(x, y);
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
