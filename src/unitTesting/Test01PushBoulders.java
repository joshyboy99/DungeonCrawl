package unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import dungeon.backend.Dungeon;
import dungeon.backend.entity.Boulder;
import dungeon.backend.entity.Player;

public class Test01PushBoulders {
	//Player can move the boulder only if they're in the adjacent square.
	@Test
	public void testAC1() {
		System.out.println("- - TEST RANDOM BOULDER TO ADJCENT SQUARE - -");
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 1,2);
		System.out.print("Created a boulder (3,2) and a player instantiated at square 1,2\n");
		Boulder b1 = new Boulder(3,2, dungeon);
		dungeon.addEntity(b1);
		System.out.print("Moving player right, should have no effect on boulder's position\n");
		player.moveRight();
        assertTrue(b1.getX() == 3);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 2);
        System.out.println("- -               PASSED                  - -");
	}
	//Boulder will only move in the direction the player is pushing.
	// For every square the player moves in the direction that it is pushed, the boulder will move only one square.
	@Test 
	public void testAC2and3() {
		System.out.println("- -     MOVE IN DIRECTION PLAYER IS PUSHING   - -");
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 2,2);
		System.out.print("Created a boulder (3,2) and a player instantiated at square 2,2\n");
		Boulder b1 = new Boulder(3,2, dungeon);
        dungeon.addEntity(b1); 
        System.out.print("Moving player right, pushing the boulder\n");
    	player.moveRight();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player right 3 times\n");
        player.moveRight();
        player.moveRight();
        player.moveRight();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("Move player above boulder, to ensure can be pushed downwards\n");
        player.moveUp();
        player.moveRight();
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 1);
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move player down, pushing boulder in process\n");
        player.moveDown();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 3);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player down 3 times\n");
        player.moveDown();
        player.moveDown();
        player.moveDown();
        assertTrue(b1.getX() == 4);
        assertTrue(b1.getY() == 4);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 3);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Testing pushing boulder up");
        player.setX(2);
        player.setY(3);
        b1.setX(2);
        b1.setY(2);
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 3);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Move player up, pushing boulder in process\n");
        player.moveUp();
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 1);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.print("Ensuring boulder cannot go off map, move player up 3 times\n");
        player.moveUp();
        player.moveUp();
        player.moveUp();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 0);
        assertTrue(player.getX() == 2);
        assertTrue(player.getY() == 1);
        System.out.print("Testing pushing boulder left");
        player.setX(4);
        player.setY(2);
        b1.setX(3);
        b1.setY(2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 3);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 4);
        assertTrue(player.getY() == 2);
        System.out.print("Move player left, pushing boulder in process\n");
        player.moveLeft();
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        assertTrue(b1.getX() == 2);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 3);
        assertTrue(player.getY() == 2);
        System.out.print("Ensuring boulder cannot go off map, move player left 3 times\n");
        player.moveLeft();
        player.moveLeft();
        player.moveLeft();
        assertTrue(b1.getX() == 0);
        assertTrue(b1.getY() == 2);
        assertTrue(player.getX() == 1);
        assertTrue(player.getY() == 2);
        System.out.print("New boulder position: (" + b1.getX() + "," + b1.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
        System.out.println("- -               PASSED                  - -");
    }
	//  Player can only move one boulder at a time.
	@Test 
	public void testAC4() {
		System.out.println("- - TEST MOVE ONE BOULDER AT A TIME - -");
		Dungeon dungeon = new Dungeon(10, 10);
		Player player = new Player(dungeon, 2, 5);
		dungeon.setPlayer(player);
		Boulder boulder = new Boulder(3, 5, dungeon);
		Boulder boulder2 = new Boulder(4, 5, dungeon);
		dungeon.addEntity(boulder);
		dungeon.addEntity(boulder2);
		player.moveRight();
		dungeon.updateDungeon();
        System.out.print("New boulder1 position: (" + boulder.getX() + "," + boulder.getY() + ")\n");
        System.out.print("New boulder2 position: (" + boulder2.getX() + "," + boulder2.getY() + ")\n");
        System.out.print("New player position: (" + player.getX() + "," + player.getY() + ")\n");
		assertEquals(player.getX(), 2);
		assertEquals(player.getY(), 5);
		assertEquals(boulder.getX(), 3);
		assertEquals(boulder.getY(), 5);
		assertEquals(boulder2.getX(), 4);
		assertEquals(boulder2.getY(), 5);
		System.out.println("- -               PASSED                  - -");
		
	}
}
