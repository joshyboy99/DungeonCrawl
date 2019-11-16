package dungeon.backend.entity;

import dungeon.backend.Dungeon;
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.ContactBehaviour.Destroy;
import dungeon.backend.MoveBehaviour.PlayerControl;

public class Fireball extends Entity{
	
	public Fireball(int x, int y, Dungeon dungeon) {
		super(x, y, dungeon);
		this.moveBehaviour = new PlayerControl(this);
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
		System.out.println("here!");
		System.out.println("size:" + dungeon.getEntities().size());
		this.setX(startX);
		this.setY(startY);
		this.setMx(1);
		dungeon.scanTile(this, this.getX() + 1, this.getY());
		kill(getX(), getY());
		//failed to go anywhere, remove!!!!
		if(this.getMx() == 0) {
			this.removeSelf();
		}
	}
	public void shootLeft(int startX, int startY){
		this.setX(startX);
		this.setY(startY);
		while(this.checkIfEndOfDungeon() == false){
			this.setMx(-1);
			dungeon.scanTile(this, this.getX() - 1, this.getY());
			kill(getX(), getY());
			//failed to go anywhere, remove!!!!
			if(this.getMx() == 0) {
				this.removeSelf();
				break;
			}
			else {
				this.setX(this.getMx() + this.getX());
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void shootUp(int startX, int startY){
		this.setX(startX);
		this.setY(startY);
		while(this.checkIfEndOfDungeon() == false){
			this.setMy(-1);
			dungeon.scanTile(this, this.getX(), this.getY() - 1);
			kill(getX(), getY());
			if(this.getMy() == 0) {
				this.removeSelf();
				break;
			}
			else {
				this.setY(this.getMy() + this.getY());
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void shootDown(int startX, int startY){
		this.setX(startX);
		this.setY(startY);
		while(this.checkIfEndOfDungeon() == false){
			this.setMy(1);
			dungeon.scanTile(this, this.getX(), this.getY() + 1);
			kill(getX(), getY());
			if(this.getMy() == 0) {
				this.removeSelf();
				break;
			}
			else {
				this.setY(this.getMy() + this.getY());
			}
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void kill (int x, int y) {
		for ( Entity e : this.dungeon.EntitiesOnTile(x, y)) {
			if(e instanceof Enemy) {
				e.removeSelf();
			}
		}
	}
	
	
	
}
