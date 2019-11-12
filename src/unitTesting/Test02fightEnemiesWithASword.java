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
		

		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		
		assertFalse(dungeon.checkEntitiesOnDungeon(e0));
		
		System.out.println("- -                     PASSED                     - -");
		
	}
	
	/**
	 * - - E - - 
	 * - - s - -
	 * E - p - E
	 * - - - - - 
	 * E - E - -  
	 */
	@Test
	public void killEnemyEveryDirection() {
		System.out.println("- -            TEST SLAY EVERY DIRECTION           - -");
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 2,2);
		dungeon.setPlayer(player);
		Sword s0 = new Sword(2,1,dungeon);
		dungeon.addEntity(s0);
		Enemy e0 = new Enemy(2,0, dungeon);
		dungeon.addEntity(e0);
		Enemy e1 = new Enemy(0,2, dungeon);
		dungeon.addEntity(e1);
		Enemy e2 = new Enemy(4,2, dungeon);
		dungeon.addEntity(e2);
		Enemy e3 = new Enemy(2,4, dungeon);
		dungeon.addEntity(e3);
		Enemy e4 = new Enemy(0,4, dungeon);
		dungeon.addEntity(e4);
		
		player.moveUp();
		player.activePickup();
		Inventory invent = player.getInventory();
		assertTrue(invent.checkForItem(s0));
		
		player.useSword();
		assertFalse(dungeon.checkEntitiesOnDungeon(e0));
		System.out.println("Swing Num: " + s0.swingNum());
		
		player.moveDown();
		player.moveLeft();
		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		assertFalse(dungeon.checkEntitiesOnDungeon(e1));
		
		player.moveRight();
		player.moveRight();
		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		assertFalse(dungeon.checkEntitiesOnDungeon(e2));

		
		player.moveLeft();
		player.moveDown();
		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		assertFalse(dungeon.checkEntitiesOnDungeon(e3));

		
		player.moveDown();
		player.moveLeft();
		player.useSword();
		System.out.println("Swing Num: " + s0.swingNum());
		assertFalse(dungeon.checkEntitiesOnDungeon(e4));
		
		assertFalse(invent.checkForItem(s0));
		System.out.println("No more Sword");
		
		System.out.println("- -                     PASSED                     - -");

	}


	
}
