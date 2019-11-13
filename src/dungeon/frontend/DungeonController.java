package dungeon.frontend;

import dungeon.backend.entity.*;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.scene.input.MouseEvent;

import dungeon.backend.*;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
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
    
    private DungeonSelectScreen selectScreen;
    

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.entities = dungeon.getInitialEntities();
        this.initialEntities = new ArrayList<>(initialEntities);
        this.map = new HashMap<Entity, ImageView>();
        this.timeline = new Timeline(new KeyFrame(Duration.millis(800), d -> this.controllerUpdate()));
        timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
    }
    
    public void controllerUpdate() {
    	
    	dungeon.updateDungeon();

    	for (Entity e : this.entities) {
    		
    		// here
    		if (e instanceof Enemy) {
    			e.performMove();
    		}
    	}
    	
    }
    
    public void refreshDungeonImage() {
    	refreshEntityImage();

    }
    
    public void refreshEntityImage() {
    	
    	for (Entity e : this.entities) {
    		
    		if (e instanceof Door) {
    			refreshDoor((Door) e);
    			continue;
    		}
    		
    		if (!dungeon.checkEntitiesOnDungeon(e)) {
				clearImage(e);
				continue;
			}
    		//anything that can get removed but readded later
    		if(dungeon.checkEntitiesOnDungeon(e) && map.get(e).getImage() == null) {
    			//sword
    			if(e instanceof Sword) {
    				refreshSword((Sword) e);
    			}
    		}
    		  		
    	}
    }
    
    public void refreshDoor(Door d) {
    	
	   if (d.isOpened()) {
	    	ImageView doorImage = map.get(d);
	    	Image openDoor = new Image("/open_door.png");
	    	doorImage.setImage(openDoor);
		}

    }
    
    public void refreshSword(Sword s) {
    	ImageView swordImage = map.get(s);
    	Image newSword = new Image("sword.gif");
    	swordImage.setImage(newSword);
    }
    
    
    public void clearImage(Entity e) {
    	ImageView imageView = map.get(e);
    	// Image ground = new Image("/dirt_0_new.png");
    	imageView.setImage(null);
    }
    
    public void pauseAndPlay() {
    	if(pauseFlag) {
    		// click to play
    		timeline.play();
    		pauseFlag = false;
    		Image pauseImg = new Image("/pause.png");
        	pausePlayButton.setImage(pauseImg);
    	} else {
    		// click to pause
    		timeline.stop();
    		pauseFlag = true;
    		Image playImg = new Image("/play.png");
    		pausePlayButton.setImage(playImg);
    	}
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
        
        Image box = new Image("/box.png");
        int x = dungeon.getWidth();
        for (int y = 0; y <= 2; y++) {
    		squares.add(new ImageView(box), x, y);
    	}
        
        Image pauseImg = new Image("/pause.png");
		pausePlayButton = new ImageView(pauseImg);
		pausePlayButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	    	pauseAndPlay();
    	    }
    	}); 
        squares.add(pausePlayButton, dungeon.getWidth(), dungeon.getHeight()-3);
        
        
    	Image resetImg = new Image("/restart.png");
    	ImageView reset = new ImageView(resetImg);
    	reset.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {
    	        try {
    	        	timeline.stop();
					dungeonScreen.restart();
				} catch (IOException e) {
					e.printStackTrace();
				}
    	    }
    	});
    	squares.add(reset, dungeon.getWidth(), dungeon.getHeight()-2);
    	
    	Image homeImg = new Image("/home.png");
    	ImageView home = new ImageView(homeImg);
    	home.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
    	    @Override
    	    public void handle(MouseEvent mouseEvent) {

    	        	selectScreen.start();
				
    	    }
    	});
    	squares.add(home, dungeon.getWidth(), dungeon.getHeight()-1);

        for (ImageView entity : initialEntities)
            squares.getChildren().add(entity);

    }

    @FXML
    public void handleKeyPress(KeyEvent event) {
    	
    	if (pauseFlag) return;
    	
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
        case A:
        	player.activePickup();
        	break;        	
        case S:
        	player.useSword();
        	break;	
        default:
            break;
        }
        dungeon.updateDungeon();
        
        if (dungeon.isComplete()) {
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
    
    public void setDungeonSelectScreen(DungeonSelectScreen selectScreen) {
    	this.selectScreen = selectScreen;
    }
    
    public void setEndGameScreen(DungeonEndScreen endScreen) {
    	this.endScreen = endScreen;
    }
    
    public DungeonEndScreen getEndGameScreen() {
    	return this.endScreen;
    }

    public void getMap(HashMap<Entity, ImageView> map) {
    	this.map = map;
    }
}

