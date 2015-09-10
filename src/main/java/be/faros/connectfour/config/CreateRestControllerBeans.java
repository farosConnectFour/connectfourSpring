package be.faros.connectfour.config;

import be.faros.connectfour.restcontrollers.UserRestController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by juchtdi on 9/09/2015.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = UserRestController.class)
public class CreateRestControllerBeans {

}
