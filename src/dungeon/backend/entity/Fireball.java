package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.PlayerControl;
import dungeon.backend.MoveBehaviour.Projectile;

public class Fireball extends Entity{
	
	public Fireball(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new Projectile(this);
		this.contactBehaviour = new Destroy(this);
	}
	
	
	public Fireball() {
		this.moveBehaviour = new PlayerControl(this);
		this.contactBehaviour = new Destroy(this);
	}


	public boolean checkIfEndOfDungeon(){
		//if reached max dungeon height
		if (dungeon.getHeight() == this.getY()) {
			return true;
		}//if reached max dungeon width
		else if (dungeon.getWidth() == this.getX()) {
			return true;
		}//if reached max dungeon width
		else if (this.getX() == 0) {
			return true;
		}//if reached max dungeon height
		else if (this.getY() == 0) {
			return true;
		}
		return false; 
	}
	
	
	public void shootRight(int startX, int startY){
		this.setMx(1);
		this.dungeon.scanTile(this, this.getX() + 1,this.getY());
		//check for no walls
		if (this.getMx() == 0) {
			this.removeSelf();
			return;
		}
		this.kill(this.getX() + 1, this.getY());
		this.setX(startX + 1);
		this.setY(startY);
		this.setFacing("RIGHT");
	}
	public void shootLeft(int startX, int startY){
		this.setMx(-1);
		this.dungeon.scanTile(this, this.getX() - 1,this.getY());
		//check for no walls
		if (this.getMx() == 0) {
			this.removeSelf();
			return;
		}
		this.kill(this.getX() -1, this.getY());
		this.setX(startX - 1);
		this.setY(startY);
		this.setFacing("LEFT");
	}
	public void shootUp(int startX, int startY){
		this.setMy(-1);
		this.dungeon.scanTile(this, this.getX(),this.getY() - 1);
		//check for no walls
		if (this.getMy() == 0) {
			this.removeSelf();
			return;
		}
		this.kill(this.getX(), this.getY() - 1);
		this.setX(startX);
		this.setY(startY - 1);
		this.setFacing("UP");
		
		
	}
	public void shootDown(int startX, int startY){
		this.setMy(1);
		this.dungeon.scanTile(this, this.getX(),this.getY() + 1);
		//check for no walls
		if (this.getMy() == 0) {
			this.removeSelf();
			return;
		}
		this.kill(this.getX(), this.getY() + 1);
		this.setX(startX);
		this.setY(startY + 1);
		this.setFacing("DOWN");
		
	}
	

	
	
	
}
