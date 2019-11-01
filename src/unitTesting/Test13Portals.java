package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 1,1);
        dungeon.addEntity(new Portal(0,1,dungeon, 0));
        dungeon.addEntity(new Portal(3,3,dungeon, 0));
        dungeon.addEntity(new Portal(2,1,dungeon, 1));
        dungeon.addEntity(new Portal(4,3,dungeon, 1));     
        System.out.println("- - TEST TELEPORT PLAYER - -");
		// check position of player
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);	
        //move into portal
        player.moveRight();
        System.out.print(player.getX() + "\n");
        System.out.print(player.getY() + "\n");
        assertTrue(player.x().getValue().intValue() == 3);
        assertTrue(player.y().getValue().intValue() == 3);	        
		//Each portal has a corresponding portal.
		
		//When the player walks on the same square as a portal, the player appears on the square of corresponding portal.
		
		//When an enemy walks on the same square as a portal, the enemy appears on the square of corresponding portal.

        
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
