package examp5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examp5.bean.Coffe;
import examp5.config.ProjectConfig;

public class DemoApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Coffe bean = context.getBean(Coffe.class);
		System.out.println(bean.makeCoffe());
	}

}
