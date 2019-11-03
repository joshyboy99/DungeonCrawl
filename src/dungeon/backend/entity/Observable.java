package dungeon.backend.entity;

/** 
 * The observable class, where it is is being
 * observed
 * 
 * @author JAG
 *
 */
public interface Observable {
	
	void updateDungeon();
	void addObserver(Observer o);
	void removeObserver(Observer o);
}
