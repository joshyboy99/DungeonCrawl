package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
