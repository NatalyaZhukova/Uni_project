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

	public Abiturient() {
		super.setUserType("abiturient");
	}

	public Abiturient(int id, String username, String password, String userType,
			String firstName, String middleName, String lastName,
			int firstScore, int secondScore, int thirdScore, int schoolScore,
			int overallScore, int chosenFaculty) {
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

	@Override
	public String toString() {
		return "Abiturient [id "+ getId()+" username "+ getUsername() + " firstName=" + firstName + ", middlName="
				+ middleName + ", lastName=" + lastName + ", firstScore="
				+ firstScore + ", secondScore=" + secondScore + ", thirdScore="
				+ thirdScore + ", schoolScore=" + schoolScore
				+ ", overallScore=" + overallScore + ", chosenFaculty="
				+ chosenFaculty + "]";
	}
	
	

}
