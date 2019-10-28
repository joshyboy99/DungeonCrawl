package unsw.unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testPlayerPushesBoulderIntoTeleport() {
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
