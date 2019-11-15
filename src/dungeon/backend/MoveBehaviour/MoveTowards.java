package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.Dungeon;
import dungeon.backend.entity.Entity;

/**
 * This move behavior is appropriate for entities
 * that need to move towards a particular entity.
 * @author JAG
 *
 */
public class MoveTowards extends Behaviour implements MoveBehaviour {
	
	Entity targetEntity;
	Dungeon dungeon; 
	public MoveTowards(Entity attached, Entity targetEntity, Dungeon dungeon) {
		super(attached);
		this.targetEntity = targetEntity;
		this.dungeon = dungeon;
	}
	
	@Override
	public void move() {

		attached.setMx(0);
		attached.setMy(0);
		//if attached is to the left of targetEntity
		if(attached.getX() > targetEntity.getX()) {
			attached.setMx(-1);
			this.dungeon.scanTile(attached, attached.getX() - 1, attached.getY());
			attached.setX(attached.getX() + attached.getMx());
			
			//if enemy is above targetEntity 
			if (attached.getY() < targetEntity.getY() == true) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() +1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if (attached.getY() > targetEntity.getY() == true) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX() , attached.getY() -1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
		} 
		
		//if attached is to the right of targetEntity
		else if(attached.getX() < targetEntity.getX() && attached.getMx() == 0){
			attached.setMx(1);
			this.dungeon.scanTile(attached, attached.getX() + 1, attached.getY());
			attached.setX(attached.getX() + attached.getMx());
			
			//above
			if(attached.getY() < targetEntity.getY()) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() +1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if(attached.getY() > targetEntity.getY()) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() -1);
				attached.setY(attached.getY() + attached.getMy());
			}
		} 
		
		////if targetEntity and attached inline on x axis 
		else if(attached.getX() == targetEntity.getX()) {
			
			if(attached.getY() < targetEntity.getY() && attached.getMy() == 0) {
				attached.setMy(1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() +1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
			//below
			else if(attached.getY() > targetEntity.getY()  && attached.getMy() == 0) {
				attached.setMy(-1);
				this.dungeon.scanTile(attached, attached.getX(), attached.getY() -1);
				attached.setY(attached.getY() + attached.getMy());
			}
			
		}
	
		
	}
}