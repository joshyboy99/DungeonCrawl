package unitTesting;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Enemy;
import dungeon.backend.entity.Player;
import dungeon.backend.entity.Wall;

/*
 * US1.4  - As a player I want to have enemies so that I can feel challenged.
.
 */
public class Test14Enemies {
	@Test
	//Enemies walk constantly in the direction of the player.
	public void testAC1(){
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 2,1);
		dungeon.setPlayer(player);
		Enemy e0 = new Enemy(5, 1,dungeon);
		dungeon.addEntity(e0);
		System.out.println("-- TESTING ENEMY MOVEMENT --  ");  
		System.out.println("-- TESTING LEFT --  ");  
		System.out.println("Player position: ("+ player.getX() + "," + player.getY()  + ")");  
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");  
		e0.performMove();
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");
		assertTrue(e0.x().getValue().intValue() == 4);
		assertTrue(e0.y().getValue().intValue() == 1);
		e0.performMove();
		assertTrue(e0.x().getValue().intValue() == 3);
		assertTrue(e0.y().getValue().intValue() == 1);
		System.out.println("-- TESTING RIGHT --  "); 
		player.setX(7);
		player.setY(1);
		e0.setX(3);
		e0.setY(1);
		e0.performMove();
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");
		assertTrue(e0.x().getValue().intValue() == 4);
		assertTrue(e0.y().getValue().intValue() == 1);
		System.out.println("-- TESTING UP --  "); 
		player.setX(3);
		player.setY(1);
		e0.setX(3);
		e0.setY(5);
		e0.performMove();
		assertTrue(e0.x().getValue().intValue() == 3);
		assertTrue(e0.y().getValue().intValue() == 4);
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");
		System.out.println("-- TESTING DOWN --  "); 
		player.setX(3);
		player.setY(5);
		e0.setX(3);
		e0.setY(1);
		e0.performMove();
		assertTrue(e0.x().getValue().intValue() == 3);
		assertTrue(e0.y().getValue().intValue() == 2);
		System.out.println("-- TEST PASSED --  ");  
	}
	
	@Test
	//If the enemy touched the player, the level is reset and the player must start again..
	public void testAC2(){
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 3,1);
		dungeon.setPlayer(player);
		Enemy e0 = new Enemy(4, 1,dungeon);
		dungeon.addEntity(e0);
		System.out.println("-- TESTING ENEMY TOUCHING --  ");  
		e0.performMove();
		assertTrue(e0.x().getValue().intValue() == 3);
		assertTrue(e0.y().getValue().intValue() == 2);

		System.out.println("-- TESTING ENEMY TOUCHING --  ");  
		
	}
	
	@Test
	//If a wall is in front of the enemy, enemy chooses path to player.
	public void testAC3(){
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 2,2);
		dungeon.setPlayer(player);
		Enemy e0 = new Enemy(5, 1,dungeon);
		dungeon.addEntity(e0);
		Wall w0 = new Wall(4, 1,dungeon);
		dungeon.addEntity(w0);
		System.out.println("-- TESTING ENEMY CAN NAVIGATE WALL --  ");  
		e0.performMove();
		e0.performMove();
		e0.performMove();
		e0.performMove();
		e0.performMove();
		e0.performMove();
		e0.performMove();
		e0.performMove();
		System.out.println("Enemy position: ("+ e0.getX() + "," + e0.getY()  + ")");
		assertTrue(e0.x().getValue().intValue() == 2);
		assertTrue(e0.y().getValue().intValue() == 2);
		System.out.println("-- TEST PASSED --  ");  
		
	}
}
