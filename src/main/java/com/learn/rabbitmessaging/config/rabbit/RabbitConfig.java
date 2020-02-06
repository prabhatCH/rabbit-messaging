package com.learn.rabbitmessaging.config.rabbit;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author prabhat.choudhary
 * @since 05/02/20
 */
@Configuration
public class RabbitConfig {

	static {
		System.out.println("Rabbit is getting configured");
	}

	private static class ExchangeConfig {
		@Bean
		public TopicExchange topicExchange() {
			return new TopicExchange("amq.topic");
		}

		@Bean
		public DirectExchange directExchange() {
			return new DirectExchange("amq.direct");
		}

		@Bean
		public FanoutExchange fanoutExchange() {
			return new FanoutExchange("amq.fanout");
		}
	}
}
