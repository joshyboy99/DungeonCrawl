package dungeon.backend.ContactBehaviour;
/**
 * Behaviour for when you can freely walk through attatched object made by JAG
 */
import dungeon.backend.entity.Entity;

public class NoContact implements ContactBehaviour {
	private Entity attatched; 
	public NoContact(Entity attatched) {
		this.attatched = attatched;
	}
	@Override
	public void onTouch(Entity entity) {

	}

}
