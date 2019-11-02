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
 * @author Robert Clifton-Everest
 *
 */

public class Dungeon implements Observable {

    private int width, height;
    private List<Entity> entities;
    private Player player;
    private GoalManager goalManager;
    private boolean fail;
    private List<Entity> observers;

    public Dungeon(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.player = null;
        this.goalManager = null;
        this.fail = false;
        
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
        this.goalManager = new GoalManager(this, player);
    }

    public void addEntity(Entity entity) {
    	if (entity instanceof Observer) {
    		System.out.print(entity);
    		addObserver( (Observer) entity);
    	}
        entities.add(entity);
    }
    
    public List<Entity> getEntities() {
    	return this.entities;
    }
    
    //scan tile, invoke contact behavior on entity which touched tile. Will return false if tile cannot be walked over.
    public void scanTile(Entity touched, int x, int y) {
//    	for(Entity e: entities) {
//    		if (e.samePosition(x, y)) {
//    			e.performTouch(touched);
//    		}
//    	}	
    	
    	for (Entity e: EntitiesOnTile(x,y)) {
    		e.performTouch(touched);
    	}

    }
    
    public List<Entity> EntitiesOnTile(int x, int y) {
    	
    	List<Entity> entList = new ArrayList<Entity>();
    	
		for(Entity e: entities) {
    		if(e.samePosition(x, y)) {
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
    
    public void removeEntity(Entity e) {
    	
//	    	if(e instanceof Pickup) {
//	    		if(player.checkInventory((Pickup) e)) {
//	    			player.removeItem((Pickup) e);
//	    		}
//	    	}
    	entities.remove(e);
    }
    
    public boolean checkEntitiesOnDungeon(Entity e) {
    	return this.entities.contains(e);
    }
    
    // set up goals
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
		// TODO Auto-generated method stub
		observers.add((Entity)o);

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove((Entity)o);
	}

	@Override
	public void updateDungeon() {
		for (Entity e : this.observers) {
			((Observer)e).update(player);
		}
	}
}

   
