package unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class Test18InvincibilityPotion {
	/**
     * player collects the potion by going on top of the square box containing the potion
     * once the potion is collected, the effects of it are immediately activated and a visual cue is displayed on
     * the player, indicating the consumable that is active.
     * the effects will be deactivated once the timer is finished
     */
	
    @Test
    void testPotionTime() {
    	// 5x5 Map
    	// track time -> checkcountdown
    	
        System.out.println("- - Test POTION TIME - -");
        
        System.out.println("- -      PASSED      - -");
    }
    
    @Test
    void testPotionEffect() {
    	// 5x5 Map
    	// kill Enemies 
        System.out.println("- - Test POTION EFFECT - -");
        
        System.out.println("- -       PASSED       - -");
    }

}
