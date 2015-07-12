/*
 * The package contains classes which store information from database 
 */
package by.zhukova.uni.entity;

import java.io.Serializable;


/**
 * 
 * Class {@code Entity} is the root of the entity hierarchy for this project.
 * All other classes in package {@code by.zhukova.uni.entity} has {@code Entity} as a superclass
 * 
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */

public abstract class Entity implements Serializable {
    
    /**   Identifier of entity object . */
	private int id;
	
	/**
	 * Instantiates a new entity.
	 *
	 * @param id the id
	 */
	Entity(int id) {
		this.setId(id);
	}
	
	/**
	 * Instantiates a new entity.
	 */
	Entity() {}
	
	/**
	 *  
	 * Getter  for field id.
	 *
	 * @return identifier of object
	 */

	public int getId() {
		return id;
	}
	
	/**
	 *  
	 * Setter for field id.
	 *
	 * @param id the new id
	 */

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Entity)) {
			return false;
		}
		Entity other = (Entity) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	
}
