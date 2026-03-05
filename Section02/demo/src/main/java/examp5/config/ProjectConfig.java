package examp5.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import examp5.bean.Coffe;

@Configuration
@ComponentScan(basePackages = "examp5.bean")
public class ProjectConfig {

	public final Coffe coffe;

	@Autowired
	public ProjectConfig(Coffe coffe) {
		this.coffe = coffe;
	}
}
