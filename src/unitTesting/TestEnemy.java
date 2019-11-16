package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test; 

/*
 * Combination of :
 * 
 * US0.2 - As a player I want to be able to fight enemies with a sword
 * so that I can accomplish the objectives of the level.
 * 
 * US1.4 - As a player I want to have enemies so that I can feel challenged.
 * 
 * US1.5 - As a player I want to have a sword so I can defeat enemy entities.
 * 
 */

class TestEnemy {
    @Test
    void testEnemyKillingEachOther() {
    	
		System.out.println("- -               TEST SLAY ENEMY                  - -");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 2,1);
		Enemy e0 = new Enemy(5, 1,dungeon);
		Enemy e1 = new Enemy(5, 1,dungeon);
		dungeon.addEntity(e0);
		dungeon.addEntity(e1);
		
		System.out.println("- -               TEST SLAY ENEMY                  - -");
		System.out.println("Player position: ("+ player.getX() + "," + player.getY()  + ")");  
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");  


		e0.performMove();

		e1.performMove();
		
		assertTrue(dungeon.checkEntitiesOnDungeon(e0));
		assertTrue(dungeon.checkEntitiesOnDungeon(e1));
    	
    }
    
}
