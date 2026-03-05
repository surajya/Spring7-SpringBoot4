package exam2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Primary;

@Configuration
public class VehicleConfig {

	@Bean(name = "scarpio")
	public Vehicle vehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Scarpio");
		return vehicle;
	}

	@Bean(value = "fortuner")
	public Vehicle vehicle2() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Fortuner");
		return vehicle;
	}

	@Bean
	@Description("This is a description for vehicle3")
	@Primary
	public Vehicle vehicle3() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Innova");
		return vehicle;
	}

	@Bean
	public String name() {
		return "This is a name bean";
	}
}
