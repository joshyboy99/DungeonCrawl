package dungeon.backend.entity;

public class Key extends Pickup {
	private int keyID; 	
		
	public Key(int x, int y, int keyID) {
		super(x, y);
		this.keyID = keyID;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the keyID
	 */
	public int getKeyID() {
		return keyID;
	}
	
	//TO DO:
	//CHANGE PICKUPBEHAVIOUR WHEN PLAYER HAS KEY 

	
}
