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
