package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.PlayerControl;
import dungeon.backend.MoveBehaviour.Projectile;


/**
 * The Fireball entity is a destructive ball of flame that kills enemies
 * as it flies through the dungeon.
 * @author Shelby
 *
 */
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

	/**
	 * A boolean check that is used to determine
	 * whether the fireball has reached the farthest 
	 * extent of the dungeon.
	 * @return true if the edge reached, false otherwise.
	 */
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
	
	/**
	 * This method is called when a fireball is released 
	 * traveling rightward away from the source. 
	 * @param startX the x coordinate from which to launch the fireball.
	 * @param startY the y coordinate from which to launch the fireball.
	 */
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
	
	/**
	 * This method is called when a fireball is released 
	 * traveling leftward away from the source. 
	 * @param startX the x coordinate from which to launch the fireball.
	 * @param startY the y coordinate from which to launch the fireball.
	 */
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
	
	/**
	 * This method is called when a fireball is released 
	 * traveling upward away from the source. 
	 * @param startX the x coordinate from which to launch the fireball.
	 * @param startY the y coordinate from which to launch the fireball.
	 */
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
	
	/**
	 * This method is called when a fireball is released 
	 * traveling downward away from the source. 
	 * @param startX the x coordinate from which to launch the fireball.
	 * @param startY the y coordinate from which to launch the fireball.
	 */
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
