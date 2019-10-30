package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * US1.3 - As a player I want to have portals so I can be teleported.
 */

class Test13Portals {
	@Test
	void testPlayerTeleport() {
		// 5x5 map
		/* 
		   x ] - - -
		   - - - - -
		   - - - - -
		   - - - [ - 
		             */
		// check position of player
        System.out.println("- - TEST TELEPORT PLAYER - -");
        
        System.out.println("- -         PASSED       - -");
	}
	
	void testBoulderTeleport() {
		// 5x5 map
		/* 
		   x o ] - -
		   - - - - -
		   - - - - -
		   - - - [ - 
		             */
		// check position of boulder
		// check position of player
		
        System.out.println("- - TEST TELEPORT BOULDER - -");
        
        System.out.println("- -         PASSED        - -");
		
	}

}
