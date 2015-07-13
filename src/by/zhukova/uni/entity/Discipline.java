/*
 * The package contains classes which store information from database 
 */
package by.zhukova.uni.entity;

/**
 * Class {@code Discipline} stores the information from database table
 * {@code disciplines}
 * 
 * @author Natallya Zhukova
 * @since 1.0
 */
public class Discipline extends Entity {

	/** The name of discipline. */
	private String name;

	/**
	 * Instantiates a new discipline.
	 */
	public Discipline() {
	}

	/**
	 * Instantiates a new discipline.
	 *
	 * @param id
	 *            the identifier
	 * @param name
	 *            the name
	 */
	public Discipline(int id, String name) {
		super(id);
		this.name = name;
	}

	/**
	 * Gets the name of discipline.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of discipline.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.zhukova.uni.entity.Entity#toString()
	 */
	@Override
	public String toString() {
		return super.toString() + "Discipline [name=" + name + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.zhukova.uni.entity.Entity#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.zhukova.uni.entity.Entity#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Discipline)) {
			return false;
		}
		Discipline other = (Discipline) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
