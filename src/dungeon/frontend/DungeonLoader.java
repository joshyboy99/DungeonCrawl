package dungeon.frontend;

import dungeon.backend.entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import dungeon.backend.*;

/**
 * Loads a dungeon from a .json file.
 *
 * By extending this class, a subclass can hook into entity creation. This is
 * useful for creating UI elements with corresponding entities.
 *
 * @author Robert Clifton-Everest
 *
 */
public abstract class DungeonLoader {
	
	private String filename;
    private JSONObject json;

    public DungeonLoader(String filename) throws FileNotFoundException {
    	this.filename = filename;
        json = new JSONObject(new JSONTokener(new FileReader("dungeons/" + filename)));
    }

    /**
     * Parses the JSON to create a dungeon.
     * @return
     */
    public Dungeon load() {
        int width = json.getInt("width");
        int height = json.getInt("height");

        Dungeon dungeon = new Dungeon(width, height);

        JSONArray jsonEntities = json.getJSONArray("entities");

        for (int i = 0; i < jsonEntities.length(); i++) {
            loadEntity(dungeon, jsonEntities.getJSONObject(i));
        }
        
        JSONObject goalCondition = json.getJSONObject("goal-condition");
        dungeon.setupGoal(goalCondition);
        
        return dungeon;
    }

    private void loadEntity(Dungeon dungeon, JSONObject json) {
        String type = json.getString("type");
        int x = json.getInt("x");
        int y = json.getInt("y");

        Entity entity = null;
        switch (type) {
        
        case "player":
            Player player = new Player(dungeon, x, y);
            dungeon.setPlayer(player);
            onLoad(player);
            entity = player;
            break;
        case "wall":
            Wall wall = new Wall(x, y, dungeon);
            onLoad(wall);
            entity = wall;
            break;
        case "exit":
        	Exit exit = new Exit(x, y, dungeon);
        	onLoad(exit);
        	entity = exit;
        	break;
        
        case "sword":
        	Sword sword = new Sword(x, y, dungeon);
        	onLoad(sword);
        	entity = sword;
        	break;

        case "boulder":
        	Boulder boulder = new Boulder(x, y, dungeon);
        	onLoad(boulder);
        	entity = boulder;
        	break;

        case "switch":
        	FloorSwitch floorSwitch = new FloorSwitch(x, y, dungeon);
        	onLoad(floorSwitch);
        	entity = floorSwitch;
        	break;

        case "enemy":
        	Enemy enemy = new Enemy(x, y, dungeon);
        	onLoad(enemy);
        	entity = enemy;
        	break;

        case "invincibility":
        	Potion potion = new Potion(x, y, dungeon);
        	onLoad(potion);
        	entity = potion;
        	break;

        case "treasure":
        	Treasure treasure = new Treasure(x, y, dungeon);
        	onLoad(treasure);
        	entity = treasure;
        	break;

        case "door":
        	int id = json.getInt("id");
        	Door door = new Door(x, y, id, dungeon);
        	onLoad(door);
        	entity = door;
        	break;

        case "key":
        	id = json.getInt("id");
        	Key key = new Key(x, y, id, dungeon);
        	onLoad(key);
        	entity = key;
        	break;
        	
        case "portal":
        	id = json.getInt("id");
        	Portal portal = new Portal(x, y, dungeon, id);
        	onLoad(portal);
        	entity = portal;
        	break;
        }
        dungeon.addEntity(entity);
        dungeon.addInitialEntity(entity);
    }
    
    
    public abstract void onLoad(Entity player);

    public abstract void onLoad(Wall wall);
    
    public abstract void onLoad(Exit exit);
    
    public abstract void onLoad(Sword sword);

    public abstract void onLoad(Boulder boulder);

    public abstract void onLoad(FloorSwitch floorSwitch);

    public abstract void onLoad(Enemy enemy);

    public abstract void onLoad(Potion potion);

    public abstract void onLoad(Treasure treasure);

    public abstract void onLoad(Door door);

    public abstract void onLoad(Key key);
    
    public abstract void onLoad(Portal portal);


    // TODO Create additional abstract methods for the other entities

}
