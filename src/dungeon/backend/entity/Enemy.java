package dungeon.backend.entity;

public class Enemy extends Entity {
	

	private Player player;
	private boolean dead;
	
	public Enemy(int x, int y, Player player) {
		super(x, y, moveBehaviour, contactBehaviour);
		this.player = player;
		this.dead = false;
	}
	
	

}
