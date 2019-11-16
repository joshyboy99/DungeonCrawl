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
	
	public Enemy getEnemy() {
		for(Entity e: this.dungeon.getEntities()) {
			if(e instanceof Enemy) {
				return (Enemy)e; 
			}
		}
		return null; 
	}
	
	public void summon(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
		}
		Enemy targetEnemy = getEnemy();
		if(targetEnemy == null) {
			return; 
		}
		
		switch (facing) {
		case "UP":
			this.setMy(-1);
			this.scanDungeonTile(x, y);
			if(this.getMy() == 0) return; 
			dungeon.addSummoned(new Summoned(x, y - 1, targetEnemy, dungeon));
			this.mana--;
			break;
		
		case "DOWN":
			this.setMy(1);
			this.scanDungeonTile(x, y + 1);
			if(this.getMy() == 0) return; 
			dungeon.addSummoned(new Summoned(x, y + 1, targetEnemy, dungeon));
			this.mana--;
			break;
		
		case "LEFT":
			this.setMx(-1);
			this.scanDungeonTile(x - 1, y);
			if(this.getMx() == 0) return; 
			dungeon.addSummoned(new Summoned(x - 1, y, targetEnemy, dungeon));
			this.mana--;
			break;
		
		case "RIGHT":
			this.setMx(1);
			this.scanDungeonTile(x + 1, y);
			if(this.getMx() == 0) return; 
			dungeon.addSummoned(new Summoned(x + 1, y, targetEnemy, dungeon));
			this.mana--;
			break;
		}
	}
	
	
	public void shoot(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
		}
		switch (facing) {
		
		case "UP":
			Fireball f0 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f0);
			f0.shootUp(x, y);
			this.mana--;
			break;
		
		case "DOWN":
			Fireball f1 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f1);
			f1.shootDown(x, y);
			this.mana--;
			break;
		
		case "LEFT":
			Fireball f2 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f2);
			f2.shootLeft(x, y);
			this.mana--;
			break;
		
		case "RIGHT":
			Fireball f3 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f3);
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
