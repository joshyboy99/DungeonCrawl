package dungeon.backend.entity;

public interface Observable {
	
	void updateDungeon();
	void addObserver(Observer o);
	void removeObserver(Observer o);
}
