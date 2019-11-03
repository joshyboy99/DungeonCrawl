package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test; 

/*
 * US1.2 - As a player I want to have treasures so that 
 * I can accomplish the objective of the level.
 */

class Test12Treasures {
	// think about what you can do here
	
	@Test
	void testTreasureCounter() {
    	// 5x5 Map player at (0,1)
    	// Treasure in (0,2) 
    	// pick up by going left once 
		// check Treasure counter
		
        System.out.println("- - TEST PICK UP TREASURE - -");
        
        System.out.println("- -         PASSED        - -");
	}
}
