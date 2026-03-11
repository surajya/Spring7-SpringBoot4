package examp6.bean;

public class Bike {
	String name;

	public Bike() {
		System.out.println("Bike constructor called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Bike [name=" + name + "]";
	}
}
