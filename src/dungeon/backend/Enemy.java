package dungeon.backend;
import dungeon.backend.*;

public class Enemy extends Entity {
	

	private Player player;
	private boolean dead;
	
	public Enemy(int x, int y, Player player) {
		super(x, y);
		this.player = player;
		this.dead = false;
	}

}
