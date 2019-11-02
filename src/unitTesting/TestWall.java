package unitTesting;

import dungeon.backend.entity.*;
import dungeon.backend.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class TestWall {
	
	@Test
    void Trapped() {        
    	// 3x3map
        // player @ 1,1 
        // wall @ (0,1), (1,2), (2,1), (1,0)
		
        Dungeon dungeon = new Dungeon(3,3);
        Player player = new Player(dungeon, 1,1);
        dungeon.addEntity(new Wall(0,1,dungeon));
        dungeon.addEntity(new Wall(1,2,dungeon));
        dungeon.addEntity(new Wall(2,1,dungeon));
        dungeon.addEntity(new Wall(1,0,dungeon));
        
        System.out.println("- - TEST TRAPPED WITH WALL - -");
        
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);

        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveLeft();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveUp();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        player.moveDown();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("- -       TEST PASSED      - -");
        
        
    }
	
}
