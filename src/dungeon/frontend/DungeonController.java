package dungeon.frontend;

import dungeon.backend.entity.*;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dungeon.backend.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * A JavaFX controller for the dungeon.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonController {

    @FXML
    private GridPane squares;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;
    
    private DungeonScreen dungeonScreen;
    
    private DungeonEndScreen endScreen;
    
    private HashMap<Entity, ImageView> map;
    
    private Timeline timeline;
    
    private ImageView pausePlayButton;

    private boolean pauseFlag;
    
    private List<Entity> entities;
    

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.entities = dungeon.getEntities();
        this.initialEntities = new ArrayList<>(initialEntities);
        this.map = new HashMap<Entity, ImageView>();
        this.timeline = new Timeline(new KeyFrame(Duration.millis(500), d -> this.controllerUpdate()));
    }
    
    public void controllerUpdate() {
    	dungeon.updateDungeon();
    	refreshDungeonImage();

    	if (dungeon.isComplete()) {
        	this.timeline.stop();
        	endScreen.start(true);
        }
    	
        if (dungeon.isFail()) {
        	endScreen.start(false);
        }
    	
    }
    
    public void refreshDungeonImage() {
    	refreshEntityImage();

    }
    
    public void refreshEntityImage() {
    	
    	int counter = 0;
    	for (Entity e : this.entities) {
    		
    		//exist entity
//    		if (e instanceof Door) {
//    			refreshDoor((Door) e);
//    		}
    		
    		if (e instanceof Pickup) {
    			// e instanceof Pickup
    			
    			System.out.println("Seperator" + counter);
    			Pickup p = (Pickup) e;
    			
    			System.out.println(dungeon.checkEntitiesOnDungeon(e));
    			
	    		if (player.checkInventory(p)) {
	    			System.out.println("asdkfjalksfdjl");
					this.entities.remove(e);
					clearImage(e);
					continue;
				}
	    	counter ++;
    		}
    	}
    }
    
    public void clearImage(Entity e) {
    	ImageView imageView = map.get(e);
    	// Image ground = new Image("/dirt_0_new.png");
    	imageView.setImage(null);
    }

    @FXML
    public void initialize() {
        Image ground = new Image("/dirt_0_new.png");

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
        }

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);

    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
        case UP:
            player.moveUp();
            break;
        case DOWN:
            player.moveDown();
            break;
        case LEFT:
            player.moveLeft();
            break;
        case RIGHT:
            player.moveRight();
            break;
        default:
            break;
        }
                
        if (dungeon.isComplete()) {
        	System.out.println("here");
        	endScreen.start(true);
        }
        if (dungeon.isFail()) {
        	endScreen.start(false);
        }
        
        refreshDungeonImage();
    }
    
    public void setDungeonScreen(DungeonScreen dungeonScreen) {
    	this.dungeonScreen = dungeonScreen;
    }
    
    public void setEndGameScreen(DungeonEndScreen endScreen) {
    	this.endScreen = endScreen;
    }

    public void getMap(HashMap<Entity, ImageView> map) {
    	this.map = map;
    }
}

