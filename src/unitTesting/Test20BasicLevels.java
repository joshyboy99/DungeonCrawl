package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONObject;
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
    	
        System.out.println("- - Test WIN BY TREASURE - -");
        
    	Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 5, 5);

		dungeon.setPlayer(player);
		JSONObject goal = new JSONObject();
		goal.put("goal", "treasure");
		dungeon.setupGoal(goal);

		
		Treasure treasure1 = new Treasure(7,5,dungeon);
		Treasure treasure2 = new Treasure(8,5,dungeon);
		dungeon.addEntity(treasure1);
		dungeon.addEntity(treasure2);
		
		
		assertFalse(dungeon.isComplete());

		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());
		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());
		player.moveRight();
		dungeon.updateDungeon();
		assertTrue(dungeon.isComplete());
        
        System.out.println("- -         PASSED       - -");
    }
    
    @Test
    void testWinByTreasureNotSatisfied() {
        // create 5x5 puzzle
    	// set the completion condition of the level to collect all treasures
    	
        // collect partial treasures
    	// assert lose
    	
        System.out.println("- - Test LOSE BY TREASURE - -");
    	Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 5, 5);

		dungeon.setPlayer(player);
		JSONObject goal = new JSONObject();
		goal.put("goal", "treasure");
		dungeon.setupGoal(goal);

		
		Treasure treasure1 = new Treasure(7,5,dungeon);
		Treasure treasure2 = new Treasure(8,5,dungeon);
		dungeon.addEntity(treasure1);
		dungeon.addEntity(treasure2);
		
		
		assertFalse(dungeon.isComplete());

		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());
		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());

        
        System.out.println("- -         PASSED        - -");
    }
//    
//    @Test
//    void testWinbyEnemyConditionSatisfied() {
//        // create 5x5 puzzle
//        // set the completion condition of the level to kill all enemies
//
//        // kill all enemies
//    	
//    	// assert win
//    	
//        System.out.println("- - Test WIN BY SLAY - -");
//        
//        System.out.println("- -      PASSED      - -");
//        
//    }
//    
//    @Test
//    void testWinbyEnemyConditionNotSatisfied() {
//        // create 5x5 puzzle
//        // set the completion condition of the level to kill all enemies
//
//        // kill partial enemies
//    	
//    	// assert lose
//    	
//        System.out.println("- - Test LOSE BY SLAY - -");
//        
//        System.out.println("- -       PASSED      - -");
//    }
//
	@Test
	void testFloorSwitchesSatisfied() {
		// create 5x5 puzzle
		// set the completion condition of the level to open all floor switch

        // add the entities to the level
		
		// assert win
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 5, 5);
		dungeon.setPlayer(player);
		
        System.out.println("- - Test WIN BY SWITCH - -");
		
		JSONObject goal = new JSONObject();
		goal.put("goal", "boulders");
		dungeon.setupGoal(goal);
		
		Boulder boulder = new Boulder(6,5,dungeon);
		dungeon.addEntity(boulder);
		FloorSwitch floor = new FloorSwitch(7,5,dungeon);
		dungeon.addEntity(floor);
		
		assertFalse(dungeon.isComplete());

		player.moveRight();

		dungeon.updateDungeon();
		assertTrue(dungeon.isComplete());
        
        System.out.println("- -       PASSED       - -");

	}

	@Test
	void testFloorSwitchesNotSatisfied() {
		// create 5x5 puzzle
		// set the completion condition of the level to open all floor switch

        // add the entities to the level
		
		// assert lose
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 5, 5);
		dungeon.setPlayer(player);
		
		
        System.out.println("- - Test LOSE BY SWITCH - -");
        
		JSONObject goal = new JSONObject();
		goal.put("goal", "boulders");
		dungeon.setupGoal(goal);
		
		Boulder boulder = new Boulder(6,5,dungeon);
		dungeon.addEntity(boulder);
		FloorSwitch floor = new FloorSwitch(7,5,dungeon);
		dungeon.addEntity(floor);
		
		assertFalse(dungeon.isComplete());

		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());
        
        System.out.println("- -        PASSED       - -");

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
		Dungeon dungeon = new Dungeon(3, 3);
		Player player = new Player(dungeon, 1, 1);
		dungeon.setPlayer(player);
		
        System.out.println("- - Test WIN BY EXIT - -");
        
		JSONObject goal = new JSONObject();
		goal.put("goal", "exit");
		dungeon.setupGoal(goal);
		
		Exit exit = new Exit(2,1,dungeon);
		dungeon.addEntity(exit);
		
		assertFalse(dungeon.isComplete());
		player.moveRight();
		dungeon.updateDungeon();
		
		assertTrue(dungeon.isComplete());
		
        System.out.println("- -      PASSED      - -");
    }
    
    
}
