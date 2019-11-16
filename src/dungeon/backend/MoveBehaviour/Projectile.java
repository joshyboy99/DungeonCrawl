package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.entity.Entity;

/**
 * Behaviour if player's control
 * @author JAG
 *
 */
public class Projectile extends Behaviour implements MoveBehaviour{

	public Projectile(Entity attached) {
		super(attached);
	}

	@Override
	public void move() {
		if(attached.getFacing() == null) {
			attached.removeSelf();
			return;
		}
		switch (attached.getFacing()) {
			case "RIGHT":
			attached.setMx(1);
			attached.dungeon.scanTile(attached, attached.getX() + 1, attached.getY());
			attached.kill(attached.getX(), attached.getY());
			//failed to go anywhere, remove!!!!
			if(attached.getMx() == 0) {
				attached.removeSelf();
				break;
			}
			attached.kill(attached.getX(), attached.getY());
			attached.setX(attached.getMx() + attached.getX());
			attached.kill(attached.getX(), attached.getY());
			break;
			
			case "LEFT":
			attached.setMx(-1);
			attached.dungeon.scanTile(attached, attached.getX() - 1,attached.getY());
			//failed to go anywhere, remove!!!!
			if(attached.getMx() == 0) {
				attached.removeSelf();
				break;
			}	
			attached.kill(attached.getX(), attached.getY());
			attached.setX(attached.getMx() + attached.getX());
			attached.kill(attached.getX(), attached.getY());
			break;
			
			case "UP":
			attached.setMy(-1);
			attached.dungeon.scanTile(attached, attached.getX(),attached.getY() - 1);
			//failed to go anywhere, remove!!!!
			if(attached.getMy() == 0) {
				attached.removeSelf();
				break;
			}	
			attached.kill(attached.getX(), attached.getY());
			attached.setY(attached.getMy() + attached.getY());
			attached.kill(attached.getX(), attached.getY());
			break;
			
			case "DOWN":
			attached.setMy(1);
			attached.dungeon.scanTile(attached, attached.getX(),attached.getY() + 1);
			//failed to go anywhere, remove!!!!
			if(attached.getMy() == 0) {
				attached.removeSelf();
				break;
			}	
			attached.kill(attached.getX(), attached.getY());
			attached.setY(attached.getMy() + attached.getY());
			attached.kill(attached.getX(), attached.getY());
			break;
		}
		
	}

}
