package exam1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

	@Bean
	public Vehicle vehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Scarpio");
		return vehicle;
	}

	@Bean
	public Vehicle vehicle2() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Fortuner");
		return vehicle;
	}

	@Bean
	public Vehicle vehicle3() {
		Vehicle vehicle = new Vehicle();
		vehicle.setName("Innova");
		return vehicle;
	}

}
