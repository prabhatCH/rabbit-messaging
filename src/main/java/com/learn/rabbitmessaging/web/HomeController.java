package com.learn.rabbitmessaging.web;

import com.learn.rabbitmessaging.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
@RestController
@Profile("sender")
public class HomeController {

	@Autowired
	private MessageSender messageSender;

	@PostMapping
	public String sendMessage(@RequestParam String message, @RequestParam String routingKey) {
		System.out.println("Sending message " + message + " and routing key : " + routingKey);
		messageSender.send(message, routingKey);
		return "Message sent!";
	}
}
