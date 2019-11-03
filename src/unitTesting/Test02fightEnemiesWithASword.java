package unitTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Enemy;
import dungeon.backend.entity.Inventory;
import dungeon.backend.entity.Player;
import dungeon.backend.entity.Sword;

public class Test02fightEnemiesWithASword {
	//The player initiates an attack when the ?a? button is pressed provided with a sword equipped.
	//If player is in the square adjacent to an enemy and makes a successful attack, the enemy entity will vanish.
	@Test
	public void testAC1and2() {
		System.out.println("- -               TEST SLAY ENEMY                  - -");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 8,5);
		Sword s0 = new Sword(9,5,dungeon);
		Enemy e0 = new Enemy(4,5, dungeon);
		dungeon.addEntity(e0);
		dungeon.addEntity(s0);
		player.moveRight();
		player.activePickup();
		
		Inventory invent = player.getInventory();
		assertTrue(invent.checkForItem(s0));
		
		player.moveLeft();
		player.moveLeft();
		player.moveLeft();
		player.moveLeft();
		System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		
		assertFalse(dungeon.checkEntitiesOnDungeon(e0));
		
		System.out.println("- -                     PASSED                     - -");
		
	}


	
}
