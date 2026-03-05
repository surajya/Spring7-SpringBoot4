package exam4.bean;

import lombok.Data;

@Data
public class Vehicle {

	public Vehicle() {
		System.out.println("Vehicle constructor called");
	}

	String name;

}
