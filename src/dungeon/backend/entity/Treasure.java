package dungeon.backend.Entity;

public class Treasure extends Entity {

	public Treasure(int x, int y) {
		super(x, y, moveBehaviour, contactBehaviour, spawnBehaviour);
	}

}
