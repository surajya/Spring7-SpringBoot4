package examp7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import examp7.bean.MyService;
import examp7.config.ProjectConfig;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		MyService bean1 = context.getBean(MyService.class);
		MyService bean2 = context.getBean(MyService.class);
		System.out.println(bean1.hashCode() + "\n" + bean2.hashCode());
	}

}
