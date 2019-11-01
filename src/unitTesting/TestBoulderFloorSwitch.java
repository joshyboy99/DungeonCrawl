package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/* Combination of :
 * US0.1 - As a player I want to push boulders in the direction I move
 * so that I can accomplish the objectives of the level.
 * 
 * US1.6 - As a player I want to have boulders that can be pushed so 
 * that I can accomplish the objective of the level
 * 
 * US1.7 - As a player I want to have floor switches that can be triggered 
 * so that I can complete the objective of the level.
 */

class TestBoulderFloorSwitch {
    @Test
    void testPlayerPushesABoulder() {
    	// 5x5 map
    	// player @ (0,1), boulder @ (0,2)
    	// push push boulder to left -> check the position of boulder
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 2,1);
		System.out.print("Created a boulder (3,1) and a player instantiated at square 2,1\n");
		Boulder b1 = new Boulder(3,1);
        dungeon.addEntity(b1); 
        System.out.print("Moving player right, pushing the boulder\n");
    	player.moveRight();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 1);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player right 3 times");
        player.moveRight();
        player.moveRight();
        player.moveRight();
        player.moveRight();
        assertTrue(b1.getX() == 5);
        assertTrue(b1.getY() == 1);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        
    }
    
    @Test
    void testPlayerCanOnlyPushOneBoulderAtATime() {
    	// 5x5 map
    	// player @ (0,1), boulder_one @ (0,2), boulder_two @ (0,3)
    	// should not move
    	
    }
    
    @Test
    void testPlayerPushesABoulderIntoAnotherBoulder() {

        
    }
    
    @Test
    void testPlayerTriesToPushBoulderIntoAnObstacle() {
        // i.e  : if the player tries to push the boulder into an obstacle or an object 
        //     (e.g. enemy, wall, door, potion, treasures etc.), 
        //     the player and the boulder should not move.
        
    }
    
    @Test
    void testPlayerTriesToPushBoulderIntoACollectable() {
        // i.e : if the player tries to push the boulder into an obstacle or an object 
        //     (e.g. enemy, wall, door, potion, treasures etc.), 
        //     the player and the boulder should not move.
        
    } 
    
    @Test
    void testPlayerTriesToPushBoulderIntoAnEnemy() {
        // i.e : if the player tries to push the boulder into an obstacle or an object 
        //     (e.g. enemy, wall, door, potion, treasures etc.), 
        //     the player and the boulder should not move.
        
    }
    
    
    @Test
    void testPlayerTriggerFloorSwitchByBoulder() {

    }
    
    @Test
    void testPlayerUntriggersFloorSwitchByBoulder() {
     
    }
    
    @Test
    void testPushingBoulderOffOneFloorSwitchOntoAnother() {
        
    }
    
}
