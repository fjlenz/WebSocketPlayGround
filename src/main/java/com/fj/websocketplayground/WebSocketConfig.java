package com.fj.websocketplayground;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  Logger logger = LoggerFactory.getLogger("jsonConsoleAppender");
	
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
	logger.info("Config. Message Broker");
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
	logger.info("Registering Stomp endpoint");
    registry.addEndpoint("/gs-guide-websocket").withSockJS();
  }

}