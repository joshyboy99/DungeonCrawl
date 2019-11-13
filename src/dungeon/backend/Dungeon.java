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
 * The Dungeon is the world in which all the entities exist.
 * It is described by a set of 2D coordinates and a list of 
 * entities that can be at these coordinates. 
 *
 * @author JAG
 *
 */

public class Dungeon implements Observable {
	
	/**
	 * The maximum x and y values of this dungeon's coordinate system.
	 */
    private int width, height;
    
    /**
     * A list containing all entities that have ever
     * been loaded to the current dungeon. 
     */
    private List<Entity> initialEntities;
    
    

	/**
     * The list of entity objects contained within this dungeon
     */
    private List<Entity> entities;
    
    /**
     * The list of objects this dungeon is observing.
     */
    private List<Entity> observers;
    
    /**
     * A state of the dungeon describing whether or not the player 
     * has triggered a fail condition.
     */
    private boolean fail;
    
    /**
     * The player entity who inhabits this dungeon, generally controlled by a user.
     */
    private Player player;
    
    /**
     * The Set of methods responsible for monitoring and allocating the goals of this
     * dungeon to be completed by the player.
     */
    private GoalManager goalManager;
    
    /**
     * Describes the number of doors that have been unlocked within this dungeon,
     * which can be used as a goal-condition.
     */
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
        this.initialEntities = new ArrayList<>();
        this.player = null;
        this.goalManager = null;
        this.fail = false;
        Dungeon.doors = 0;
        
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
     * This Method sets the player of the dungeon to be one that
	 * is entered as a variable.
     * It instantiates the goalManager, making sure that this goal is 
     * for this particular player. 
     * @param player Setting the Player in belongs in Dungeon. 
     */
    public void setPlayer(Player player) {
        this.player = player;
        this.goalManager = new GoalManager(this, player);
    }

    /**
     * This method adds a new entity to the dungeon. 
     * While importing the Entity, it checks if it's an observer and 
     * if so it gets added into the list of entities
     * and observers. 
     * It also checks if the entity is a door, that it is within
     * the maximum allowable number of doors. 
     * @param entity the entity to be added to the dungeon.
     */
    public void addEntity(Entity entity) {
    	
    	if (entity instanceof Observer) {
    		addObserver( (Observer) entity);
    	}
    	
    	if (entity instanceof Door) {
    		if(doors < 3) {
    			doors++;
    		}
    		else {
    			return;
    		}
    	}
    	
        entities.add(entity);
    }
    
    /**
     * Returns a list of Entity objects stored in Dungeon
     * @return the list of entities in this dungeon
     */
    public List<Entity> getEntities() {
    	return this.entities;
    }
    
    /**
     * Scan Tile invokes the contactBehaviour of all entities of a given
     * tile.
     *  
     * @param toucher The entity that touches this space.
     * @param x The x coordinate of where the interaction occurs.
     * @param y The y coordinate of where the interaction occurs.
     */
    public void scanTile(Entity toucher, int x, int y) {
    	for (Entity e: EntitiesOnTile(x,y)) {
    		e.performTouch(toucher);
    	}
    }
 
    
    /**
     * Returns a list of entities at a given coordinate.  
     * 
     * @param x The x coordinate of that tile
     * @param y The y coordinate of that tile
     * @return List of the entity objects at the specified location
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
     * Finds the corresponding portal with the same ID within the same 
     * Dungeon. Searches the entity list for portals and compares each 
     * portal id with that of the known portal. 
     * @param portal the known portal 
     * @param ID the Portal-ID of known portal
     * @return Portal the found Portal
     */
    public Portal getPortalPair(Portal portal) {
    	
    	for(Entity entity : this.entities) {
    		
    		if(entity instanceof Portal) {
    			Portal p = (Portal) entity;
    			if(p.getportalID() == portal.getportalID() && portal.equals(p) == false) {
    				return p;
    			}
    		}
    		
    	}
    	
		return portal;
    }
    
    /**
     * This Method removes a target entity from the dungeon
     * @param e The entity ready to be removed
     */
    public void removeEntity(Entity e) {
    	entities.remove(e);
    }
    
    /**
     * Checks if the Entity is still in Dungeon 
     * @param e the entity to be searched for
     * @return true if the entity is found, false otherwise
     */
    public boolean checkEntitiesOnDungeon(Entity e) {
    	return this.entities.contains(e);
    }

    /**
     * sets a new goal for the goal manager
     * @param goalCondition the new goal condition as JSON
     */
    public void setupGoal(JSONObject goalCondition) {
    	goalManager.setGoal(goalCondition);
    }

    /**
     * Returns the composite goal from goal manager
     * @return the composite goal object from goal manger. 
     */
    public Goal getGoal() {
    	return goalManager.getGoal();
    }
    
    /**
     * Checks if all dungeon goals have been completed.
     * @return true if the dungeon goals are complete, false otherwise.
     */
    public boolean isComplete() {
    	return goalManager.checkComplete();
    }
    
    /**
     * Sets the status of this dungeon to failed. 
     */
    public void failStage() {
    	this.fail = true;
    }

    /**
     * Used to check if the dungeon has been failed.
     * @return true if the dungeon has failed, false otherwise. 
     */
    public boolean isFail() {
    	return this.fail;
    }
    
    /**
     * Used to get the list of observer entities in this class. 
     * @return
     */
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
		if (!this.checkEntitiesOnDungeon(player)) {
			this.failStage();
			return;
		}
		for (Entity e : this.observers) {
			((Observer)e).update(player);
		}
	}
	
	public void addInitialEntity(Entity e) {
		this.initialEntities.add(e);
	}
	
	public List<Entity> getInitialEntities() {
		return initialEntities;
	}

	public void setInitialEntities(List<Entity> initialEntities) {
		this.initialEntities = initialEntities;
	}
}

   
