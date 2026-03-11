package examp6.bean;

public class Vehicle {
	String name;
	Engine engine;

	public Vehicle(Engine engine) {
		this.engine = engine;
		System.out.println("Vehicle constructor called");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Engine getEngine() {
		return engine;
	}

	public String toString() {
		return "Vehicle [name=" + name + ", engine=" + engine + "]";
	}
}
