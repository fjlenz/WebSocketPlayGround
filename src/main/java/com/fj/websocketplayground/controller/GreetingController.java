package com.fj.websocketplayground.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fj.websocketplayground.model.Message;
import com.fj.websocketplayground.model.Greeting;

@Controller
public class GreetingController {

	Logger logger = LoggerFactory.getLogger("jsonConsoleAppender");
	  
	//API for thymeleaf mapping of the temaplte in greeting.html
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

   //websocket API
   @MessageMapping("/hello")
   @SendTo("/topic/greetings")
   public Greeting greeting(Message message) throws Exception {
	   logger.info("Someone calling the /topic/greeting endpoint: {}", message);
	   Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
   }
	  
}
