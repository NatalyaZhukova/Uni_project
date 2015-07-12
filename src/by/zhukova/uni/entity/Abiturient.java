/*
 * The package contains classes which store information from database 
 */

package by.zhukova.uni.entity;


/** 
 * Class {@code Abiturient} stores information from database table {@code abiturients}
 *  
 * @author Natallya Zhukova
 * @since 1.0
 * 
 * */

public class Abiturient extends User {

	/** The first name. */
	private String firstName;
	
	/** The middle name. */
	private String middleName;
	
	/** The last name. */
	private String lastName;

	/** The  score of first discipline. */
	private int firstScore;
	
	/**  The  score of second discipline. */
	private int secondScore;
	
	/**  The  score of third discipline. */
	private int thirdScore;
	
	/** The average school mark transformed to double-digit number. */
	private int schoolScore;
	
	/** The sum of all scores. */
	private int overallScore;
	
	/** Identifier of chosen faculty. */
	private int chosenFaculty;
	
	/** The status of registered application. */
	private String status;

	/**
	 * Instantiates a new application.
	 */
	public Abiturient() {
		super.setUserType("abiturient");
		setStatus("waiting");
	}

	/**
	 * Instantiates a new application.
	 *
	 * @param id the id
	 * @param username the username
	 * @param password the password
	 * @param userType the user type
	 * @param firstName the first name
	 * @param middleName the middle name
	 * @param lastName the last name
	 * @param firstScore the  score of the first discipline
	 * @param secondScore the  score of the second discipline
	 * @param thirdScore the  score of the third discipline
	 * @param schoolScore the average school mark
	 * @param overallScore the sum of all scores
	 * @param chosenFaculty the chosen faculty
	 * @param status the status of registered application
	 */
	public Abiturient(int id, String username, String password, String userType,
			String firstName, String middleName, String lastName,
			int firstScore, int secondScore, int thirdScore, int schoolScore,
			int overallScore, int chosenFaculty, String status) {
		super(id, username, password, userType);
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
		this.schoolScore = schoolScore;
		this.overallScore = overallScore;
		this.chosenFaculty = chosenFaculty;
		this.status = status;
		
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middlName the new middle name
	 */
	public void setMiddleName(String middlName) {
		this.middleName = middlName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the score of the first discipline.
	 *
	 * @return the score of the first discipline
	 */
	public int getFirstScore() {
		return firstScore;
	}

	/**
	 * Sets the score of the first discipline.
	 *
	 * @param firstScore the new  score of the first discipline
	 */
	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	/**
	 * Gets the score of the second discipline.
	 *
	 * @return the score of the second discipline
	 */
	public int getSecondScore() {
		return secondScore;
	}

	/**
	 * Sets the score of the second discipline.
	 *
	 * @param secondScore the new score of the second discipline
	 */
	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

	/**
	 * Gets the score of the third discipline.
	 *
	 * @return the score of the third discipline
	 */
	public int getThirdScore() {
		return thirdScore;
	}

	/**
	 * Sets the score of the third discipline.
	 *
	 * @param thirdScore the new score of the third discipline
	 */
	public void setThirdScore(int thirdScore) {
		this.thirdScore = thirdScore;
	}

	/**
	 * Gets the average school mark transformed to double-digit number.
	 *
	 * @return the average school mark transformed to double-digit number
	 */
	public int getSchoolScore() {
		return schoolScore;
	}

	/**
	 * Sets the average school mark transformed to double-digit number.
	 *
	 * @param schoolScore the new average school mark transformed to double-digit number
	 */
	public void setSchoolScore(int schoolScore) {
		this.schoolScore = schoolScore;
	}

	/**
	 * Gets the sum of all scores.
	 *
	 * @return the sum of all scores
	 */
	public int getOverallScore() {
		return overallScore;
	}

	/**
	 * Sets the sum of all scores.
	 *
	 * @param score the new sum of all scores
	 */
	public void setOverallScore(int score) {
		this.overallScore = score;
	}

	/**
	 * Gets the identifier of chosen faculty.
	 *
	 * @return the identifier of chosen faculty
	 */
	public int getChosenFaculty() {
		return chosenFaculty;
	}

	/**
	 * Sets the identifier of chosen faculty.
	 *
	 * @param chosenFaculty the new identifier of chosen faculty
	 */
	public void setChosenFaculty(int chosenFaculty) {
		this.chosenFaculty = chosenFaculty;
	}

	/**
	 * Gets the status of registered application.
	 *
	 * @return the status of registered application
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of registered application.
	 *
	 * @param status the new status of registered application
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	
	/* (non-Javadoc)
	 * @see by.zhukova.uni.entity.User#toString()
	 */
	@Override
	public String toString() {
		return super.toString()+ "Abiturient [firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", firstScore="
				+ firstScore + ", secondScore=" + secondScore + ", thirdScore="
				+ thirdScore + ", schoolScore=" + schoolScore
				+ ", overallScore=" + overallScore + ", chosenFaculty="
				+ chosenFaculty + ", status=" + status + "]";
	}

	
	/* (non-Javadoc)
	 * @see by.zhukova.uni.entity.User#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + chosenFaculty;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + firstScore;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + overallScore;
		result = prime * result + schoolScore;
		result = prime * result + secondScore;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + thirdScore;
		return result;
	}

	
	/* (non-Javadoc)
	 * @see by.zhukova.uni.entity.User#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Abiturient)) {
			return false;
		}
		Abiturient other = (Abiturient) obj;
		if (chosenFaculty != other.chosenFaculty) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (firstScore != other.firstScore) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}
		if (overallScore != other.overallScore) {
			return false;
		}
		if (schoolScore != other.schoolScore) {
			return false;
		}
		if (secondScore != other.secondScore) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (thirdScore != other.thirdScore) {
			return false;
		}
		return true;
	}

	
	
	

}
