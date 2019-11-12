package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.Dungeon;
import dungeon.backend.entity.Entity;

/**
 * This MoveBehaviour Instructs the attached entity
 * to move away from a target entity.
 * @author JAG
 *
 */
public class Flee extends Behaviour implements MoveBehaviour {
	
	
	Entity targetEntity;
	Dungeon dungeon; 
	public Flee(Entity attached, Entity targetEntity, Dungeon dungeon) {
		super(attached);
		this.targetEntity = targetEntity;
		this.dungeon = dungeon;
	}
	/**
	 * The move behavior of flee is that of running away from the target entity. It is like the inverse of
	 * move towards. Used for enemies when player is under the influence of the potion. 
	 */
	@Override
	public void move() {
		int aX = attached.getX();
		int aY = attached.getY();
		int tX = targetEntity.getX();
		int tY = targetEntity.getY();

		
		//if attached is to the left of targetEntity
		if(aX > tX) {
			attached.setMx(1);
			this.dungeon.scanTile(attached, aX + 1, aY);
			attached.setX(aX + attached.getMx());
			
			//if enemy is above targetEntity 
			if (aY < tY) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, aX, aY -1);
				attached.setY(aY + attached.getMy());
			}
			
			//below
			else if (aY > tY) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, aX, aY + 1);
				attached.setY(aY + attached.getMy());
			}
			
		} 
		
		//if attached is to the right of targetEntity
		else if(aX < tX){
			attached.setMx(-1);
			this.dungeon.scanTile(attached, aX - 1, aY);
			attached.setX(aX + attached.getMx());
			
			//above
			if(aY < tY) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, aX, aY -1);
				attached.setY(aY + attached.getMy());
			}
			
			//below
			else if(aY > tY) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, aX, aY +1);
				attached.setY(aY + attached.getMy());
			}
		} 
		
		////if targetEntity and attached inline on x axis 
		else if(aX == tX) {
			
			if(aY < tY) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, aX, aY -1);
				attached.setY(aY + attached.getMy());
			}
			
			//below
			else if(aY > tY) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, aX, aY + 1);
				attached.setY(aY + attached.getMy());
			}
			
		}
	
		
	}
	

}
