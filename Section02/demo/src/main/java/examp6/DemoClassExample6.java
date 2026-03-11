package examp6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examp6.bean.Bike;
import examp6.bean.Engine;
import examp6.bean.Vehicle;
import examp6.config.ProjectConfig;

public class DemoClassExample6 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		if (context.containsBean("engine")) {
			Engine engine = context.getBean(Engine.class);
			System.out.println("Engine name = " + engine.getName());
		}
		if (context.containsBean("vehicle")) {
			Vehicle v = context.getBean(Vehicle.class);
			System.out.println("Vehicle name = " + v.getName());
			System.out.println("Vehicle engine = " + v.getEngine());
		}
		if (context.containsBean("bike")) {
			Bike b = context.getBean(Bike.class);
			System.out.println("Bike model = " + b.getName());
		}

	}
}
