package dungeon.backend.goal;

public interface Goal {
	/**
	 * Checks if the dungeon satisfies the conditions to win the game
	 * @return	True if conditions satisfied, false otherwise
	 */
	public boolean isComplete();
}
