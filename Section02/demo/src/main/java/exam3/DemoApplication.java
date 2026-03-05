package exam3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(DemoApplication.class,
		// args);

		var context = new AnnotationConfigApplicationContext(VehicleConfig.class);

		Vehicle bean = context.getBean(Vehicle.class);
		System.out.println(bean.getName());

		context.close();

	}

}
