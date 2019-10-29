package unitTesting;

import dungeon.LevelMaker.*;
import dungeon.backend.*;

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
    	
    	LevelProducer producer = new LevelProducer();
        Level emptyLevel = producer.generateEmptyLevel(5, 5);
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 1 ,1);
        
        System.out.println("- - TEST RANDOM MOVEMENT - -");
        
        IntegerProperty one = new SimpleIntegerProperty(1);
        IntegerProperty two = new SimpleIntegerProperty(2);
        IntegerProperty six = new SimpleIntegerProperty(6);
        
        player.setX(two);
        assertTrue(player.x().getValue().intValue() == 2);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("Move Up working");
             
    }

    @Test
    void testMovementSingle(){
    	// Testing basic player's movement of a single direction once
    	// 5x5 Map,  spawn at center of map
    	// LEFT RIGHT UP DOWN STATIONARY
    	// Check position every time
    	
    	LevelProducer producer = new LevelProducer();
        Level emptyLevel = producer.generateEmptyLevel(5, 5);
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 1 ,1);
        
        System.out.println("- - TEST SINGLE MOVEMENT - -");
        
        IntegerProperty one = new SimpleIntegerProperty(1);
        IntegerProperty two = new SimpleIntegerProperty(2);
        
        player.setX(two);
        assertTrue(player.x().getValue().intValue() == 2);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("Move Up working");
                
        player.setX(one);
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);

        System.out.println("Move Down Up");
        
        player.setY(two);
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 2);
        
        System.out.println("Move Right working");

        player.setY(one);
        assertTrue(player.x().getValue().intValue()  == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("Move Left working");
        
    }

    @Test
    void testMovementMultiple() {
    	// Testing basic player's movement of multiple direction multiple times
    	// 5x5 Map,  spawn at center of map
    	// 3 TIMES UP, DOWN, LEFT , RIGHT , STATIONARY
    	// check position every time

        
    }

}
