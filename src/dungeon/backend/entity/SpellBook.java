package dungeon.backend.entity;

import dungeon.backend.*;
import dungeon.backend.ContactBehaviour.*;
import dungeon.backend.MoveBehaviour.*;
import dungeon.backend.PickUpBehaviour.Store;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SpellBook extends Pickup{

	private int successfulSpells;
	private Fireball fireball; 
	
	public SpellBook(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Static(this);
		this.contactBehaviour = new ActivePickup(this);
		this.pickupBehaviour = new Store(this);
		this.successfulSpells = 0;
	}	
	
	
	public void shoot(String facing, int x, int y) {
		
		switch (facing) {
		
		case "UP":
			this.fireball.shootUp(x, y);
			successfulSpells++;
			break;
		
		case "DOWN":
			this.fireball.shootDown(x, y);
			successfulSpells++;
			break;
		
		case "LEFT":
			this.fireball.shootLeft(x, y);
			successfulSpells++;
			break;
		
		case "RIGHT":
			this.fireball.shootRight(x, y);
			successfulSpells++;
			break;
	}	
	}
}
