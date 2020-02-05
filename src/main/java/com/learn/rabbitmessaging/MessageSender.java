package com.learn.rabbitmessaging;

import org.springframework.amqp.core.AbstractExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
public class MessageSender {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private List<AbstractExchange> exchangeList;

	public void send(String message, String routingKey, Class<? extends AbstractExchange> exchangeType) {
		AbstractExchange exchange = exchangeList.stream().filter(ex -> ex.getClass().equals(exchangeType)).findFirst().get();
		System.out.println(" [x] Sending to exchange : " + exchange.getName() + " with routing key : " + routingKey);
		template.convertAndSend(exchange.getName(), routingKey, message);
		System.out.println(" [x] Sent '" + message + "'");
	}
}
