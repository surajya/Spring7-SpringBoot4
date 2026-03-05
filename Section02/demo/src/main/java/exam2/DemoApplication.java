package exam2;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(DemoApplication.class,
		// args);

		var context = new AnnotationConfigApplicationContext(VehicleConfig.class);

		Vehicle bean = context.getBean("scarpio", Vehicle.class);
		System.out.println(bean.getName());

		Vehicle bean2 = context.getBean("fortuner", Vehicle.class);
		System.out.println(bean2.getName());

		Vehicle bean3 = context.getBean(Vehicle.class);
		System.out.println(bean3.getName());

		String name = context.getBean("name", String.class);
		System.out.println(name);
	}

}
