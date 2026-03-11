package examp7.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(BeanDefinition.SCOPE_SINGLETON)
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MyService {

	public MyService() {
		// TODO Auto-generated constructor stub
		System.out.println("MyService constructor called");
	}

}
