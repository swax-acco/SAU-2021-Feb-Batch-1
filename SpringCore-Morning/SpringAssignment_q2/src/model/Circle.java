package model;

public class Circle {

	private String name;

	public String getName() throws Exception {
		throw new Exception("Circle getName Exception");
		// return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
