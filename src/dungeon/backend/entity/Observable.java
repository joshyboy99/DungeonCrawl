package dungeon.backend.entity;

/** 
 * This Observable interface is for objects to be observed. 
 * @author JAG
 *
 */
public interface Observable {
	
	void updateDungeon();
	void addObserver(Observer o);
	void removeObserver(Observer o);
}
