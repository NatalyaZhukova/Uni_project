/*
 * The package contains classes which store information from database 
 */
package by.zhukova.uni.entity;

/**
 * Class {@code Faculty} stores information from database table
 * {@code faculties}.
 */
public class Faculty extends Entity {

	private static final long serialVersionUID = 1L;

	/** The name of faculty. */
	private String name;

	/** The admission plan to the faculty. */
	private int facultyPlan;

	/** The identifier of the first discipline. */
	private int firstDiscipline;

	/** The identifier of the second discipline. */
	private int secondDiscipline;

	/** The identifier of the third discipline. */
	private int thirdDiscipline;

	/**
	 * Instantiates a new faculty.
	 */
	public Faculty() {
	}

	/**
	 * Instantiates a new faculty.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param facultyPlan
	 *            the admission plan
	 * @param firstDiscipline
	 *            the id of the first discipline
	 * @param secondDiscipline
	 *            the id of the second discipline
	 * @param thirdDiscipline
	 *            the id of the third discipline
	 */
	public Faculty(int id, String name, int facultyPlan, int firstDiscipline, int secondDiscipline,
			int thirdDiscipline) {
		super(id);
		this.name = name;
		this.facultyPlan = facultyPlan;
		this.firstDiscipline = firstDiscipline;
		this.secondDiscipline = secondDiscipline;
		this.thirdDiscipline = thirdDiscipline;
	}

	/**
	 * Gets the faculty name.
	 *
	 * @return the faculty name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the faculty name.
	 *
	 * @param name
	 *            the new faculty name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the admission plan of the faculty.
	 *
	 * @return the admission plan of the faculty
	 */
	public int getFacultyPlan() {
		return facultyPlan;
	}

	/**
	 * Sets the admission plan of the faculty.
	 *
	 * @param facultyPlan
	 *            the new admission plan
	 */
	public void setFacultyPlan(int facultyPlan) {
		this.facultyPlan = facultyPlan;
	}

	/**
	 * Gets the identifier of the first discipline.
	 *
	 * @return the id of the first discipline
	 */
	public int getFirstDiscipline() {
		return firstDiscipline;
	}

	/**
	 * Sets the identifier of the first discipline.
	 *
	 * @param firstDiscipline
	 *            the new id of the first discipline
	 */
	public void setFirstDiscipline(int firstDiscipline) {
		this.firstDiscipline = firstDiscipline;
	}

	/**
	 * Gets the identifier of the second discipline.
	 *
	 * @return the id of the second discipline
	 */
	public int getSecondDiscipline() {
		return secondDiscipline;
	}

	/**
	 * Sets the identifier of the second discipline.
	 *
	 * @param secondDiscipline
	 *            the new id of the second discipline
	 */
	public void setSecondDiscipline(int secondDiscipline) {
		this.secondDiscipline = secondDiscipline;
	}

	/**
	 * Gets the identifier of the third discipline.
	 *
	 * @return the id of the third discipline
	 */
	public int getThirdDiscipline() {
		return thirdDiscipline;
	}

	/**
	 * Sets the identifier of the third discipline.
	 *
	 * @param thirdDiscipline
	 *            the new id of the third discipline
	 */
	public void setThirdDiscipline(int thirdDiscipline) {
		this.thirdDiscipline = thirdDiscipline;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see by.zhukova.uni.entity.Entity#toString()
	 */
	@Override
	public String toString() {
		return "Faculty [name=" + name + ", facultyPlan=" + facultyPlan + ", firstDiscipline=" + firstDiscipline
				+ ", secondDiscipline=" + secondDiscipline + ", thirdDiscipline=" + thirdDiscipline + ", getId()="
				+ getId() + ", toString()=" + super.toString();
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
		result = prime * result + facultyPlan;
		result = prime * result + firstDiscipline;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + secondDiscipline;
		result = prime * result + thirdDiscipline;
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
		if (!(obj instanceof Faculty)) {
			return false;
		}
		Faculty other = (Faculty) obj;
		if (facultyPlan != other.facultyPlan) {
			return false;
		}
		if (firstDiscipline != other.firstDiscipline) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (secondDiscipline != other.secondDiscipline) {
			return false;
		}
		if (thirdDiscipline != other.thirdDiscipline) {
			return false;
		}
		return true;
	}

}
