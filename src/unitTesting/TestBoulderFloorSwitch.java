package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;

import static org.junit.Assert.assertFalse;
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
		Player player = new Player(dungeon, 2,2);
		System.out.print("Created a boulder (3,1) and a player instantiated at square 2,1\n");
		Boulder b1 = new Boulder(3,2, dungeon);
        dungeon.addEntity(b1); 
        System.out.print("Moving player right, pushing the boulder\n");
    	player.moveRight();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player right 3 times\n");
        player.moveRight();
        player.moveRight();
        player.moveRight();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("Move player above boulder, to ensure can be pushed downwards\n");
        player.moveUp();
        player.moveRight();
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 1);
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move player down, pushing boulder in process\n");
        player.moveDown();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 3);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player down 3 times\n");
        player.moveDown();
        player.moveDown();
        player.moveDown();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 4);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 3);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Testing pushing boulder up");
        player.setX(2);
        player.setY(3);
        b1.setX(2);
        b1.setY(2);
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 3);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move player up, pushing boulder in process\n");
        player.moveUp();
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 1);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player up 3 times\n");
        player.moveUp();
        player.moveUp();
        player.moveUp();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 0);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 1);
        System.out.print("Testing pushing boulder left");
        player.setX(4);
        player.setY(2);
        b1.setX(3);
        b1.setY(2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 3);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 2);
        System.out.print("Move player left, pushing boulder in process\n");
        player.moveLeft();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("Ensuring boulder cannot go off map, move player left 3 times\n");
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        assertTrue(b1.getX() == 0);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 1);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        
    }
    
    @Test
    void testPlayerCanOnlyPushOneBoulderAtATime() {
    	// 5x5 map
    	// player @ (0,1), boulder_one @ (0,2), boulder_two @ (0,3)
    	// should not move
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 2, 5);
		dungeon.setPlayer(player);
		Boulder boulder = new Boulder(3, 5, dungeon);
		Boulder boulder2 = new Boulder(4, 5, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(boulder2);
		player.moveRight();
		dungeon.updateDungeon();
        System.out.print("New boulder1 position: (" + boulder.getX() + "," + boulder.getY() + ")\n");
        System.out.print("New boulder2 position: (" + boulder2.getX() + "," + boulder2.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
		assertEquals(player.getX(), 2);
		assertEquals(player.getY(), 5);
		assertEquals(boulder.getX(), 3);
		assertEquals(boulder.getY(), 5);
		assertEquals(boulder2.getX(), 4);
		assertEquals(boulder2.getY(), 5);
    	
    }

    @Test
    void testPlayerTriesToPushBoulderIntoAnObstacle() {
        // i.e  : if the player tries to push the boulder into an obstacle or an object 
        //     (e.g. enemy, wall, door, potion, treasures etc.), 
        //     the player and the boulder should not move.
        System.out.print(" --- TESTING IF WALL (ie repel) WILL STOP BOULDER'S PATH --- \n");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 3,5);
		Boulder b1 = new Boulder(4,5, dungeon);
        dungeon.addEntity(b1); 
        Wall w1 = new Wall(5,5, dungeon);
        dungeon.addEntity(w1); 
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player right, pushing boulder in process -- however, should not move\n");
        player.moveRight();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 5);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 5);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder to right of wall\n");
        player.setX(7);
        player.setY(5);
        b1.setX(6);
        b1.setY(5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player left, pushing boulder in process -- however, should not move\n");
        player.moveLeft();
        assertTrue(b1.getX() == 6);
        assertTrue(b1.getY() == 5);
        assertTrue(player.getX() == 7);
        assertTrue(player.getY() == 5);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder above wall\n");
        player.setX(5);
        player.setY(3);
        b1.setX(5);
        b1.setY(4);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player down, pushing boulder in process -- however, should not move\n");
        assertTrue(b1.getX() == 5);
        assertTrue(b1.getY() == 4);
        assertTrue(player.getX() == 5);
        assertTrue(player.getY() == 3);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder below wall\n");
        player.setX(5);
        player.setY(7);
        b1.setX(5);
        b1.setY(6);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player up, pushing boulder in process -- however, should not move\n");
        player.moveUp();
        assertTrue(b1.getX() == 5);
        assertTrue(b1.getY() == 6);
        assertTrue(player.getX() == 5);
        assertTrue(player.getY() == 7);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("TEST PASSED!!!!\n");
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
    	
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		Boulder boulder = new Boulder(1, 0, dungeon);
		FloorSwitch fswitch = new FloorSwitch(2, 0, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(fswitch);		
		assertFalse(fswitch.getState());
		
		player.moveRight();
		dungeon.updateDungeon();
		assertTrue(fswitch.getState());
		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(fswitch.getState());

    }
    
    @Test
    void testPlayerUntriggersFloorSwitchByBoulder() {
     
    }
    
    @Test
    void testPushingBoulderOffOneFloorSwitchOntoAnother() {
        
    }
    
}
