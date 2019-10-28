package unsw.dungeon;

public class Killentity implements Contactbehaviour {
	Entity entity; 
	public Killentity(Entity entity) {
		super();
		this.entity = entity;
	}

	@Override
	public void onTouch(Entity e) {
		// TODO Auto-generated method stub
		this.entity.kill(e);
	}
	

}
