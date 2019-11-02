package unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
 

import dungeon.backend.entity.*;
import dungeon.backend.*;
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
        Dungeon dungeon = new Dungeon(5,5);

        Player player = new Player(dungeon, 1 ,1);

        dungeon.setPlayer(player);
        Treasure treasure = new Treasure(2, 1, dungeon);
        dungeon.addEntity(treasure);
        Inventory invent = player.getInventory();
        
        System.out.println("- - TEST PICK UP TREASURE - -");
        assertTrue(invent.getItems().isEmpty());
        player.moveRight();
        System.out.println(player.x().getValue().intValue());
        System.out.println(player.y().getValue().intValue());
        
        System.out.println(treasure.x().getValue().intValue());
        System.out.println(treasure.y().getValue().intValue());
        
        //assertTrue(invent.checkForItem(treasure));
        System.out.println(invent.checkForItem(treasure));
        
        System.out.println("- -         PASSED        - -");

    }

//    @Test
//    void testPickUpSword() {
//    	// 5x5 Map player at (0,1)
//    	// Sword in (0,2) 
//    	// pick up by going left once 
//    	// check if on board
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Sword sword = new Sword(0, 2);
//        Inventory invent = player.getInventory();
//        
//        System.out.println("- - TEST PICK UP TREASURE - -");
//        
//        System.out.println("- -         PASSED        - -");
//    }
//
//
//    @Test
//    void testPickUpKey() {
//    	// 5x5 Map player at (0,1)
//    	// Key in (0,2) 
//    	// pick up by going left once 
//    	// check if on board
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Key key = new Key(1, 1, 1);
//        Inventory invent = player.getInventory();
//        assertTrue(invent.getItems().isEmpty());
//        player.moveRight();
//        assertTrue(player.checkInventory(key));
//        
//        System.out.println("- -         PASSED        - -");
//    }
//
//    @Test
//    void testPickUpInvincibilityPotion() {
//    	// 5x5 Map player at (0,1)
//    	// Potion in (0,2) 
//    	// pick up by going left once 
//    	// check if on board
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Potion key = new Potion(0, 2);
//        Inventory invent = player.getInventory();
//        
//        System.out.println("- -  TEST PICK UP POTION  - -");
//        
//        System.out.println("- -         PASSED        - -");
//    }
//
//	@Test
//	void testPickUpSwordLimit() {
//    	// 5x5 Map player at (0,1)
//    	// sword_one in (0,2), sword_two in (0,3)
//    	// pick up by going left 
//		// check if on board of sword_one
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Sword sword1 = new Sword(0, 2);
//        Sword sword2 = new Sword(0, 3);
//        Inventory invent = player.getInventory();
//        
//        System.out.println("- -   TEST PICK UP SWORD  - -");
//        
//        System.out.println("- -         PASSED        - -");
//	}
//
//	@Test
//	void testPickUpKeyLimit() {
//    	// 5x5 Map player at (0,1)
//    	// key_one in (0,2), key_two in (0,3)
//    	// pick up by going left
//		// check if on board of key_one
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Key key1 = new Key(0, 2, 1);
//        Key key2 = new Key(0, 3, 2);
//        Inventory invent = player.getInventory();
//        
//        System.out.println("- -    TEST PICK UP KEY   - -");
//        
//        System.out.println("- -         PASSED        - -");
//
//	}
//	
//	@Test
//	void testPickUpAllItems() {
//    	// 5x5 Map player at (0,1)
//    	// Treasure in (0,2) Sword, Key, potion
//    	// pick up by going left.
//        Dungeon dungeon = new Dungeon(5,5);
//        Player player = new Player(dungeon, 0 ,1);
//        Key key = new Key(0, 2, 1);
//        Sword sword = new Sword(0, 3);
//        Treasure treasure = new Treasure(0, 3, 1);
//        Potion potion = new Potion(0, 3);
//        Inventory invent = player.getInventory();
//        
//        System.out.println("- -    TEST PICK UP ALL   - -");
//        
//        System.out.println("- -         PASSED        - -");
//
//	}

}
