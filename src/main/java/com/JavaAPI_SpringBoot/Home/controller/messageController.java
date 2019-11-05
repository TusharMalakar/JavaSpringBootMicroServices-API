//package com.JavaAPI_SpringBoot.Home.controller;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//import com.JavaAPI_SpringBoot.Home.model.message;
//
//
///**
// * Dont need to user @RestController because it will remain active 
// * untill user kills the endpoints
// * */
//
//@Controller
//public class messageController {
//	
//	@MessageMapping("/SockMessage")
//	@SendTo("/topic/SockMessage")
//	public message getMessage(message _message) {
//	
//		return _message;
//	}
//
//}
