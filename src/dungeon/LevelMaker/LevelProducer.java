package dungeon.LevelMaker;

import dungeon.backend.*;
import dungeon.LevelMaker.*;

public class LevelProducer {
	private Player player;
	private Level levelBoard = null;
	
    public Level generateEmptyLevel(int nRows, int nCols) {  
        Level emptyPuzzle = new Level(nRows, nCols);
        addPuzzleBorder(emptyPuzzle);
        return emptyPuzzle;
    }
    
    private void addPuzzleBorder(Level level) {
        int x, y;

        for (x = 0; x < level.getRows(); x++) {
            if (x == 0 || x == (level.getRows() - 1)) {
                for (y = 0; y < level.getCols(); y++) {
                	level.addEntity(new Wall(x, y), x, y);
                }
            }
        }

        for (y = 0; y < level.getCols(); y++) {
            if (y == 0 || y == (level.getCols() - 1))
            for (x = 0; x < level.getRows(); x++) {
            	level.addEntity(new Wall(x, y), x, y);
            }
        }
    }

}
