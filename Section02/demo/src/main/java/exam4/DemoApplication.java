package exam4;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exam4.bean.Person;
import exam4.bean.Vehicle;
import exam4.config.VehicleConfig;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(DemoApplication.class,
		// args);

		var context = new AnnotationConfigApplicationContext(VehicleConfig.class);

		Vehicle bean = context.getBean(Vehicle.class);
		System.out.println(bean);

		Person person = context.getBean(Person.class);
		System.out.println(person);

		context.close();

	}

}
