package unitTesting;

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
