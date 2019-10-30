package dungeon.LevelMaker;

import dungeon.backend.*;
import dungeon.LevelMaker.*;
import java.util.ArrayList;
import java.util.List;

public class LevelSquare {
	
    private int x;
    private int y;
    private List<Entity> allEntities;
    private Status state;
    
    public LevelSquare(int x, int y) {
        this.x = x;
        this.y = y;
        initialiseSquare();
    }
    
    private void initialiseSquare() {
        this.allEntities = new ArrayList<Entity>();
        // allEntities.add(emptySquare);
    	
    	this.state = Status.EMPTY;
    }
    
    public boolean hasEntity(Entity e) {
        return allEntities.contains(e);
    }
    
    public void addEntity(Entity e) {
        allEntities.add(e);
    }


}
