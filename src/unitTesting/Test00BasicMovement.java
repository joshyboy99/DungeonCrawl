package unitTesting;

import dungeon.LevelMaker.*;
import dungeon.backend.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        
//        player.setX(2);
//        assertTrue(player.getXLocation() == 2);
//        assertTrue(player.getYLocation() == 1);
        
        

    }

    @Test
    void testMovementSingle(){
    	// Testing basic player's movement of a single direction once
    	// 5x5 Map,  spawn at center of map
    	// LEFT RIGHT UP DOWN STATIONARY
    	// Check position every time
    }

    @Test
    void testMovementMultiple() {
    	// Testing basic player's movement of multiple direction multiple times
    	// 5x5 Map,  spawn at center of map
    	// 3 TIMES UP, DOWN, LEFT , RIGHT , STATIONARY
    	// check position every time

    }

}
