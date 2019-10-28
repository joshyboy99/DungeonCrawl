package unsw.unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
 * US0.3 - As a player I want to be able to collect items so that
 * I can complete the objectives of the level.
 */

class Test03Collectable {
    @Test
    void testPickUpTreasure() {
    	// 5x5 Map player at (0,1)
    	// Treasure in (0,2) 
    	// pick up by going left once 
    	// check if on board

    }

    @Test
    void testPickUpSword() {
    	// 5x5 Map player at (0,1)
    	// Sword in (0,2) 
    	// pick up by going left once 
    	// check if on board

    }


    @Test
    void testPickUpKey() {
    	// 5x5 Map player at (0,1)
    	// Key in (0,2) 
    	// pick up by going left once 
    	// check if on board

    }

    @Test
    void testPickUpInvincibilityPotion() {
    	// 5x5 Map player at (0,1)
    	// Potion in (0,2) 
    	// pick up by going left once 
    	// check if on board

    }

	@Test
	void testPickUpSwordLimit() {
    	// 5x5 Map player at (0,1)
    	// sword_one in (0,2), sword_two in (0,3)
    	// pick up by going left 
		// check if on board of sword_one
	}

	@Test
	void testPickUpKeyLimit() {
    	// 5x5 Map player at (0,1)
    	// key_one in (0,2), key_two in (0,3)
    	// pick up by going left
		// check if on board of key_one

	}
	
	@Test
	void testPickUpAllItems() {
    	// 5x5 Map player at (0,1)
    	// Treasure in (0,2) Sword, Key, potion
    	// pick up by going left.

	}

}
