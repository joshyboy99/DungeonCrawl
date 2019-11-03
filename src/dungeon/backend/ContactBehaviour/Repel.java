package dungeon.backend.ContactBehaviour;
/**
 * Behaviour for when you cannot walk through attached object made by JAG
 */
import dungeon.backend.InteractableBehaviour;
import dungeon.backend.entity.*;

/**
 * This class looks at the contact behaviour when it being
 * contacted, hence it has it repels when walked over
 * @author JAG
 *
 */
public class Repel extends InteractableBehaviour implements ContactBehaviour {
	
	
	public Repel(Entity attached) {
		super(attached);
	}
	
	@Override
	public void onTouch(Entity entity) {
		entity.setMx(0);
		entity.setMy(0);
	}
}
