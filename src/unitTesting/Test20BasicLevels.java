package unitTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* 
 * US2.0 - As a player I want to have basic levels so that 
 * I can understand the basic control of the game.
 */

class Test20BasicLevels{
    @Test
    void testWinByTreasure() {
        // create 5x5 puzzle
        // set the completion condition of the level to collect all treasures

        // collect all treasures
    	
    	// assert win
    }
    
    @Test
    void testWinByTreasureNotSatisfied() {
        // create 5x5 puzzle
    	// set the completion condition of the level to collect all treasures
    	
        // collect partial treasures
    	// assert lose
    }
    
    @Test
    void testWinbyEnemyConditionSatisfied() {
        // create 5x5 puzzle
        // set the completion condition of the level to kill all enemies

        // kill all enemies
    	
    	// assert win
        
    }
    
    @Test
    void testWinbyEnemyConditionNotSatisfied() {
        // create 5x5 puzzle
        // set the completion condition of the level to kill all enemies

        // kill partial enemies
    	
    	// assert lose
    }

	@Test
	void testFloorSwitchesSatisfied() {
		// create 5x5 puzzle
		// set the completion condition of the level to open all floor switch

        // add the entities to the level
		
		// assert win

	}

	@Test
	void testFloorSwitchesNotSatisfied() {
		// create 5x5 puzzle
		// set the completion condition of the level to open all floor switch

        // add the entities to the level
		
		// assert lose

	}
	
    
    
    @Test
    void testCompleteViaExit() {
        // The puzzle contains the completion condition 'CompleteViaExit' 
        // (i.e. the puzzle can only be completed by the player going through an exit).
        // player goes through an exit, the 'CompleteViaExit' completion condition is satisfied
        // and the puzzle should be completed

        // set the completion condition of the level to CompleteViaExit
        
        // move the player into an exit
        
        // checking that the exit has been reached by the player 
                
        // check that the level has been completed
    }
    
    
}
