package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test; 

/*
 * Extra Case
 */
class TestPlayerDied {
    
	@Test
    void testGameOverIfPlayerIsDead() {
		System.out.println("- -          TEST FAIL           - -");
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 1,1);
		dungeon.setPlayer(player);
		
		Enemy e0 = new Enemy(0,1, dungeon);
		dungeon.addEntity(e0);
		
		player.moveRight();

		assertFalse(dungeon.checkEntitiesOnDungeon(player));
		assertFalse(dungeon.isComplete());
		
		System.out.println("- -          TEST PASS           - -");


    }
    
    @Test
    void testPlayerDiesByEnemy() {
		System.out.println("- -          TEST DEAD           - -");
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 1,1);
		dungeon.setPlayer(player);
		
		Enemy e0 = new Enemy(0,1, dungeon);
		dungeon.addEntity(e0);
		
		player.moveRight();

		assertFalse(dungeon.checkEntitiesOnDungeon(player));
		
		System.out.println("- -          TEST PASS           - -");

        
    }
    
}
