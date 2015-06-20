package by.zhukova.uni.entity;

public class Faculty extends Entity {

	
	private String name;
	private int facultyPlan;
	private int firstDiscipline;
	private int secondDiscipline;
	private int thirdDiscipline;
	
	public Faculty() {}
	
	
	
	public Faculty(int id, String name, int facultyPlan, int firstDiscipline,
			int secondDiscipline, int thirdDiscipline) {
		super(id);
		this.name = name;
		this.facultyPlan = facultyPlan;
		this.firstDiscipline = firstDiscipline;
		this.secondDiscipline = secondDiscipline;
		this.thirdDiscipline = thirdDiscipline;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFacultyPlan() {
		return facultyPlan;
	}

	public void setFacultyPlan(int facultyPlan) {
		this.facultyPlan = facultyPlan;
	}

	public int getFirstDiscipline() {
		return firstDiscipline;
	}

	public void setFirstDiscipline(int firstDiscipline) {
		this.firstDiscipline = firstDiscipline;
	}

	public int getSecondDiscipline() {
		return secondDiscipline;
	}

	public void setSecondDiscipline(int secondDiscipline) {
		this.secondDiscipline = secondDiscipline;
	}

	public int getThirdDiscipline() {
		return thirdDiscipline;
	}

	public void setThirdDiscipline(int thirdDiscipline) {
		this.thirdDiscipline = thirdDiscipline;
	}

}
