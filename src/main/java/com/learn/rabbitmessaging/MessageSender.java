package com.learn.rabbitmessaging;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
public class MessageSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private TopicExchange topicExchange;

	public void send(String message, String routingKey) {
		System.out.println(" [x] Sending to exchange : " + topicExchange.getName() + " with routing key : " + routingKey);
		template.convertAndSend(topicExchange.getName(), routingKey, message);
		System.out.println(" [x] Sent '" + message + "'");
	}
}
