package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.Dungeon;
import dungeon.backend.entity.Entity;

public class Flee extends Behaviour implements MoveBehaviour {
	
	Entity targetEntity;
	Dungeon dungeon; 
	public Flee(Entity attached, Entity targetEntity, Dungeon dungeon) {
		super(attached);
		this.targetEntity = targetEntity;
		this.dungeon = dungeon;
	}
	@Override
	public void move() {
		int aX = attached.getX();
		int aY = attached.getY();
		int tX = targetEntity.getX();
		int tY = targetEntity.getY();
		
		//if attached is to the left of targetEntity
		if(aX > tX) {
			
			this.dungeon.scanTile(attached, aX - 1, aY);
			
			attached.setMx(aX - 1);
			
			//if enemy is above targetEntity 
			if (aY < tY == true) {
				attached.setMy(aY + 1);
			}
			
			//below
			else if (aY > tY == true) {
				attached.setMy(aY - 1);
			}
			
		} 
		
		//if attached is to the right of targetEntity
		else if(aX < tY){
			
			this.dungeon.scanTile(attached, aX + 1, aY);
			
			attached.setMx(aX + 1);
			
			//above
			if(aY < tY) {
				this.dungeon.scanTile(attached, aX, aY + 1);
				attached.setMy(aY + 1);
			}
			
			//below
			else if(aY > tY) {
				this.dungeon.scanTile(attached, aX, aY-1);
				attached.setMy(aY - 1);
			}
		} 
		
		////if targetEntity and attached inline on x axis 
		else if(aX == tY) {
			
			if(aY < tY) {
				this.dungeon.scanTile(attached, aX, aY+1);
				attached.setMx(aY - 1);
			}
			
			//below
			else if(aY > tY) {
				this.dungeon.scanTile(attached, aX, aY-1);
				attached.setMx(aY + 1);
			}
			
		}
		
		attached.nextMove();
		
	}
	

}
