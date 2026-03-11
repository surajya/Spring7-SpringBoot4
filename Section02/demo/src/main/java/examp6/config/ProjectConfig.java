package examp6.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyRegisterBean.class)
public class ProjectConfig {

}
