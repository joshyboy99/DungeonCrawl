package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/*
 * US0.0 - As a player I want to be able to move my character up, down,
 * left or right so that I can move around the level.
 */

class Test00BasicMovement {

    @Test
    void testRandomMovement() {
    	// Testing basic player's movement of player in an empty dungeon
    	// 5x5 Map
    	// Make a series of random movement
    	// check the Player's position every time
    	
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 1,1);
        
        System.out.println("- - TEST RANDOM MOVEMENT - -");
        
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 2);
        assertTrue(player.y().getValue().intValue() == 1);
        
        
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 3);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 4);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveDown();
        assertTrue(player.x().getValue().intValue() == 4);
        assertTrue(player.y().getValue().intValue() == 2);
        
        player.moveDown();
        assertTrue(player.x().getValue().intValue() == 4);
        assertTrue(player.y().getValue().intValue() == 3);
        
        player.moveLeft();
        assertTrue(player.x().getValue().intValue() == 3);
        assertTrue(player.y().getValue().intValue() == 3);
        System.out.println("Move SNAKE working");
             
    }

    @Test
    void testMovementSingle(){
    	// Testing basic player's movement of a single direction once
    	// 5x5 Map,  spawn at center of map
    	// LEFT RIGHT UP DOWN STATIONARY
    	// Check position every time
    	
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 1 ,1);
        
        System.out.println("- - TEST SINGLE MOVEMENT - -");
        
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 2);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("Move RIGHT working");
                
        player.moveLeft();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);

        System.out.println("Move LEFT working");
        
        player.moveDown();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 2);
        
        System.out.println("Move DOWN working");

        player.moveUp();
        assertTrue(player.x().getValue().intValue()  == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("Move UP working");
        
        assertTrue(player.x().getValue().intValue()  == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        System.out.println("No move working");
        
    }

    @Test
    void testMovementMultiple() {
    	// Testing basic player's movement of multiple direction multiple times
    	// 5x5 Map,  spawn at center of map
    	// 3 TIMES UP, DOWN, LEFT , RIGHT , STATIONARY
    	// check position every time

        
    }

}
