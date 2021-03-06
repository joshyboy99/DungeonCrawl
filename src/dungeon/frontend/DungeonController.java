package dungeon.frontend;

import dungeon.backend.entity.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javafx.scene.input.MouseEvent;

import dungeon.backend.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    
	@FXML
	private TextArea instructions;

    private List<ImageView> initialEntities;

    private Player player;

    private Dungeon dungeon;
    
    private DungeonScreen dungeonScreen;
    
    private DungeonSelectScreen selectScreen;
    
    private DungeonEndScreen endScreen;
    
    private HashMap<Entity, ImageView> map;
    
    private Timeline timeline;
    
    private ImageView pausePlayButton;

    private boolean pauseFlag;
    
    private TextField mana;
    
    private TextField swordSwings;
    
    private List<Entity> entities;
    
    private int treasures;
    
    

    public DungeonController(Dungeon dungeon, List<ImageView> initialEntities) {
        this.dungeon = dungeon;
        this.player = dungeon.getPlayer();
        this.entities = dungeon.getInitialEntities();
        this.initialEntities = new ArrayList<>(initialEntities);
        this.treasures = treasureCounter();
        this.map = new HashMap<Entity, ImageView>();
        this.timeline = new Timeline(new KeyFrame(Duration.millis(800), d -> this.controllerUpdate()));
        timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
				
		
    }
    
    /**
     * This method calls update dungeon so that
     * the screen can display the new states of each
     * entity with every update.
     */
    public void controllerUpdate() {
    	
    	dungeon.updateDungeon();

    	for (Entity e : this.entities) {

    		if (e instanceof Enemy) {
    			e.performMove();
    			
    		}
    	}
    	for(Fireball f: this.dungeon.getFireBalls()) {
   			if(map.get(f) == null) {
    			refreshFireball(f);
    		}	
   			else{
    			f.performMove();
    		}
    	}
    	for(Summoned s: this.dungeon.getSummoned()) {
   			if(map.get(s) == null) {
    			refreshFireball(s);
    		}	
   			else{
    			s.performMove();
    		}
        }
    	
    	for(Entity e: this.dungeon.getDeletedEntities()) {
    		if (e instanceof Fireball && map.get(e) != null) {
    			map.get(e).setImage(null);
    	    }
    		if (e instanceof Summoned && map.get(e) != null) {
    			map.get(e).setImage(null);
    	    }
        }

    }
    
    /**
     * This manager method calls the 
     * methods necessary to update the 
     * images on the dungeon to the most
     * recent state. 
     */
    public void refreshDungeonImage() {
    	refreshEntityImage();
    	addToInventory();

    }
    
    /**
     * this method refreshes the images
     * for all of the entities on the dungeon individually
     * 
     */
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
    
    
    public void refreshFireball(Summoned s) {
    	ImageView summonedImage = new ImageView();
    	Image summonedb = new Image("/gnome.png");
    	summonedImage.setImage(summonedb);
    	trackPosition(s, summonedImage);
        initialEntities.add(summonedImage);
        this.map.put(s, summonedImage);
    }
    
    public void refreshFireball(Fireball f) {
    	ImageView fireballImage = new ImageView();
    	Image fireb = new Image("/fireball.gif");
    	fireballImage.setImage(fireb);
    	trackPosition(f, fireballImage);
        initialEntities.add(fireballImage);
        this.map.put(f, fireballImage);
    }
    
    /**
     * This method updates all the doors in 
     * the dungeon to display the open
     * image for those which have been opened.
     * @param d
     */
    public void refreshDoor(Door d) {
    	
	   if (d.isOpened()) {
	    	ImageView doorImage = map.get(d);
	    	Image openDoor = new Image("/open_door.png");
	    	doorImage.setImage(openDoor);
		}

    }
    
    /**
     * this method updates the mana counter
     * to the most recent value. 
     */
    public void refreshMana() {
    	if (dungeon.getPlayer().getMana() != -1) {
    		TextField text0 = new TextField();
    		String mana = Integer.toString(dungeon.getPlayer().getMana());
    		text0.setText(mana);
    		text0.setDisable(true);
    		TextField text1 = new TextField();
    		this.mana = text0; 
    		text1.setText("M:");
    		text1.setDisable(true);
    		text0.setStyle("-fx-text-fill: blue;");
    		text1.setStyle("-fx-text-fill: blue;");
        	squares.add(text0, dungeon.getWidth() - 1, 1);
        	squares.add(text1, dungeon.getWidth() - 2, 1);
    	}
    	else if (dungeon.getPlayer().getMana() == -1 && this.mana != null) {
    		this.mana.clear();
    		this.mana.setText("0");
    	}
    }
    
    /**
     * This method updates the sword hit counter
     * to the most recent number.
     */
    public void refreshSwordHits() {
    	if (dungeon.getPlayer().getSwordSwings() != -1) {
    		TextField text0 = new TextField();
    		String swordSwings = Integer.toString(dungeon.getPlayer().getSwordSwings());
    		text0.setText(swordSwings);
    		text0.setDisable(true);
    		this.swordSwings = text0;
    		TextField text1 = new TextField();
    		text1.setText("S:");
    		text1.setDisable(true);
    		text0.setStyle("-fx-text-fill: grey;");
    		text1.setStyle("-fx-text-fill: grey;");
        	squares.add(text0, dungeon.getWidth() - 1, 0);
        	squares.add(text1, dungeon.getWidth() - 2, 0);
    	}
    	else if (dungeon.getPlayer().getSwordSwings() == -1 && this.swordSwings != null) {
    		this.swordSwings.clear();
    		this.swordSwings.setText("0");
    	}
    }
    
    public void refreshSword(Sword s) {
    	ImageView swordImage = map.get(s);
    	Image newSword = new Image("sword.gif");
    	swordImage.setImage(newSword);
    }
    
    /**
     * Counts the instances of treasure left
     * in the dungeon
     * @return the numeber of treasure entities in the dungeon as an int. 
     */
    private int treasureCounter() {
    	
    	int t = 0;
    	for (Entity e : entities) {
    		if (e instanceof Treasure) {
    			t ++;
    		} 		
    	}
    	
    	return t;
    }
    
    /**
     * Returns the current amount of treasure inside an inventory list.
     * @param picks a list of Pickup objects.
     * @return the number of treasure entites in the list as an int. 
     */
    private int currentTreasure(ArrayList<Pickup> picks) {
    	
    	int c = 0;
    	for (Pickup p : picks) {
    		if (p instanceof Treasure) {
    			c ++;
    		} 		
    	}	
    	return c;
    }
    
    /**
     * Removes entities from the dungeon that have been added
     * to the players inventory. 
     */
    public void addToInventory() {
    	
    	boolean swordFlag = false;
    	boolean keyFlag = false;
    	boolean treasureFlag = false;
    	boolean spellbookFlag = false;
    	
    	int x = dungeon.getWidth();
    	int y = 0;
    	Inventory invent = player.getInventory();
    	
    	int currentTreasures = currentTreasure(invent.getItems());
    	
    	for (Pickup p : invent.getItems()) {
    		if (p instanceof Key && keyFlag == false) {
    			Key k = (Key) p;
    			TextField text0 = new TextField();
        		String keyId = Integer.toString(k.getKeyID());
        		text0.setText(keyId);
    			squares.add(text0, dungeon.getWidth() - 1, 4);
    			
    			ImageView keyImage = map.get(p);
    			Image key = new Image("/key.png");
    			keyImage.setImage(key);
    			keyFlag = true;
    			y = 4;
    			
    		} else if (p instanceof Sword && swordFlag == false) {
    			ImageView swordImage = map.get(p);
    			Image sword = new Image("/sword.png");
    			swordImage.setImage(sword);
    			swordFlag = true;
    			y = 0;
    			
    		} else if (p instanceof Treasure && 
    				this.treasures != 0 && 
    				this.treasures == currentTreasures 
    				&& treasureFlag == false) {
    			
    			ImageView treasureImage = map.get(p);
    			Image treasure = new Image("/gold.gif");
    			treasureImage.setImage(treasure);
    			treasureFlag = true;
    			y = 2;
    		} else if (p instanceof SpellBook && spellbookFlag == false) {
    			ImageView spellbookImage = map.get(p);
    			Image spellbook = new Image("/spellbook.gif");
    			spellbookImage.setImage(spellbook);
    
    			spellbookFlag = true;
    			y = 1;
    		}
    		
    		p.x().set(x);
    		p.y().set(y);
    		
    	}
	
    	for (Entity e : entities) {
    		if (e instanceof Potion) {
    			Potion p = (Potion) e;
    			if (p.potionInEffect()) {
    				ImageView potionImage = map.get(p);
        			Image potion = new Image("/potion.gif");
        			potionImage.setImage(potion);
        			y = 3;	
        			p.x().set(x);
            		p.y().set(y);
    			}
    		}
    	}
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
        Image ground = new Image("/floor.jpg");

        // Add the ground first so it is below all other entities
        for (int x = 0; x < dungeon.getWidth(); x++) {
            for (int y = 0; y < dungeon.getHeight(); y++) {
                squares.add(new ImageView(ground), x, y);
            }
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
    	    		timeline.stop();
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
        case F:
        	player.shootMagic();
        	break;	
        case W:
        	player.summon();
        	break;	
        case D:
        	player.updateSummoners();
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
        refreshMana();
    	refreshSwordHits();
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
    
    public DungeonSelectScreen getDungeonSelectScreen() {
    	return this.selectScreen;
    }
    
    public DungeonEndScreen getEndGameScreen() {
    	return this.endScreen;
    }

    public void getMap(HashMap<Entity, ImageView> map) {
    	this.map = map;
    }
    
    public void setInstructions(String instructions) {
    	this.instructions.setText(instructions);
    }
    
    public String getInstructions() {
    	return this.instructions.getText();
    }
    
    
    /**
     * Set a node in a GridPane to have its position track the position of an
     * entity in the dungeon.
     *
     * By connecting the model with the view in this way, the model requires no
     * knowledge of the view and changes to the position of entities in the
     * model will automatically be reflected in the view.
     * @param entity
     * @param node
     */
    private void trackPosition(Entity entity, Node node) {
    	squares.add(node, entity.getX(), entity.getY());
        GridPane.setColumnIndex(node, entity.getX());
        GridPane.setRowIndex(node, entity.getY());
        entity.x().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setColumnIndex(node, newValue.intValue());
            }
        });
        entity.y().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                    Number oldValue, Number newValue) {
                GridPane.setRowIndex(node, newValue.intValue());
            }
        });
        
    }    
    
}

