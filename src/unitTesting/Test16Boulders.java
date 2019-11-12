package unitTesting;
//US1.6 - As a player I want to have boulders that can be pushed so that I can accomplish the objective of the level

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Boulder;
import dungeon.backend.entity.Enemy;
import dungeon.backend.entity.Player;
import dungeon.backend.entity.Wall;

public class Test16Boulders {
	@Test
	//Boulders will not move if another entity which restricts movement is in the way of moving.
	public void testAC1(){
        // i.e  : if the player tries to push the boulder into a wall
        //     the player and the boulder should not move.
        System.out.print(" --- TESTING IF WALL (ie repel) WILL STOP BOULDER'S PATH --- \n");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 3,5);
		Boulder b1 = new Boulder(4,5, dungeon);
        dungeon.addEntity(b1); 
        Wall w1 = new Wall(5,5, dungeon);
        dungeon.addEntity(w1); 
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player right, pushing boulder in process -- however, should not move\n");
        player.moveRight();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 5);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 5);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder to right of wall\n");
        player.setX(7);
        player.setY(5);
        b1.setX(6);
        b1.setY(5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player left, pushing boulder in process -- however, should not move\n");
        player.moveLeft();
        assertTrue(b1.getX() == 6);
        assertTrue(b1.getY() == 5);
        assertTrue(player.getX() == 7);
        assertTrue(player.getY() == 5);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder above wall\n");
        player.setX(5);
        player.setY(3);
        b1.setX(5);
        b1.setY(4);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player down, pushing boulder in process -- however, should not move\n");
        assertTrue(b1.getX() == 5);
        assertTrue(b1.getY() == 4);
        assertTrue(player.getX() == 5);
        assertTrue(player.getY() == 3);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player and boulder below wall\n");
        player.setX(5);
        player.setY(7);
        b1.setX(5);
        b1.setY(6);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Moving player up, pushing boulder in process -- however, should not move\n");
        player.moveUp();
        assertTrue(b1.getX() == 5);
        assertTrue(b1.getY() == 6);
        assertTrue(player.getX() == 5);
        assertTrue(player.getY() == 7);
        assertTrue(w1.getX() == 5);
        assertTrue(w1.getY() == 5);
        System.out.print("New wall position: (" + w1.getX() + "," + w1.getY() + ")\n");
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("TEST PASSED!!!!\n");	
	}
	@Test
	//Boulders cannot be destroyed by any entity
	public void testAC2(){
        System.out.print(" --- Boulders cannot be destroyed by any entity --- \n");
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 3,5);
		dungeon.setPlayer(player);
		Boulder b1 = new Boulder(4,5, dungeon);
        dungeon.addEntity(b1); 
        Enemy e0 = new Enemy(5,5, dungeon);
        dungeon.addEntity(e0); 
		e0.performMove();
		System.out.print(" Moving enemy towards boulder \n");
        assertTrue(dungeon.checkEntitiesOnDungeon(b1));
        System.out.print(" --- TEST PASSED --- \n");
	}
	
	@Test
	//Boulders will only move one square at a time
	public void testAC3(){
		Dungeon dungeon = new Dungeon(10,10);
		Player player = new Player(dungeon, 1,5);
		Boulder b0 = new Boulder(2,5, dungeon);
		dungeon.addEntity(b0);
		dungeon.setPlayer(player);
		player.moveRight();
		System.out.print(b0.getX());
        assertTrue(b0.getX() == 3);
        assertTrue(b0.getY() == 5);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 5);
        
        System.out.print(" --- TEST PASSED --- \n");
	}
	
}
