package unitTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Boulder;
import dungeon.backend.entity.FloorSwitch;
import dungeon.backend.entity.Player;
//US1.7 - As a player I want to have floor switches that can be triggered so that I can complete the objective of the level.
public class Test17FloorSwitches {
	//  When an entity is on the same square as the floor switch, its status is closed
	@Test
    void testAC1and2() {
    	
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		Boulder boulder = new Boulder(1, 0, dungeon);
		FloorSwitch fswitch = new FloorSwitch(2, 0, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(fswitch);		
		assertFalse(fswitch.getState());
		
		player.moveRight();
		dungeon.updateDungeon();
		assertTrue(fswitch.getState());
		player.moveRight();
		dungeon.updateDungeon();
		assertFalse(fswitch.getState());

    }
}
