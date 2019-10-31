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
        Wall topWall = new Wall(0,1);
        Wall rightWall = new Wall(1,2);
        Wall downWall = new Wall(2,1);
        Wall leftWall = new Wall(1,0);
        
        System.out.println("- - TEST TRAPPED WITH WALL - -");
        
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);

        // right         
        player.moveRight();
        assertTrue(player.x().getValue().intValue() == 1);
        assertTrue(player.y().getValue().intValue() == 1);
        
        // wrong
//        player.moveRight();
//        assertTrue(player.x().getValue().intValue() == 2);
//        assertTrue(player.y().getValue().intValue() == 1);
        
        System.out.println("- -       TEST PASSED      - -");
        
        
    }
	
}
