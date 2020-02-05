package com.learn.rabbitmessaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
public class MessageReceiver {

	@RabbitListener(queues = "venus")
	public void receive1(String in) {
		receive(in, "venus");
	}

	@RabbitListener(queues = "earth")
	public void receive2(String in) {
		receive(in, "earth");
	}

	@RabbitListener(queues = "planets")
	public void receive3(String in) {
		receive(in, "planets");
	}

	private void receive(String in, String queueName) {
		System.out.println("[Q]: " + queueName + " - " + "Message received : " + in);
	}
}
