package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;

/**
 * A pickup that allows the player to spend
 * mana in exchange for the power to either
 * shoot a fireball or summon a helpful wizard.
 * @author Shelby
 *
 */
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
	
	/**
	 * Creates an instance of a summoned entity
	 * to assist the player by hunting enemies. 
	 * @param facing the direction the summoner is currently facing
	 * presented as a string
	 * @param x the current x coordinate of the summoner
	 * @param y the current y coordinate of the summoner
	 */
	public void summon(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
			return; 
		}
		Enemy targetEnemy = getEnemy();
		if(targetEnemy == null) {
			return; 
		}
		
		switch (facing) {
		case "UP":
			this.setMy(-1);
			this.scanDungeonTile(x, y - 1);
			if(this.getMy() == 0) return; 
			dungeon.addSummoned(new Summoned(x, y - 1, targetEnemy, dungeon));
			this.mana = 0;
			break;
		
		case "DOWN":
			this.setMy(1);
			this.scanDungeonTile(x, y + 1);
			if(this.getMy() == 0) return; 
			dungeon.addSummoned(new Summoned(x, y + 1, targetEnemy, dungeon));
			this.mana = 0;
			break;
		
		case "LEFT":
			this.setMx(-1);
			this.scanDungeonTile(x - 1, y);
			if(this.getMx() == 0) return; 
			dungeon.addSummoned(new Summoned(x - 1, y, targetEnemy, dungeon));
			this.mana = 0;
			break;
		
		case "RIGHT":
			this.setMx(1);
			this.scanDungeonTile(x + 1, y);
			if(this.getMx() == 0) return; 
			dungeon.addSummoned(new Summoned(x + 1, y, targetEnemy, dungeon));
			this.mana = 0;
			break;
		}
	}
	
	/**
	 * The method responsible for releasing a fireball in the direction
	 * that the caster is facing. 
	 * @param facing the direction the summoner is currently facing
	 * presented as a string
	 * @param x the current x coordinate of the summoner
	 * @param y the current y coordinate of the summoner
	 */
	public void shoot(String facing, int x, int y) {
		if (checkEnoughMana() == false) {
			this.removeFromInventory();
			return; 
		}
		switch (facing) {
		
		case "UP":
			Fireball f0 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f0);
			f0.shootUp(x, y);
			this.mana = this.mana - 5;
			break;
		
		case "DOWN":
			Fireball f1 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f1);
			f1.shootDown(x, y);
			this.mana = this.mana - 5;
			break;
		
		case "LEFT":
			Fireball f2 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f2);
			f2.shootLeft(x, y);
			this.mana = this.mana - 5;
			break;
		
		case "RIGHT":
			Fireball f3 = new Fireball(x, y, dungeon);
			dungeon.addFireball(f3);
			f3.shootRight(x, y);
			this.mana = this.mana - 5;
			break;
		}	
	}
	
	/**
	 * This method is called to confirm that the player still
	 * has mana that can be used to cast spells.
	 * @return
	 */
	public boolean checkEnoughMana() {
		if (this.mana == 0) {
			return false; 
		}
		return true; 
	}
	
	/**
	 * Removes the SpellBook from the inventory.
	 */
	public void removeFromInventory() {
		Inventory iven = dungeon.getPlayer().getInventory();
		iven.remove(this);
	}
	
	/**
	 * This method is used to ascertain the amount of mana
	 * remaining in the player
	 * @return the amount of mana in the player
	 */
	public int getMana() {
		return this.mana;
	}
}
