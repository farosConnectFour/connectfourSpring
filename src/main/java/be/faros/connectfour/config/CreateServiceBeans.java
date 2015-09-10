package be.faros.connectfour.config;

import be.faros.connectfour.services.UserService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = UserService.class)
public class CreateServiceBeans {

}