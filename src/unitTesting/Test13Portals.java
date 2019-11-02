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
	//Each portal has a corresponding portal.
	//When the player walks on the same square as a portal, the player appears on the square of corresponding portal.
	void testPlayerTeleportAcceptance1and2() {
		// 5x5 map
		/* 
		   x ] - - -
		   - - - - -
		   - - - - -
		   - - - [ - 
		             */
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 2,1);
		System.out.print("Created 4 portals (2 pairs) and a player instantiated at square 2,1\n");
        dungeon.addEntity(new Portal(1,1,dungeon, 0)); 
        dungeon.addEntity(new Portal(3,3,dungeon, 0));
        dungeon.addEntity(new Portal(3,1,dungeon, 1));
        dungeon.addEntity(new Portal(4,3,dungeon, 1));
        System.out.print("Portal 1: Coordinates (1,1) ID: 0 \n");  
        System.out.print("Portal 2: Coordinates (3,3) ID: 0 \n");    
        System.out.print("Portal 3: Coordinates (3,1) ID: 1 \n");    
        System.out.print("Portal 4: Coordinates (4,3) ID: 1 \n");    
        System.out.println("- - TEST TELEPORT PLAYER - -");
		// check position of player
        assertTrue(player.x().getValue().intValue() == 2);
        assertTrue(player.y().getValue().intValue() == 1);	
        System.out.print("Moving player into portal 1 through a left movement\n");
        player.moveLeft();
        System.out.print("New coordinates: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(player.x().getValue().intValue() == 3);
        assertTrue(player.y().getValue().intValue() == 3);	
        System.out.print("New coordinates: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move successful!\n");
        System.out.print("Moving player into portal 4 with a right movement\n");
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 3);
        assertTrue(player.y().getValue().intValue() == 1);	       
        System.out.print("New coordinates: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move successful!\n");		
		//When an enemy walks on the same square as a portal, the enemy appears on the square of corresponding portal.

        
        System.out.println("- -         PASSED       - -");
	}
	@Test 
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
		
		System.out.print("- - TEST TELEPORT BOULDER - -");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 2,2);
		System.out.print("Created 4 portals (2 pairs) and a player instantiated at square (" +player.getX() +"," + player.getY() +"\n");
        dungeon.addEntity(new Portal(4,2,dungeon, 0)); 
        dungeon.addEntity(new Portal(4,4,dungeon, 0));
        dungeon.addEntity(new Portal(3,1,dungeon, 1));
        dungeon.addEntity(new Portal(4,3,dungeon, 1));
        System.out.print("Portal 1: Coordinates (3,2) ID: 0 \n");  
        System.out.print("Portal 2: Coordinates (4,4) ID: 0 \n");    
        System.out.print("Portal 3: Coordinates (3,1) ID: 1 \n");    
        System.out.print("Portal 4: Coordinates (4,3) ID: 1 \n");   
        Boulder b0 = new Boulder(3,2, dungeon);
        dungeon.addEntity(b0);
        System.out.print("Created a boulder at: (" + b0.getX() + "," + b0.getY() + ")\n");
        System.out.print("Moving player right into the portal at 4,2! \n");
        player.moveRight();
        System.out.print("New boulder coordinates: (" + b0.getX() + "," + b0.getY() + ")\n");
        System.out.print("New player coordinates: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b0.x().getValue().intValue() == 4);
        assertTrue(b0.y().getValue().intValue() == 4);
        System.out.println("- -         PASSED        - -");
		
	}

}
