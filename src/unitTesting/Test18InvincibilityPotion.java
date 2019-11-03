package unitTesting;

import dungeon.backend.*;
import dungeon.backend.entity.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test; 

class Test18InvincibilityPotion {
	/**
     * player collects the potion by going on top of the square box containing the potion
     * once the potion is collected, the effects of it are immediately activated and a visual cue is displayed on
     * the player, indicating the consumable that is active.
     * the effects will be deactivated once the timer is finished
     */
    @Test
    //While the potion is in effect, enemy entities flee from the player.
    void testAC2() {
    	System.out.println("- - Test POTION EFFECTS - -");
 		Dungeon dungeon = new Dungeon(5,5);
 		Player player = new Player(dungeon, 0, 0);
 		dungeon.setPlayer(player);
 		Potion potion = new Potion(1, 0, dungeon);
 		dungeon.addEntity(potion);	
 		Enemy e0 = new Enemy(3, 0, dungeon);
 		dungeon.addEntity(e0);
 		e0.performMove();
 		System.out.println("TESTING IF ENEMY MOVING TOWARDS");
 		assertTrue(e0.getX() == 2);
 		assertTrue(e0.getY() == 0);
 		player.moveRight();
 		player.activePickup();
 		assertTrue(potion.potionInEffect());
 		e0.Flee();
 		System.out.println("enemy " + e0.getX() + " "+ e0.getY());
 		System.out.println("p " + player.getX() + " "+ player.getY());
 		System.out.println("enemy " + e0.getX() + " "+ e0.getY());
 		assertTrue(e0.getX() == 2);
 		assertTrue(e0.getY() == 0);
    }
    @Test
    void testAC3and5() {
    	// 5x5 Map
    	// track time -> checkcountdown
    	
        System.out.println("- - Test POTION TIME - -");
        
		Dungeon dungeon = new Dungeon(5,5);
		Player player = new Player(dungeon, 0, 0);
		dungeon.setPlayer(player);
		Potion potion = new Potion(1, 0, dungeon);
		dungeon.addEntity(potion);		
		
		Enemy e0 = new Enemy(5,2,dungeon);
		dungeon.addEntity(e0);
		
		player.moveRight();

		player.activePickup();

		
		assertTrue(potion.potionInEffect());

		assertFalse(dungeon.checkEntitiesOnDungeon(potion));   
	

		int x = 0;
		while (x < 16) {
			dungeon.updateDungeon();
			x++;
		}

		assertFalse(potion.potionInEffect());
 
        System.out.println("- -      PASSED      - -");
    }
    
//    @Test
//    void testPotionEffect() {
//    	// 5x5 Map
//    	// kill Enemies 
//        System.out.println("- - Test POTION EFFECT - -");
//        
//        System.out.println("- -       PASSED       - -");
//    }

}
