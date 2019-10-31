package dungeon.backend.MoveBehaviour;

import dungeon.backend.Behaviour;
import dungeon.backend.Dungeon;
import dungeon.backend.entity.Entity;

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
		
		int attachedEntityX = attached.getX();
		int attachedEntityY = attached.getY();
		int targetEntitiyX = targetEntity.getX();
		int targetEntitiyY = targetEntity.getY();
		
		//if attached is to the left of targetEntity
		if(attachedEntityX > targetEntitiyX) {
			
			this.dungeon.scanTile(attached, attachedEntityX - 1, attachedEntityY);
			
			attached.setX(attachedEntityX - 1);
			
			//if enemy is above targetEntity 
			if (attachedEntityY < targetEntitiyY == true) {
				attached.setX(attachedEntityX + 1);
			}
			//below
			else if (attachedEntityY < targetEntitiyY == true) {
				attached.setX(attachedEntityX - 1);
			}
			
		} 
		
		//if attached is to the right of targetEntity
		else if(attachedEntityX < targetEntitiyY){
			
			this.dungeon.scanTile(attached, attachedEntityX + 1, attachedEntityY);
			
			attached.setX(attachedEntityX + 1);
			
			//above
			if(attachedEntityY < targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY + 1) == true) {
				
				attached.setY(attachedEntityY + 1);
			}
			
			//below
			else if(attachedEntityY > targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY-1) == true) {
				attached.setY(attachedEntityY - 1);
			}
			
		} 
		
		////if targetEntity and attached inline on x axis 
		else if(attachedEntityX == targetEntitiyY) {
			
			if(attachedEntityY < targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY+1) == true) {
				attached.setX(attachedEntityY + 1);
			}
			
			//below
			else if(attachedEntityY < targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY-1) == true) {
				attached.setX(attachedEntityY - 1);
			}
			
		} 
		
		else if(this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY+1) == false) {
			
			if(attachedEntityY < targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY+1) == true) {
				attached.setX(attachedEntityY + 1);
			}
			//below
			
			else if(attachedEntityY < targetEntitiyY && this.dungeon.scanTile(attached, attachedEntityX, attachedEntityY-1) == true) {
				attached.setX(attachedEntityY - 1);
			}
		}

	}
	//PROBLEMS : WHAT IF ENEMY STUCK IN CORNER?

}