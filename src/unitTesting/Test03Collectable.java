package unitTesting;

import static org.junit.Assert.assertFalse;
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

    //The player can only hold none or one sword. While the player already has a sword, another sword cannot be picked up.
    @Test
    void testAC3() {
    	// 5x5 Map player at (0,1)
    	// Sword in (0,2) 
    	// pick up by going left once 
    	// check if on board
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 0 ,1);
        Sword sword0 = new Sword(0, 2, dungeon);
        Sword sword1 = new Sword(0, 3, dungeon);
        dungeon.addEntity(sword0);
        dungeon.addEntity(sword1);
        Inventory invent = player.getInventory();
   
        System.out.println("- - TEST PICK UP SWORD - -");
        System.out.println("- - Instantiate 2 swords and a player - -");
		System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
		System.out.println("Sword coordinates: (" + sword0.getX()+ "," +sword0.getY() +")");
		System.out.println("Sword coordinates: (" + sword1.getX()+ "," +sword1.getY() +")");
        player.moveDown();
        player.activePickup();
        assertFalse(dungeon.checkEntitiesOnDungeon(sword0));
        assertTrue(invent.checkForItem(sword0));  
        assertTrue(player.getX() == 0);
        assertTrue(player.getY() == 2);
        System.out.println("Move player down again, seeing if next sword is collected and old one dropped");
        player.moveDown();
        player.activePickup();
        assertTrue(invent.checkForItem(sword1));  
        assertFalse(dungeon.checkEntitiesOnDungeon(sword1));
        assertTrue(dungeon.checkEntitiesOnDungeon(sword0)); 
		System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
		System.out.println("Sword coordinates: (" + sword0.getX()+ "," +sword0.getY() +")");
		System.out.println("Sword coordinates: (" + sword1.getX()+ "," +sword1.getY() +")");
        assertTrue(sword0.getX() == 0);
        assertTrue(sword0.getY() == 3);
        assertTrue(player.getX() == 0);
        assertTrue(player.getY() == 3);
        System.out.println("- -         PASSED        - -");
    }    
    //The player can only hold none or one key at a time. While the player already has a key, another key cannot be picked up.
	@Test
	void testAC4() {
    	// 5x5 Map player at (0,1)
    	// key_one in (0,2), key_two in (0,3)
    	// pick up by going left
		// check if on board of key_one
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 0 ,1);
        Key key1 = new Key(0, 2, 1, dungeon);
        Key key2 = new Key(0, 3, 2, dungeon);
        dungeon.addEntity(key1);
        dungeon.addEntity(key2);
        Inventory invent = player.getInventory();
        System.out.println("- -    TEST PICK UP KEY   - -");
        System.out.println("- - Instantiate 2 keys and a player - -");
		System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
		System.out.println("Key1 coordinates: (" + key1.getX()+ "," +key1.getY() +")");
		System.out.println("Key2 coordinates: (" + key2.getX()+ "," +key2.getY() +")");
		System.out.println("Move player down to collect first key");
		player.moveDown();
		player.activePickup();
		System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
        assertTrue(invent.checkForItem(key1)); 
        assertFalse(dungeon.checkEntitiesOnDungeon(key1));
        System.out.println("Move player down to collect second key");
        player.moveDown();
        player.activePickup();
        System.out.println("Player coordinates: (" + player.getX()+ "," +player.getY() +")");
        assertFalse(invent.checkForItem(key1)); 
        assertFalse(dungeon.checkEntitiesOnDungeon(key2));
        assertTrue(invent.checkForItem(key2)); 
        assertTrue(key1.getX() == 0);
        assertTrue(key1.getY() == 3);
        System.out.println("- -         PASSED        - -");

	}
	//The player can pick up treasures that are on the map.	
    @Test
    void testAC5() {
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
        assertFalse(dungeon.checkEntitiesOnDungeon(treasure));
        assertTrue(invent.checkForItem(treasure));        
        System.out.println("- -         PASSED        - -");   
    }
    //The player can pick up invincibility potion, While the potion is active,another invincibility potion cannot be picked up.
    void testAC6() {
    	 Dungeon dungeon = new Dungeon(5,5);
    	 Player player = new Player(dungeon, 1 ,1);
    	 dungeon.setPlayer(player);
    	 Potion p0 = new Potion(2, 1, dungeon);
    	 Potion p1 = new Potion(3, 1, dungeon);
    	 dungeon.addEntity(p0);
    	 dungeon.addEntity(p1);
    	 System.out.println("- - TEST PICK UP 2X INVINCIBILITY POTION - -");
    	 player.moveRight();
    	 System.out.println("- -         PASSED        - -");  
    	 
    }
}
    
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
//

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


