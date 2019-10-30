package dungeon.LevelMaker;

import dungeon.backend.*;
import java.util.ArrayList;
import java.util.List;


public class Level {
	private LevelSquare[][] levelBoard;
    private int rows;
    private int cols;
    
    
    public Level(int rows, int cols) {
        this.levelBoard = new LevelSquare[rows][cols];
        this.rows = rows;
        this.cols = cols;
        initialiseBoard();
    }
    
    private void initialiseBoard() {
        for (int x = 0; x < this.rows; x++) {
            for (int y = 0; y < this.cols; y++) {
                levelBoard[x][y] = new LevelSquare(x, y);
            }
        }
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    public void addEntity(Entity entity, int x, int y) {
        if (!isValidSquare(x, y)) return;
        if (onBoard(entity)) return;
        
        levelBoard[x][y].addEntity(entity);
        
//        entity.setX(x);
//        entity.setY(y);
    }
    
    public boolean isValidSquare(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols) return false;
        return true;
    }
    
    public boolean onBoard(Entity entity) {
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (levelBoard[x][y].hasEntity(entity)) {
                    return true;
                }
            }
        }
        return false;
    }

}
