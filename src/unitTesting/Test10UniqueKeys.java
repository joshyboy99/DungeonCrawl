package unitTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
 

import dungeon.backend.entity.*;
import dungeon.backend.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Test10UniqueKeys {
	//A key will only open one door.
	@Test
	public void testAC3(){
        Dungeon dungeon = new Dungeon(10,10);
        Player player = new Player(dungeon,  4,5);
        Key key0 = new Key(4, 6, 1,dungeon);
        Key key1 = new Key(3, 5, 2,dungeon);
        Door door0 = new Door(5,5,1, dungeon);
        dungeon.addEntity(key0);
        dungeon.addEntity(key1);
        dungeon.addEntity(door0);
        Inventory invent = player.getInventory();
        System.out.println("- - TEST OPENING ONE DOOR - -");
        player.moveLeft();
        player.activePickup();
        System.out.println("Picking up key1 with ID: " + key1.getKeyID());
        assertFalse(dungeon.checkEntitiesOnDungeon(key1));
        assertTrue(invent.checkForItem(key1));  
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 5);
        player.moveRight();
        player.moveRight();
        player.moveRight();
        System.out.println("Moving right, attempting to unlock door0 with ID 1");
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 5);
        System.out.println("Collecting the right key for door");
        player.moveDown();
        player.activePickup();
        player.moveUp();
        assertTrue(dungeon.checkEntitiesOnDungeon(key1));
        assertFalse(invent.checkForItem(key1)); 
        assertFalse(dungeon.checkEntitiesOnDungeon(key0));
        assertTrue(invent.checkForItem(key0)); 
        System.out.println("Attempting to unlock right key for door");
        player.moveRight();
        player.moveRight();
        player.moveRight();
        System.out.println(player.getX());
        System.out.println(player.getY());
        assertTrue(player.getX() == 6);
        assertTrue(player.getY() == 5);
        System.out.println("TEST PASSED: PLAYER MADE IT THROUGH THE DOOR!"); 
	}
	//The key disappears once the corresponding door opens.
	@Test
	public void testAC4(){
        Dungeon dungeon = new Dungeon(10,10);
        Player player = new Player(dungeon,  4,5);
        Key key0 = new Key(3, 5, 1,dungeon);
        Door door0 = new Door(5,5,1, dungeon);	
        dungeon.addEntity(key0);
        dungeon.addEntity(door0);
        Inventory invent = player.getInventory();
        System.out.println("- - TEST Key is gone - -");
        System.out.println("- - Player collects key - -");
        player.moveLeft();
        player.activePickup();
        assertFalse(dungeon.checkEntitiesOnDungeon(key0));
        assertTrue(invent.checkForItem(key0)); 
        player.moveRight();
        player.moveRight();
        System.out.println("- - Player uses key on door - -");
        assertFalse(dungeon.checkEntitiesOnDungeon(key0));
        assertFalse(invent.checkForItem(key0));
        
        System.out.println("- - TEST PASSED! - -");
	}
	@Test
	public void testAC8() {
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
        
        Inventory invent = player.getInventory();
        
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
}
