package com.sp.jobportal.client.config;

import com.sp.jobportal.client.PostServicesInf;
import com.sp.jobportal.client.TodoServicesInf;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(types = {TodoServicesInf.class, PostServicesInf.class})
public class HttpServiceClientConfig {
}
