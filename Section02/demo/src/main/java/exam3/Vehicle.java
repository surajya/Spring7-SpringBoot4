package exam3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Vehicle implements InitializingBean, DisposableBean {

	String name;

//	@PostConstruct
//	public void init() {
//		this.name = "audi";
//	}

//	@PreDestroy
//	public void destroy() {
//		System.out.println("destroy Vehicle class");
//	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		this.name = "tesla";
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("destroy Vehicle class using DisposableBean");
	}

}
