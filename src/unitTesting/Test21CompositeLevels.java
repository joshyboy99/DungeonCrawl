package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/*
 * US 2.1 - As a player I want to have more complex 
 * levels so that I can feel challenged.
 */

class Test21CompositeLevels {
//	@Test
//	void testKillEnemiesAndExit() {
//        System.out.println("- - Test WIN COMPOSITE_1 - -");
//          
//        System.out.println("- -        PASSED        - -");
//		
//	}
	
	@Test
	void testTreasuresAndFloorSwitch() {

        System.out.println("- - Test WIN COMPOSITE_2 - -");
        Dungeon dungeon = new Dungeon(5, 5);
		Player player = new Player(dungeon, 3, 2);
		dungeon.setPlayer(player);
		JSONObject goal = new JSONObject();
		goal.put("goal", "AND");
		
		JSONArray subGoal = new JSONArray();
		JSONObject sub1 = new JSONObject();
		sub1.put("goal", "boulders");
		JSONObject sub2 = new JSONObject();
		sub2.put("goal", "treasure");
		
		subGoal.put(sub1);
		subGoal.put(sub2);
		goal.put("subgoals", subGoal);
		
		dungeon.setupGoal(goal);
		
		Treasure treasure = new Treasure(4,2, dungeon);
		dungeon.addEntity(treasure);
		
		Inventory invent = player.getInventory();
		
		Boulder boulder = new Boulder(2, 2, dungeon);
		FloorSwitch fswitch = new FloorSwitch(1, 2, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(fswitch);		
		assertFalse(fswitch.getState());


		assertFalse(dungeon.isComplete());


		player.moveLeft();
		dungeon.updateDungeon();
		assertTrue(fswitch.getState());

		assertFalse(dungeon.isComplete());

		player.moveRight();

		dungeon.updateDungeon();
		assertFalse(dungeon.isComplete());
		player.moveRight();
		dungeon.updateDungeon();

        assertFalse(dungeon.checkEntitiesOnDungeon(treasure));
        assertTrue(invent.checkForItem(treasure));    
        dungeon.updateDungeon();
        assertTrue(dungeon.isComplete());
        
        
        System.out.println("- -        PASSED        - -");
		
	}
	
//	@Test
//	void testTreasuresOrKillEnmiesAndExit() {
//		
//        System.out.println("- - Test WIN COMPOSITE_3 - -");
//        
//        System.out.println("- -        PASSED        - -");
//		
//	}
	
}
