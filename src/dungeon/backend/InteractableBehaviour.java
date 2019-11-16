package dungeon.backend;

import java.util.ArrayList;
import java.util.List;

import dungeon.backend.entity.*;



/**
 * This Abstract class is responsible for the series of behaviours that involves
 * the interaction between the holder of a behaviour, and another entity. Whether that be
 * touching another entity or picking it up, this class facilitates those entity-entity ineractions.
 * @author JAG
 *
 */
public abstract class InteractableBehaviour extends Behaviour {
	
	/**
	 * A list of entity classes that this behavior will perform its 
	 * interactions with. 
	 */
	protected List<Entity> ValidEntities;
	
	public InteractableBehaviour(Entity attached) {
		super(attached);
		this.ValidEntities = new ArrayList<Entity>();
	}
	
	/**
	 * This method checks if an incoming entity is valid to be interacted with
	 * @param e the incoming entity
	 * @return true if the entity is valid for interaction, false otherwise. 
	 */
	protected boolean checkValidEntityClass(Entity e) {
		for (Entity ie : ValidEntities) {
			if(ie == null) {
				continue;
			}
			if(e.getClass().equals(ie.getClass())) {
				return true;
			}
		}
		return false;
	}
	
	public void addEntity(Entity e) {
		this.ValidEntities.add(e);
	}
	
	protected void removeEntity(Entity e) {
		this.ValidEntities.remove(e);
	}
}
