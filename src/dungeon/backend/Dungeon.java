/**
 *
 */
package dungeon.backend;

import dungeon.backend.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author Robert Clifton-Everest
 *
 */

public class Dungeon {

    private int width, height;
    private List<Entity> entities;
    private Player player;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.player = null;
        
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
    
    public List<Entity> getEntities() {
    	return this.entities;
    }
    
    //scan tile, invoke contact behavior on entity which touched tile. Will return false if tile cannot be walked over.
    public void scanTile(Entity touched, int x, int y) {
    	for(Entity e: EntitiesOnTile(x,y)) {
    			e.performTouch(touched);
		}	
    }
    
    public List<Entity> EntitiesOnTile(int x, int y) {
    	
    	List<Entity> entList = new ArrayList<Entity>();
    	
		for(Entity e: entities) {
    		if(e.getX() == x && e.getY() == y) {
    			entList.add(e);
    		}
    	}
		
		return entList;
    }
    
    public Portal getGetPortalPair(Portal portal,int ID) {
    	for(Entity entity : this.entities) {
    		//first, find entities which are portals
    		if(entity instanceof Portal) {
    			//force entity to act as portal
    			Portal p = (Portal) entity;
    			//check if same ID, and also is not same portal being passed thru
    			if(p.getportalID() == ID && portal.equals(p) == false) {
    				return p;
    			}
    		}
    	}
		return portal;
    }
}
