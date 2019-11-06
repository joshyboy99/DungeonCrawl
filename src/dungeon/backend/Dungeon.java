/**
 *
 */
package dungeon.backend;

import dungeon.backend.entity.*;
import dungeon.backend.goal.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

/**
 * A dungeon in the interactive dungeon player.
 *
 * A dungeon can contain many entities, each occupy a square. More than one
 * entity can occupy the same square.
 *
 * @author JAG
 *
 */

public class Dungeon implements Observable {

    private int width, height;
    private List<Entity> entities;
    private List<Entity> observers;
    private boolean fail;
    private Player player;
    private GoalManager goalManager;
    private static int doors;

    /**
     * A constructor for the Dungeon Class. 
     * @param width The width of the Dungeon
     * @param height The Height of the Dungeon
     */
    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.player = null;
        this.goalManager = null;
        this.fail = false;
        this.doors = 0;
        
    }
    

    /**
     * Getter of the Dungeon's Width
     * @return The Width of the Dungeon
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Getter of the Dungeon's Height
     * @return The Height of the Dungeon
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Getter of the Dungeon's Player
     * @return The Player that Belong in the Dungeon
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Setter of the Player in Dungeon. 
     * It instantiate the goalManager, making sure that this goal is 
     * for this particular player. 
     * @param player Setting the Player in belongs in Dungeon. 
     */
    public void setPlayer(Player player) {
        this.player = player;
        this.goalManager = new GoalManager(this, player);
    }

    /**
     * While importing Entity, it checks if it's an observer,
     * so it gets added into the list. Then subsequently into 
     * the own entities' list.
     * @param entity
     */
    public void addEntity(Entity entity) {
    	if (entity instanceof Observer) {
    		addObserver( (Observer) entity);
    	}
    	if (entity instanceof Door) {
    		if (doors == 3) return;
    		doors++;
    	}
        entities.add(entity);
    }
    
    /**
     * Getter of entities of the Dungeon
     * @return Dungeon's entities.
     */
    public List<Entity> getEntities() {
    	return this.entities;
    }
    
    /**
     * Scan tile, invoke contact behavior on entity which touched tile. 
     *  
     * @param touched The entity that touches 
     * @param x The x coordinate of where the interact entity
     * @param y The y coordinate of where the interact entity
     */
    public void scanTile(Entity touched, int x, int y) {

    	for (Entity e: EntitiesOnTile(x,y)) {
    		e.performTouch(touched);
    	}

    }
    
    /**
     * The list of entities on that particular tile. 
     * 
     * @param x The x coordinate of that tile
     * @param y The y coordinate of that tile
     * @return List of the entities
     */
    public List<Entity> EntitiesOnTile(int x, int y) {
    	
    	List<Entity> entList = new ArrayList<Entity>();
    	
		for(Entity e: entities) {
    		if(e.samePosition(x, y)) {
    			entList.add(e);
    		}
    	}
		
		return entList;
    }
    
    /**
     * Finds the other portal with the same ID within the same 
     * Dungeon 
     * @param portal Initial portal 
     * @param ID Initial ID of initial portal
     * @return Portal of the new Portal
     */
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
    
    /**
     * Remove the entity within dungeon
     * @param e The entity ready to be removed
     */
    public void removeEntity(Entity e) {
    	
//	    	if(e instanceof Pickup) {
//	    		if(player.checkInventory((Pickup) e)) {
//	    			player.removeItem((Pickup) e);
//	    		}
//	    	}
    	entities.remove(e);
    }
    
    /**
     * Checks if the Entity is still in Dungeon 
     * @param e
     * @return
     */
    public boolean checkEntitiesOnDungeon(Entity e) {
    	return this.entities.contains(e);
    }

    
    public void setupGoal(JSONObject goalCondition) {
    	goalManager.setGoal(goalCondition);
    }

    public Goal getGoal() {
    	return goalManager.getGoal();
    }

    public boolean isComplete() {
    	return goalManager.checkComplete();
    }
    
    public void failStage() {
    	this.fail = true;
    }

    public boolean isFail() {
    	return this.fail;
    }
    
    public List<Entity> getObservers() {
    	return this.observers;
    }
    

	@Override
	public void addObserver(Observer o) {
		observers.add((Entity)o);

	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove((Entity)o);
	}

	@Override
	public void updateDungeon() {
		for (Entity e : this.observers) {
			((Observer)e).update(player);
		}
	}
}

   
