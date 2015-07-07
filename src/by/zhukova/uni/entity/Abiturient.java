package by.zhukova.uni.entity;

public class Abiturient extends User {

	private String firstName;
	private String middleName;
	private String lastName;

	private int firstScore;
	private int secondScore;
	private int thirdScore;
	private int schoolScore;
	private int overallScore;
	private int chosenFaculty;
	private String status;

	public Abiturient() {
		super.setUserType("abiturient");
		setStatus("waiting");
	}

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middlName) {
		this.middleName = middlName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

	public int getThirdScore() {
		return thirdScore;
	}

	public void setThirdScore(int thirdScore) {
		this.thirdScore = thirdScore;
	}

	public int getSchoolScore() {
		return schoolScore;
	}

	public void setSchoolScore(int schoolScore) {
		this.schoolScore = schoolScore;
	}

	public int getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(int score) {
		this.overallScore = score;
	}

	public int getChosenFaculty() {
		return chosenFaculty;
	}

	public void setChosenFaculty(int chosenFaculty) {
		this.chosenFaculty = chosenFaculty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Abiturient [firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", firstScore="
				+ firstScore + ", secondScore=" + secondScore + ", thirdScore="
				+ thirdScore + ", schoolScore=" + schoolScore
				+ ", overallScore=" + overallScore + ", chosenFaculty="
				+ chosenFaculty + ", status=" + status + "]";
	}

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
