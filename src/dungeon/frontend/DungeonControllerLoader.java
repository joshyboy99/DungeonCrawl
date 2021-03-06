package dungeon.frontend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dungeon.backend.entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * A DungeonLoader that also creates the necessary ImageViews for the UI,
 * connects them via listeners to the model, and creates a controller.
 * @author Robert Clifton-Everest
 *
 */
public class DungeonControllerLoader extends DungeonLoader {

    private List<ImageView> entities;

    //Images
    private Image playerImage;
    private Image wallImage;
    private Image exitImage;
    private Image swordImage;
    private Image boulderImage;
    private Image switchImage;
    private Image enemyImage;
    private Image potionImage;
    private Image treasureImage;
    private Image closedDoorImage;
    private Image keyImage;
    private Image portalImage;
    private Image spellBookImage;
    private Image fireballImage;
    private Image mushroomImage;
    private Image airImage;
    private Image fireImage;
    private Image waterImage;
    private Image aangImage;
    private Image tophImage;
    
    private HashMap<Entity, ImageView> map;

    public DungeonControllerLoader(String filename)
            throws FileNotFoundException {
        super(filename);
        
        this.map = new HashMap<Entity, ImageView>();
        
        entities = new ArrayList<>();
        playerImage = new Image("/human_new.png");
        wallImage = new Image("/wall.png");
        exitImage = new Image("/exit.png");
        swordImage = new Image("/sword.gif");
        boulderImage = new Image("/boulder.png");
        switchImage = new Image("/pressure_plate.png");
        enemyImage = new Image("/enemy.gif");
        potionImage = new Image("/potion.gif");  
        treasureImage = new Image("/gold.gif");
        closedDoorImage = new Image("/closed_door.png");
        keyImage = new Image("/key.png");
        portalImage = new Image("/portal.gif");
        spellBookImage = new Image("/spellbook.gif");
        fireballImage = new Image("/fireball.gif");
        mushroomImage = new Image("/mushroom.gif");
        airImage = new Image("/air.gif");
        waterImage = new Image("/water.gif");
        fireImage = new Image("/fire.gif");
        aangImage = new Image("/aang.png");
        tophImage = new Image("/toph.png");
        
    }

    @Override
    public void onLoad(Entity player, int num) {
    	ImageView view = new ImageView(playerImage);
    	
    	if (num == 0) {
    		view = new ImageView(playerImage);
    	} else if (num == 1) {
    		view = new ImageView(aangImage);
    	}
    	
        addEntity(player, view);
    }

    @Override
    public void onLoad(Wall wall) {
        ImageView view = new ImageView(wallImage);
        addEntity(wall, view);
    }
    
    @Override
    public void onLoad(Exit exit) {
    	ImageView view = new ImageView(exitImage);
    	addEntity(exit, view);
    }
    
    @Override
    public void onLoad(Sword sword) {
    	ImageView view = new ImageView(swordImage);
    	addEntity(sword, view);
    }
    
    @Override
    public void onLoad(Boulder boulder) {
    	ImageView view = new ImageView(boulderImage);
    	addEntity(boulder, view);
    }
    
    @Override
    public void onLoad(FloorSwitch floorSwitch) {
    	ImageView view = new ImageView(switchImage);
    	addEntity(floorSwitch, view);
    }
    
    @Override
    public void onLoad(Enemy enemy, int num) {
    	
    	ImageView view = new ImageView(enemyImage);
    	
    	if (num == 0) {
    		view = new ImageView(enemyImage);
    	} else if (num == 1) {
    		view = new ImageView(tophImage);
    	}

    	addEntity(enemy, view);
    }
    
    @Override
    public void onLoad(Potion potion) {
    	ImageView view = new ImageView(potionImage);
    	addEntity(potion, view);
    }
    
    @Override
    public void onLoad(Treasure treasure) {
    	ImageView view = new ImageView(treasureImage);
    	addEntity(treasure, view);
    }
    
    @Override
    public void onLoad(Door door) {
    	ImageView view = new ImageView(closedDoorImage);
    	addEntity(door, view);
    }
    
    @Override
    public void onLoad(Key key) {
    	ImageView view = new ImageView(keyImage);
    	addEntity(key, view);
    }
    
    @Override
    public void onLoad(Portal portal) {
    	ImageView view = new ImageView(portalImage);
    	addEntity(portal, view);
    }
    
    @Override
    public void onLoad(SpellBook spellbook) {
    	ImageView view = new ImageView(spellBookImage);
    	addEntity(spellbook, view);
    }
    
    @Override
    public void onLoad(Fireball fireball) {
    	ImageView view = new ImageView(fireballImage);
    	addEntity(fireball, view);
    }
    
    @Override
    public void onLoad(Mushroom mushroom) {
    	ImageView view = new ImageView(mushroomImage);
    	addEntity(mushroom, view);
    }
    
    @Override
    public void onLoad(Air air) {
    	ImageView view = new ImageView(airImage);
    	addEntity(air, view);
    }
    
    @Override
    public void onLoad(Water water) {
    	ImageView view = new ImageView(waterImage);
    	addEntity(water, view);
    }
    
    @Override
    public void onLoad(Fire fire) {
    	ImageView view = new ImageView(fireImage);
    	addEntity(fire, view);
    }


    private void addEntity(Entity entity, ImageView view) {
        trackPosition(entity, view);
        entities.add(view);
        
        this.map.put(entity, view);
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

    /**
     * Create a controller that can be attached to the DungeonView with all the
     * loaded entities.
     * @return
     * @throws FileNotFoundException
     */
    public DungeonController loadController() throws FileNotFoundException {
    	DungeonController controller = new DungeonController(load(), entities);
    	controller.getMap(this.map);
        return controller;
    }


}
