package com.JavaAPI_SpringBoot.Home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import com.JavaAPI_SpringBoot.Home.model.message;

import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class WebSocketSchedulerConfig {
	
	message sockMessage;
	//sending message to the same endpoint
	@Autowired
	SimpMessagingTemplate template;
	
	//After every tree second message will be triggered
	//@Scheduled(fixedDelay = 3000000)
	public void sendAdhocMessages() {
		
		template.convertAndSend("/topic/SockMessage", sockMessage);
		
	}
	
}
