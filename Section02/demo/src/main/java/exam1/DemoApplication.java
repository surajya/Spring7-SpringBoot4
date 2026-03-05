package exam1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

//		Vehicle bean = context.getBean(Vehicle.class);
//		System.out.println(bean.getName());

		Vehicle bean2 = context.getBean("vehicle2", Vehicle.class);
		System.out.println(bean2.getName());
	}

}
