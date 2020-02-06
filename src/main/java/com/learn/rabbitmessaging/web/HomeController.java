package com.learn.rabbitmessaging.web;

import com.learn.rabbitmessaging.MessageSender;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
@RestController
@Profile("sender")
@RequestMapping("/send")
public class HomeController {

	@Autowired
	private MessageSender messageSender;

	@PostMapping("/{routingKey}/topic")
	public String sendTopicMessage(@RequestBody String message, @PathVariable String routingKey) {
		System.out.println("Sending topic message " + message + " and routing key : " + routingKey);
		messageSender.send(message, routingKey, TopicExchange.class);
		return "Message sent!";
	}

	@PostMapping("/{routingKey}/direct")
	public String sendDirectMessage(@RequestBody String message, @PathVariable String routingKey) {
		System.out.println("Sending direct message " + message + " and routing key : " + routingKey);
		messageSender.send(message, routingKey, DirectExchange.class);
		return "Message sent!";
	}

	/**
	 * There is no routing key in this API to demonstrate the fact that even if you send a routing key to a fanout exchange, it is simply ignored
	 * and the message is routed to all the subscribed queues.
	 */
	@PostMapping("/fanout")
	public String sendFanoutMessage(@RequestBody String message) {
		System.out.println("Sending fanout message " + message);
		messageSender.send(message, "junkKeyWhichWillBeIgnored", FanoutExchange.class);
		return "Message sent!";
	}
}
