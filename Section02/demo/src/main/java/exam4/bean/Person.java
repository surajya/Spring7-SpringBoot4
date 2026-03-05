package exam4.bean;

import lombok.Data;

@Data
public class Person {

	String name;

	Vehicle vehicle;

	public Person() {
		System.out.println("Person constructor called");
	}
}
