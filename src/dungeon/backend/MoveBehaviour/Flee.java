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

		
		//if attached is to the left of targetEntity
		if(attached.getX() > targetEntity.getX()) {
			attached.setMx(1);
			this.dungeon.scanTile(attached, attached.getX() + 1, attached.getY());
			attached.setX(attached.getX() + attached.getMx());
			
			//if enemy is above targetEntity 
			if (attached.getY() < targetEntity.getY()) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() -1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if (attached.getY() > targetEntity.getY()) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() + 1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
		} 
		
		//if attached is to the right of targetEntity
		else if(attached.getX() < targetEntity.getX()){
			attached.setMx(-1);
			this.dungeon.scanTile(attached, attached.getX() - 1, attached.getY());
			attached.setX(attached.getX() + attached.getMx());
			
			//above
			if(attached.getY() < targetEntity.getY()) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() -1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if(attached.getY() > targetEntity.getY()) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() +1);
				attached.setY(attached.getY() + attached.getMy());
			}
		} 
		
		////if targetEntity and attached inline on x axis 
		else if(attached.getX() == targetEntity.getX()) {
			
			if(attached.getY() < targetEntity.getY()) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() - 1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if(attached.getY() > targetEntity.getY()) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() + 1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
		}
	
		
	}
	

}
