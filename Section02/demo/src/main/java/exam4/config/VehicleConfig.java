package exam4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import exam4.bean.Person;
import exam4.bean.Vehicle;

@Configuration
public class VehicleConfig {

	@Bean
	public Person person(Vehicle vehicle) {
		var person = new Person();
		person.setName("jack");
		person.setVehicle(vehicle); // Autowiring by method parameter
		return person;
	}
	
	@Bean
	public Vehicle vehicle() {
		var vehicle = new Vehicle();
		vehicle.setName("audi");
		return vehicle;
	}

//	@Bean
//	public Person person() {
//		var person = new Person();
//		person.setName("jack");
//		person.setVehicle(vehicle()); //Autowiring by method call
//		return person;
//	}

}
