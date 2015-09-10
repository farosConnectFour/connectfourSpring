package be.faros.connectfour.config;

import be.faros.connectfour.socketcontrollers.UserSocketController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by juchtdi on 10/09/2015.
 */
@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackageClasses = UserSocketController.class)
public class CreateWebsocketBeans extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gamePlayed").setAllowedOrigins("*").withSockJS();
    }
}
