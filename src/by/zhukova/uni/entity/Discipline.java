package by.zhukova.uni.entity;

public class Discipline extends Entity {

	
	private String name;

	public Discipline() {
	}

	public Discipline(int id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
}
