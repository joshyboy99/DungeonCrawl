package unitTesting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Enemy;
import dungeon.backend.entity.Inventory;
import dungeon.backend.entity.Pickup;
import dungeon.backend.entity.Player;
import dungeon.backend.entity.Sword;
import dungeon.backend.entity.Wall;

public class Test19Walls { 
	//Player cannot destroy walls.
	@Test
    void testAC3() {  
        Dungeon dungeon = new Dungeon(5,5);
        Player player = new Player(dungeon, 1,2);
        Sword s0 = new Sword(1,1, dungeon);
        Inventory invent = player.getInventory();
        invent.add((Pickup) s0);
        Wall w0 = new Wall(3,2,dungeon);
        dungeon.addEntity(w0);
        player.moveRight();
        player.moveRight();
        player.moveRight();
        player.useSword();
        assertTrue(dungeon.checkEntitiesOnDungeon(w0));
        System.out.print("WALL STILL HERE -- PASSED");
        
        
        
		
	}
	//Player cannot walk through walls.
	@Test
    void testAC4() {        
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
	@Test
	//Enemies cannot walk through walls.
    void testAC5() {  
	    Dungeon dungeon = new Dungeon(10,10);
	    Player player = new Player(dungeon, 3,1);
	    Enemy e0 = new Enemy(1,1, dungeon);
	    dungeon.setPlayer(player);
	    dungeon.addEntity(new Wall(0,1,dungeon));
	    dungeon.addEntity(new Wall(1,2,dungeon));
	    dungeon.addEntity(new Wall(2,1,dungeon));
	    dungeon.addEntity(new Wall(1,0,dungeon));
	    e0.performMove();
	    e0.performMove();
	    e0.performMove();
	    assertTrue(e0.x().getValue().intValue() == 1);
	    assertTrue(e0.x().getValue().intValue() == 1);
	    System.out.println("- -       TEST PASSED      - -");
	}
}
