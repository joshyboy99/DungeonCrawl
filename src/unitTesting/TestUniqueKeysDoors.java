package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test; 

/* Combination of :
 * 
 * US1.0 - As a player I want to obtain unique keys so that 
 * I can get through the sealed doors and accomplish the 
 * objective of the level.
 * 
 * US1.1 - As a player I want to have sealed doors so that 
 * I can be challenged.
 */

class TestUniqueKeysDoors {
	
    @Test
    void testOnlyOneKeyCanUnlockCorrespondingDoor() {        
    	// 5x5 map
        // check that unused door is not open (locked)
        // unlock door with corresponding key
        // check that the door is now open
        Dungeon dungeon = new Dungeon(5,1);

        Player player = new Player(dungeon, 1 ,1);
        Key key = new Key(0, 1, 1, dungeon);
        dungeon.addEntity(key);
        Door door = new Door(2,1,1,dungeon);
        dungeon.addEntity(door);
        
        // Inventory invent = player.getInventory();
        
        System.out.println("- -    TEST OPEN DOOR   - -");
        
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveLeft();
        player.activePickup();
        assertTrue(player.checkInventory(key));
        assertFalse(dungeon.checkEntitiesOnDungeon(key));
        
        player.moveRight();
        player.moveRight();
        player.moveRight();
        player.moveRight();
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 4);
        assertTrue(player.y().getValue().intValue() == 1);
        
        
        System.out.println("- -     TEST PASSED    - -");
        
    }
    
    @Test
    void TestWrongKeyCantUnlockAndOpenDoor() {
        // using the wrong key to try and unlock and open a door 
        // should not not unlock and open the door
        
        // check that unused door is not open (locked)
        
        // unlock door with corresponding key
        // check that the door is now open
    }
    
    @Test
    void TestMultipleDoorsOneGetsUnlockedOtherDoorsRemainLocked() {
        // Multiple doors on the board. A key is used to unlock and open a door
        // the remaining doors should remain unlocked
        
        // check that unused door is not open (locked)

        
        // unlock door with corresponding key
        // check that the door is now open
        
        //check that the other door is not open, i.e. it is still locked
    }

}
