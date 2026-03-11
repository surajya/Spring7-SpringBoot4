package examp6.config;

import java.util.Random;

import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;

import examp6.bean.Bike;
import examp6.bean.Engine;
import examp6.bean.Vehicle;

public class MyRegisterBean implements BeanRegistrar {

	@Override
	public void register(BeanRegistry registry, Environment env) {
		// TODO Auto-generated method stub
		int num = new Random().nextInt(100);
		System.out.println("Random number generated: " + num);
		if (num % 2 == 0) {

			registry.registerBean("engine", Engine.class, spec -> spec.supplier(context -> {
				Engine engine = new Engine();
				engine.setName("Latest Engine");
				return engine;
			}));

			registry.registerBean("vehicle", Vehicle.class, spec -> spec.supplier(context -> {
				Engine engine = context.bean(Engine.class);
				Vehicle vehicle = new Vehicle(engine);
				vehicle.setName("Car");
				return vehicle;
			}));

		} else {
			registry.registerBean("bike", Bike.class, spec -> spec.supplier(context -> {
				Bike bike = new Bike();
				bike.setName("Mountain Bike");
				return bike;
			}));
		}

	}
}
