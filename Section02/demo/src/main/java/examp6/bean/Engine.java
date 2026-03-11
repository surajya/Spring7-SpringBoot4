package examp6.bean;

public class Engine {
	String name;

	public Engine() {
		System.out.println("Engine constructor called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Engine [name=" + name + "]";
	}

}
