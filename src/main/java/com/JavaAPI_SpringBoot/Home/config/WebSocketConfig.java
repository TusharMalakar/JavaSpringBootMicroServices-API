package com.JavaAPI_SpringBoot.Home.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;


/**
 * Websocket is a live controller that's why we don't need controller annnotation.
 * untill websockt endpoints exits by user, the WS endpoints will update itself
 * */

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
	
	//adding endpoint to stomp
	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/webSocketMessagging")
	     .withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//adding message to registry
		registry.enableSimpleBroker("/topic");
		
		//prefix for the endpoint
		registry.setApplicationDestinationPrefixes("/tushar");
	}
	
}
