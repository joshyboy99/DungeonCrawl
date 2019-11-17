package dungeon.backend.goal;

/**
 * An interface to share methods for
 * goal objects, which represent the
 * tasks that the player must complete
 * in order to win the level. 
 * @author JAG
 *
 */
public interface Goal {
	/**
	 * Checks if the dungeon satisfies the conditions to win the game
	 * @return	True if conditions satisfied, false otherwise
	 */
	public boolean isComplete();
}

