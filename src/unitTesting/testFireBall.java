package unitTesting;


import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test; 


public class testFireBall {
	   @Test
	    void testPlayerCanOnlyPushOneBoulderAtATime() {
			Dungeon dungeon = new Dungeon(10, 10);
			Player player = new Player(dungeon, 2, 5);
			Enemy enemy0 = new Enemy(5, 5, dungeon);
			Inventory invent = player.getInventory();
			dungeon.setPlayer(player);
			SpellBook spellbook = new SpellBook(3, 5, dungeon);
			dungeon.addEntity(spellbook);
			dungeon.addEntity(enemy0);
			player.moveRight();
			player.activePickup();
	        assertFalse(dungeon.checkEntitiesOnDungeon(spellbook));
	        assertTrue(invent.checkForItem(spellbook));
	        player.shootMagic();
	        assertFalse(dungeon.checkEntitiesOnDungeon(enemy0));
	   }
}
