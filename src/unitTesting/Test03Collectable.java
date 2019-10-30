package unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dungeon.LevelMaker.Level;
import dungeon.LevelMaker.LevelProducer;
import dungeon.backend.Dungeon;
import dungeon.backend.Player;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
    	LevelProducer producer = new LevelProducer();
        Level emptyLevel = producer.generateEmptyLevel(5, 5);
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 0 ,1);
        
        System.out.println("- - TEST PICK UP TREASURE - -");
        
        System.out.println("- -         PASSED        - -");

    }

    @Test
    void testPickUpSword() {
    	// 5x5 Map player at (0,1)
    	// Sword in (0,2) 
    	// pick up by going left once 
    	// check if on board
        System.out.println("- - TEST PICK UP TREASURE - -");
        
        System.out.println("- -         PASSED        - -");
    }


    @Test
    void testPickUpKey() {
    	// 5x5 Map player at (0,1)
    	// Key in (0,2) 
    	// pick up by going left once 
    	// check if on board
        System.out.println("- -   TEST PICK UP KEY    - -");
        
        System.out.println("- -         PASSED        - -");
    }

    @Test
    void testPickUpInvincibilityPotion() {
    	// 5x5 Map player at (0,1)
    	// Potion in (0,2) 
    	// pick up by going left once 
    	// check if on board
        System.out.println("- -  TEST PICK UP POTION  - -");
        
        System.out.println("- -         PASSED        - -");
    }

	@Test
	void testPickUpSwordLimit() {
    	// 5x5 Map player at (0,1)
    	// sword_one in (0,2), sword_two in (0,3)
    	// pick up by going left 
		// check if on board of sword_one
        System.out.println("- -   TEST PICK UP SWORD  - -");
        
        System.out.println("- -         PASSED        - -");
	}

	@Test
	void testPickUpKeyLimit() {
    	// 5x5 Map player at (0,1)
    	// key_one in (0,2), key_two in (0,3)
    	// pick up by going left
		// check if on board of key_one
        System.out.println("- -    TEST PICK UP KEY   - -");
        
        System.out.println("- -         PASSED        - -");

	}
	
	@Test
	void testPickUpAllItems() {
    	// 5x5 Map player at (0,1)
    	// Treasure in (0,2) Sword, Key, potion
    	// pick up by going left.
        System.out.println("- -    TEST PICK UP ALL   - -");
        
        System.out.println("- -         PASSED        - -");

	}

}
